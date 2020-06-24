package spring.boot.task1.boottask1.service.impl;

import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.service.FileService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String readFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader
                    .lines()
                    .reduce((s1, s2) -> s1 + s2)
                    .orElseThrow();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
