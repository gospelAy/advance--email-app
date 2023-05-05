package dtos.responses;

public class FindUserResponse {

    private int userId;

    private String emailAddress;

    private String fullName;

    private String dateRegistered;

    @Override
    public String toString() {
        return "FindUserResponses{" +
                "userId=" + userId +
                ", emailAddress='" + emailAddress + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateRegistered='" + dateRegistered + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }


}
