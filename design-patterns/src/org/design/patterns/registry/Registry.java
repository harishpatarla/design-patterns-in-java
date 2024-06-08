package org.design.patterns.registry;

import org.design.patterns.factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Registry<T> {

    public static <T> Registry<T> createRegistry(Consumer<Builder<T>> consumer, Function<String, Factory<T>> errorFunction) {
        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = map::put;
        consumer.accept(builder); //implementation of this method is builder.register("rectangle", Rectangle::new)
        return shape -> map.computeIfAbsent(shape, errorFunction);
    }

    Factory<? extends T> buildShapeFactory(String shape);
}
