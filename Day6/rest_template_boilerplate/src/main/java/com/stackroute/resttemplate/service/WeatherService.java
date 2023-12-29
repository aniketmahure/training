package com.stackroute.resttemplate.service;

import com.stackroute.resttemplate.model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    //add your api key here
    private static final String API_KEY = "7a4152e7c9ad4762a07104658232711";

    //add the base api url here
    private static final String API_URL = "https://api.weatherapi.com/v1/current.json?key=";

    private final RestTemplate restTemplate;
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //using rest template, get the weather details of a city
    public Weather getWeather(String city) {
        Weather weatherData = restTemplate.getForObject(API_URL+API_KEY+"&q="+city+"&aqi=no",Weather.class);
      return weatherData;
    }


}
