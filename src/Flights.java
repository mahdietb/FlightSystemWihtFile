import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Flights extends FileWriter<Flight> {
    Scanner input = new Scanner(System.in);
    private  final int RECORD_SIZE = 212;
    private RandomAccessFile flightFile;

    public Flights(RandomAccessFile flightFile) {
        this.flightFile = flightFile;
    }

    @Override
    void writeFile(Flight flight) throws IOException {
        flightFile.writeChars(fixForWrite(flight.getId()));
        flightFile.writeChars(fixForWrite(flight.getOrigin()));
        flightFile.writeChars(fixForWrite(flight.getDestination()));
        flightFile.writeChars(fixForWrite(flight.getDate()));
        flightFile.writeChars(fixForWrite(flight.getTime()));
        flightFile.writeLong(flight.getPrice());
        flightFile.writeInt(flight.getSeats());
    }


    @Override
    public Flight read() throws IOException {

        String id = readFixChars(FIX_SIZE);
        String origin = readFixChars(FIX_SIZE);
        String destination = readFixChars(FIX_SIZE);
        String date = readFixChars(FIX_SIZE);
        String time = readFixChars(FIX_SIZE);
        long price = flightFile.readLong();
        int seats = flightFile.readInt();
        return new Flight(id, origin, destination, date, time, price, seats);
    }

    @Override
    public Flight creatObject() {
        System.out.print("id = ");
        String id = input.nextLine();
        System.out.print("origin = ");
        String origin = input.nextLine();
        System.out.print("destination = ");
        String destination = input.nextLine();
        System.out.print("time = ");
        String time = input.nextLine();
        System.out.print("date = ");
        String date = input.nextLine();
        System.out.print("price = ");
        long price = input.nextLong();
        System.out.print("seats = ");
        int seats = input.nextInt();
        return new Flight(id, origin, destination, time, date, price, seats);
    }


    public String readFixChars(int n) throws IOException {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tmp.append(flightFile.readChar());
        }
        return tmp.toString().trim();
    }

    public long getByteNum(long recordNum) {
        return RECORD_SIZE * recordNum;
    }


    public void moveFilePointer(long recordNum) throws IOException {
        flightFile.seek(getByteNum(recordNum));
    }


    public long getNumberOfRecord() throws IOException {
        return flightFile.length() / RECORD_SIZE;
    }


    public void closeFile() throws IOException {
        flightFile.close();
    }

    @Override
    public void shiftRecords(Flight flight) {

    }




}

