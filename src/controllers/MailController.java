package controllers;

import dtos.requests.CreateMailRequest;
import dtos.responses.FindMailResponse;

import services.EmailService;
import services.EmailServiceImpl;

public class MailController {

    private EmailService mailService = new EmailServiceImpl();

    public Object createMail(CreateMailRequest request) {
        try {
            return (mailService.createMail(request));
        } catch (IllegalArgumentException ex){
            return (ex.getMessage());
        }
    }

    public FindMailResponse findByOwnerMailId(int id) {
        return mailService.findByMailId(id);
    }

    public String deleteMailByMailId(int id){
        try{
            return mailService.delete(id);
        } catch (IllegalArgumentException | NullPointerException ex) {
            return ex.getMessage();
        }
    }


}
