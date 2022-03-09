# ![TrendsActionLogo](https://drive.google.com/uc?id=1pNGJBmpgFGaBN9eTT_lwYkxvIq5vYDIw) Motov Test Android for Interview (MTA)



![badge](https://img.shields.io/github/languages/count/beygee/survive) ![badge](https://img.shields.io/github/languages/top/beygee/survive) ![badge](https://img.shields.io/github/languages/code-size/beygee/survive) ![badge](https://img.shields.io/github/repo-size/beygee/survive) ![badge](https://img.shields.io/github/issues/beygee/survive) ![badge](https://img.shields.io/github/issues-closed/beygee/survive) ![badge](https://img.shields.io/github/last-commit/beygee/survive)


## :page_facing_up: 프로젝트 개요
### OpenWeatherMap의 [Hourly-forecast-for-4days](https://openweathermap.org/api/hourly-forecast) API 를 이용하여, 

### 현재위치의 시간별 날씨정보를 표시하는 안드로이드 앱을 구현


## :dart: 프로젝트 분석
#### Motov의 핵심 사업인 Taxi Top Media Ads Service의 로직과 유사한 설계 과제로 분석됨.

#### 사용자의 실시간 위치기반으로 날씨를 요청함에 따라,
Taxi의 실시간 위치기반으로 Ads를 요청함에 따라,

#### 현재위치의 시간별 날씨를 표시하는 안드로이드 앱을 구현.

현재위치(지역타겟광고)의 시간별(타임스팟 광고 상품) Ads를 표시하는 클라이언트 구현.

#### Paging 기능을 사용함으로써 한 페이지에 item을 24시간 분량씩 로드하는 분할 로드 기능을 설계 기능으로 요구함.

Paging 기능을 사용함으로써 호출 시점에서 Ads 데이터 전체를 로드하여 표시하는 것이 아니라, 데이터 호출 시점(지역 이동 혹은 시간흐름)에 따라 해당 지역 혹은 일정시간동안 광고할 (최소필요) 데이터 갯수만 로드하여 API 호출 cost 를 줄이고, 서버에 신규 데이터 혹은 수정된 데이터를 적절한 타이밍에 로드하며, 당장 불필요한 데이터 호출을 방지하기 위한 Lazy Loading 기법.

## :computer: 기술 스택
![badge](https://img.shields.io/badge/SCM-Github-181717?logo=Github) ![badge](https://img.shields.io/badge/SCM-Git-F05032?logo=Git) ![badge](https://img.shields.io/badge/Package-Gradle-02303A?logo=Gradle) ![badge](https://img.shields.io/badge/Language-Java-007396?logo=Java) ![badge](https://img.shields.io/badge/Framework-Android-3DDC84?logo=Android) ![badge](https://img.shields.io/badge/IDE-Android Studio-3DDC84?logo=Android Studio) ![badge](https://img.shields.io/badge/Library-Glide-21baa2) ![badge](https://img.shields.io/badge/Library-Retrofit2-47b984) ![badge](https://img.shields.io/badge/Library-okHttp3-009485) ![badge](https://img.shields.io/badge/Library-RxJava2-b7178b) ![badge](https://img.shields.io/badge/Library-Espresso-946e59)