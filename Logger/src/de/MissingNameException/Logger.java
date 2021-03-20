package de.MissingNameException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

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
			logFile = new File(path + ld.getYear() + "-" + ld.getMonthValue() + "-" + ld.getDayOfMonth() + ".log");
			if(logFile.createNewFile()) {
				print("Log file created");
			} else {
				print("Log file found");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void warning(String name, String msg) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));
			LocalTime lt = LocalTime.now();
			bw.write("["+lt.getHour()+" : "+lt.getMinute()+" : "+lt.getSecond()+"] ("+name+"/Warning) :   " + msg);
			bw.newLine();
			print("Wrote an WARNING into logfile");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void info(String name, String msg) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));
			LocalTime lt = LocalTime.now();
			bw.write("["+lt.getHour()+" : "+lt.getMinute()+" : "+lt.getSecond()+"] ["+name+"/INFO] :   " + msg);
			bw.newLine();
			print("Wrote an INFO into logfile");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void error(String name, String msg) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));
			LocalTime lt = LocalTime.now();
			bw.write("["+lt.getHour()+" : "+lt.getMinute()+" : "+lt.getSecond()+"] {"+name+"/ERROR} :   " + msg);
			bw.newLine();
			print("Wrote an ERROR into logfile");
			bw.close();
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
