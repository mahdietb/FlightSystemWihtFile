import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightsFile extends FlightRecord implements CreatedFileRequirement<FlightRecord> {
    List<Flight> flights = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public FlightsFile(RandomAccessFile flightFile ) throws FileNotFoundException {
        super(flightFile);
//, flights
    }

    private RandomAccessFile originalFile = new RandomAccessFile("flightsFile", "rw");
//    FlightsFile flightsFile = new FlightsFile(originalFile);

    public void addDefault() {
        flights.add(new Flight("WS-12", "Yazd", "Isfahan", "12:31", "1402-03-14", 700000, 12));
        flights.add(new Flight("WA-43", "Tehran", "Isfahan", "00:31", "1402-02-14", 1000000, 119));
        flights.add(new Flight("AD-31", "Tehran", "Rasht", "09:00", "1402-02-10", 900000, 89));
        flights.add(new Flight("MN-02", "KishIsland", "Isfahan", "10:45", "1402-01-02", 1300000, 8));
        flights.add(new Flight("KA-12", "Tehran", "Qom", "11:30", "1402-02-01", 700000, 100));
        flights.add(new Flight("BG-44", "Isfahan", "Mashhad", "12:40", "1402-01-20", 1500000, 87));
        flights.add(new Flight("BG-71", "Mashhad", "Tehran", "01:40", "1402-03-12", 1500000, 77));
        flights.add(new Flight("ZX-10", "Mashhad", "Isfahan", "13:50", "1402-03-09", 1300000, 137));
        flights.add(new Flight("SE-11", "Shiraz", "Yazd", "10:00", "1402-01-08", 900000, 70));
        flights.add(new Flight("HJ-11", "Tabriz", "Mashhad", "00:20", "1402-01-21", 1500000, 60));
        flights.add(new Flight("GS-13", "Qom", "Tehran", "01:10", "1402-03-02", 500000, 17));
        flights.add(new Flight("GZ-27", "Abadan", "Isfahan", "08:00", "1402-04-12", 1000000, 5));
        flights.add(new Flight("JK-34", "Tehran", "Isfahan", "11:00", "1402-01-13", 1000000, 130));
        flights.add(new Flight("SH-65", "Mashhad", "Isfahan", "17:20", "1402-01-20", 1500000, 67));
        flights.add(new Flight("PL-19", "Rasht", "Tabriz", "00:00", "1402-02-22", 700000, 230));
        flights.add(new Flight("RA-88", "Kerman", "Isfahan", "15:00", "1402-04-29", 1000000, 44));
        flights.add(new Flight("YU-71", "KishIsland", "Tehran", "21:30", "1402-03-30", 1700000, 117));
        flights.add(new Flight("WZ-54", "Shiraz", "chabahar", "11:40", "1402-01-27", 800000, 90));
        flights.add(new Flight("PO-56", "Ramsar", "Tehran", "08:30", "1402-03-10", 800000, 9));
    }


    public void checkData() {
        if (flights.isEmpty()) {
            addDefault();
        }
    }

    public void writeOriginalFile() throws IOException {

        checkData();
        for (Flight flight : flights) {
            writeFile(flight);
        }

    }

    @Override
    public void addObject() throws IOException {
        String id = input.nextLine();
        String origin = input.nextLine();
        String destination = input.nextLine();
        String time = input.nextLine();
        String date = input.nextLine();
        long price = input.nextLong();
        int seats = input.nextInt();
        Flight flight = new Flight(id, origin, destination, time, date, price, seats);
        flights.add(flight);
        moveFilePointer(19);
        writeFile(flight);
    }

    @Override
    public FlightRecord removeObject() {
        return null;
    }

    @Override
    public void creatFile(FlightRecord flightRecord) {

    }

    @Override
    public void readFile() throws IOException {
        long size = getNumberOfRecord();
        Flight flight = readStudentFromFile();
        System.out.print("Flight " + ")");
        System.out.println(flight);


    }
}
