package exercises.week3.observer;// Valentino Vranić
// Objektovo-orientované programovanie 2014/15

// triedy a rozhrania majú prístup package, aby mohli byť v jednom súbore
// korektnejšie by bolo rozložiť ich do vlastných súborov a nastaviť im prístup public


import java.util.*;

interface TempDisplay { // rozhranie Observer
   void refresh(); // aktualizácia pozorovateľa
}


interface TempSensor { // rozhranie Element
   void addDisplay(TempDisplay d); // pripoj pozorovateľa
   void removeDisplay(TempDisplay d); // odpoj pozorovateľa
   void notifyDisplays(); // pošli notifikáciu pozorovateľom
   double readTemp();
   public void measureTemp();
}

class HumanTempSensor implements TempSensor {
   private List<TempDisplay> displays = new ArrayList<>();
   private double temp;
   public double refreshRate;
  
   public double readTemp() {
      return temp;
   }
   public void measureTemp() {
      // . . . zistí teplotu z fyzickej jednotky
      notifyDisplays(); // a pošle notifikáciu displejom
   }
   public void setTempDebug(double t) { temp = t; }
   public void addDisplay(TempDisplay d) {
      displays.add(d);
   }
   public void removeDisplay(TempDisplay d) { /* . . . */ }
   public void notifyDisplays() {
      for (TempDisplay dis : displays) {
         dis.refresh();
      }    
   }
}

class RoundTemp implements TempDisplay {
   private HumanTempSensor sensor;
   private int temp;

   public RoundTemp(HumanTempSensor s) {
      sensor = s;
   }

   public void display() {
      System.out.println(Math.round(temp));
   }

   @Override
   public void refresh() {
      temp = (int)sensor.readTemp();
   }
}

class DigitalTemp implements TempDisplay {
   private HumanTempSensor sensor;
   private float temp;

   public DigitalTemp(HumanTempSensor s) {
      sensor = s;
   }
   public void refresh() {
      temp = (float)sensor.readTemp();
   }
   public void display() { // len dve desatinné miesta
      System.out.println(
         Math.round(temp * 100.0) / 100.0);
   }
   public void measureTemp() {
      sensor.measureTemp();
   }
}

// vymenovaný typ - časť 10.7 v OJA
enum TempRange { LOW, NORMAL, HIGH }

class RelTemp implements TempDisplay {
   private HumanTempSensor sensor;
   TempRange range;
   double high = 37.0;
   double low = 35.0;

   public RelTemp(HumanTempSensor s) {
      sensor = s;
   }

   public void refresh() {
      double temp = sensor.readTemp();
    
      if (temp <= low)
         range = TempRange.LOW;
      else if (temp >= high)
         range = TempRange.HIGH;
      else
         range = TempRange.NORMAL;
   }

   public void display() {
      switch (range) {
         case LOW:
            System.out.println("LOW");
            break;
         case HIGH:
            System.out.println("HIGH");
            break;
         default:
            System.out.println("NORMAL");
      }     
   }  
   public void measureTemp() {
      sensor.measureTemp();
   }
} // class RelTemp


class M {
   public static void main(String[] args) {
      HumanTempSensor s = new HumanTempSensor();
    
      DigitalTemp d1 = new DigitalTemp(s);    
      s.addDisplay(d1);
      RelTemp d2 = new RelTemp(s);
      s.addDisplay(d2);
      RoundTemp d3 = new RoundTemp(s);
      s.addDisplay(d3);
    
      s.setTempDebug(37.33333333);
      s.notifyDisplays();

      d1.display(); // 37.33
      d2.display(); // HIGH
      d3.display();
   }  
}
