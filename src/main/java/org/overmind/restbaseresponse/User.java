package org.overmind.restbaseresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {

    private final String name;

    private final int age;

    public static User of(String name, int age) {
        return new User(name, age);
    }

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @JsonProperty("name")
    public String name() {
        return name;
    }

    @JsonProperty("age")
    public int age() {
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
