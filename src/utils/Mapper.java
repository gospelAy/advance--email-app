package utils;

import data.models.Mail;
import dtos.requests.CreateMailRequest;

import dtos.requests.SignUpRequest;
import dtos.responses.FindMailResponse;
import dtos.responses.FindUserResponse;
import data.models.User;

import java.time.format.DateTimeFormatter;

public class Mapper {


    public static User map(SignUpRequest registerRequest){
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmailAddress(registerRequest.getEmailAddress());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

    public static void map(User foundUser, FindUserResponse response){
        response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setEmailAddress(foundUser.getEmailAddress());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
    }

    public static void map(CreateMailRequest createMailRequest, Mail mail) {
        mail.setSubject(createMailRequest.getSubject());
        mail.setBody(createMailRequest.getBody());
        mail.setOwnerEmailAddress(createMailRequest.getOwnerEmailAddress());
    }

    public static void map(Mail foundMail, FindMailResponse response) {
        response.setId(foundMail.getId());
        response.setSubject(foundMail.getSubject());
        response.setBody(foundMail.getBody());
        response.setOwnerEmailAddress(foundMail.getOwnerEmailAddress());
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
//        response.setTimeCreated(LocalDateTime.parse(formatter.format(foundMail.getTimeCreated())));

    }
}
