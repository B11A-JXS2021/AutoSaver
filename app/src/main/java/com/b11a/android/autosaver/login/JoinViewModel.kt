package com.b11a.android.autosaver.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.b11a.android.autosaver.hashSHA256
import com.b11a.android.autosaver.login.models.UserJoin
import com.b11a.android.autosaver.kServerURL
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.util.regex.Pattern

class JoinViewModel: ViewModel() {
    private val joinURL = kServerURL("rest-auth/registrations")
    private val client = OkHttpClient()

    private val _join = MutableLiveData<UserJoin>().apply {
        value = UserJoin()
    }
    val join: LiveData<UserJoin> = _join

    private val _joining = MutableLiveData<Boolean>().apply {
        value = false
    }
    val joining: LiveData<Boolean> = _joining

    private val _userToken = MutableLiveData<String?>().apply {
        value = null
    }
    val userToken: LiveData<String?> = _userToken

    private val _errorJoin = MutableLiveData<UserJoin>().apply {
        value = UserJoin()
    }
    val errorJoin: LiveData<UserJoin> = _errorJoin

    private var correctPassword = false

    fun setEmail(email: String) {
        _join.value?.email = email
    }

    fun setPassword1(password: String) {
        correctPassword = Pattern.matches("^(?=.*[0-9])(?=.*[~!?@#$%^&*()-])(?=.*[a-zA-Z]).{8,}$", password)
        _join.value?.password1 = password
    }

    fun setPassword2(password: String) {
        _join.value?.password2 = password
    }

    fun join() {
        _joining.value = true

        val requestBody = FormBody.Builder()
            .add("email", _join.value!!.email)
            .add("password1", hashSHA256(_join.value!!.password1))
            .add("password2", hashSHA256(_join.value!!.password2))
            .build()
        val request = Request.Builder()
            .url(joinURL)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("JOIN", e.toString())
                _joining.postValue(false)
                return
            }

            override fun onResponse(call: Call, response: Response) {
                val responseString = response.body!!.string()
                Log.d("JOIN", responseString)

                val jsonObject = JSONObject(responseString)

                if(jsonObject.has("key"))
                    _userToken.postValue(jsonObject.getString("key"))
                else checkInvalid(jsonObject)

                _joining.postValue(false)
            }
        })
    }

    fun checkInvalid(result: JSONObject) {
        val error = UserJoin()

        if(result.has("email")) error.email = result.getJSONArray("email").getString(0)
        if(!correctPassword) {
            if(join.value!!.password1.length < 8)
                error.password1 += "This password is too short. It must contain at least 8 characters.\n"
            if(Pattern.matches("^(?=.*[0-9])(?=.*[~!?@#$%^&*()-])(?=.*[a-zA-Z]).{8,}$", join.value!!.password1))
                error.password1 += "Password must contain Numbers, Alphabet, Special Character\n"
        }
        if(result.has("password2")) error.password2 = result.getJSONArray("password2").getString(0)
        if(result.has("non_field_errors")) error.password2 = result.getJSONArray("non_field_errors").getString(0)

        _errorJoin.postValue(error)
    }
}