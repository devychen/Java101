package st11;

/**
 * A class to represent a Corpus,
 * with a public method to determine the Flesch readability index.
 * 
 * @author mkz
 * TASK: Fill in the missing `getFleschIndex()` method
 *
 */

import java.io.*;

public class Corpus {
    
    private File inputFile;
    private String encoding;
    
    /**
     * Construct a Corpus object from the specified file using UTF-8 encoding
     * @param fileName the name of the file to use in this Corpus
     */
    public Corpus(String fileName) {
        this(fileName, "UTF-8");
    }
    
    /**
     * Construct a Corpus object from the specified file with the given encoding
     * @param fileName the name of the file to use in this Corpus
     * @param anEncoding the encoding to use when reading the file
     */
    public Corpus(String fileName, String anEncoding) {
        inputFile = new File(fileName);
        encoding = anEncoding;
    }
    
    /**
     * Helper method to determine the number of syllables in the parameter
     * @param form the word to process
     * @return the number of syllables in form
     */
    private int getNumSyllables(String form) {
        
        boolean lastWasVowel = false;
        boolean thisIsVowel = false;
        int syllableCnt = 0;
        
        if ((form == null) || (form.length() == 0)) {
            return 0;
        }
        
        // Iterate the characters in word.
        for (int i = 0; i < form.length(); i++) {  
            
            // Update lastWasVowel
            lastWasVowel = thisIsVowel;
            
            // Determine if this char is a vowel
            switch (form.charAt(i)) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                case 'y':
                case 'Y':
                    thisIsVowel = true;
                    break;
                default:
                    thisIsVowel = false;
            }
            
            // Only increment syllableCnt if the previous char
            // was NOT a vowel and this one is
            if (thisIsVowel && !lastWasVowel) {
                syllableCnt++;
            }
         }
        
        // A trailing 'e' would have been falsely counted as a syllable
        // if proceeded by a consonant
        if (form.endsWith("e") && !lastWasVowel) {
            syllableCnt--;
        }
        
        // All non-empty words have at least 1 syllable
        if (syllableCnt == 0) {
            syllableCnt = 1;
        }
        
        return syllableCnt;
    }
    
    /**
     * Helper method to determine if the input word is the last in a sentence (ie word
     * ends with '.' , '?' , '!' , ':' , or ';'
     * @param word the word to process
     * @return true if this word is the last in a sentence, false otherwise
     */
    private boolean endOfSentence(String word) {
        boolean thisIsEOS = false;
        String trimmedWord = word.trim(); // why - The trim() method removes whitespace from both ends of a string.
        int len = trimmedWord.length();
        
        switch (trimmedWord.charAt(len-1)) {
            case '.':
            case '?':
            case '!':
            case ':':
            case ';':
                thisIsEOS = true;
                break;
            default:
                thisIsEOS = false;
        }
        return thisIsEOS;
    }
    
    /**
     * Determine the Flesch readability index of this Corpus. Values near 100 indicate easily
     * read material (comics). Values near 0 indicate difficult-to-read material (insurance
     * policies). The index is based on ratios of the number of sentences, words, and
     * syllables in the corpus. No linguistic analysis is made.
     * @return the Flesch readability index of this Corpus
     * @throws FileNotFoundException if the file used for this Corpus is not found
     * @throws UnsupportedEncodingException if the file endoding is not supported
     * @throws IOException if an error occurs while reading the corpus file
     */
    public int getFleschIndex() throws FileNotFoundException,
        UnsupportedEncodingException, IOException {
        
        // TODO

        // initialize the variables
        int numSentences = 0;
        int numWords = 0;
        int numSyllables = 0;

        // create the new BufferedReader object and read the first line
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), encoding));
        String currentLine = br.readLine();

        while (currentLine != null) {
            // split the line to a String array
            String[] words = currentLine.split("\\s+");

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                // if the word is empty --> continue
                if (word.isEmpty()) {
                    continue;
                }

                numSyllables += getNumSyllables(word);
                numWords++;

                if(!word.isEmpty() && endOfSentence(word)) {
                    numSentences += 1;
                }

            }
            currentLine = br.readLine();
        }

        br.close();

        // now calculate the fleschindex
        return (int) (206.835
                - 84.6 * ((double) numSyllables/numWords)
                - 1.015 * ((double) numWords/numSentences));
    }

}