package org.project04;

public class Passenger implements Comparable<Passenger> {   // класс реализует интерфейс Comparable для возможности сортировки
    private String name;
    private String document;
    private int flight_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public Passenger(String name, String document, int flight_number) {
        this.name = name;
        this.document = document;
        this.flight_number = flight_number;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n\t\tДокумент: " + document + "\n";
    }

    // сравнение пассажиров для последующей сортировки по имени
    @Override
    public int compareTo(Passenger o) {
        return this.name.compareTo(o.getName());
    }
}