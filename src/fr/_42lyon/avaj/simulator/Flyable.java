package fr._42lyon.avaj.simulator;

public abstract class Flyable {
   protected WeatherTower weatherTower;

   public abstract void updateConditions();

   protected abstract String getInfo();

   public void registerTower(WeatherTower weatherTower) {
      this.weatherTower = weatherTower;
      this.weatherTower.register(this);
      Logger.getLogger().log("Tower says: " + this.getInfo() + " registered to weather tower.");
   }
}
