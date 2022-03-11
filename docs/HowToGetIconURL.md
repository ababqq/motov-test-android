# How to get icon URL

Example of API response below :

```json

...
    "weather": [
        {
            "id": 500,
            "main": "Rain",
            "description": "light rain",
            "icon": "10n"
        }
    ],
...
```

The **icon URL**  is	 http://openweathermap.org/img/wn/$icon@2x.png    on the API response.

### Icon list

| Day icon                                                    | Night icon                                                  | Description      |
| :---------------------------------------------------------- | :---------------------------------------------------------- | :--------------- |
| 01d.png ![img](http://openweathermap.org/img/wn/01d@2x.png) | 01n.png ![img](http://openweathermap.org/img/wn/01n@2x.png) | clear sky        |
| 02d.png ![img](http://openweathermap.org/img/wn/02d@2x.png) | 02n.png ![img](http://openweathermap.org/img/wn/02n@2x.png) | few clouds       |
| 03d.png ![img](http://openweathermap.org/img/wn/03d@2x.png) | 03n.png ![img](http://openweathermap.org/img/wn/03n@2x.png) | scattered clouds |
| 04d.png ![img](http://openweathermap.org/img/wn/04d@2x.png) | 04n.png ![img](http://openweathermap.org/img/wn/04n@2x.png) | broken clouds    |
| 09d.png ![img](http://openweathermap.org/img/wn/09d@2x.png) | 09n.png ![img](http://openweathermap.org/img/wn/09n@2x.png) | shower rain      |
| 10d.png ![img](http://openweathermap.org/img/wn/10d@2x.png) | 10n.png ![img](http://openweathermap.org/img/wn/10n@2x.png) | rain             |
| 11d.png ![img](http://openweathermap.org/img/wn/11d@2x.png) | 11n.png ![img](http://openweathermap.org/img/wn/11n@2x.png) | thunderstorm     |
| 13d.png ![img](http://openweathermap.org/img/wn/13d@2x.png) | 13n.png ![img](http://openweathermap.org/img/wn/13n@2x.png) | snow             |
| 50d.png ![img](http://openweathermap.org/img/wn/50d@2x.png) | 50n.png ![img](http://openweathermap.org/img/wn/50n@2x.png) | mist             |



## Weather condition codes

| ID   | Main         | Description                     | Icon                                                    |
| :--- | :----------- | :------------------------------ | :------------------------------------------------------ |
| 200  | Thunderstorm | thunderstorm with light rain    | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 201  | Thunderstorm | thunderstorm with rain          | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 202  | Thunderstorm | thunderstorm with heavy rain    | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 210  | Thunderstorm | light thunderstorm              | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 211  | Thunderstorm | thunderstorm                    | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 212  | Thunderstorm | heavy thunderstorm              | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 221  | Thunderstorm | ragged thunderstorm             | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 230  | Thunderstorm | thunderstorm with light drizzle | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 231  | Thunderstorm | thunderstorm with drizzle       | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |
| 232  | Thunderstorm | thunderstorm with heavy drizzle | ![img](http://openweathermap.org/img/wn/11d@2x.png) 11d |



| ID   | Main    | Description                   | Icon                                                    |
| :--- | :------ | :---------------------------- | :------------------------------------------------------ |
| 300  | Drizzle | light intensity drizzle       | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 301  | Drizzle | drizzle                       | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 302  | Drizzle | heavy intensity drizzle       | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 310  | Drizzle | light intensity drizzle rain  | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 311  | Drizzle | drizzle rain                  | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 312  | Drizzle | heavy intensity drizzle rain  | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 313  | Drizzle | shower rain and drizzle       | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 314  | Drizzle | heavy shower rain and drizzle | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 321  | Drizzle | shower drizzle                | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |



| ID   | Main | Description                 | Icon                                                    |
| :--- | :--- | :-------------------------- | ------------------------------------------------------- |
| 500  | Rain | light rain                  | ![img](http://openweathermap.org/img/wn/10d@2x.png) 10d |
| 501  | Rain | moderate rain               | ![img](http://openweathermap.org/img/wn/10d@2x.png) 10d |
| 502  | Rain | heavy intensity rain        | ![img](http://openweathermap.org/img/wn/10d@2x.png) 10d |
| 503  | Rain | very heavy rain             | ![img](http://openweathermap.org/img/wn/10d@2x.png) 10d |
| 504  | Rain | extreme rain                | ![img](http://openweathermap.org/img/wn/10d@2x.png) 10d |
| 511  | Rain | freezing rain               | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 520  | Rain | light intensity shower rain | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 521  | Rain | shower rain                 | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 522  | Rain | heavy intensity shower rain | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |
| 531  | Rain | ragged shower rain          | ![img](http://openweathermap.org/img/wn/09d@2x.png) 09d |



| ID   | Main | Description         | Icon                                                    |
| :--- | :--- | :------------------ | ------------------------------------------------------- |
| 600  | Snow | light snow          | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 601  | Snow | Snow                | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 602  | Snow | Heavy snow          | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 611  | Snow | Sleet               | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 612  | Snow | Light shower sleet  | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 613  | Snow | Shower sleet        | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 615  | Snow | Light rain and snow | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 616  | Snow | Rain and snow       | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 620  | Snow | Light shower snow   | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 621  | Snow | Shower snow         | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |
| 622  | Snow | Heavy shower snow   | ![img](http://openweathermap.org/img/wn/13d@2x.png) 13d |



### Group 7xx: Atmosphere

| ID   | Main    | Description       | Icon                                                    |
| :--- | :------ | :---------------- | ------------------------------------------------------- |
| 701  | Mist    | mist              | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 711  | Smoke   | Smoke             | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 721  | Haze    | Haze              | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 731  | Dust    | sand/ dust whirls | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 741  | Fog     | fog               | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 751  | Sand    | sand              | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 761  | Dust    | dust              | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 762  | Ash     | volcanic ash      | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 771  | Squall  | squalls           | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |
| 781  | Tornado | tornado           | ![img](http://openweathermap.org/img/wn/50d@2x.png) 50d |



### Group 800: Clear

| ID   | Main  | Description | Icon                                                         |
| :--- | :---- | :---------- | :----------------------------------------------------------- |
| 800  | Clear | clear sky   | ![img](http://openweathermap.org/img/wn/01d@2x.png) 01d ![img](http://openweathermap.org/img/w/01n.png) 01n |



### Group 80x: Clouds

| ID   | Main   | Description              | Icon                                                         |
| :--- | :----- | :----------------------- | :----------------------------------------------------------- |
| 801  | Clouds | few clouds: 11-25%       | ![img](http://openweathermap.org/img/wn/02d@2x.png) 02d ![img](http://openweathermap.org/img/wn/02n@2x.png) 02n |
| 802  | Clouds | scattered clouds: 25-50% | ![img](http://openweathermap.org/img/wn/03d@2x.png) 03d ![img](http://openweathermap.org/img/wn/03n@2x.png) 03n |
| 803  | Clouds | broken clouds: 51-84%    | ![img](http://openweathermap.org/img/wn/04d@2x.png) 04d ![img](http://openweathermap.org/img/wn/04n@2x.png) 04n |
| 804  | Clouds | overcast clouds: 85-100% | ![img](http://openweathermap.org/img/wn/04d@2x.png) 04d ![img](http://openweathermap.org/img/wn/04n@2x.png) 04n |