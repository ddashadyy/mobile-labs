package com.gennadiy;


public class Invoker extends Character {

    private int moveSpeed;

    public Invoker(String name, int healthPoints, int manaPool, String innateAbility, AttributeType attributeType) {
        super(name, healthPoints, manaPool, innateAbility, attributeType);
        moveSpeed = 280;
    }

    public String invoke(String combination) {
        StringBuilder sBuilder = new StringBuilder();
        switch (combination) {
            case "qqq": sBuilder.append("Cold Snap"); break;
            case "qqw": sBuilder.append("Ghoust Walk"); break;
            case "qqe": sBuilder.append("Ice Wall"); break;
            case "www": sBuilder.append("E.M.P"); break;
            case "wwq": sBuilder.append("Tornado"); break;
            case "wwe": sBuilder.append("Alacrity"); break;
            case "qwe": sBuilder.append("Deafening Blast"); break;
            case "eee": sBuilder.append("Sun Strike"); break;
            case "eeq": sBuilder.append("Forge Spirit"); break; 
            case "eew": sBuilder.append("Chaos Meteor"); break;
    
            default: break;
        }

        return sBuilder.toString();
    }

    @Override
    public String toString() {
        return String.format(
            "Invoker[name='%s', healthPoints=%d, manaPool=%d, innateAbility='%s', attributeType=%s, moveSpeed=%d]",
            getName(), getHealthPoints(), getManaPool(), getInnateAbility(), getAttributeType(), getMoveSpeed()
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

    public int getMoveSpeed() { return moveSpeed; }

}
