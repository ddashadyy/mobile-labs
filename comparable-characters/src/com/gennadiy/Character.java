package com.gennadiy;


public abstract class Character implements Comparable<Character> {
    
    protected String name;
    protected int healthPoints;
    protected int manaPool;
    protected String innateAbility;
    protected AttributeType attributeType;

    public String getName() { return this.name; }
    public int getHealthPoints() { return this.healthPoints; }
    public int getManaPool() { return this.manaPool; }
    public String getInnateAbility() { return this.innateAbility; }
    public AttributeType getAttributeType() { return this.attributeType; }

    public Character(String name, int healthPoints, int manaPool, 
        String innateAbility, AttributeType attributeType) {

        this.name = name;
        this.healthPoints = healthPoints;
        this.manaPool = manaPool;
        this.innateAbility = innateAbility;
        this.attributeType = attributeType;
    }

    @Override
    public int compareTo(Character other) {

        if (other == null) return 1;

        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) return nameCompare;
        
        int healthCompare = Integer.compare(this.healthPoints, other.healthPoints);
        if (healthCompare != 0) return healthCompare;
        
        int manaCompare = Integer.compare(this.manaPool, other.manaPool);
        if (manaCompare != 0) return manaCompare;
        
        int innateAbilityCompare = this.innateAbility.compareTo(other.innateAbility);
        if (innateAbilityCompare != 0) return innateAbilityCompare;
        
        return this.attributeType.compareTo(other.attributeType);
    }


}
