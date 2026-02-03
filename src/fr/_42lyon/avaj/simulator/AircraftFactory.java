package fr._42lyon.avaj.simulator;

public class AircraftFactory {
	private static AircraftFactory instance = new AircraftFactory();

	private AircraftFactory() {
	}

	public static AircraftFactory getInstance() {
		return instance;
	}

	public Flyable newAircraft(String type, String name, Coordinates coordinates) {
		long id = Aircraft.nextId();
		if (type.equalsIgnoreCase("Helicopter")) {
			return new Helicopter(id, name, coordinates);
		} else if (type.equalsIgnoreCase("JetPlane")) {
			return new JetPlane(id, name, coordinates);
		} else if (type.equalsIgnoreCase("Balloon")) {
			return new Balloon(id, name, coordinates);
		} else {
			return null;
		}
	}
}
