import java.io.IOException;
import java.io.RandomAccessFile;

public interface File<T> {
    int fixSize = 30;

    void writeFile(T instance);

    T readFile(RandomAccessFile file);

    /**
     * this method fix the size of every string
     *
     * @param value string value
     * @return the fixed size
     */
    default String fixForWrite(String value) {
        StringBuilder valueBuilder = new StringBuilder(value);
        while (valueBuilder.length() < fixSize)
            valueBuilder.append(" ");
        value = valueBuilder.toString();
        return value.substring(0, fixSize);
    }

    default String readString(RandomAccessFile file) throws IOException {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < fixSize; i++) {
            temp.append(file.readChar());
        }
        return temp.toString().trim();
    }



}
