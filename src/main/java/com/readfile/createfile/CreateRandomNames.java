package com.readfile.createfile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.javafaker.Faker;

/**
 * Create a file with random names that will be placed at the home directory.
 * ~/file.txt
 * 
 * @author saldivar
 *
 */
public class CreateRandomNames {

	private CreateRandomNames() {
	}

	private static final Logger LOGGER = Logger.getLogger(CreateRandomNames.class.getName());

	public static void main(String[] args) {

		Faker faker = new Faker();
		List<String> lines = new ArrayList<>();

		for (int i = 0; i < 1_000_000; i++) {

			lines.add(faker.name().firstName() + " " + faker.name().lastName());

		}

		try {

			Files.write(Paths.get(System.getProperty("user.home") + "/file.txt"), lines, StandardCharsets.UTF_8);

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Not able to save to file " + e);
		}

	}

}
