# How to call API v3

### Original Tech Requirement API

```apl
api.openweathermap.org/data/2.5/forecast/hourly?lat={lat}&lon={lon}&appid={API key}
```

### Official Changed Tech Requirement API
```apl
api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
```


# Weather parameters in API

| Parameters |          |                                                              |
| :--------- | -------- | ------------------------------------------------------------ |
| `lat, lon` | required | Geographical coordinates (latitude, longitude)               |
| `appid`    | required | Your unique API key (you can always find it on your account page under the ["API key" tab](https://home.openweathermap.org/api_keys)) |
| `exclude`  | optional | By using this parameter you can exclude some parts of the weather data from the API response. It should be a comma-delimited list (without spaces).Available values:`current``minutely``hourly``daily``alerts` |
| `units`    | optional | Units of measurement. `standard`, `metric` and `imperial` units are available. If you do not use the `units` parameter, `standard` units will be applied by default. [Learn more](https://openweathermap.org/api/one-call-api#data) |
| `lang`     | optional | You can use the `lang` parameter to get the output in your language. [Learn more](https://openweathermap.org/api/one-call-api#multi) |



### JSON

* API response example

```json
{
  "lat": 33.44,
  "lon": -94.04,
  "timezone": "America/Chicago",
  "timezone_offset": -21600,
  "current": {
    "dt": 1618317040,
    "sunrise": 1618282134,
    "sunset": 1618333901,
    "temp": 284.07,
    "feels_like": 282.84,
    "pressure": 1019,
    "humidity": 62,
    "dew_point": 277.08,
    "uvi": 0.89,
    "clouds": 0,
    "visibility": 10000,
    "wind_speed": 6,
    "wind_deg": 300,
    "weather": [
      {
        "id": 500,
        "main": "Rain",
        "description": "light rain",
        "icon": "10d"
      }
    ],
    "rain": {
      "1h": 0.21
    }
  },
    "minutely": [
    {
      "dt": 1618317060,
      "precipitation": 0.205
    },
    ...
  },
    "hourly": [
    {
      "dt": 1618315200,
      "temp": 282.58,
      "feels_like": 280.4,
      "pressure": 1019,
      "humidity": 68,
      "dew_point": 276.98,
      "uvi": 1.4,
      "clouds": 19,
      "visibility": 306,
      "wind_speed": 4.12,
      "wind_deg": 296,
      "wind_gust": 7.33,
      "weather": [
        {
          "id": 801,
          "main": "Clouds",
          "description": "few clouds",
          "icon": "02d"
        }
      ],
      "pop": 0
    },
    ...
  }
    "daily": [
    {
      "dt": 1618308000,
      "sunrise": 1618282134,
      "sunset": 1618333901,
      "moonrise": 1618284960,
      "moonset": 1618339740,
      "moon_phase": 0.04,
      "temp": {
        "day": 279.79,
        "min": 275.09,
        "max": 284.07,
        "night": 275.09,
        "eve": 279.21,
        "morn": 278.49
      },
      "feels_like": {
        "day": 277.59,
        "night": 276.27,
        "eve": 276.49,
        "morn": 276.27
      },
      "pressure": 1020,
      "humidity": 81,
      "dew_point": 276.77,
      "wind_speed": 3.06,
      "wind_deg": 294,
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "clouds": 56,
      "pop": 0.2,
      "rain": 0.62,
      "uvi": 1.93
    },
    ...
    },
    "alerts": [
    {
      "sender_name": "NWS Tulsa",
      "event": "Heat Advisory",
      "start": 1597341600,
      "end": 1597366800,
      "description": "...HEAT ADVISORY REMAINS IN EFFECT FROM 1 PM THIS AFTERNOON TO\n8 PM CDT THIS EVENING...\n* WHAT...Heat index values of 105 to 109 degrees expected.\n* WHERE...Creek, Okfuskee, Okmulgee, McIntosh, Pittsburg,\nLatimer, Pushmataha, and Choctaw Counties.\n* WHEN...From 1 PM to 8 PM CDT Thursday.\n* IMPACTS...The combination of hot temperatures and high\nhumidity will combine to create a dangerous situation in which\nheat illnesses are possible.",
      "tags": [
        "Extreme temperature value"
        ]
    },
    ...
  ]           
                  
```
# Fields in API response
- `lat` Geographical coordinates of the location (latitude)

- `lon` Geographical coordinates of the location (longitude)

- `timezone` Timezone name for the requested location

- `timezone_offset` Shift in seconds from UTC

- `current` **Current weather data API response**

- - `current.dt` Current time, Unix, UTC

  - `current.sunrise` Sunrise time, Unix, UTC

  - `current.sunset` Sunset time, Unix, UTC

  - `current.temp` Temperature. Units - default: kelvin, metric: Celsius, imperial: Fahrenheit. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `current.feels_like` Temperature. This temperature parameter accounts for the human perception of weather. Units – default: kelvin, metric: Celsius, imperial: Fahrenheit.

  - `current.pressure` Atmospheric pressure on the sea level, hPa

  - `current.humidity` Humidity, %

  - `current.dew_point` Atmospheric temperature (varying according to pressure and humidity) below which water droplets begin to condense and dew can form. Units – default: kelvin, metric: Celsius, imperial: Fahrenheit.

  - `current.clouds` Cloudiness, %

  - `current.uvi` Current UV index

  - `current.visibility` Average visibility, metres

  - `current.wind_speed` Wind speed. Wind speed. Units – default: metre/sec, metric: metre/sec, imperial: miles/hour. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `current.wind_gust` (where available) Wind gust. Units – default: metre/sec, metric: metre/sec, imperial: miles/hour. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `current.wind_deg` Wind direction, degrees (meteorological)

  - `current.rain`

  - - `current.rain.1h` (where available) Rain volume for last hour, mm

  - `current.snow`

  - - `current.snow.1h` (where available) Snow volume for last hour, mm

  - ```
    current.weather
    ```

    - `current.weather.id` [Weather condition id](https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2)
    - `current.weather.main` Group of weather parameters (Rain, Snow, Extreme etc.)
    - `current.weather.description` Weather condition within the group ([full list of weather conditions](https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2)). Get the output in [your language](https://openweathermap.org/api/one-call-api#multi)
    - `current.weather.icon` Weather icon id. [How to get icons](https://openweathermap.org/weather-conditions#How-to-get-icon-URL)

- `minutely` **Minute forecast weather data API response**

- - `minutely.dt` Time of the forecasted data, unix, UTC
  - `minutely.precipitation` Precipitation volume, mm

- `hourly` **Hourly forecast weather data API response**

- - `hourly.dt` Time of the forecasted data, Unix, UTC

  - `hourly.temp` Temperature. Units – default: kelvin, metric: Celsius, imperial: Fahrenheit. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `hourly.feels_like` Temperature. This accounts for the human perception of weather. Units – default: kelvin, metric: Celsius, imperial: Fahrenheit.

  - `hourly.pressure` Atmospheric pressure on the sea level, hPa

  - `hourly.humidity` Humidity, %

  - `hourly.dew_point` Atmospheric temperature (varying according to pressure and humidity) below which water droplets begin to condense and dew can form. Units – default: kelvin, metric: Celsius, imperial: Fahrenheit.

  - `hourly.uvi` UV index

  - `hourly.clouds` Cloudiness, %

  - `hourly.visibility` Average visibility, metres

  - `hourly.wind_speed` Wind speed. Units – default: metre/sec, metric: metre/sec, imperial: miles/hour.[How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `hourly.wind_gust` (where available) Wind gust. Units – default: metre/sec, metric: metre/sec, imperial: miles/hour. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `chourly.wind_deg` Wind direction, degrees (meteorological)

  - `hourly.pop` Probability of precipitation

  - `hourly.rain`

  - - `hourly.rain.1h` (where available) Rain volume for last hour, mm

  - `hourly.snow`

  - - `hourly.snow.1h` (where available) Snow volume for last hour, mm

  - ```
    hourly.weather
    ```

    - `hourly.weather.id` [Weather condition id](https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2)
    - `hourly.weather.main` Group of weather parameters (Rain, Snow, Extreme etc.)
    - `hourly.weather.description` Weather condition within the group ([full list of weather conditions](https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2)). Get the output in [your language](https://openweathermap.org/api/one-call-api#multi)
    - `hourly.weather.icon` Weather icon id. [How to get icons](https://openweathermap.org/weather-conditions#How-to-get-icon-URL)

- ```
  daily
  ```

   

  Daily forecast weather data API response

  - `daily.dt` Time of the forecasted data, Unix, UTC

  - `daily.sunrise` Sunrise time, Unix, UTC

  - `daily.sunset` Sunset time, Unix, UTC

  - `daily.moonrise` The time of when the moon rises for this day, Unix, UTC

  - `daily.moonset` The time of when the moon sets for this day, Unix, UTC

  - `daily.moon_phase` Moon phase. `0` and `1` are 'new moon', `0.25` is 'first quarter moon', `0.5` is 'full moon' and `0.75` is 'last quarter moon'. The periods in between are called 'waxing crescent', 'waxing gibous', 'waning gibous', and 'waning crescent', respectively.

  - `daily.temp` Units – default: kelvin, metric: Celsius, imperial: Fahrenheit. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - - `daily.temp.morn` Morning temperature.
    - `daily.temp.day` Day temperature.
    - `daily.temp.eve` Evening temperature.
    - `daily.temp.night` Night temperature.
    - `daily.temp.min` Min daily temperature.
    - `daily.temp.max` Max daily temperature.

  - ```
    daily.feels_like
    ```

     

    This accounts for the human perception of weather. Units – default: kelvin, metric: Celsius, imperial: Fahrenheit.

     

    How to change units used

    - `daily.feels_like.morn` Morning temperature.
    - `daily.feels_like.day` Day temperature.
    - `daily.feels_like.eve` Evening temperature.
    - `daily.feels_like.night` Night temperature.

  - `daily.pressure` Atmospheric pressure on the sea level, hPa

  - `daily.humidity` Humidity, %

  - `daily.dew_point` Atmospheric temperature (varying according to pressure and humidity) below which water droplets begin to condense and dew can form. Units – default: kelvin, metric: Celsius, imperial: Fahrenheit.

  - `daily.wind_speed` Wind speed. Units – default: metre/sec, metric: metre/sec, imperial: miles/hour. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `daily.wind_gust` (where available) Wind gust. Units – default: metre/sec, metric: metre/sec, imperial: miles/hour. [How to change units used](https://openweathermap.org/api/one-call-api#data)

  - `daily.wind_deg` Wind direction, degrees (meteorological)

  - `daily.clouds` Cloudiness, %

  - `daily.uvi` The maximum value of UV index for the day

  - `daily.pop` Probability of precipitation

  - `daily.rain` (where available) Precipitation volume, mm

  - `daily.snow` (where available) Snow volume, mm

  - `daily.weather`

  - - `daily.weather.id` [Weather condition id](https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2)
    - `daily.weather.main` Group of weather parameters (Rain, Snow, Extreme etc.)
    - `daily.weather.description` Weather condition within the group ([full list of weather conditions](https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2)). Get the output in [your language](https://openweathermap.org/api/one-call-api#multi)
    - `daily.weather.icon` Weather icon id. [How to get icons](https://openweathermap.org/weather-conditions#How-to-get-icon-URL)

- ```
  alerts
  ```

   

  National weather alerts data from major national weather warning systems

  - `alerts.sender_name` Name of the alert source. Please read here the [full list of alert sources](https://openweathermap.org/api/one-call-api#listsource)
  - `alerts.event` Alert event name
  - `alerts.start` Date and time of the start of the alert, Unix, UTC
  - `alerts.end` Date and time of the end of the alert, Unix, UTC
  - `alerts.description` Description of the alert
  - `alerts.tags` Type of severe weather