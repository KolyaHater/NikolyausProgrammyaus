package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }
    
    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }
    @Test
    void isPrimeReturnsFalseForNumbersLessThanTwo() {
        boolean result1 = CourseToolkit.isPrime(1);
        boolean result2 = CourseToolkit.isPrime(0);
        boolean result3 = CourseToolkit.isPrime(-5);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void isPrimeReturnsTrueForTwo() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }

    @Test
    void isPrimeReturnsTrueForPrimeNumbers() {
        boolean result1 = CourseToolkit.isPrime(3);
        boolean result2 = CourseToolkit.isPrime(17);

        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void isPrimeReturnsFalseForCompositeAndSquares() {
        boolean result1 = CourseToolkit.isPrime(4);
        boolean result2 = CourseToolkit.isPrime(9);
        boolean result3 = CourseToolkit.isPrime(49);

        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }
    @Test
    void isPalindromeReturnsTrueForPalindrome() {
        boolean result1 = CourseToolkit.isPalindrome("aba");
        boolean result2 = CourseToolkit.isPalindrome("a");
        boolean result3 = CourseToolkit.isPalindrome("");

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    void isPalindromeReturnsFalseForNonPalindrome() {
        boolean result = CourseToolkit.isPalindrome("abc");

        assertFalse(result);
    }

    @Test
    void isPalindromeThrowsOnNull() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    @Test
    void averageCalculatesCorrectly() {
        double result1 = CourseToolkit.average(new int[]{1, 2, 3, 6});
        double result2 = CourseToolkit.average(new int[]{-1, -2});

        assertEquals(3.0, result1, 0.0001);
        assertEquals(-1.5, result2, 0.0001);
    }

    @Test
    void averageThrowsOnNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[]{}));
    }
}
