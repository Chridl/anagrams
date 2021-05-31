package com.ck.anagrams;

import com.ck.anagrams.builder.AnagramBuilder;
import com.ck.anagrams.parser.WordFileParser;
import com.ck.anagrams.model.Anagram;
import com.ck.anagrams.printer.AnagramPrinter;
import com.ck.anagrams.util.AnagramUtil;
import com.ck.anagrams.validate.FileValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AnagramsApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(AnagramsApplication.class);

	private final AnagramUtil anagramUtil = new AnagramUtil();
	private final FileValidator fileValidator = new FileValidator();
	private final WordFileParser wordFileParser = new WordFileParser();
	private final AnagramPrinter anagramPrinter = new AnagramPrinter();
	private final AnagramBuilder anagramBuilder = new AnagramBuilder();

	public static void main(String[] args) {
		SpringApplication.run(AnagramsApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (args.length != 1) {
			logger.warn("Use exactly one argument to run this program " +
					"- the path to the file containing the words.");
			return;
		}
		String filePath = args[0];

		if (!fileValidator.isExistingFile(filePath)) {
			logger.warn("File with path {} not found! Aborting...", filePath);
			return;
		}
		if (!fileValidator.isTextFile(filePath)) {
			logger.warn("File {} is not a text file! Aborting...", filePath);
			return;
		}

		List<String> words = wordFileParser.parseWordFile(filePath);
		List<Anagram> anagrams = anagramBuilder.buildAnagrams(words);

		Map<String, List<Anagram>> matchingAnagrams = anagramUtil.findMatchingAnagrams(anagrams);
		anagramPrinter.printAnagrams(matchingAnagrams);
	}
}