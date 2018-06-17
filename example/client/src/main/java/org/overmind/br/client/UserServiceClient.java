package org.overmind.br.client;

import org.overmind.baseresponse.example.user.model.User;
import org.overmind.br.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "http://localhost:8080", name = "userServiceClient")
@RequestMapping("user")
public interface UserServiceClient {

    @GetMapping("{name}")
    Response<User> findOne(@PathVariable("name") String name);

    @GetMapping("me")
    Response<User> findOne();
}