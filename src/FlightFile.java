import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class FlightFile {

    private Map<String, List<Flight>> search = new HashMap<>();
    private List<Flight> flights = new ArrayList<>();
    Fill fill = new Fill();

    private RandomAccessFile flightFile;

    public void addDefault() {
        flights.add(new Flight("WS-12", "Yazd", "Isfahan", "12:31", "1402-03-14", 700000, 12));
        flights.add(new Flight("WA-43", "Tehran", "Isfahan", "00:31", "1402-02-14", 1000000, 119));
        flights.add(new Flight("AD-31", "Tehran", "Rasht", "09:00", "1402-02-10", 900000, 89));
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

    public void writeFile() throws IOException {
        checkData();
        RandomAccessFile flightFile = new RandomAccessFile("flights.dat", "rw");
        Flights file = new Flights(flightFile);
        for (Flight flight : flights) {
            file.writeFile(flight);
        }
    }

    public List<Flight> readRecordsFromFile() throws IOException {
        List<Flight> flightList = new ArrayList<>();
        RandomAccessFile flightFile = new RandomAccessFile("flights.dat", "rw");
        Flights file = new Flights(flightFile);
        flightFile.seek(0);
        for (int i = 0; i < file.getNumberOfRecord(); i++) {
            flightList.add(file.read());
        }
        file.closeFile();
        return flightList;
    }

    /**
     * this method is for adding new record of flight
     *
     * @throws IOException
     */
    public void addFlight() throws IOException {
        RandomAccessFile flightFile = new RandomAccessFile("flights.dat", "rw");
        Flights file = new Flights(flightFile);
        flightFile.seek(flightFile.length());
        flights.add(file.creatObject());
        int size = flights.size();
        file.writeFile(flights.get(size - 1));
        file.closeFile();

    }

    public void checkData() {
        if (flights.isEmpty()) {
            addDefault();
        }
    }


    public void removeFlight() throws FileNotFoundException {
        RandomAccessFile flightFile = new RandomAccessFile("flights.dat", "rw");
        Flights file = new Flights(flightFile);


    }

    /**
     * this method is up to find the intended flightRecord ib file
     *
     * @param id the id of intended flight
     * @throws IOException no
     */
    public Flight findingRecord(String id, int index) throws IOException {
        Flight flight = null;
        RandomAccessFile flightFile = new RandomAccessFile("flights.dat", "rw");
        Flights file = new Flights(flightFile);
        for (int i = 0; i < file.getNumberOfRecord(); i++) {
            file.moveFilePointer(i);
            if (file.readFixChars(file.FIX_SIZE).equals(id)) {
                file.moveFilePointer(i);
                flight = file.read();
                index = i;

            }
        }
        file.closeFile();
        return flight;
    }

    public void updateFlight(Scanner input) throws IOException {
        int index = 0;
        String id = input.nextLine();
        Flight flightNum1 = findingRecord(id, index);
        Flight flightNum2 = fill.fill();
        String flight1 = flightNum1.toString();
        String[] icons1 = flight1.split(",");
        String flight2 = flightNum2.toString();
        String[] icons2 = flight2.split(",");
        for (int i = 0; i < icons2.length; i++) {
            if (icons2[i] != null) {
                icons1[i] = icons2[i];
            }
        }
        RandomAccessFile flightFile = new RandomAccessFile("flights.dat", "rw");
        Flights file = new Flights(flightFile);
        file.moveFilePointer(index);
        long price=Long.parseLong(icons1[5]);
        file.writeFile(new Flight(icons1[0],icons1[1],icons1[2],icons1[3],icons1[4],price,Integer.parseInt(icons1[6])));
    }

}
