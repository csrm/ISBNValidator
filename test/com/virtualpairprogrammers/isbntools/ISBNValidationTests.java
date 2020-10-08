package com.virtualpairprogrammers.isbntools;

import org.junit.Test;

import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;

public class ISBNValidationTests {
    @Test
    public void checkAValidISBN() {
        ValidateISBN isbn = new ValidateISBN();
        boolean result = isbn.checkISBN("0140449116");
        assertTrue("First Value", result);
        result = isbn.checkISBN("0140177396");
        assertTrue("Second Value", result);
    }

    @Test
    public void endingWithXAreValid() {
        ValidateISBN isbn = new ValidateISBN();
        boolean result = isbn.checkISBN("012000030X");
        assertTrue("Ending with X", result);
    }
    @Test
    public void checkInValidISBN() {
        ValidateISBN isbn = new ValidateISBN();
        boolean result = isbn.checkISBN("0140449016");
        assertFalse(result);
    }
    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNNotAllowed() {
        ValidateISBN isbn = new ValidateISBN();
        boolean result = isbn.checkISBN("123456789");
    }
    @Test
    public void nonNumericNotAllowed() {
        ValidateISBN isbn = new ValidateISBN();
        assertThrows(NumberFormatException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                boolean result = isbn.checkISBN("helloworld");
            }
        });
    }

}
