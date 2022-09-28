package tutorial.lab3.tutorial.lab3;


import java.util.*;

public class SortingDemo
{
   public static void main(String[] args)
   {

      Item i1 = new Item("Toaster", 2);
      Item i2 = new Item("Widget", 8);
      Item i3 = new Item("Modem", 5);
      Item i4 = new Item("Laptop", 6);
      Item i5 = new Item("Chair", 6);
      Item i6 = new Item("Boooooook", 2);

      List<Item> list = new ArrayList<>();
      list.add(i1);
      list.add(i2);
      list.add(i3);
      list.add(i4);
      list.add(i5);
      list.add(i6);

      List <Integer> test = new ArrayList<>();
      for(int i = 1; i <= 10; i++)
         test.add((i));
      test.sort(Comparator.reverseOrder());
      System.out.println(test);
//
//
//      // sort items by partNumber
//      Collections.sort(list, new Comparator<>() {
//         @Override
//         public int compare(Item o1, Item o2) {
//            return o1.getPartNumber() - o2.getPartNumber();
//         }
//      });
//      System.out.println(list);
//
//      list.sort(new Comparator<>() {
//         public int compare(Item a, Item b) {
//            return a.getPartNumber() > b.getPartNumber() ? 1 : -1;
//         }
//      });
//      System.out.println(list);
//
//      // sort items by the length of description
//      Collections.sort(list, (o1, o2) -> o1.getDescription().length() - o2.getDescription().length());
//      System.out.println(list);
//
//      // sort items by the length of description
//      list.sort((o1, o2) -> o1.getDescription().length() - o2.getDescription().length());
//      System.out.println(list);

      // sort items first by partNumber, then by description
      list.sort(Comparator.comparing(Item::getPartNumber).thenComparing(Item::getDescription));
      System.out.println(list);

//      Set<Item> parts = new TreeSet<>();
//      parts.add(i1);
//      parts.add(i2);
//      parts.add(i3);
//      parts.add(i4);
//      parts.add(i5);
//      parts.add(i6);
//      System.out.println(parts);
   }
}
