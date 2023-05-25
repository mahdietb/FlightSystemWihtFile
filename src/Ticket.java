public class Ticket {
    private String ticketId;

    private String userName;
    private User user;


    public Ticket(String ticketId,String name) {
        this.ticketId = ticketId;
        this.userName=name;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
