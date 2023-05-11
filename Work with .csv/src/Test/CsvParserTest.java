package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import com.example.CsvReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;

public class CsvParserTest {

    @Test
    public void testParseCsv() throws IOException, CsvException {
        StringReader reader = new StringReader("Name, Age, Gender\nJohn, 25, Male\nJane, 30, Female\n");

        String csvFilePath = "data/test.csv";
        char separatorTest = ',';

        CsvReader csvReader = new CsvReader();
        List<List<String>> result = csvReader.readCsv(csvFilePath, separatorTest);

        assertEquals(3, result.size());

        assertEquals("Name", result.get(0).get(0));
        assertEquals(" Age", result.get(0).get(1));
        assertEquals(" Gender", result.get(0).get(2));

        assertEquals("John", result.get(1).get(0));
        assertEquals(" 25", result.get(1).get(1));
        assertEquals(" Male", result.get(1).get(2));

        assertEquals("Jane", result.get(2).get(0));
        assertEquals(" 30", result.get(2).get(1));
        assertEquals(" Female", result.get(2).get(2));
    }

}
