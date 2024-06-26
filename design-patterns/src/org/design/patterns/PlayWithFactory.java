package org.design.patterns;

import org.design.patterns.factory.CircleFactory;
import org.design.patterns.factory.Factory;
import org.design.patterns.model.Circle;

import java.awt.*;
import java.util.List;

import static org.design.patterns.factory.Factory.createFactory;
import static org.design.patterns.factory.Factory.createSingleton;

public class PlayWithFactory {
    public static void main(String[] args) {

        CircleFactory factory = Circle::new;
        Circle circle = factory.newInstance();
        System.out.println(circle);

        List<Circle> circleList = factory.create5Circles();
        System.out.println(circleList);

        //Using Generic Factory
        Factory<Circle> circleFactory = Circle::new;
        Circle genericCircle = circleFactory.newInstance();
        System.out.println(genericCircle);

        List<Circle> factory5Circles = circleFactory.create5();
        System.out.println(factory5Circles);

        //To create red or blue circle
        Factory<Circle> genericFactory1 = createFactory(Circle::new, Color.BLUE);
        Factory<Circle> defaultGenericFactory = createFactory(Circle::new);

        System.out.println("Circle=" + defaultGenericFactory.newInstance());
        System.out.println("Circles=" + defaultGenericFactory.create5());
        System.out.println("Circle=" + genericFactory1.newInstance());
        System.out.println("Circles=" + genericFactory1.create5());

        // To create singleton
        Factory<Circle> singleton = createSingleton(Circle::new);
        Circle circle1 = singleton.get();
        Circle circle2 = singleton.get();
        // checks if both point to same memory location which means it's the same object returned in both cases
        System.out.println(circle1.hashCode() == circle2.hashCode());

    }
}
