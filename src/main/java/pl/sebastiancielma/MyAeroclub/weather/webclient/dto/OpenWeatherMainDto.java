package pl.sebastiancielma.MyAeroclub.weather.webclient.dto;

import lombok.Getter;

@Getter
public class OpenWeatherMainDto {
        private float temp;
        private int pressure;
        private int humidity;
}
