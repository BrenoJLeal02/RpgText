package net.codes.main;

import static net.codes.main.GameLogic.jogador;

public class Historia {

    // Parte 1: Introdução ao mundo
    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT I: PARTE 1");
        GameLogic.printSeparator(30);
        System.out.println("Você desperta em uma clareira iluminada por um estranho brilho prateado.");
        System.out.println("O silêncio ao seu redor é perturbador, quebrado apenas pelo som distante de corujas.");
        System.out.println("Enquanto tenta entender onde está, percebe uma mochila ao seu lado. Dentro, você encontra:");
        System.out.println("- Um mapa misterioso\n- Uma adaga enferrujada\n- Um pequeno cristal brilhante");
        System.out.println("Intrigado, você decide explorar a floresta densa à sua frente...");
        GameLogic.anythingContinue();
    }

    // Parte 2: Primeiro desafio
    public static void act1Part2() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT I: PARTE 2");
        GameLogic.printSeparator(30);
        System.out.println("Após caminhar por horas, você sente que está sendo observado.");
        System.out.println("De repente, um lobo com olhos brilhantes emerge das sombras, rosnando ferozmente!");
        System.out.println("Você precisa decidir rapidamente:");
        System.out.println("1) Enfrentar o lobo com a adaga\n2) Tentar fugir correndo pela floresta\n3) Usar o cristal para tentar assustá-lo");

        int escolha = GameLogic.readInt("O que você faz? Escolha 1, 2 ou 3:", 3); // Pede a escolha do jogador
        switch (escolha) {
            case 1:
                System.out.println("Você enfrenta o lobo com a adaga, mas sua arma está velha e danificada...");
                System.out.println("Após uma luta intensa, você o derrota, mas sai com alguns ferimentos.");
                jogador.hp -= 10; // Exemplo de impacto na vida do jogador
                break;
            case 2:
                System.out.println("Você corre pela floresta, mas o lobo é rápido e o alcança!");
                System.out.println("Você é forçado a lutar, mas escapa por pouco, exausto.");
                jogador.hp -= 15; // Maior penalidade por fugir
                break;
            case 3:
                System.out.println("Você ergue o cristal, que brilha intensamente e afasta o lobo!");
                System.out.println("Surpreso, você percebe que o cristal tem poderes que você ainda não entende.");
                jogador.hp += 5; // Bônus de mana
                break;
        }
        GameLogic.anythingContinue();
    }

    // Parte 3: Um encontro inesperado
    public static void act1Part3() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT I: PARTE 3");
        GameLogic.printSeparator(30);
        System.out.println("Exausto e ferido, você encontra uma pequena cabana escondida entre as árvores.");
        System.out.println("A porta range ao abrir, revelando um interior acolhedor, iluminado por uma lareira.");
        System.out.println("Uma figura encapuzada está sentada à mesa, misturando ingredientes em um caldeirão.");
        System.out.println("\"Entre, aventureiro,\" diz a figura com uma voz rouca.");
        System.out.println("Você hesita, mas a necessidade de respostas (e descanso) o obriga a entrar.");
        System.out.println("O misterioso alquimista oferece ajuda, mas com uma condição:");
        System.out.println("\"Traga-me o coração do guardião da floresta e eu lhe darei o que procura.\"");
        GameLogic.anythingContinue();
    }
    public static void printOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - FIM DO ACT I");
        GameLogic.printSeparator(30);
        System.out.println("Armado com informações e uma nova missão, " + jogador.name + "segue para o coração da floresta.");
        System.out.println("A noite está mais escura do que nunca, e você sente que algo está observando.");
        System.out.println("Com determinação, você se prepara para o confronto que pode mudar tudo.");
        System.out.println("O Act I chega ao fim, mas o verdadeiro desafio está apenas começando...");
        GameLogic.anythingContinue();
    }
    public static void act2Part1() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT II: PARTE 1");
        GameLogic.printSeparator(30);
        System.out.println("A floresta ao seu redor fica cada vez mais densa, e o ar se torna pesado.");
        System.out.println("Você sente que está se aproximando de algo perigoso.");
        System.out.println("No caminho, você encontra três opções:");
        System.out.println("1) Seguir o som de água corrente ao norte\n2) Entrar em uma caverna oculta\n3) Continuar pela trilha principal");

        int escolha = GameLogic.readInt("O que você faz? Escolha 1, 2 ou 3:", 3);

        switch (escolha) {
            case 1:
                System.out.println("Você segue o som da água e encontra um riacho cristalino.");
                System.out.println("Ao beber a água, sente suas forças se renovarem.");
                jogador.hp += 10;
                System.out.println("Você recuperou 10 pontos de vida!");
                break;
            case 2:
                System.out.println("Você entra na caverna e é atacado por morcegos selvagens!");
                System.out.println("Consegue escapar, mas sai com alguns ferimentos.");
                jogador.hp -= 10;
                break;
            case 3:
                System.out.println("Você continua pela trilha principal e sente que está no caminho certo.");
                System.out.println("Nada acontece, mas a tensão aumenta.");
                break;
        }
        GameLogic.anythingContinue();
    }
    public static void act2Part2() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT II: PARTE 2");
        GameLogic.printSeparator(30);
        System.out.println("Mais à frente, você encontra o Guardião da Floresta, um imenso ser feito de madeira e pedra.");
        System.out.println("Ele ruge e avança em sua direção!");
        System.out.println("Você tem três opções:");
        System.out.println("1) Atacar com sua arma\n2) Usar o cristal mágico\n3) Procurar algo ao seu redor para usar contra ele");

        int escolha = GameLogic.readInt("O que você faz? Escolha 1, 2 ou 3:", 3);

        switch (escolha) {
            case 1:
                System.out.println("Você ataca com sua arma, mas o guardião é resistente.");
                System.out.println("Após uma batalha intensa, você o derrota, mas sai gravemente ferido.");
                jogador.hp -= 20;
                break;
            case 2:
                System.out.println("Você usa o cristal mágico. Um raio de luz atinge o guardião, enfraquecendo-o.");
                System.out.println("Aproveitando a oportunidade, você o derrota com facilidade.");
                jogador.hp -= 10;
                break;
            case 3:
                System.out.println("Você encontra uma poção de fogo escondida no chão e a arremessa no guardião.");
                System.out.println("Ele pega fogo e cai, derrotado!");
                break;
        }
        GameLogic.anythingContinue();
    }

    public static void act2Outro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - FIM DO ACT II");
        GameLogic.printSeparator(30);
        System.out.println("Você obtém o coração do Guardião da Floresta e retorna à cabana do alquimista.");
        System.out.println("Ele sorri enigmaticamente e lhe entrega um pergaminho contendo um mapa para um antigo templo.");
        System.out.println("Seu próximo destino está claro: o Templo do Crepúsculo.");
        GameLogic.anythingContinue();
    }

    // ====================
    // ACT III - O Templo do Crepúsculo
    // ====================

    public static void act3Part1() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT III: PARTE 1");
        GameLogic.printSeparator(30);
        System.out.println("Você chega ao Templo do Crepúsculo, um local antigo coberto por runas brilhantes.");
        System.out.println("Ao entrar, o chão começa a tremer e você ouve uma voz ecoando:");
        System.out.println("\"Resolva meus enigmas ou pereça.\"");
        System.out.println("Primeiro enigma: O que caminha de manhã com quatro patas, à tarde com duas, e à noite com três?");
        System.out.println("1) Um cachorro\n2) Um humano\n3) Uma cadeira");

        int escolha = GameLogic.readInt("Qual é sua resposta?", 3);

        if (escolha == 2) {
            System.out.println("Você responde corretamente! As portas do templo se abrem.");
        } else {
            System.out.println("Você erra a resposta, e uma armadilha é ativada!");
            System.out.println("Você sofre danos, mas consegue sobreviver.");
            jogador.hp -= 15;
        }
        GameLogic.anythingContinue();
    }

    public static void act3Part2() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT III: PARTE 2");
        GameLogic.printSeparator(30);
        System.out.println("No coração do templo, você encontra um artefato poderoso: o Amuleto da Luz.");
        System.out.println("Ao pegá-lo, um espírito guardião surge, exigindo que você prove seu valor!");
        System.out.println("1) Atacar o espírito\n2) Negociar com ele\n3) Oferecer o cristal mágico");

        int escolha = GameLogic.readInt("O que você faz? Escolha 1, 2 ou 3:", 3);

        switch (escolha) {
            case 1:
                System.out.println("Você ataca o espírito, mas ele é muito poderoso. Após uma luta árdua, você o derrota.");
                jogador.hp -= 25;
                break;
            case 2:
                System.out.println("Você tenta negociar e o espírito aceita. Ele lhe dá o amuleto sem lutar.");
                break;
            case 3:
                System.out.println("Você oferece o cristal mágico. O espírito o aceita e desaparece, deixando o amuleto.");
                jogador.hp -= 10;
                break;
        }
        GameLogic.anythingContinue();
    }

    public static void act3Outro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - FIM DO ACT III");
        GameLogic.printSeparator(30);
        System.out.println("Com o Amuleto da Luz em mãos, você sai do templo, mas sente que está sendo observado.");
        System.out.println("O vento carrega uma mensagem sombria: \"O Senhor das Trevas já sabe de sua presença.\"");
        System.out.println("Seu próximo destino: o Castelo da Eternidade.");
        GameLogic.anythingContinue();
    }

    // ====================
    // ACT IV - O Confronto Final
    // ====================

    public static void act4(Jogador jogador) {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA - ACT IV: O CONFRONTO FINAL");
        GameLogic.printSeparator(30);
        System.out.println("Você chega ao Castelo da Eternidade, lar do Senhor das Trevas.");
        System.out.println("Ao entrar no salão principal, ele aparece, envolto em sombras.");
        System.out.println("\"Você ousa me desafiar, mortal? Prepare-se para seu fim!\"");
        System.out.println("Você precisa decidir:");
        System.out.println("1) Usar o Amuleto da Luz para atacá-lo diretamente\n2) Tentar negociar\n3) Procurar um ponto fraco no ambiente");

        int escolha = GameLogic.readInt("Qual é sua escolha?", 3);

        switch (escolha) {
            case 1:
                System.out.println("O Amuleto brilha intensamente e atinge o Senhor das Trevas, destruindo-o!");
                System.out.println("A vitória é sua, mas você sente que um grande preço foi pago.");
                jogador.hp -= 30;
                break;
            case 2:
                System.out.println("Você tenta negociar, mas o Senhor das Trevas não é convencido. Ele o ataca!");
                jogador.hp -= 20;
                System.out.println("Com dificuldade, você consegue derrotá-lo.");
                break;
            case 3:
                System.out.println("Você procura um ponto fraco e descobre um cristal sombrio que alimenta seu poder.");
                System.out.println("Ao destruí-lo, o Senhor das Trevas enfraquece e você o derrota facilmente!");
                break;
        }
        GameLogic.anythingContinue();
    }
}


