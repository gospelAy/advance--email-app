package services;

import data.repositories.UserRepositoryImpl;
import dtos.requests.SignUpRequest;
import dtos.responses.FindUserResponse;
import data.models.User;
import data.repositories.UserRepository;
import utils.Mapper;

public class UserServiceImpl implements UserService {

    private static UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User register(SignUpRequest registerRequest) {
//        if (userExist(registerRequest.getEmailAddress()) == true) throw new IllegalArgumentException
        if (userExist(registerRequest.getEmailAddress())) throw new IllegalArgumentException
                (registerRequest.getEmailAddress() + " is already taken by a user, Kindly think about another mail address");
        return userRepository.save(Mapper.map(registerRequest));
    }

    private boolean userExist(String emailAddress) {
        User found = userRepository.findByEmailAddress(emailAddress);
        return found != null;
    }

    @Override
    public FindUserResponse findUser(String mail, String password) {
        User foundUser = userRepository.findByEmailAddress(mail);
        if (foundUser == null) throw new NullPointerException("User does not exist");
        verifyUserPassword(mail, password);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }

    @Override
    public String delete(User user) {
        return "Successfully deleted";
    }

    @Override
    public String delete(String mail, String password) {
        User foundUser = userRepository.findByEmailAddress(mail);
        if (foundUser == null) throw new NullPointerException("User does not exist");
        verifyUserPassword(mail,password);
        userRepository.delete(mail);
        return "User successfully deleted";
    }

    public void verifyUserPassword(String mail, String password) {
        User foundUser = userRepository.findByEmailAddress(mail);
        if (!foundUser.getPassword().equals(password)) {
            throw new IllegalArgumentException("incorrect password");
        }
    }
}
