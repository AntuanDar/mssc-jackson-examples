package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by taranenko on 28.09.2021
 * description: в application-kebab.properties указано использовать отличную от дефолтной
 * стратегию при сериализации из объекта в json записывать имена полей в стиле KEBAB_CASE
 * Класс в котором хранятся константы стратегий PropertyNamingStrategy
 */
@JsonTest
@ActiveProfiles("kebab")
public class BeerDtoKebabTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSnakeCase() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }
}
