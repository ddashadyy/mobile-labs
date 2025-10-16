package com.gennadiy;


public class EmberSpirit extends Character {

    private int dodgeSpellsCounter;

    public EmberSpirit(String name, int healthPoints, int manaPool, String innateAbility, AttributeType attributeType) {
        super(name, healthPoints, manaPool, innateAbility, attributeType);
        dodgeSpellsCounter = 0; 
    }

    public String fireRemnant(float xPosition, float yPosition) {
        ++dodgeSpellsCounter;
        return String.format("Fire Remnant is placed on %.2f%n X position and %.2f%n Y position");
    }

    @Override 
    public String toString() {
        return String.format(
            "EmberSpirit[name='%s', healthPoints=%d, manaPool=%d, innateAbility='%s', attributeType=%s, dodgeSpellsCounter=%d]",
            getName(), getHealthPoints(), getManaPool(), getInnateAbility(), getAttributeType(), getDodgeSpellsCounter()
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

    public int getDodgeSpellsCounter() { return dodgeSpellsCounter; }

    
}
