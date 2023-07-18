package pl.sebastiancielma.MyAeroclub.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.weather.model.WeatherDto;
import pl.sebastiancielma.MyAeroclub.weather.webclient.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    public WeatherDto getWeather(){
        return weatherClient.getWeatherForCity("lublin");
    }


}
