package org.design.patterns.registry;

import org.design.patterns.factory.Factory;
import org.design.patterns.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@FunctionalInterface
public interface Registry {

    public static Registry createRegistry(Consumer<Builder<Shape>> consumer) {
        Map<String, Factory<Shape>> map = new HashMap<>();
        Builder<Shape> builder = map::put;
        consumer.accept(builder); //implementation of this method is builder.register("rectangle", Rectangle::new)
        return map::get;
    }

    Factory<? extends Shape> buildShapeFactory(String shape);
}
