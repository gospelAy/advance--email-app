package services;

import data.models.Mail;
import data.models.User;
import data.repositories.MailRepository;
import data.repositories.MailRepositoryImpl;
import dtos.requests.CreateMailRequest;
import dtos.responses.FindMailResponse;
import utils.Mapper;

public class EmailServiceImpl implements EmailService{

    MailRepository mailRepository = new MailRepositoryImpl();

    static UserService userService = new UserServiceImpl();

    @Override
    public Mail createMail(CreateMailRequest requestToCreateMail) {
        Mail mail = new Mail();
        Mapper.map(requestToCreateMail, mail);
        return mailRepository.create(mail);
    }

    @Override
    public FindMailResponse findMail(String mail) {
        Mail foundMail = mailRepository.findByUserMail(mail);
        if (foundMail == null) throw new NullPointerException("User does not exist");
        FindMailResponse response = new FindMailResponse();
        Mapper.map(foundMail, response);
        return response;
    }

    @Override
    public FindMailResponse findByMailId(int id) {
        Mail foundMail = mailRepository.findByMailId(id);
        if (foundMail == null) throw new NullPointerException("Mail does not exist or have been deleted ");
        FindMailResponse response = new FindMailResponse();
        Mapper.map(foundMail, response);
        return response;
    }

    @Override
    public String delete(Mail mail) {
        return null;
    }

    @Override
    public String delete(String mail) {
        Mail foundMail = mailRepository.findByUserMail(mail);
        if (foundMail == null) throw new NullPointerException("Mail does not exist or have been deleted");
        mailRepository.deleteByOwnerEmail(mail);
        return "Mail successfully deleted";
    }


    @Override
    public String delete(int id) {
        Mail foundMail = mailRepository.findByMailId(id);
        if (foundMail == null) throw new NullPointerException("Mail does not exist or have been deleted");
        mailRepository.deleteByEmailId(id);
        return "Mail successfully deleted";
    }

}
