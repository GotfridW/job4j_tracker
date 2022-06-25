package ru.job4j.stream;

import java.util.Objects;

public class Label {
    private String name = " - 50% off";
    private float price = 0.5f;

    public Label() {
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Label label = (Label) o;
        return Float.compare(label.price, price) == 0 && Objects.equals(name, label.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
