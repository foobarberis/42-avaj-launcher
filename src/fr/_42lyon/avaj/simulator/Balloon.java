package fr._42lyon.avaj.simulator;

public class Balloon extends Aircraft {
	public Balloon(long id, String name, Coordinates coordinates) {
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
				longitude += 2;
				height += 4;
				Logger.getLogger().log(this.getInfo() + ": Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				height -= 5;
				Logger.getLogger().log(this.getInfo() + ": Damn you rain! You messed up my balloon.");
				break;
			case "FOG":
				height -= 3;
				Logger.getLogger().log(this.getInfo() + ": I can't see the ground.");
				break;
			case "SNOW":
				height -= 15;
				Logger.getLogger().log(this.getInfo() + ": It's snowing. We're gonna crash.");
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
