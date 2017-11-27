package org.project04;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // настоящему программисту лень писать каждый раз данные каждого пассажира вручную,
        // поэтому сделаем готовый лист :)
        // при необходимости легко прикрутить Scanner(in)

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Матроскин-03", "усы, лапы и хвост-3", 1251));
        passengers.add(new Passenger("Матроскин-05", "усы, лапы и хвост-5", 1250));
        passengers.add(new Passenger("Матроскин-01", "усы, лапы и хвост-1", 1251));
        passengers.add(new Passenger("Матроскин-04", "усы, лапы и хвост-4", 1251));
        passengers.add(new Passenger("Матроскин-02", "усы, лапы и хвост-2", 1252));
        passengers.add(new Passenger("Матроскин-08", "усы, лапы и хвост-8", 1174));
        passengers.add(new Passenger("Матроскин-06", "усы, лапы и хвост-6", 1174));
        passengers.add(new Passenger("Матроскин-10", "усы, лапы и хвост-10", 1258));
        passengers.add(new Passenger("Матроскин-07", "усы, лапы и хвост-7", 1250));
        passengers.add(new Passenger("Матроскин-09", "усы, лапы и хвост-9", 1251));
        // цифры в именах двузначные для корректной сортировки. В реальности вряд ли будет имя с цифрами, поэтому годится.

        passengers.sort(Comparator.naturalOrder()); // отсортировали пассажиров по имени

        Map<Integer, Integer> m = new HashMap<>(); // определение количества человек в каждом рейсе. Рейс - количество.
        for (Passenger passenger : passengers) {
            Integer count = m.get(passenger.getFlight_number()) == null ? 0 : m.get(passenger.getFlight_number());
            m.put(passenger.getFlight_number(), count + 1);
        }

        Map<Integer, List<Passenger>> passengerMap = new TreeMap<>();

        //рассадка пассажиров по рейсам
        List<Passenger> tmp = new ArrayList<>(); // сюда будем складывать пассажиров каждого рейса
        for (Integer i : m.keySet()) {           // перебор по ключам Map'а "рейс - количество"
            for (Passenger p : passengers) {     // перебор пассажиров
                if (p.getFlight_number() == i) { // если номер рейса пассажира совпадает с ключом Мар,
                    tmp.add(p);                  // то добавляем его в List
                }
            }
            passengerMap.put(i, new LinkedList<>(tmp)); // перебрали всех пассажиров рейса, добавляем их в TreeMap
            tmp.clear();                         //очищаем пассажиров предыдущего рейса
        }

        // страшная конструкция вывода на экран с лямбда-выражением :)
        // TreeMap хранит данные в отсортированном по ключу виде, поэтому про сортировку не думаем
        passengerMap.forEach((k, v) -> System.out.print("Рейс " + k + ":\n\tПассажиров: " + v.size() + "\n" + listToString(v)));
    }

    // приватный метод для нормального вывода на экран содержимого листа. в комментариях не нуждается.
    private static String listToString(List<Passenger> list) {
        String result = "";
        for (Passenger passenger : list) {
            result += "\t-\t" + passenger + "\n";
        }
        return result;
    }
}
