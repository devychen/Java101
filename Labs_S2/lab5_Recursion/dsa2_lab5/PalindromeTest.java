import org.junit.Test;
import static org.junit.Assert.*;

// Test class of Palindrome class to check isPalindromeRecursive method
public class PalindromeTest {

    @Test
    // Test if an empty line is a palindrome. Expect true
    public void testIsPalindrome_empty() {
        assertTrue(Palindrome.isPalindromeRecursive(""));
    }

    @Test
    // Test if a line with a length 1 is a palindrome. Expect true
    public void testIsPalindrome_length1() {
        assertTrue(Palindrome.isPalindromeRecursive("a"));
    }

    @Test
    // test if a line consisting of punctuation only is a palindrome --> expect true
    public void testIsPalindrome_punct() {
        assertTrue(Palindrome.isPalindromeRecursive(",!.??"));
    }

    @Test
    // test a line consisting of punctuation and one letter --> expect true
    public void testIsPalindrome_punctOneLetter() {
        assertTrue(Palindrome.isPalindromeRecursive(",!.?R?"));
    }

    @Test
    // Test a short palindrome line that must be insensitive to cases. Expect true
    public void testIsPalindrome_shortPalindrome() {
        assertTrue(Palindrome.isPalindromeRecursive("Anna"));
    }

    @Test
    // Test a short non-palindrome line. Expect false
    public void testIsPalindrome_shortNonPalindrome() {
        assertFalse(Palindrome.isPalindromeRecursive("Foo"));
    }

    @Test
    // Test a long palindrome line. Expect true
    public void testIsPalindrome_longPalindrome() {
        assertTrue(Palindrome.isPalindromeRecursive("Able was i ere i saw Elba"));
    }

    @Test
    // Test a palindrome line with (non-palindrome) punctuation. Expect true
    public void testIsPalindrome_withPunctuation() {
        assertTrue(Palindrome.isPalindromeRecursive("Red roses run no risk, sir, on nurses order."));
    }

    @Test
    // Test a palindrome line with numbers. Expect true
    public void testIsPalindrome_withCorrectNumbers() {
        assertTrue(Palindrome.isPalindromeRecursive("I was 1 or Ro 1 saw I"));
    }

    @Test
    // Test a non-palindrome line with numbers. Expect false
    public void testIsPalindrome_withIncorrectNumbers() {
        assertFalse(Palindrome.isPalindromeRecursive("I was 2 or Ro 1 saw I"));
    }
}