package data.repositories;

import data.models.Mail;

import java.util.ArrayList;
import java.util.List;



    public class MailRepositoryImpl implements MailRepository {

        private List<Mail> mails = new ArrayList<>();

        Mail newMail = new Mail();

        @Override
        public Mail create(Mail maker) {
            boolean mailHasNotBeenCreated = maker.getId() == 0;
            if (mailHasNotBeenCreated) {
                maker.setId(generateUserId());
                mails.add(maker);
            }
            return maker;
        }


        private int generateUserId() {
            return mails.size() + 1;
        }


        @Override
        public Mail findByMailId(int id) {
            for (Mail owner: mails){
                if (owner.getId() == (id))
                    return owner;
            }
            return null;
        }

        @Override
        public List<Mail> findAll(int id) {
            return null;
        }

        @Override
        public Mail findByUserMail(String mail) {
            for (Mail owner: mails){
                if (owner.getOwnerEmailAddress().equalsIgnoreCase(mail))
                    return owner;
            }
            return null;

        }

        @Override
        public void delete(Mail owner) {
            for (Mail mail: mails) {
                if (mail == owner){
                    mails.remove(owner);
                }
            }
        }

        @Override
        public void deleteByOwnerEmail(String mail) {
            newMail = findByUserMail(mail);
            mails.remove(newMail);
        }

        public void deleteByEmailId(int id) {
            newMail = findByMailId(id);
            mails.remove(newMail);
        }


        @Override
        public void deleteAll() {
            mails.clear();

        }

        @Override
        public long getNumberOfMails() {
            return mails.size();
        }
    }

