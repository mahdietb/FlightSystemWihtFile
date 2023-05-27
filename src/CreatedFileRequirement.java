import java.io.IOException;

public interface CreatedFileRequirement<T> {
    void addObject() throws IOException;

    T removeObject();

    void creatFile(T t);

    void readFile() throws IOException;

}
