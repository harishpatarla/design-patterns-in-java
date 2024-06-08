package org.design.patterns.factory;

import org.design.patterns.model.Circle;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public interface CircleFactory extends Supplier<Circle> {

    default Circle newInstance() {
        return this.get();
    }

    default List<Circle> create5Circles() {
        return IntStream.range(0, 5).mapToObj(i -> newInstance()).toList();
    }
}
