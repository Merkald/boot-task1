package spring.boot.task1.boottask1.service.impl.link;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.service.FileService;

@Primary
@Service
public class LinkServiceImpl implements FileService {
    @Override
    public List<String> readFile(String path) {
        try {
            URL url = new URL(path);
            try (BufferedReader bufferedReader =
                         new BufferedReader(new InputStreamReader(url.openStream()))) {
                return bufferedReader
                        .lines()
                        .collect(Collectors.toList());
            } catch (FileNotFoundException e) {
                throw new RuntimeException("File doesnt exist");
            } catch (IOException e) {
                throw new RuntimeException("IOException", e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("url exception", e);
        }
    }
}
