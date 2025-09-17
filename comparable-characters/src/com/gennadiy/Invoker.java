package com.gennadiy;


import com.gennadiy.AttributeType;
import com.gennadiy.Character;

public class Invoker extends Character {

    public Invoker(String name, int healthPoints, int manaPool, String innateAbility, AttributeType attributeType) {
        super(name, healthPoints, manaPool, innateAbility, attributeType);
    }

    public String invoke(String combination) {
        switch (combination) {
            case "qqq": return "Cold Snap"; break;
            case "qqw": return "Ghoust Walk"; break;
            case "qqe": return "Ice Wall"; break;
            case "www": return "E.M.P"; break;
            case "wwq": return "Tornado"; break;
            case "wwe": return "Alacrity"; break;
            case "qwe": return "Deafening Blast"; break;
            case "eee": return "Sun Strike"; break;
            case "eeq": return "Forge Spirit"; break; 
            case "eew": return "Chaos Meteor"; break;
    
            default: break;
        }

    }

    @Override
    public String toString() {
        return String.format(
            "Invoker[name='%s', healthPoints=%d, manaPool=%d, innateAbility='%s', attributeType=%s]",
            getName(), getHealthPoints(), getManaPool(), getInnateAbility(), getAttributeType()
        );
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;

        final Invoker otherInvoker = (Invoker) object;

        if (!(this.getName().equals(otherInvoker.getName()))) return false;
        if (Integer.compare(this.getHealthPoints(), otherInvoker.getHealthPoints()) != 0) return false;
        if (Integer.compare(this.getManaPool(), otherInvoker.getManaPool()) != 0) return false;
        if (!(this.getInnateAbility().equals(otherInvoker.getInnateAbility()))) return false;
        if (this.attributeType.compareTo(otherInvoker.attributeType) != 0) return false;
        
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
