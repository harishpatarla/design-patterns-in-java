package org.design.patterns.factory;


import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        return supplier::get;
    }

    static <T> Factory<T> createSingleton(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <P, T> Factory<T> createFactory(Function<P, T> constructor, P color) {
        return () -> constructor.apply(color);
    }

    default T newInstance() {
        return this.get();
    }

    default List<T> create5() {
        return IntStream.range(0, 5).mapToObj(i -> newInstance()).toList();
    }
}
