package com.app.weather_api.service;

import com.app.weather_api.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    //private final RestTemplate restTemplate;
    private final RestClient restClient;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.units}")
    private String units;

    /*
    @Value("${weather.api.base-url}")
    private String baseUrl;

    public WeatherResponse getWeatherByCity(String city) {
        String url = String.format(
                "%s?q=%s&appid=%s&units=%s",
                baseUrl, city, apiKey, units
        );

        return restTemplate.getForObject(url, WeatherResponse.class);
    }
    */

    public WeatherResponse getWeatherByCity(String city) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", city)
                        .queryParam("appid", apiKey)
                        .queryParam("units", units)
                        .build())
                .retrieve()
                .body(WeatherResponse.class);
    }

    public WeatherResponse getWeatherByCoordinates(double lat, double lon) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .queryParam("appid", apiKey)
                        .queryParam("units", units)
                        .build())
                .retrieve()
                .body(WeatherResponse.class);
    }
}