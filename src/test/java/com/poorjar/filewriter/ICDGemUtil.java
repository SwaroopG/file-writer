package com.poorjar.filewriter;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by sgaddameedhi on 3/31/2017.
 */
public class ICDGemUtil {
    @Test
    public void testDataTransform() throws Exception {
        processData("src/test/resources/2017_I9gem.txt");
        processData("src/test/resources/2017_I10gem.txt");
    }

    private void processData(String filename) throws IOException {
        // Clear the output file if it exists.
        initOutputFile();

        FileReader reader = new FileReader(filename);
        FileWriter writer = new FileWriter("src/test/resources/finalICDGemFile.txt", true);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            String nextLine = generateCommaSeparatedLine(scanner.nextLine().trim());
            if (nextLine != null || !nextLine.isEmpty()) {
                writer.write(nextLine);
                writer.write(System.getProperty("line.separator"));
            }
        }
        scanner.close();
        writer.close();
        reader.close();
    }

    /**
     * Clears the output file if it exists.
     */
    private void initOutputFile() throws IOException {
        FileWriter writer = new FileWriter("src/test/resources/output.txt");
        writer.write("");
        writer.close();
    }

    /**
     * Creates the Comma-Separated Line. Ex. A00.00,00.01,00000
     */
    private String generateCommaSeparatedLine(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        StringBuilder result = new StringBuilder();

        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (index == 0 || index == 1) {
                result.append(addDecimalToICDCodes(token));
            } else {
                result.append(token);
            }
            if (tokenizer.hasMoreTokens()) {
                result.append(",");
            }
            index++;
        }
        return result.toString();
    }

    /**
     * Adds decimal to ICD codes.
     * For E Codes - Decimal is after 4 characters.
     * For E codes - leave codes that are 4 characters in length
     * For all other codes - Only add decimal after 3 characters if length is greater than 3.
     */
    private String addDecimalToICDCodes(String token) {
        if (token.startsWith("E") && token.length() > 4) {
            return token.substring(0, 4) + "." + token.substring(3, token.length());
        } else if (token.startsWith("E") && token.length() <= 4) {
            return token;
        } else if (token.length() > 3) {
            return token.substring(0, 3) + "." + token.substring(2, token.length());
        }
        return token;
    }
}
