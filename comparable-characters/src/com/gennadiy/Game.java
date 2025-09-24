package com.gennadiy;

import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;


public class Game {

    public static void main(String[] args) {
        
        List<Character> characters = new ArrayList<>();

        characters.add(new Invoker("Invoker", 540, 411, "Invoke", AttributeType.INTELLEGENCE));
        characters.add(new EmberSpirit("Ember Spirit", 610, 380, "Immolation", AttributeType.AGILITY));
        characters.add(new Huskar("Huskar", 700, "Blood Magic", AttributeType.STRENGTH, 400));

        characters.sort(Character::compareTo);

        for (Character character : characters)
            System.out.println(character);


    }



}
