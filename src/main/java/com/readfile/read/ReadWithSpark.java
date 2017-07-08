package com.readfile.read;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import com.readfile.createfile.CreateRandomNames;

/**
 * Reading the number of occurrences of Kareem in the file located at the home
 * directory. The file gets created by running {@link CreateRandomNames}
 * 
 * Execution: <br/>
 * mvn exec:java -Dexec.mainClass="com.readfile.read.ReadWithSpark"
 * 
 * @author saldivar
 *
 */
public class ReadWithSpark {

	private ReadWithSpark() {
	}

	public static void main(String[] args) {

		SparkConf sparkConf = new SparkConf().setAppName("sparkReader").setMaster("local[2]");

		try (JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);) {

			System.out.println("Count with apache spark: "
					+ javaSparkContext.textFile(System.getProperty("user.home") + "/file.txt")
							.flatMap(line -> Arrays.asList(line.split(" ")).iterator())
							.filter(word -> word.equals("Kareem"))
							.map(word -> 1)
							.reduce((total, e) -> total + e));

		}

	}

}
