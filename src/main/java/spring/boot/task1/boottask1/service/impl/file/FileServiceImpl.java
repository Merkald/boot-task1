package spring.boot.task1.boottask1.service.impl.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.service.FileService;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader
                    .lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File doesnt exist");
        } catch (IOException e) {
            throw new RuntimeException("IOException", e);
        }
    }
}
