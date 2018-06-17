package org.overmind.baseresponse.example.user.service;

import org.overmind.baseresponse.ControlledException;
import org.overmind.baseresponse.ControlledExceptionHandler;
import org.overmind.baseresponse.Response;
import org.overmind.baseresponse.example.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.overmind.baseresponse.example.user.service.Responses.*;

@RestController
@RequestMapping("user")
public class UserController implements ControlledExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("{name}")
    public Response<User> findOne(@PathVariable("name") String name) {
        return userRepository.findOne(name)
                .map(Responses::ok)
                .orElseGet(() ->
                        notFound("user with name " + name)
                );
    }

    @GetMapping("me")
    public Response<User> findOne() {
        return usedCached(User.of("Eugene", 24), "user");
    }

    @Override
    public void processControlledException(ControlledException e) {
        logger.error("Exception during '/user' processing", e);
    }
}
