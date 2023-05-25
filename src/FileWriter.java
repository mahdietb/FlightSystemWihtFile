import java.io.IOException;
import java.io.RandomAccessFile;

public interface FileWriter<T> {
    int fixSize = 30;

    /**
     * method for writing the file
     * @param instance instance of our object
     */
    void writeFile(T instance);

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

    /**
     * this method is for reading data from our file
     * @return created instance with the data
     */
    T readStudentFromFile();


    /**
     * this method help to read strings with char method from file class
     * @param file our randomAccessFile
     * @return the string
     * @throws IOException input or output exception
     */
    default String readString(RandomAccessFile file) throws IOException {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < fixSize; i++) {
            temp.append(file.readChar());
        }
        return temp.toString().trim();
    }


}


