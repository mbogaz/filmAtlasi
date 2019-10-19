package com.filmatlasi.dev.controller.v1;

import com.filmatlasi.dev.dto.model.UserDto;
import com.filmatlasi.dev.dto.model.UserSignupRequest;
import com.filmatlasi.dev.dto.resource.Response;
import com.filmatlasi.dev.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@Api(value="film-atlasi-application", description="Operations pertaining to user management in the filmatlasi application")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public Response signup(@RequestBody @Valid UserSignupRequest userSignupRequest) {
        return Response.ok().setPayload(registerUser(userSignupRequest, false));
    }

    @GetMapping("/all")
    public Response getAllUsers() {
        return Response.ok().setPayload(userService.getAllUsers());
    }

    private UserDto registerUser(UserSignupRequest userSignupRequest, boolean isAdmin) {
        UserDto userDto = new UserDto()
                .setEmail(userSignupRequest.getEmail())
                .setPassword(userSignupRequest.getPassword())
                .setFirstName(userSignupRequest.getFirstName())
                .setLastName(userSignupRequest.getLastName())
                .setMobileNumber(userSignupRequest.getMobileNumber())
                .setAdmin(isAdmin);

        return userService.signup(userDto);
    }

}
