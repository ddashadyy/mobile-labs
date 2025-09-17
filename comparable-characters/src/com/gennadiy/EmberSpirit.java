package com.gennadiy;


import com.gennadiy.AttributeType;
import com.gennadiy.Character;

public class EmberSpirit extends Character {

    public EmberSpirit(String name, int healthPoints, int manaPool, String innateAbility, AttributeType attributeType) {
        super(name, healthPoints, manaPool, innateAbility, attributeType);
    }

    public String fireRemnant(float xPosition, float yPosition) {
        return String.format("Fire Remnant is placed on %.2f%n X position and %.2f%n Y position");
    }

    @Override 
    public String toString() {
        return String.format(
            "EmberSpirit[name='%s', healthPoints=%d, manaPool=%d, innateAbility='%s', attributeType=%s]",
            getName(), getHealthPoints(), getManaPool(), getInnateAbility(), getAttributeType()
        );
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;

        final EmberSpirit otherEmberSpirit = (EmberSpirit) object;

        if (!(this.getName().equals(otherEmberSpirit.getName()))) return false;
        if (Integer.compare(this.getHealthPoints(), otherEmberSpirit.getHealthPoints()) != 0) return false;
        if (Integer.compare(this.getManaPool(), otherEmberSpirit.getManaPool()) != 0) return false;
        if (!(this.getInnateAbility().equals(otherEmberSpirit.getInnateAbility()))) return false;
        if (this.attributeType.compareTo(otherEmberSpirit.attributeType) != 0) return false;
        
        return true;
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public int getHealthPoints() { return this.healthPoints; }

    @Override
    public int getManaPool() { return this.manaPool; }

    @Override
    public String getInnateAbility() { return this.innateAbility; }

    @Override
    public AttributeType getAttributeType() { return this.attributeType; }


    
}
