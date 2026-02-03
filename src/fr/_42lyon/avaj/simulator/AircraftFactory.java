 package fr._42lyon.avaj.simulator;

public class AircraftFactory {
	private static AircraftFactory instance = new AircraftFactory();

	private AircraftFactory() {
	}

	public static AircraftFactory getInstance() {
		return instance;
	}

	public Flyable newAircraft(String type, String name, Coordinates coordinates) {
		if (type.equals("Helicopter")) {
			return new Helicopter(Aircraft.nextId(), name, coordinates);
		} else if (type.equals("JetPlane")) {
			return new JetPlane(Aircraft.nextId(), name, coordinates);
		} else if (type.equals("Balloon")) {
			return new Balloon(Aircraft.nextId(), name, coordinates);
		}
		return null;
	}
}
