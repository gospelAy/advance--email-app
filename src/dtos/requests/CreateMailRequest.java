
package dtos.requests;


public class CreateMailRequest {


    private String subject;

    private String body;
    private String ownerEmailAddress;


    @Override
    public String toString() {
        return "CreateMailRequest{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }

    public void setOwnerEmailAddress(String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }
}
