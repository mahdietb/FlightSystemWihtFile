import java.io.IOException;

public abstract class FileWriter<T> {

    final int FIX_SIZE = 20;

    /**
     * method for writing the file
     *
     * @param t instance of our object
     */
    abstract void writeFile(T t) throws IOException;


    public String fixForWrite(String value) {
        StringBuilder valueBuilder = new StringBuilder(value);
        while (valueBuilder.length() < FIX_SIZE)
            valueBuilder.append(" ");
        value = valueBuilder.toString();
        return value.substring(0, FIX_SIZE);
    }


    public abstract T read() throws IOException;

    public abstract T creatObject();
    public void shiftRecords(T t){

    }



}











