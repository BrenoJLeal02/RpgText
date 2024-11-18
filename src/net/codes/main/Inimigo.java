package net.codes.main;

public class Inimigo extends Personagem {
    //acumula o xp do jogador
    int playerXp;

    public Inimigo(String name, int playerXp) {
        super(name, (int) (Math.random() * playerXp + playerXp/3 + 5), (int) (Math.random() * (playerXp/4 + 2) + 1 ));
        this.playerXp = playerXp;
    }

    //Calculos dos ataques e da defesa do inimigo
    @Override
    public int attack() {
        return (int) (Math.random() * (playerXp/4 + 1) + xp/4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (playerXp/4 + 1) + xp/4 + 3);
    }
}
