package ru.gb.group4546_5984.spring_sem06_hw_task02.configuration;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.client.RestTemplate;

/**
 * Конфигуратор
 * принимает значения из файла настройки application.yaml
 */
@ConfigurationProperties(prefix = "url")
@Getter
@Setter
public class RickAndMortyApiConfig {
    private String CHARACTER_API;
    private String LOCATION_API;
    private String EPISODE_API;
    private RestTemplate restTemplate;


}
