package com.iit.mp2.test.driver;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import com.iit.mp2.driver.FileLoader;
import com.iit.mp2.exception.FileParsingException;

public class TestConsole {

	@Test
	public void testLoadingFirstOptionFiles() throws FileParsingException, ParseException, IOException {
		FileLoader.loadFile();
	}
	
}
