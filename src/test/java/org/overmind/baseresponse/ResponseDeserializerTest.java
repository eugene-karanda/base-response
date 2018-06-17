package org.overmind.baseresponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseDeserializerTest {

    @Test
    public void serializationSimpleType() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();

        final Response<String> response = Response.of(
                ResponseInfo.of(0, "OK"),
                "Hello World"
        );

        final String json = objectMapper.writeValueAsString(response);
        assertThat(json)
                .isEqualTo("{\"code\":0,\"description\":\"OK\",\"payload\":\"Hello World\"}");
    }

    @Test
    public void serializationObjectType() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();

        final Response<User> response = Response.of(
                ResponseInfo.of(0, "OK"),
                User.of("Eugene Karanda", 24)
        );

        final String json = objectMapper.writeValueAsString(response);
        assertThat(json)
                .isEqualTo("{\"code\":0,\"description\":\"OK\",\"name\":\"Eugene Karanda\",\"age\":24}");
    }

    @Test
    public void deserializationSimpleType() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String json = "{\"code\":0,\"description\":\"OK\",\"payload\":\"Hello World\"}";

        final TypeReference<Response<String>> typeReference = new TypeReference<Response<String>>() {
        };

        Response<String> response = objectMapper.readValue(json, typeReference);
        assertThat(response)
                .isEqualTo(
                        Response.of(
                                ResponseInfo.of(0, "OK"),
                                "Hello World"
                        )
                );

    }

    @Test
    public void deserializationObjectType() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String json = "{\"code\":0,\"description\":\"OK\",\"name\":\"Martin Fowler\",\"age\":55}";

        final TypeReference<Response<User>> typeReference = new TypeReference<Response<User>>() {
        };

        Response<User> response = objectMapper.readValue(json, typeReference);
        assertThat(response)
                .isEqualTo(
                        Response.of(
                                ResponseInfo.of(0, "OK"),
                                User.of("Martin Fowler", 55)
                        )
                );

    }
}

class User {

    private final String name;

    private final int age;

    @JsonCreator
    static User of(
            @JsonProperty("name") String name,
            @JsonProperty("age") int age
    ) {
        return new User(name, age);
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}