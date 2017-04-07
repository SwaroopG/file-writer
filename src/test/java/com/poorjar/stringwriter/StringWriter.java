package com.poorjar.stringwriter;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public final class StringWriter {
    @Test
    public void printDependencies() throws FileNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();

        File file = new File(classLoader.getResource("lineups.txt").getPath());
        Scanner input = new Scanner(file);
        String previousToken = "";

        while (input.hasNext()) {
            String nextToken = input.nextLine().trim();
            StringTokenizer tokenizer = new StringTokenizer(nextToken, ",");

            if (previousToken.equals(nextToken)) {
                System.out.println("**********" + tokenizer.nextToken() + ".X|pkg00@" + tokenizer.nextToken() + ".ROVI");
            }

            if (!previousToken.equals(nextToken)) {
                System.out.println(tokenizer.nextToken() + ".X|pkg00@" + tokenizer.nextToken() + ".ROVI");
            }
            previousToken = nextToken;
        }

        input.close();
    }
}
