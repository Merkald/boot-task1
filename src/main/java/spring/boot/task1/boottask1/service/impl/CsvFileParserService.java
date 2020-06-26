package spring.boot.task1.boottask1.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.CsvGroupedDates;
import spring.boot.task1.boottask1.service.FileParserService;
import spring.boot.task1.boottask1.service.FileService;

@Service
public class CsvFileParserService implements FileParserService<List<CsvGroupedDates>> {
    @Autowired
    private FileService fileService;

    @Override
    public List<CsvGroupedDates> parseFile(String path) {
        return fileService.readFile(path)
                .stream()
                .map(this::parseString)
                .collect(Collectors.toList());
    }

    private CsvGroupedDates parseString(String line) {
        CsvGroupedDates dates = new CsvGroupedDates();
        String[] mass = line.split(",");
        dates.setId(Long.parseLong(mass[0]));
        dates.setProductId(mass[1]);
        dates.setUserId(mass[2]);
        dates.setProfileName(mass[3]);
        dates.setHelpfulnessNumerator(Long.parseLong(mass[4]));
        dates.setHelpfulnessDenominator(Long.parseLong(mass[5]));
        dates.setScore(Long.parseLong(mass[6]));
        dates.setTime(Long.parseLong(mass[7]));
        dates.setSummary(mass[8]);
        dates.setText(mass[9]);
        return dates;
    }
}
