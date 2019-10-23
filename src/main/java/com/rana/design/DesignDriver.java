package com.rana.design;

public class DesignDriver {
    public static void main(String[] args) {
        MovingAverage average = new MovingAverage(5);
        System.out.println(average.next(12009));
        System.out.println(average.next(1965));
        System.out.println(average.next(-940));
        System.out.println(average.next(-8516));
        System.out.println(average.next(-16446));
        System.out.println(average.next(7870));
        System.out.println(average.next(25545));
        System.out.println(average.next(-21028));
        System.out.println(average.next(18430));
        System.out.println(average.next(-5));

    }
}
