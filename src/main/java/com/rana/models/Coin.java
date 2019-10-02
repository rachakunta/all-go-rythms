package com.rana.models;

public enum Coin {
    HALF(0.5), DOLLAR(1), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private double value;

    Coin(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
