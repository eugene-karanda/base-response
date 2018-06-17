package org.overmind.br.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(MyRunner.class);

    private final UserServiceClient userServiceClient;

    @Autowired
    public MyRunner(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Override
    public void run(String... args) {
        logger.info("Response from user-service: {}", userServiceClient.findOne("Oleg"));
    }

}
