package de.MissingNameException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Logger {

	
	private boolean output = true;
	
	private File logFile;
	
	/**
	 * Creates config file if its not already created.
	 * If file already exists it loads all existing configs
	 * @param path Set the path where the config.cfg can be located
	 */
	public Logger(String path) {
		try {
			LocalDate ld = LocalDate.now();
			logFile = new File(path + ld.getYear() + "-" + ld.getMonthValue() + "-" + ld.getDayOfMonth() + ".cfg");
			if(logFile.createNewFile()) {
				print("Log file created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Simple getter getLogFile()
	 * @return logFile
	 */
	public File getLogFile() {
		return logFile;
	}

	/**
	 * toggles the output if activated, you'll see messages like logfile loaded etc.
	 * @param value if true it enables output
	 */
	public void toggleOutput(boolean value) {
		output = value;
	}
	
	private void print(String x) {
		if(output) {
			System.out.println(x);
		}
	}
	
}
