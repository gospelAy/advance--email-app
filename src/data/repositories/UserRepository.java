package data.repositories;

import data.models.User;

import java.util.List;

public interface UserRepository{

    User save (User user);

    User findByEmailAddress(String EmailAddress);

    long numberOfUsers();

    List<User> findAll();

//    void delete (User owner);

    void delete (String mail);

    void deleteAll();




}
