package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeSerializeDto() throws IOException {

        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1231231123123,\"price\":\"12.99\",\"createdDate\":\"2021-09-29T11:47:45+0300\",\"lastUpdatedDate\":\"2021-09-29T11:47:45+0300\",\"myLocalDate\":\"20210929\",\"beerId\":\"7dbbb431-65f4-49c2-b15e-1dd639a294c1\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(beerDto);
    }

}