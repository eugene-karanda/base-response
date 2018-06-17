package org.overmind.baseresponse.example.user.service;

import org.overmind.baseresponse.example.user.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public UserRepository userRepository() {
        return UserRepository.builder()
                .with(User.of("Anton", 24))
                .with(User.of("Maxim", 28))
                .with(User.of("Oleg", 23))
                .build();
    }
}
