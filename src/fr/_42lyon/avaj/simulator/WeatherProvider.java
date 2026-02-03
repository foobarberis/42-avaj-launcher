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
		int seed = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
		return this.weather[seed % 4];
	}
}
