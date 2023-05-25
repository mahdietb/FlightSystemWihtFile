import java.io.IOException;
import java.io.RandomAccessFile;

public interface FileWriter {

    public interface File<T> {
        int fixSize = 30;

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





    }

}
