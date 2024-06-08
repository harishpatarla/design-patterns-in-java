package org.design.patterns.registry;

import org.design.patterns.factory.Factory;
import org.design.patterns.model.Rectangle;
import org.design.patterns.model.Shape;
import org.design.patterns.model.Square;
import org.design.patterns.model.Triangle;

public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape) {

        switch (shape) {
            //takes a label of shape and returns the Shape - Builder
            case "square":
                return () -> new Square();
            case "triangle":
                return () -> new Triangle();
            case "rectangle":
                return () -> new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }
}
