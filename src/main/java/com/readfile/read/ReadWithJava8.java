package com.readfile.read;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.readfile.createfile.CreateRandomNames;

/**
 * Reading the number of occurrences of Kareem in the file located at the home
 * directory. The file gets created by running {@link CreateRandomNames}
 * 
 * Execution: <br/>
 * mvn exec:java -Dexec.mainClass="com.readfile.read.ReadWithJava8" -Dexec.cleanupDaemonThreads=false
 * 
 * @author saldivar
 *
 */
public class ReadWithJava8 {

	private ReadWithJava8() {}
	
	public static void main(String[] args) throws Exception {

		System.out.println("Count with plain java 8: " + 
		Files.lines(Paths.get(System.getProperty("user.home") + "/file.txt"))
			.parallel()
			.flatMap(line -> Stream.of(line.split(" ")))
			.filter(word -> word.equals("Kareem"))
			.mapToLong(i -> 1)
			.reduce(0, Long::sum));
	}

}
