package org.design.patterns.visitor;

public interface Visitor<R> {

    R visit(Object o);
}