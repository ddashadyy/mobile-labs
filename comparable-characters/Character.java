public abstract class Character implements Comparable<Character> {
    
    private int healthPoints;
    private int manaPool;
    private String innateAbility;

    public abstract int getHealthPoints(); 
    public abstract int getManaPool();
    public abstract String getInnateAbility();

    @Override
    public int compareTo(Character character) {}


}
