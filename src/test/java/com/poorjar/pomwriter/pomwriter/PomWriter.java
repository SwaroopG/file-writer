package com.poorjar.pomwriter.pomwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class PomWriter {

	@Test
	public void printDependencies() throws FileNotFoundException {
		ClassLoader classLoader = this.getClass().getClassLoader();

		File jarsFile = new File(classLoader.getResource("jars.txt").getPath());
		File outputFile = new File(classLoader.getResource("output.txt").getPath());
		Scanner input = new Scanner(jarsFile);

		while (input.hasNext()) {
			String nextToken = input.next();
			System.out.println("<dependency>");
			System.out.println("  <groupId>"+ nextToken +"</groupId>");
			System.out.println("  <artifactId>"+ nextToken +"</artifactId>");
			System.out.println("  <version>1.0</version>");
			System.out.println("  <scope>system</scope>");
			System.out.println("  <systemPath>/opt/darn/main/nfs/shared/lib/"+ nextToken +".jar</systemPath>");
			System.out.println("</dependency>");
		}

		input.close();
	}
}
