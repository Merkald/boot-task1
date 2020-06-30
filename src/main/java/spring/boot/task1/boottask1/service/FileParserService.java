package spring.boot.task1.boottask1.service;

public interface FileParserService<T> {
    T parseFile(String path);
}
