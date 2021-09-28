package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

/**
 * Created by taranenko on 28.09.2021
 * description: в application-snake.properties указано использовать отличную от дефолтной
 * стратегию при сериализации из объекта в json записывать имена полей в стиле SNAKE_CASE
 * Класс в котором хранятся константы стратегий PropertyNamingStrategy
 * Если у поля стоит аннотиция @JsonProperty("beerId") где указан параметр default (то при сериализации будет
 * использоваться это имя вместо названия поля, но при десериализации в самом json должен быть так же указан beerId
 * если будет id, то его значение будет null
 *
 * @JsonFormat(shape = JsonFormat.Shape.STRING) - это аннотация скажет Jackson, что нужно приобразить значения поля к строке
 * например число
 *
 * @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING) - можно указать паттерн для даты
 */
@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSnakeCase() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }
}
