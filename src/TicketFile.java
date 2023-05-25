import java.io.IOException;
import java.io.RandomAccessFile;

public class TicketFile implements FileWriter<Ticket> {

    private final int RECORD_SIZE = 80;
    private RandomAccessFile ticketFile;

    @Override
    public void writeFile(Ticket ticket) throws IOException {
        ticketFile.writeChars(fixForWrite(ticket.getTicketId()));
        ticketFile.writeChars(fixForWrite(ticket.getUser().getUserName()));
    }

    @Override
    public String fixForWrite(String value) {
        return FileWriter.super.fixForWrite(value);
    }

    @Override
    public Ticket readStudentFromFile() throws IOException {
        String ticketId = readString(ticketFile);
        String userName = readString(ticketFile);
        return new Ticket(ticketId, userName);
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
        ticketFile.seek(getByteNum(recordNum));
    }

    @Override
    public long getNumberOfRecord() throws IOException {
        return ticketFile.length() / RECORD_SIZE;
    }

    @Override
    public void closeFile() throws IOException {
        ticketFile.close();
    }
}
