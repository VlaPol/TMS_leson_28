package by.tms.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private static final char[] inputArray = new char[]{'h', 'e', 'l', ' ', 'w'};

    @Test
    void shouldReturnFalseIfNotEmptyArray() {
        assertFalse(StringUtils.isBlank(inputArray));
    }

    @Test
    void shouldReturnTrueIfIsEmpty() {
        char[] emptyArray = new char[]{};
        assertTrue(StringUtils.isBlank(emptyArray));
    }

    @Test
    void shouldReturnTrueIfStringHasAllRussianCharacters() {
        char[] russianArray = new char[]{'ы', 'я', 'о'};
        assertTrue(StringUtils.isRussian(russianArray));
    }

    @Test
    void shouldReturnFalseIfStringHasRussianAndOtherCharacters() {
        char[] mixedArray = new char[]{'ы', '1', 'I', '#'};
        assertFalse(StringUtils.isRussian(mixedArray));
    }

    @Test
    void shouldReturnFalseIfStringHasNoRussianCharacter() {
        assertFalse(StringUtils.isRussian(inputArray));
    }

    @Test
    void shouldReturnFalseIfSubstringLengthMoreThanMainString() {
        char[] substring = new char[]{'n', 'e', 'w', ' ', 's', 'u', 'b'};
        assertFalse(StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnTrueIfSubstringLengthIsEmpty() {
        char[] substring = new char[]{};
        assertTrue(StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnTrueIfSubstringAdMainStringsLengthAreZero() {
        char[] substring = new char[]{};
        char[] inputArray = new char[]{};
        assertTrue(StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnFalseIfMainStringsLessThenSubstring() {
        char[] substring = new char[]{'1', '2'};
        char[] inputArray = new char[]{};
        assertFalse(StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnTrueIfSubstringIsPartOfMainString() {
        char[] substring = new char[]{'e', 'l', ' '};
        assertTrue(StringUtils.contains(inputArray, substring));
    }

    @Test
    void shouldReturnFalseIfSubstringIsNotPartOfMainString() {
        char[] substring = new char[]{'z', 'l', 'o'};
        assertFalse(StringUtils.contains(inputArray, substring));
    }

    @Test
    void shouldReturnNumberIfStringConsistOnlyDigits() {
        char[] digitArray = new char[]{'1', '2', '3'};
        int result = StringUtils.parseInt(digitArray);
        assert (123 == result);
    }

    @Test
    void shouldThrowExceptionIfStringConsistNotOnlyDigits() {
        char[] digitMixedArray = new char[]{'1', 'g', '3'};

        assertThrows(IllegalArgumentException.class,
                () -> StringUtils.parseInt(digitMixedArray));
    }

    @Test
    void shouldReturnFalseIfStringHasBlanksCharacters() {
        char[] emptyArray = new char[]{'\n', '\t'};
        assertTrue(StringUtils.isBlank(emptyArray));
    }

    @Test
    void shouldReturnTrueIfAllLowerCaseCharAreRussian() {
        char[] lowerRussianCharacters = new char[]{'в', 'з', 'ё', 'е'};
        assertTrue(StringUtils.isRussian(lowerRussianCharacters));
    }

    @Test
    void shouldReturnTrueIfAllUpperCaseCharAreRussian() {
        char[] upperRussianCharacters = new char[]{'В', 'Н', 'Ё', 'О'};
        assertTrue(StringUtils.isRussian(upperRussianCharacters));
    }

    @Test
    void shouldReturnFalseIfInputArrayIsEmpty() {
        char[] emptyArray = new char[]{};
        assertTrue(StringUtils.isRussian(emptyArray));
    }

}