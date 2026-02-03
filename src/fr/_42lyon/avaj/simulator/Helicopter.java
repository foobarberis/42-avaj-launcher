package fr._42lyon.avaj.simulator;

public class Helicopter extends Aircraft {
	public Helicopter(long id, String name, Coordinates coordinates) {
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		switch (weather) {
			case "SUN":
				longitude += 10;
				height += 2;
				Logger.getLogger().log(this.getInfo() + ": This is hot.");
				break;
			case "RAIN":
				longitude += 5;
				Logger.getLogger().log(this.getInfo() + ": It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				longitude += 1;
				Logger.getLogger().log(this.getInfo() + ": I can't see anything!");
				break;
			case "SNOW":
				height -= 12;
				Logger.getLogger().log(this.getInfo() + ": My rotor is going to freeze!");
				break;
		}

		if (height > 100) {
			height = 100;
		}

		if (height <= 0) {
			height = 0;
			Logger.getLogger().log(this.getInfo() + " landing.");
			Logger.getLogger().log("Tower says: " + this.getInfo() + " unregistered from weather tower.");
			this.weatherTower.unregister(this);
		}

		this.coordinates = new Coordinates(longitude, latitude, height);
	}
}
