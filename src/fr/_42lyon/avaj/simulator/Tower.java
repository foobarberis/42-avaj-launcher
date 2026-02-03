package fr._42lyon.avaj.simulator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tower {
   private List<Flyable> observers = new CopyOnWriteArrayList<>();

   public void register(Flyable flyable) {
      if (!this.observers.contains(flyable)) {
         this.observers.add(flyable);
      }
   }

   public void unregister(Flyable flyable) {
      this.observers.remove(flyable);
   }

   protected void conditionChanged() {
      for (Flyable flyable : this.observers) {
         flyable.updateConditions();
      }
   }
}
