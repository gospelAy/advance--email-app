package services;

import dtos.requests.SignUpRequest;
import dtos.responses.FindUserResponse;
import data.models.User;

public interface UserService {

    User register(SignUpRequest request);

    FindUserResponse findUser(String mail, String password);
    //    List<FindUserResponse> findAll();
    String delete(User user);
    String delete(String mail, String password);
}
