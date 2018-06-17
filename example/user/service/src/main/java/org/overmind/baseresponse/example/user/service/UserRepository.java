package org.overmind.baseresponse.example.user.service;

import org.overmind.baseresponse.example.user.model.User;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class UserRepository {

    private final Map<String, User> userMap;

    private UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Optional<User> findOne(String name) {
        String key = name.toLowerCase();

        return Optional.ofNullable(
                userMap.get(key)
        );
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final Map<String, User> userMap;

        private Builder() {
            this.userMap = new TreeMap<>();
        }

        public Builder with(User user) {
            String name = user.name();
            String key = name.toLowerCase();

            User previous = userMap.put(key, user);

            if (previous != null) {
                throw new IllegalArgumentException(
                        MessageFormat.format("User with name ''{0}'' already exists", name)
                );
            }

            return this;
        }

        public UserRepository build() {
            return new UserRepository(
                    Collections.unmodifiableMap(userMap)
            );
        }
    }
}
