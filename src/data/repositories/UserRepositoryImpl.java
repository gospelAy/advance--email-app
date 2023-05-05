package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {

    private List<User> users = new ArrayList<>();

    User newUser = new User();
    private int counter = 0;

    @Override

    public User save(User user ) {
        boolean userHasNotBeenCreated = user.getId() == 0;
        if (userHasNotBeenCreated) {
            user.setId(generateUserId());
            users.add(user);
        }
        return user;
    }

    private int generateUserId() {

        return users.size() + 1;
    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        for (User user: users){
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress))
                return user;
        }
        return null;

    }

    @Override
    public long numberOfUsers() {
        return users.size();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public void delete(User owner) {

    }

    @Override
    public void delete(String mail) {

        newUser = findByEmailAddress(mail);
//        newUser.verifyUserPassword(password);
        users.remove(newUser);
    }


    @Override
    public void deleteAll() {
        while (users.size() > 0) {

            users.remove(0);
            counter--;

        }
    }
}

