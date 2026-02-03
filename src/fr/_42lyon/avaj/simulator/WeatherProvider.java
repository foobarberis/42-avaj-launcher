package fr._42lyon.avaj.simulator;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private String[] weather = new String[] { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		// Sum as a long to avoid int overflow, then map the coordinate-based seed to a valid weather index.
		long seed = (long) coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
		return this.weather[(int) (seed % this.weather.length)];
	}
}
