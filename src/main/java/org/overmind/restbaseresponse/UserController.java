package org.overmind.restbaseresponse;

import org.overmind.restbaseresponse.response.Response;
import org.overmind.restbaseresponse.response.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.overmind.restbaseresponse.response.ResponseUtil.notFound;
import static org.overmind.restbaseresponse.response.ResponseUtil.ok;
import static org.overmind.restbaseresponse.response.ResponseUtil.usedCached;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{name}")
    public Response<User> findOne(@PathVariable("name") String name) {
        Response<String> asd = ok("asd");

        return userRepository.findOne(name)
                .map(ResponseUtil::ok)
                .orElseGet(() ->
                        notFound("user with name " + name)
                );
    }

    @GetMapping("/me")
    public Response<User> findOne() {
        return usedCached(User.of("Eugene", 24), "user");
    }
}
