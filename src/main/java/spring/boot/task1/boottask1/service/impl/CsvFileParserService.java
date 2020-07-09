package spring.boot.task1.boottask1.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.service.FileParserService;
import spring.boot.task1.boottask1.service.FileService;

@Service
public class CsvFileParserService implements FileParserService<List<Review>> {
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
    public List<Review> parseFile(String path) {
        List<String> lines = fileService.readFile(path);
        lines.remove(0);
        return lines
                .stream()
                .map(this::parseString)
                .collect(Collectors.toList());
    }

    private Review parseString(String line) {
        Review dates = new Review();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setMaxCharsPerColumn(100000);
        CsvParser csvParser = new CsvParser(settings);
        String[] splittedLine = csvParser.parseLine(line);
        dates.setId(Long.parseLong(splittedLine[ID]));
        dates.setProductId(splittedLine[PRODUCT_ID]);
        dates.setProfileId(splittedLine[USER_ID]);
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
