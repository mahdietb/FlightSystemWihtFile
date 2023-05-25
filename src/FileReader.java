import java.io.IOException;
import java.io.RandomAccessFile;

public interface FileReader<T> {

    int fixSize=30;


    T readStudentFromFile();
    default String readString(RandomAccessFile file) throws IOException {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < fixSize; i++) {
            temp.append(file.readChar());
        }
        return temp.toString().trim();
    }

}
