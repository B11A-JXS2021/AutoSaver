# Auto Saver
- 해커톤명 : [JunctionX Seoul 2021](https://app.hackjunction.com/events/junctionx-seoul-2021)
- 해커톤 파트너 및 트랙 :
  - [AWS Gametech](https://aws.amazon.com/ko/gametech/)
  - [AUTOCRYPT](https://autocrypt.co.kr/)
  - [SI Analytics](https://www.si-analytics.ai/) : 트랙 선택
  - [Microsoft](https://www.microsoft.com/ko-kr/)
- 기간 : 2021.05.21 ~ 2021.05.23
- 팀명 : [B11A](https://github.com/B11A-JXS2021)
  - 권민수 : 기획
  - [고진형](https://github.com/jinhgoh) : 백엔드 개발
  - [이주형](https://github.com/yamiblack) : 안드로이드 개발
  - [장수빈](https://github.com/jsb408) : 안드로이드 개발
  - [최성우](https://github.com/nuatmochoi) : 백엔드 개발
  - 추서진 : 디자인
</br>

## [서비스 소개](https://github.com/yamiblack/AutoSaver/blob/main/About(eng).md)
- Auto Saver는 운전 시 기기의 흔들림을 감지하여 교통사고 또는 몸이 불편하신 분들의 낙상사고 시 빠른 대처가 가능하도록 도와주는 애플리케이션이다.
- 운전 중 데이터를 수집해 서버에 저장하고 그래프 형태로 표시한다.
- 운전 중 충격, 흔들림이 감지되면 경고를 띄우고 119와 비상연락망에 전화와 문자를 전송한다.
</br>

## 작동 원리
[![Video Label](https://user-images.githubusercontent.com/50551349/121243428-aa43e700-c8d8-11eb-9c37-9971385e583e.png)](https://youtu.be/xBUs9yQbTAM)

- 위 영상과 같이 **가속도 센서**를 활용하여 약한 충돌은 감지되지 않고 강한 충돌만 감지되도록 설정했다.
</br>

## 시연 영상
- 충격이나 강한 흔들림이 감지되면 사고로 인식한다.

[![Video Label](https://user-images.githubusercontent.com/50551349/121244448-d744c980-c8d9-11eb-9bf2-d327d0bbc09a.png)](https://youtu.be/7QZhXfVbyvQ)

- 10초(시연 영상에서는 3초)가 카운트되는 동안 CANCEL 버튼을 터치하지 않거나 GPS 위치 변동 등 움직임이 감지되지 않으면 119 신고 및 비상연락망으로 연락이 된다.
</br>

[![Video Label](https://user-images.githubusercontent.com/50551349/121246095-c09f7200-c8db-11eb-8a10-d93abac78c4a.png)](https://youtu.be/PEwuAjSOLkk)

- 10초(시연 영상에서는 3초)가 카운트되는 동안 CANCEL 버튼을 터치하거나 GPS 위치 변동 등 움직임이 감지되면 사고 감지가 해제된다.
</br>

## 상세 기능 소개

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483057-8e482d80-bd8f-11eb-97ba-e53455e392c9.png"/> <img width="30%" src="https://user-images.githubusercontent.com/55052074/119483068-91431e00-bd8f-11eb-98fb-f312d12c16e9.png"/></p>

### 1. 회원가입

### 1-1. 회원가입

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483234-b768be00-bd8f-11eb-9f66-50901936741c.png"/> <img width="30%" src="https://user-images.githubusercontent.com/55052074/119483242-b9328180-bd8f-11eb-85a7-657e95ccfa61.png"/></p>

- 로그인 화면에서 **회원가입** 선택시 해당 화면으로 이동하며, 이메일과 패스워드로 가입이 가능하다.
- NEXT를 누르면 서버에서 유효성 검사를 진행하고 결과값을 표시한다.
- 패스워드는 HASH로 암호화되어 전송된다.

### 1-2. 상세정보

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483375-dc5d3100-bd8f-11eb-8bbc-28d49794c706.png"/> <img width="30%" src="https://user-images.githubusercontent.com/55052074/119483382-debf8b00-bd8f-11eb-940a-389105ff5545.png"/></p>

- NEXT 버튼을 클릭하면 상세 정보 입력 화면으로 넘어온다.
- 혈액형, 특이사항은 드롭다운 메뉴로, 병력 사항과 복용 약물은 텍스트 형태로 입력받는다.

### 1-3. 비상 연락망

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483469-f6970f00-bd8f-11eb-946f-841657561c2a.png"/> <img width="30%" src="https://user-images.githubusercontent.com/55052074/119483478-f8f96900-bd8f-11eb-9ddd-6e589fce0e4f.png"/></p>

- COMPLETION 버튼을 클릭하면 비상연락망 입력 화면으로 넘어온다.
- 이름과 휴대폰 번호를 입력받는다.
- SKIP 버튼을 누르면 정보를 저장하지 않고 넘어간다.
- COMPLETION을 누르면 상세 정보와 함께 서버에 전송한다.
- 해당 과정까지 완료하지 않고 앱을 종료할 시 다음번 로그인에서 다시 입력받는다.

### 2. 로그인

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483566-11698380-bd90-11eb-9265-b3a874f3a27a.png"/></p>

- 이메일과 패스워드를 사용해 로그인이 가능하다.
- Auto Log-in을 활성화하고 로그인 시 다음 번 앱을 실행하면 자동으로 로그인된다.

### 3. 운전 습관 차트

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483619-1f1f0900-bd90-11eb-9f44-16c38c97a696.png"/></p>

- 서버에 저장된 데이터를 차트 형태로 표시한다.
- 가속도 센서 정보를 X축, Y축, Z축으로 나누어 그래프를 표시한다.

### 4. 운전 중 사고 감지

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483695-33630600-bd90-11eb-873f-3987722af013.jpg"/></p>

- 가속도 센서를 이용하여 충격, 흔들림을 감지한다.
- 큰 충격이나 흔들림이 감지되면 사고가 난 것으로 인식한다.
- 가속도 데이터는 실시간으로 서버로 전송되어 저장한다.

### 4-1. 사고 감지 시작

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119483765-44137c00-bd90-11eb-86b3-9ae1ddd49a3a.jpg"/></p>

- START 버튼을 누르면 운전 중 센서 감지가 시작된다.
- 가속도 센서 데이터가 X축, Y축, Z축으로 나뉘어 서버에 저장된다.
- END OF DRIVE를 누르면 센서 감지가 종료된다.

### 4-2. 사고 감지

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/50551349/121240503-613e6380-c8d5-11eb-91fe-6c4a2fb9d386.jpg"/> <img width="30%" src="https://user-images.githubusercontent.com/50551349/121240636-829f4f80-c8d5-11eb-9077-1bfd211fb33f.jpg"/> <img width="30%" src="https://user-images.githubusercontent.com/50551349/121240641-8337e600-c8d5-11eb-940f-82f776db7b8e.jpg"/></p>

- 충격이나 강한 흔들림이 감지되면 사고로 인식한다.
- 10초 카운트 후 119, 비상연락망에게 문자를 보내고 119에 전화를 건다.
- 문자에는 현재 시각, 현재 위치의 위경도, 혈액형 정보를 포함한다.
- 10초가 카운트되는 동안 CANCEL 버튼을 누르거나 GPS 위치 변동, 움직임이 감지되면 사고 감지가 해제된다.

### 5. 마이페이지

<p align="center"><img width="30%" src="https://user-images.githubusercontent.com/55052074/119484084-9fde0500-bd90-11eb-8f00-220053ac8cf8.png"/> <img width="30%" src="https://user-images.githubusercontent.com/55052074/119484095-a3718c00-bd90-11eb-9a49-8489dbf39032.png"/></p>

- 각 화면에서 상세 정보와 비상연락망 정보 변경이 가능하다.
</br>

## 추후 보완 내용(예정)
- 운전 습관 데이터 분석 체계화
</br>

## 사용 기술 스택
- Android(Kotlin & Java) 
- OkHttp
- MPAndroidChart
- Kotlin : MVVM Pattern 적용 
</br>
