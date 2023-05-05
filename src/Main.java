import controllers.UserController;
import controllers.MailController;
import dtos.requests.CreateMailRequest;
import dtos.requests.SignUpRequest;
import dtos.responses.FindMailResponse;
import dtos.responses.FindUserResponse;

import javax.swing.*;

public class Main {

    private static UserController userController = new UserController();
    private static MailController mailController = new MailController();
    private static FindUserResponse profile;

    private static FindMailResponse mailResponse;

    public static void main(String[] args) {
        startApp();
    }
    private static void startApp() {
        String message = """
                Hi Welcome, What would you like to do?::
                1 -> Create Account
                2 -> Login
                3 -> Exit
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> register();
            case '2' -> login();
            case '3' -> exitApplication();
            default -> {
                display("Invalid input try again");
                startApp();
            }
        }
    }
    private static void register() {
        try {
            SignUpRequest request = new SignUpRequest();
            request.setFirstName(input("Enter first Name "));
            request.setLastName(input("Enter last Name "));
            request.setEmailAddress(input("Enter mail address of your choice "));
            request.setPassword(input("Enter password "));
            var result = userController.register(request);
            display("Account created successfully");
            display(result.toString());
            startApp();
        } catch (IllegalArgumentException e){
            display(e.getMessage());
            startApp();
        }
    }

    private static void login() {
        String mail = input("Enter user email address ");
        String password = input("Provide your password");
        try {
            profile = userController.findUserByEmailAddress(mail, password);
            display("Logged in");
            continueInApp();
        }catch (IllegalArgumentException | NullPointerException e){
            display(e.getMessage());
            startApp();
        }
    }

    private static void exitApplication() {
        display("Thanks for using this application ");
        System.exit(1);
    }


    private static void continueInApp() {
        String message = """
                1 -> Send mail
                2 -> Delete Mail
                3 -> Delete Account
                4 -> Inbox
                5 -> Outbox
                6 -> Logout
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> sendMail();
            case '2' -> deleteMail();
            case '3' -> deleteAccount();
            case '4' -> inbox();
            case '5' -> outbox();
            case '6' -> logout();
            default -> {
                display("Invalid input try again");
                continueInApp();
            }
        }
    }


    private static void sendMail() {
        CreateMailRequest request = new CreateMailRequest();
        request.setSubject(input("What's ur title ? "));
        request.setBody(input("compose the mail you want to send here :"));
        String receiver = input ("Destination email address");
        request.setOwnerEmailAddress(profile.getEmailAddress());
        var post = mailController.createMail(request);
//        display(post.toString());
        display("Mail sent");
        continueInApp();
    }

    private static void deleteMail() {
        int userInput = Integer.parseInt(input("Enter the mail Id: "));
        display( mailController.deleteMailByMailId(userInput));
        continueInApp();
    }

    private static void deleteAccount() {
        String password = input("Enter your password to confirm you own this account");
        display( userController.deleteAccountByOwnerEmailAddress(profile.getEmailAddress(), password));
        startApp();
    }



    private static void inbox() {
        int userInput = Integer.parseInt(input("Enter the mail Id: "));
        try {

            mailResponse =  mailController.findByOwnerMailId(userInput);
            display(mailResponse.toString());

        }
        catch (IllegalArgumentException | NullPointerException ex) {
            display(ex.getMessage());
            continueInApp();
        }
        continueInApp();
    }

    private static void outbox() {
        int userInput = Integer.parseInt(input("Enter the mail ID: "));
        try {

            mailResponse =  mailController.findByOwnerMailId(userInput);

            display(mailResponse.toString());
        }
        catch (IllegalArgumentException | NullPointerException ex) {
            display(ex.getMessage());
            continueInApp();
        }
        continueInApp();
    }

    private static void logout() {
        display(" Logged out");
        startApp();
    }


    private static void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static String input(String dialogue) {
        return JOptionPane.showInputDialog(dialogue);
    }
}