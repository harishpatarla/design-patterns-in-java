package org.design.patterns;

import org.design.patterns.factory.Factory;
import org.design.patterns.model.Rectangle;
import org.design.patterns.model.Shape;
import org.design.patterns.model.Triangle;
import org.design.patterns.registry.Builder;
import org.design.patterns.registry.Registry;
import org.design.patterns.registry.SwitchRegistry;

import java.util.function.Consumer;

public class PlayWithRegistryBuilder {
    public static void main(String[] args) {

        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle : " + rectangleFactory.newInstance());

        //Functional impl. of pattern
        Consumer<Builder<Shape>> consumer1 = builder -> builder.register("rectangle", Rectangle::new);
        // this consumer needs to be passed to registry so registry can initialize it in its internal hashmap
        Registry registry1 = Registry.createRegistry(consumer1, s -> {
            throw new IllegalArgumentException("Unknown shape: " + s);
        });
        Factory<Rectangle> buildRectangleFactory = (Factory<Rectangle>) registry1.buildShapeFactory("rectangle");
        Rectangle rectangle = buildRectangleFactory.newInstance();
        System.out.println("Rectangle : " + rectangle);

        Consumer<Builder<Shape>> consumer2 = builder -> builder.register("triangle", Triangle::new);
        Consumer<Builder<Shape>> consumer3 = consumer1.andThen(
                consumer2
        );
        Registry registry2 = Registry.createRegistry(consumer3, s -> {
            throw new IllegalArgumentException("Unknown shape: " + s);
        });

        Factory<Triangle> buildTriangleFactory = (Factory<Triangle>) registry2.buildShapeFactory("triangle");
        Triangle triangle = buildTriangleFactory.newInstance();
        System.out.println("Triangle : " + triangle);
    }

    //since below method takes parameter and returns void it can be modelled as consumer
    // Its consumer of parameter it takes i.e. Consumer<Builder<Rectangle>>
    private static void extracted(Builder<Rectangle> builder) {
        builder.register("rectangle", Rectangle::new);
    }
}
