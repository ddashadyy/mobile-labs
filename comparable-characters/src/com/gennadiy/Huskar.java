package com.gennadiy;



public class Huskar extends Character {

    private int attackSpeed;

    public Huskar(String name, int healthPoints, String innateAbility, AttributeType attributeType, int attackSpeed) {
        super(name, healthPoints, 0, innateAbility, attributeType); 
        this.attackSpeed = attackSpeed;
    }


    public String lifeBreak() {
        return String.format("New health points is %.2f%n", (double)(getHealthPoints() * 0.7));
    }


    @Override
    public String toString() {
        return String.format(
            "Huskar[name='%s', healthPoints=%d, manaPool=%d, innateAbility='%s', attributeType=%s, attackSpeed=%d]",
            getName(), getHealthPoints(), getManaPool(), getInnateAbility(), getAttributeType(), getAttackSpeed()
        );
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;

        final Huskar otherHuskar = (Huskar) object;

        if (!(this.getName().equals(otherHuskar.getName()))) return false;
        if (Integer.compare(this.getHealthPoints(), otherHuskar.getHealthPoints()) != 0) return false;
        if (Integer.compare(this.getManaPool(), otherHuskar.getManaPool()) != 0) return false;
        if (!(this.getInnateAbility().equals(otherHuskar.getInnateAbility()))) return false;
        if (this.attributeType.compareTo(otherHuskar.attributeType) != 0) return false;
        
        return true;
    }

    public int getAttackSpeed() { return this.attackSpeed; }
}
