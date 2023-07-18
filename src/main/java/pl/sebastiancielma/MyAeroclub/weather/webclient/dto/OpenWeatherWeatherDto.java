package pl.sebastiancielma.MyAeroclub.weather.webclient.dto;

import lombok.Getter;

@Getter
public class OpenWeatherWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
}
