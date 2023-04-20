package by.tms.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private static char [] inputArray;

    @BeforeEach
    public void prepareArray(){
        inputArray = new char[]{'h','e','l',' ', 'w'};
    }


    @Test
    void shouldPrintStringWithoutGoToTheNextLine() {

    }

    @Test
    void println() {
    }

    @Test
    void shouldReturnFalseIfNotEmptyArray() {

        assertEquals(false, StringUtils.isBlank(inputArray));
    }

    @Test
    void shouldReturnTrueIfIsEmpty() {
        inputArray = new char[]{};
        assertEquals(true, StringUtils.isBlank(inputArray));
    }

    @Test
    void shouldReturnTrueIfStringHasAllRussianCharacters() {
        inputArray = new char[]{'ы','я','о'};
        assertEquals(true, StringUtils.isRussian(inputArray));
    }

    @Test
    void shouldReturnFalseIfStringHasRussianAndOtherCharacters() {
        inputArray = new char[]{'ы','1','I','#'};
        assertEquals(false, StringUtils.isRussian(inputArray));
    }

    @Test
    void shouldReturnFalseIfStringHasNoRussianCharacter() {
        assertEquals(false, StringUtils.isRussian(inputArray));
    }

    @Test
    void shouldReturnFalseIfSubstringLengthMoreThanMainString() {
        char [] substring = new char[]{'n','e','w',' ','s','u','b'};
        assertEquals(false, StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnTrueIfSubstringLengthIsEmpty() {
        char [] substring = new char[]{};
        assertEquals(true, StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnTrueIfSubstringAdMainStringsLengthAreZero() {
        char [] substring = new char[]{};
        char [] inputArray = new char[]{};
        assertEquals(true, StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnFalseIfMainStringsLengthIsZero() {
        char [] substring = new char[]{'1','2'};
        char [] inputArray = new char[]{};
        assertEquals(false, StringUtils.contains(inputArray, substring));

    }

    @Test
    void shouldReturnTrueIfSubstringIsPartOfMainString() {
        char [] substring = new char[]{'e','l',' '};
        assertEquals(true, StringUtils.contains(inputArray, substring));
    }

    @Test
    void shouldReturnFalseIfSubstringIsNotPartOfMainString() {
        char [] substring = new char[]{'z','l','o'};
        assertEquals(false, StringUtils.contains(inputArray, substring));
    }

    @Test
    void shouldReturnNumberIfStringConsistOnlyDigits() {
        inputArray = new char[]{'1','2','3'};
        int result = StringUtils.parseInt(inputArray);
        assert(123 == result );
    }

    @Test
    void shouldThrowExceptionIfStringConsistNotOnlyDigits() {
        inputArray = new char[]{'1','g','3'};

        assertThrows(IllegalArgumentException.class,
                ()->StringUtils.parseInt(inputArray));
    }
}