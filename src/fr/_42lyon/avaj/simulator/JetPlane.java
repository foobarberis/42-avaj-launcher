package fr._42lyon.avaj.simulator;

public class JetPlane extends Aircraft {
	public JetPlane(long id, String name, Coordinates coordinates) {
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
				latitude += 10;
				height += 2;
				Logger.getLogger().log(this.getInfo() + ": It's sunny, let's go fast!");
				break;
			case "RAIN":
				latitude += 5;
				Logger.getLogger().log(this.getInfo() + ": It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				latitude += 1;
				Logger.getLogger().log(this.getInfo() + ": I'm lost in the fog.");
				break;
			case "SNOW":
				height -= 7;
				Logger.getLogger().log(this.getInfo() + ": OMG! Winter is coming!");
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
