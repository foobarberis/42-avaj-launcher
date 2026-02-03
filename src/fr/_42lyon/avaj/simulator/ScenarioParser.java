package fr._42lyon.avaj.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScenarioParser {
	public ParsedScenario parse(BufferedReader reader) throws ParsingException, IOException {
		String line = reader.readLine();
		if (line == null) {
			throw new ParsingException("Empty scenario file.");
		}

		line = line.trim();
		if (line.isEmpty()) {
			throw new ParsingException("Empty first line (simulations count missing)");
		}

		int simulationsCount;
		try {
			simulationsCount = Integer.parseInt(line.split("\\s+")[0]);
		} catch (NumberFormatException e) {
			throw new ParsingException("Invalid simulations count: " + line);
		}

		if (simulationsCount < 0) {
			throw new ParsingException("Invalid simulations count (must be positive): " + simulationsCount);
		}

		List<Flyable> flyables = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				continue;
			}

			String[] parts = line.split("\\s+");
			if (parts.length != 5) {
				throw new ParsingException("Invalid line in scenario file: " + line);
			}

			String type = parts[0];
			String name = parts[1];
			int longitude, latitude, height;
			try {
				longitude = Integer.parseInt(parts[2]);
				latitude = Integer.parseInt(parts[3]);
				height = Integer.parseInt(parts[4]);
			} catch (NumberFormatException e) {
				throw new ParsingException("Invalid coordinate format: " + line);
			}

			if (longitude < 0 || latitude < 0 || height < 0) {
				throw new ParsingException("Coordinates must be positive: " + line);
			}

			if (height > 100) {
				height = 100;
			}

			Flyable flyable = AircraftFactory.getInstance().newAircraft(type, name,
					new Coordinates(longitude, latitude, height));
			if (flyable == null) {
				throw new ParsingException("Unknown aircraft type: " + type);
			}

			flyables.add(flyable);
		}

		return new ParsedScenario(simulationsCount, flyables);
	}
}
