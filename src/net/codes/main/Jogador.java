package net.codes.main;

public class Jogador extends Personagem{

    public int numAtkUpgrades,numDefUpgrades;

    // status adicionais para o jogador
    int gold, restsLeft, pots;
    //Lista para guardar os nomes das skills
    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defUpgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};


    //Contrutor do jogador
    public Jogador(String name) {
        //Chamada da superclass
        super(name, 100,0);
        //Setando os upgrades para 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;
        //Deixa o jogador escolher os atributos ao criar um novo personagem
        chooseTrait();
    }

    // métodos especificos
    @Override
    public int attack() {
        return (int) (Math.random() * (xp/4 + numAtkUpgrades * 3 + 3) + xp/10 + numAtkUpgrades * 2 + numDefUpgrades +1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (xp/4 + numDefUpgrades * 3 + 3) + xp/10 + numDefUpgrades * 2 + numAtkUpgrades +1);
    }
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Escolha suas habilidades: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        //Recebe a escolha do jogador
        int input = GameLogic.readInt("-> " , 2);
        GameLogic.clearConsole();
        //Avisa ao jogador oq ele escolheu
        if(input == 1){
            GameLogic.printHeading("Você Escolheu " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("Você Escolheu " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingContinue();
    }
}
