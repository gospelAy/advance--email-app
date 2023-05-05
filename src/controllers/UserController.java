package controllers;

import dtos.requests.SignUpRequest;
import dtos.responses.FindUserResponse;
import services.UserService;
import services.UserServiceImpl;

public class UserController {

    private UserService userService = new UserServiceImpl();

    public Object register(SignUpRequest request) {
        try {
            return userService.register(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    public FindUserResponse findUserByEmailAddress(String mail, String password) {
        return userService.findUser(mail, password);
    }

    public String deleteAccountByOwnerEmailAddress(String mail, String password) {
        try {
            return userService.delete(mail, password);
        } catch (IllegalArgumentException | NullPointerException ex) {
            return ex.getMessage();
        }
    }

}

