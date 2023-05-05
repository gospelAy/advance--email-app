package services;

import data.models.Mail;
import dtos.requests.CreateMailRequest;
import dtos.requests.SignUpRequest;
import dtos.responses.FindMailResponse;
import dtos.responses.FindUserResponse;

public interface EmailService {

    Mail createMail(CreateMailRequest request);

    FindMailResponse findMail(String mail);

    FindMailResponse findByMailId(int id);
    //    List<FindUserResponse> findAll();
    String delete(Mail mail);
    String delete(String mail);

    String delete (int id);
}
