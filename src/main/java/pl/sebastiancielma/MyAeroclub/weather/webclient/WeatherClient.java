package pl.sebastiancielma.MyAeroclub.weather.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sebastiancielma.MyAeroclub.weather.model.WeatherDto;
import pl.sebastiancielma.MyAeroclub.weather.webclient.dto.OpenWeatherWeatherDto;

@Component
public class WeatherClient {
    public static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "6a819cd8fea5092319c236ba0534e534";
    private RestTemplate restTemplate = new RestTemplate();
    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class, city, API_KEY);
        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude={part}&appid={apiKey}",
                String.class,lat,
                lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object...objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects );
    }
}
