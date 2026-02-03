package fr._42lyon.avaj.simulator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	private static Logger instance = new Logger();
	private PrintWriter writer;

	private Logger() {
		try {
			this.writer = new PrintWriter(new FileWriter("simulation.txt"));
		} catch (IOException e) {
			System.err.println("Error creating log file: " + e.getMessage());
		}

	}

	public static Logger getLogger() {
		return instance;
	}

	public void log(String message) {
		if (this.writer != null) {
			this.writer.println(message);
			this.writer.flush();
		}

	}

	public void close() {
		if (this.writer != null) {
			this.writer.close();
		}

	}
}
