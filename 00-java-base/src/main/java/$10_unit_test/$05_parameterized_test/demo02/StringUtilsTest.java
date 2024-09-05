package $10_unit_test.$05_parameterized_test.demo02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {

    static List<Arguments> testCapitalize() {
        return List.of( // arguments:
                Arguments.of("abc", "Abc"), //
                Arguments.of("APPLE", "Apple"), //
                Arguments.of("gooD", "Good"));
    }

    @ParameterizedTest
    @MethodSource
    void testCapitalize(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }

    @ParameterizedTest
    @CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
    void testCapitalizeByCsv(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = { "/test-capitalize.csv" })
    void testCapitalizeUsingCsvFile(String input, String result) {
        assertEquals(result, StringUtils.capitalize(input));
    }
}
