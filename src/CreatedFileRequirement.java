public interface CreatedFileRequirement<T> {
    T addObject();

    T removeObject();

    void creatFile(T t);

    T readFile();

}
