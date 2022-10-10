package com.company;

public class Car {
    public void start() {
        startCommand();
        startElectricity();
        startFuelSystem();
    }

    private void startElectricity() {
    }

    private void startCommand() {
    }

    private void startFuelSystem() {
    }
    // Создать класс Car с публичным методом start. Метод start вызывает внутри себя методы:
    //
    //- startElectricity()
    //
    //- startCommand()
    //
    //- startFuelSystem()
    //
    //  Перечисленные методы, являются внутренней (скрытой) частью комплексного метода start.
}
