package org.overmind.baseresponse.example.user.service;

import org.overmind.baseresponse.Response;
import org.overmind.baseresponse.example.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.overmind.baseresponse.example.user.service.Responses.*;

@RestController
@RequestMapping("user")
public class UserController {

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
}
