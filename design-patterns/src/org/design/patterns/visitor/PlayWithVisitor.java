package org.design.patterns.visitor;

import org.design.patterns.visitor.model.Body;
import org.design.patterns.visitor.model.Car;
import org.design.patterns.visitor.model.Engine;

public class PlayWithVisitor {

    public static void main(String[] args) {

        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();
    }
}
