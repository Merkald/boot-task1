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
    private final int ID = 0;
    private final int PRODUCT_ID = 1;
    private final int USER_ID = 2;
    private final int PROFILE_NAME = 3;
    private final int HELPFULNESS_NUMERATOR = 4;
    private final int HELPFULNESS_DENOMINATOR = 5;
    private final int SCOPE = 6;
    private final int TIME = 7;
    private final int SUMMARY = 8;
    private final int TEXT = 9;
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
        String[] splittedLine = line.split(",");
        dates.setId(Long.parseLong(splittedLine[ID]));
        dates.setProductId(splittedLine[PRODUCT_ID]);
        dates.setUserId(splittedLine[USER_ID]);
        dates.setProfileName(splittedLine[PROFILE_NAME]);
        dates.setHelpfulnessNumerator(Long.parseLong(splittedLine[HELPFULNESS_NUMERATOR]));
        dates.setHelpfulnessDenominator(Long.parseLong(splittedLine[HELPFULNESS_DENOMINATOR]));
        dates.setScore(Long.parseLong(splittedLine[SCOPE]));
        dates.setTime(Long.parseLong(splittedLine[TIME]));
        dates.setSummary(splittedLine[SUMMARY]);
        dates.setText(splittedLine[TEXT]);
        return dates;
    }
}
