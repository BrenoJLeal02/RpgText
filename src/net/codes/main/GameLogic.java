package net.codes.main;
import java.util.Scanner;
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Jogador jogador;

    public static boolean isRunning;

    //Encontros aleatorios
    public static String[] encounters = {"Battle" , "Battle", "Rest", "Rest", "Shop"};

    //Nome de inimigos
    public static String[] enemies = {"Vampiro", "Caçador de Vampiro", "Mecenário", "Corrupto", "Bruxa"};

    //Elementos da história
    public static int place = 0, act = 1;
    public static String[] places = {"Everlasting Mountains", "Haunted Landlines", "Castle of the Evil Emperor", "Throne Room"};

    //Pega o input do usuário do console
    public static int readInt(String prompt, int userChoices){
        int input;
        do {
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());

            }catch(Exception e){
                input = -1;
                System.out.println("Por favor utilize um número inteiro!");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }
    //Simula a limpeza do console
    public static void clearConsole(){
        for (int i = 0; i < 100; i++)
            System.out.println();


    }
    //separador com tamanho = n
    public static void printSeparator(int n){
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }
    // print do titulo
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    //Para o jogo até o usuário digitar algo e dar enter
    public static void anythingContinue(){
        System.out.println("\nDigite qualquer coisa e pressione enter para continuar...");
        scanner.next();
    }

    //Método para inicia o jogo
    public static void startGame(){
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("AGE OF THE EVIL EMPEROR");
        System.out.println("TEXT RPG BY BRENO");
        printSeparator(30);
        printSeparator(40);
        anythingContinue();

        do {
            clearConsole();
            printHeading("Qual o seu nome ?");
            name = scanner.next();
            clearConsole();
            printHeading("Seu nome é " + name + ".\nCorreto ?");
            System.out.println("(1) Sim!");
            System.out.println("(2) Não, eu gostaria de trocar meu nome.");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        }while(!nameSet);

        //imprime a intro da história(é bom criar um método que checa em que parte da história o jogador está)
        Historia.printIntro();

        // cria um objeto de novo jogador com o nome
        jogador = new Jogador(name);

        //imprime o act2
        Historia.act1Part2();
        //configurando isRunning para true, para o loop do jogo continuar
        isRunning = true;
        //começa o jogo principal(proxima parte)
        gameLoop();
    }
    //Muda o local do jogo baseado no xp do jogador
    public static void checkAct(){
        //Muda o act que o jogador está baseado no xp
        if(jogador.xp >= 10 && act == 1){
            // incrementa o act e o lugar
            act = 2;
            place = 1;
            //história
            Historia.printOutro();
            //Jogador ganha uma nova habilidade
            jogador.chooseTrait();
            //Continuar história
            Historia.act2Part1();
            //Designando novos valores para inimigos
            enemies[0] = "Vampiro";
            enemies[1] = "Caçador de Vampiro";
            enemies[2] = "Mecenário";
            enemies[3] = "Corrupto";
            enemies[4] = "Bruxa";
            //Designando valores para os encontros
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Rest";
            encounters[3] = "Rest";
            encounters[4] = "Shop";

        }else if(jogador.xp >= 50 && act == 2){
            // incrementa o act e o lugar
            act = 3;
            place = 2;
            //história
            Historia.act2Outro();
            //Jogador ganha uma nova habilidade
            jogador.chooseTrait();
            //Continuar história
            Historia.act3Part1();
            //Designando novos valores para inimigos
            enemies[0] = "Vampiro";
            enemies[1] = "Caçador de Vampiro";
            enemies[2] = "Mecenário";
            enemies[3] = "Corrupto";
            enemies[4] = "Bruxa";
            //Designando valores para os encontros
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Rest";
            encounters[3] = "Rest";
            encounters[4] = "Shop";
            //Restaurar a vida do jogador
            jogador.hp = jogador.maxHP;
        }else if(jogador.xp >= 100 && act == 3){
            // incrementa o act e o lugar
            act = 4;
            place = 3;
            //história
            Historia.act3Outro();
            //Jogador ganha uma nova habilidade
            jogador.chooseTrait();
            //Continuar história
            Historia.act4(jogador);
            //Restaurar a vida do jogador
            jogador.hp = jogador.maxHP;
            //batalha final
            finalBattle();

        }
    }

    //método de encontro aleatório
    public static void randomEncounter(){
        //um numero aleatório entre 0 até a quantidade de encontros dentro do array
        int encounter = (int) (Math.random() * encounters.length);
        if(encounters[encounter].equals("Battle")){
            randomBattle();
        }else if (encounters[encounter].equals("Rest")){
            takeRest();
        }else {
            shop();
        }

    }

    //método de continuação da jornada
    public static void continueJourney(){
        //Verifica em qual momento da história o jogador está
        checkAct();
        //Verifica se o jogo não está no ultimo ato
        if(act !=4)
            randomEncounter();
    }
    public static void characterInfo(){
        clearConsole();
        printHeading("STATUS DO PERSONAGEM");
        System.out.println(jogador.name + "\tHP: " + jogador.hp + "/" + jogador.maxHP);
        printSeparator(20);
        // xp e gold do jogador
        System.out.println("XP: " + jogador.xp + "\tGold: " + jogador.gold);
        printSeparator(20);
        //pots do jogados
        System.out.println("Pots: " + jogador.pots);
        printSeparator(20);

        if (jogador.numAtkUpgrades > 0){
            System.out.println("Habilidades de atk: " + jogador.atkUpgrades[jogador.numAtkUpgrades]);
        }
        if(jogador.numDefUpgrades > 0){
            System.out.println("Habilidade de def: " + jogador.defUpgrades[jogador.numDefUpgrades]);
        }
        anythingContinue();
    }
    //Shopping / encontrou um mercante
    public static void shop(){
        clearConsole();
        printHeading("Você encontrou um homem misterioso,\n Ele tem algo a lhe oferecer: ");
        int price = (int) (Math.random() * (10 + jogador.pots*3) + 10 + jogador.pots);
        System.out.println("- Magic Potion: " + price + " gold.");
        printSeparator(20);
        System.out.println("Você quer compara ?\n(1) Sim!\n(2) Não");
        int input = readInt("->", 2);
        if(input == 1){
            clearConsole();
            //verifica se o jogador tem gold suficiente
            if (jogador.gold >= price){
                printHeading("Você comprou uma poção de cura por " + price + " gold.");
                jogador.pots++;
                jogador.gold -= price;
            }else
                printHeading("Você não possui gold o suficiente ...");
            anythingContinue();
        }
    }
    public static void takeRest(){
        clearConsole();
        if (jogador.restsLeft >= 1){
            printHeading("Você deseja tirar um descanso ? (" + jogador.restsLeft + "descanso(s) restante(s)");
            System.out.println("(1) Sim\n(2) Agora não");
            int input = readInt("-> ", 2);
            if (input == 1){
                clearConsole();
                if (jogador.hp < jogador.maxHP){
                    int hpRestored = (int) (Math.random() * jogador.xp/4 + 10);
                    jogador.hp += hpRestored;
                    if(jogador.hp > jogador.maxHP)
                        jogador.hp = jogador.maxHP;
                    System.out.println("Você tirou um descanso e restaurou " + hpRestored + "da sua vida.");
                    System.out.println("Você agora tem " + jogador.hp + "/" + jogador.maxHP);
                }
            }else
                System.out.println("Sua vida está cheia. Você não precisa de descanso!");
            anythingContinue();

        }
    }

    //Criação de uma batalha aleatória
    public static void randomBattle(){
        clearConsole();
        printHeading("Você encotrou um inimigo. Prepare-se para o combate! ");
        anythingContinue();
        //criando novo inimigo com nome aleatório
        battle(new Inimigo(enemies[(int)(Math.random() * enemies.length)], jogador.xp ));
    }
    //método de bathalha
    public static void battle(Inimigo inimigo){
        //loop de batalha
        while(true){
            clearConsole();
            printHeading(inimigo.name + "\nHP: " + inimigo.hp + "/" + inimigo.maxHP);
            printHeading(jogador.name + "\nHP: " + jogador.hp + "/" + jogador.maxHP);
            System.out.println("Escolha uma ação: ");
            printSeparator(20);
            System.out.println("(1) Lutar\n(2) Usar poção\n(3) Fugir ");
            int input = readInt("-> ", 3);
            if(input == 1){
                //Luta
                //Calculo de dano e de dano recebido
                int dmg = jogador.attack() - inimigo.defend();
                int dmgTook = inimigo.attack() - jogador.defend();
                //checar se o dano não é negativo
                if(dmgTook < 0){
                    //adiciona dado se o jogador defender bem
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                jogador.hp -= dmgTook;
                inimigo.hp -= dmg;
                //Exibição da rodada
                clearConsole();
                printHeading("BATALHA");
                System.out.println("Você infligiu " + dmg + " de dano ao" + inimigo.name + ".");
                printSeparator(15);
                System.out.println("O " + inimigo.name + "infligiu " + dmgTook + " a você.");
                anythingContinue();
                //Checar se a vida do jogador chegou a 0
                if (jogador.hp <=0){
                    playerDied();
                    break;
                }else if(inimigo.hp <= 0){
                    clearConsole();
                    printHeading("Você derrotou o " + inimigo.name + "!");
                    //Aumentar o Xp
                    jogador.xp += inimigo.xp;
                    System.out.println("Você recebeu " + inimigo.xp + " de xp");
                    boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random() * inimigo.xp);
                    if (addRest){
                        jogador.restsLeft++;
                        System.out.println("Você ganhou um descanso extra!");
                    }
                    if(goldEarned > 0){
                        jogador.gold += goldEarned;
                        System.out.println("Você coletou " + goldEarned + "de ouro do " + inimigo.name + "!");
                    }
                    anythingContinue();
                    break;
                }
            }else if(input == 2){
                clearConsole();
                if (jogador.pots > 0 && jogador.hp < jogador.maxHP){
                    //Pode tomar poção
                    //Pergunte se ele deseja usar
                    printHeading("Você deseja tomar uma poção ?(Você possui " + jogador.pots + " no total).");
                    System.out.println("(1) Sim \n(2) Talvez mais tarde");
                    input = readInt("->", 2);
                    if(input == 1){
                        jogador.hp = jogador.maxHP;
                        clearConsole();
                        printHeading("Você bebeu uma poção de cura. Seu Hp está completo agora.");
                        anythingContinue();
                    }
                }else{
                    //Não pode tomar poção
                    printHeading("Você não possui poções ou está com a vida cheia!");
                }
            }else{
                clearConsole();
                if (act != 4){
                    //o jogador terá 35% de chance de fugir
                    if(Math.random() * 10 + 1  <= 3.5){
                        printHeading("Você conseguiu escapar do " + inimigo.name + "!");
                        anythingContinue();
                        break;
                    }else{
                        printHeading("Você não conseguiu escapar!");
                        //Caso não consiga fugir o jogador será punido com um ataque do inimigo
                        int dmgTook = inimigo.attack();
                        System.out.println("Você desviou seus olhos do combate e levou " + dmgTook + " de dano!");
                        anythingContinue();
                        //checagem se o jogador ainda está vivo
                        if (jogador.hp<=0)
                            playerDied();
                    }
                } else{
                    printHeading("Você não pode escapar do chefe final!");
                    anythingContinue();
                }
            }

        }
    }

    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolha suas ações: ");
        printSeparator(20);
        System.out.println("(1) Continuar jornada");
        System.out.println("(2) Status do Personagem");
        System.out.println("(3) Sair do jogo");
    }

    //batalha final
    public static void finalBattle(){
        battle(new Inimigo("Chefe Final", 300));
        // eu n fiz uma autro pra o act 4 então a gnt vê dps
        Historia.act4(jogador);
        isRunning = false;

    }


    //método de jogador morto
    public static void playerDied(){
        clearConsole();
        printHeading("Você morreu ...");
        printHeading("Você ganhou " + jogador.xp + " xp na sua jornada. Tente novamente !");
        System.out.println("Obrigado por jogado nosso jogo. Espero que tenha se divertido !");
        isRunning = false;
    }
    //loop do jogo principal
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> " , 3);
            if (input == 1)
                continueJourney();
            else if(input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}
