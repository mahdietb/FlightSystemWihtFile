import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UserFile implements FileWriter<User> {

    private final int RECORD_SIZE = 80;
    private RandomAccessFile userFile;

    public UserFile(String fileName) throws FileNotFoundException {
        this.userFile = new RandomAccessFile(fileName, "rw");
    }


    @Override
    public void writeFile(User user) throws IOException {
        userFile.writeChars(fixForWrite(user.getUserName()));
        userFile.writeChars(fixForWrite(user.getPassword()));
        userFile.writeInt(user.getCharge());
    }

    @Override
    public String fixForWrite(String value) {
        return FileWriter.super.fixForWrite(value);
    }

    @Override
    public User readStudentFromFile() throws IOException {
        String username = readString(userFile);
        String password = readString(userFile);
        int charge = userFile.readInt();
        return new User(username, password, charge);
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
        userFile.seek(getByteNum(recordNum));
    }

    @Override
    public long getNumberOfRecord() throws IOException {
        return userFile.length() / RECORD_SIZE;
    }

    @Override
    public void closeFile() throws IOException {
        userFile.close();
    }
}

