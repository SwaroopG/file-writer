package com.poorjar.gradle.gradlebuildwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class GradleBuildWriter {

	@Test
	public void printDependencies() throws FileNotFoundException {
		ClassLoader classLoader = this.getClass().getClassLoader();

		File jarsFile = new File(classLoader.getResource("jars.txt").getPath());
		File outputFile = new File(classLoader.getResource("output.txt").getPath());
		Scanner input = new Scanner(jarsFile);

		while (input.hasNext()) {
			String nextToken = input.next();
			System.out.println("compile name: \'"+ nextToken +"\'");
		}

		input.close();
	}
}
