import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FlightRecord implements FileWriter<Flight> {

    private final int RECORD_SIZE = 212;
    private RandomAccessFile flightFile;

    public FlightRecord(RandomAccessFile flightFile) {
        this.flightFile = flightFile;
    }

    @Override
    public void writeFile(Flight flight) throws IOException {
        flightFile.writeChars(fixForWrite(flight.getId()));
        flightFile.writeChars(fixForWrite(flight.getOrigin()));
        flightFile.writeChars(fixForWrite(flight.getDestination()));
        flightFile.writeChars(fixForWrite(flight.getDate()));
        flightFile.writeChars(fixForWrite(flight.getTime()));
        flightFile.writeLong(flight.getPrice());
        flightFile.writeInt(flight.getSeats());
    }

    @Override
    public String fixForWrite(String value) {
        return FileWriter.super.fixForWrite(value);
    }

    @Override
    public Flight readStudentFromFile() throws IOException {
        String id = readString(flightFile);
        String origin = readString(flightFile);
        String destination = readString(flightFile);
        String date = readString(flightFile);
        String time = readString(flightFile);
        long price = flightFile.readLong();
        int seats = flightFile.readInt();
        return new Flight(id, origin, destination, date, time, price, seats);
    }

    @Override
    public String readString(RandomAccessFile file) throws IOException {
        return FileWriter.super.readString(file);
    }

    @Override
    public long getByteNum(long recordNum) {
        return RECORD_SIZE * recordNum;
    }

    @Override
    public void moveFilePointer(long recordNum) throws IOException {
        flightFile.seek(getByteNum(recordNum));
    }

    @Override
    public long getNumberOfRecord() throws IOException {
        return flightFile.length() / RECORD_SIZE;
    }

    @Override
    public void closeFile() throws IOException {
        flightFile.close();
    }
}
