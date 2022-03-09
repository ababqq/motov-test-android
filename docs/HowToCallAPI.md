# How to call API

### API call address

```apl
pro.openweathermap.org/data/2.5/forecast/hourly?lat={lat}&lon={lon}&appid={API key}
```

| Parameters |          |                                                              |
| :--------- | -------- | ------------------------------------------------------------ |
| `lat, lon` | required | Geographical coordinates (latitude, longitude). If you need the geocoder to automatic convert city names and zip-codes to geo coordinates and the other way around, please use our [Geocoding API](https://openweathermap.org/api/geocoding-api). |
| `appid`    | required | Your unique API key (you can always find it on your account page under the ["API key" tab](https://home.openweathermap.org/api_keys)) |
| `mode`     | optional | Data format. Possible values are `json` and `xml`. If the `mode` parameter is empty the format is JSON by default. [Learn more](https://openweathermap.org/api/hourly-forecast#format) |
| `cnt`      | optional | A number of timestamps in response. [Learn more](https://openweathermap.org/api/hourly-forecast#limit) |
| `lang`     | optional | Language code. [Learn more](https://openweathermap.org/api/hourly-forecast#multi) |

# Weather parameters in API response



### JSON

* API response example

```json
{
  "cod": "200",
  "message": 0.0179,
  "cnt": 96,
  "list": [
   {
     "dt": 1596632400,
     "main": {
       "temp": 289.16,
       "feels_like": 288.41,
       "temp_min": 289.16,
       "temp_max": 289.16,
       "pressure": 1013,
       "sea_level": 1013,
       "grnd_level": 1010,
       "humidity": 78,
       "temp_kf": 0
     },
     "weather": [
       {
         "id": 804,
         "main": "Clouds",
         "description": "overcast clouds",
         "icon": "04n"
       }
     ],
     "clouds": {
       "all": 100
     },
     "wind": {
       "speed": 2.03,
       "deg": 252,
       "gust":5.46
     },
     "visibility": 10000,
     "pop": 0.04,
     "sys": {
       "pod": "n"
     },
     "dt_txt": "2020-08-05 13:00:00"
   },
   .....
       ],
  "city": {
   "id": 2643743,
   "name": "London",
   "coord": {
     "lat": 51.5085,
     "lon": -0.1258
   },
   "country": "GB",
   "timezone": 0,
   "sunrise": 1568958164,
   "sunset": 1569002733
  }
}
                     
                  
```

# Fields in API response

- `cod` Internal parameter

- `message` Internal parameter

- `cnt` Number of timestamps returned by this API call

- ```
  list
  ```

  - `list.dt `Time of data forecasted, Unix, UTC

  - ```
    list.main
    ```

    - `list.main.temp` Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    - `list.main.feels_like` This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    - `list.main.temp_min` Minimum temperature at the moment of calculation. This is minimal forecasted temperature (within large megalopolises and urban areas), use this parameter optionally. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    - `list.main.temp_max` Maximum temperature at the moment of calculation. This is maximal forecasted temperature (within large megalopolises and urban areas), use these parameter optionally. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
    - `list.main.pressure` Atmospheric pressure on the sea level by default, hPa
    - `list.main.sea_level` Atmospheric pressure on the sea level, hPa
    - `list.main.grnd_level` Atmospheric pressure on the ground level, hPa
    - `list.main.humidity` Humidity, %
    - `list.main.temp_kf` Internal parameter

  - ```
    list.weather
    ```

    - `list.weather.id` Weather condition id
    - `list.weather.main` Group of weather parameters (Rain, Snow, Extreme etc.)
    - `list.weather.description` Weather condition within the group. You can get the output in your language. [Learn more](https://openweathermap.org/api/hourly-forecast#multi).
    - `list.weather.icon` Weather icon id

  - ```
    list.clouds
    ```

    - `list.clouds.all` Cloudiness, %

  - ```
    list.wind
    ```

    - `list.wind.speed` Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
    - `list.wind.deg` Wind direction, degrees (meteorological)
    - `list.wind.gust` Wind gust. Units – default: metre/sec, metric: metre/sec, imperial: miles/hour.

  - ```
    list.rain
    ```

    - `list.rain.1h` Rain volume for last hour, mm

  - ```
    list.snow
    ```

    - `list.snow.1h` Snow volume for last hour

  - `list.visibility` Average visibility, metres

  - `list.pop` Probability of precipitation

  - ```
    list.sys
    ```

    - `list.sys.pod` Part of the day (n - night, d - day)

  - `list.dt_txt` Time of data forecasted, ISO, UTC

  - ```
    city
    ```

    - `city.id` City ID (available if the API call has been made by [City ID](https://openweathermap.org/api/hourly-forecast#cityid5))

    - `city.name` City name

    - ```
      city.coord
      ```

      - `city.coord.lat `City geo location, latitude
      - `city.coord.lon` City geo location, longitude

  - `country` Country code (GB, JP etc.)

  - `timezone` Shift in seconds from UTC

  - `sunrise` Sunrise time, Unix, UTC

  - `sunset` Sunset time, Unix, UTC