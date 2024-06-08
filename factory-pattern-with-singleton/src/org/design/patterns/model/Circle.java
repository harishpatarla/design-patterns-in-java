package org.design.patterns.model;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle() {
        this(Color.WHITE);
    }

    public Circle(Color color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Circle - color =" + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;
        return color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}
