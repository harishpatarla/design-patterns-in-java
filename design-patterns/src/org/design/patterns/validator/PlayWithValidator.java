package org.design.patterns.validator;

import org.design.patterns.validator.model.Person;
import org.design.patterns.validator.util.Validator;

public class PlayWithValidator {

    public static void main(String[] args) {

        Person sarah = new Person("Sarah", 29);
        Person james = new Person(null, 29);
        Person mary = new Person("Mary", -10);
        Person john = new Person("John", 1_000);
        Person linda = new Person(null, 1_000);

        sarah =
                //Validator.validate() is static method
                Validator.validate(p -> p.getName() != null, "The name should not be null")
                        // on takes Person object and return supplier,
                        // we can call .get() on it but for readability we wrap it in another supplier - ValidatorSupplier
                        .on(sarah)
                        // This does not take parameter and returns a person - so it can be modeled as supplier
                        .validate();
        System.out.println("Sarah : " + sarah);

        linda =
                Validator.validate(p -> p.getName() != null, "The name should not be null")
                        .thenValidate(p -> p.getAge() > 0, "The age should be greater than 0")
                        .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150")
                        .on(linda)
                        .validate();

        System.out.println("Linda : " + linda);

    }
}
