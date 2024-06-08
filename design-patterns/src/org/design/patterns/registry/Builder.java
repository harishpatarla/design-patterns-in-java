package org.design.patterns.registry;

import org.design.patterns.factory.Factory;

@FunctionalInterface
public interface Builder<T> {

    //record in hashmap with label and factory
    void register(String label, Factory<T> factory);
}
