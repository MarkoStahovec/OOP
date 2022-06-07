// Valentino Vranić
// Objektovo-orientované programovanie 2014/15

// triedy a rozhrania majú prístup package, aby mohli byť v jednom súbore
// korektnejšie by bolo rozložiť ich do vlastných súborov a nastaviť im prístup public
package exercises.week3.vo;

import java.util.*;

class M {
   public static void main(String[] args) {
      List<String> list = new ArrayList<>();
      list.add("a");
      list.add("b");
      list.add("c");

      DItem[] item = {new WordItem("visit"), new ListItem(list)};
      DDevice[] device = {new HorDevice(), new VerDevice()};

      for (DItem it : item)
         for (DDevice dev : device) {
            it.display(dev);
            System.out.println("");
         }
   }
}



interface DItem { // rozhranie Element
   void display(DDevice d); // prijatie návštevníka
}

class WordItem implements DItem {
   String word;
   public WordItem(String s) {
      word = s;
   }
   public void display(DDevice d) {
      d.write(this);
   }
}


class ListItem implements DItem {
   List<String> list;
   public ListItem(List<String> l) {
      list = l;
   }
   public void display(DDevice d) {
      d.write(this);
   }
}


interface DDevice { // rozhranie Visitor
   void write(WordItem item);
   void write(ListItem item);
}

class HorDevice implements DDevice {
   public void write(WordItem item) { // navštívenie WordItem
      for(int i = 0; i < item.word.length(); i++)
         System.out.print(item.word.charAt(i));
   }
   public void write(ListItem item) { // navštívenie ListItem
      for(int i = 0; i < item.list.size(); i++) {
         System.out.print(item.list.get(i));
         System.out.print(", ");
      }
   }
}


class VerDevice implements DDevice {
   public void write(WordItem item) { // navštívenie WordItem
      for(int i = 0; i < item.word.length(); i++)
         System.out.println(item.word.charAt(i));
   }
   public void write(ListItem item) { // navštívenie ListItem
      for(int i = 0; i < item.list.size(); i++) {
         System.out.print(item.list.get(i));
         System.out.println(", ");
      }
   }
}