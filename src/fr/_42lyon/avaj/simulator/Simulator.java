package fr._42lyon.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<>();

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java fr._42lyon.avaj.simulator.Simulator <scenario_file>");
			return;
		}

		Logger logger = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
			ScenarioParser parser = new ScenarioParser();
			ParsedScenario scenario = parser.parse(reader);

			logger = Logger.getLogger();
			weatherTower = new WeatherTower();
			flyables.addAll(scenario.flyables());

			for (Flyable flyable : flyables) {
				flyable.registerTower(weatherTower);
			}

			for (int i = 0; i < scenario.simulationsCount(); i++) {
				weatherTower.changeWeather();
			}
		} catch (ParsingException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			if (logger != null) {
				logger.close();
			}
		}
	}
}
