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

        String json = "{\"id\":\"2104ac15-cc28-487d-be15-30f2fd69684e\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1231231123123,\"price\":12.99,\"createdDate\":\"2021-09-28T14:41:24.715611+03:00\",\"lastUpdatedDate\":\"2021-09-28T14:41:24.715611+03:00\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(beerDto);
    }

}