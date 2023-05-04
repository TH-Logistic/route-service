package com.thlogistic.route.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.thlogistic.route.client.AuthorizationClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class ApplicationConfig {

    private static String domainUrl = System.getenv("DOMAIN_URL");

    public static final String AUTHORIZATION_BASE_URL = "http://" + domainUrl + ":8000";

    @Bean
    public AuthorizationClient authorizationClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(AuthorizationClient.class, AUTHORIZATION_BASE_URL);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true);
        return modelMapper;
    }
}
