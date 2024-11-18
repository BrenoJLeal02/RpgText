package net.codes.main;

public abstract class Personagem {
    protected String name;
    protected int maxHP, hp, xp;

    public Personagem(String name, int maxHP, int xp) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.xp = xp;
    }

    public abstract int attack();
    public abstract int defend();


}
