package com.poorjar.pomwriter.stringwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

public final class StringWriter {

    @Test
    public void printDependencies() throws FileNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();

        File file = new File(classLoader.getResource("lineups.txt").getPath());
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String nextToken = input.nextLine().trim();
            StringTokenizer tokenizer = new StringTokenizer(nextToken, ",");
            System.out.println(tokenizer.nextToken() + ".X|pkg00@"+ tokenizer.nextToken() +".ROVI");
        }

        input.close();
    }
}
