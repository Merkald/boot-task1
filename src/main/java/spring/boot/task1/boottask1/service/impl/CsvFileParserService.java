package spring.boot.task1.boottask1.service.impl;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.service.FileParserService;
import spring.boot.task1.boottask1.service.FileService;

@Service
public class CsvFileParserService implements FileParserService<List<Review>> {
    private static final int ID = 0;
    private static final int PRODUCT_ID = 1;
    private static final int USER_ID = 2;
    private static final int PROFILE_NAME = 3;
    private static final int HELPFULNESS_NUMERATOR = 4;
    private static final int HELPFULNESS_DENOMINATOR = 5;
    private static final int SCOPE = 6;
    private static final int TIME = 7;
    private static final int SUMMARY = 8;
    private static final int TEXT = 9;
    @Autowired
    @Qualifier(value = "linkServiceImpl")
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
