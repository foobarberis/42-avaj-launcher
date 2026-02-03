package fr._42lyon.avaj.simulator;

public abstract class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0L;

	protected Aircraft(long id, String name, Coordinates coordinates) {
		this.id = id;
		this.name = name;
		this.coordinates = coordinates;
	}

	protected String getInfo() {
		return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
	}

	protected static long nextId() {
		return ++idCounter;
	}
}
