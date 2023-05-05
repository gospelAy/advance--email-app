package data.repositories;

import data.models.Mail;

import java.util.List;

public interface MailRepository {
    Mail create(Mail maker);

    Mail findByMailId(int id);

    List<Mail> findAll(int id);

    Mail findByUserMail(String mail);

    void delete (Mail owner);

    void deleteByOwnerEmail (String mail);

    void deleteByEmailId(int id);

    void deleteAll();

    long getNumberOfMails();
}

