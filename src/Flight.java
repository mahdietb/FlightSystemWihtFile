public class Flight {
    private String id;
    private String origin;
    private String destination;

    private String time;
    private String date;

    private long price;
    private int seats;

    public Flight(String id, String origin, String destination, String time, String date, long price, int seats) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.time = time;
        this.date = date;
        this.price = price;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", seats=" + seats +
                '}';
    }
}
