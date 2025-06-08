import java.util.Random;


public class JogoMinecraft {
    public static void main(String[] args) throws Exception{

        var gerador = new Random();
        JogadorMinecraft cacador = new JogadorMinecraft("cacador");
        JogadorMinecraft steveConstrutor = new JogadorMinecraft ("Steve Construtor");

        while(true) {
            int numeroAleatorio = gerador.nextInt(3);
            if (cacador.foraDoJogo && steveConstrutor.foraDoJogo){
                return;
            }

            switch (numeroAleatorio) {
                case 0:
                    cacador.coletarMadeira();
                    System.out.println();
                    acoesSteve(steveConstrutor);
                    System.out.println();
                    atacarRandom(cacador, steveConstrutor);
                    tomarDano(steveConstrutor);
                    tomarDano(cacador);
                    verificarSeEstaVivo(cacador, steveConstrutor);
                    verificarSeEstaVivo(steveConstrutor, cacador);
                     break;

                case 1:
                    cacador.construir();
                    System.out.println();
                    acoesSteve(steveConstrutor);
                    System.out.println();
                    atacarRandom(cacador, steveConstrutor);
                    tomarDano(steveConstrutor);
                    tomarDano(cacador);
                    verificarSeEstaVivo(cacador, steveConstrutor);
                    verificarSeEstaVivo(steveConstrutor, cacador);
                     break;

                case 2: 
                    cacador.minerar();
                    System.out.println();
                    acoesSteve(steveConstrutor);
                    System.out.println();
                    atacarRandom(cacador, steveConstrutor);
                    tomarDano(steveConstrutor);
                    tomarDano(cacador);
                    verificarSeEstaVivo(cacador, steveConstrutor);
                    verificarSeEstaVivo(steveConstrutor, cacador);
                     break;  
                }    
            if (cacador.estaVivo()) {
              System.out.println(cacador); 
              System.out.println();
            } 
            if (steveConstrutor.estaVivo()){
              System.out.println(steveConstrutor);
              System.out.println();
            }
            System.out.println("=============================================================");
            Thread.sleep(2000);
        }
    }

    private static void verificarSeEstaVivo(JogadorMinecraft jogador, JogadorMinecraft jogador2) {
        if (!jogador.estaVivo()) {
            System.out.printf("O personagem %s morreu!%n", jogador.nome);
            jogador.foraDoJogo = true; 
            if (!jogador2.foraDoJogo){
                System.out.println(String.format("O %s é o vencedor do duelo", jogador2.nome)); 
            }
        }
    }

    private static void acoesSteve(JogadorMinecraft jogador) {
    var geradorV2 = new Random();
    int stevePrioridade = geradorV2.nextInt(10);

    switch (stevePrioridade) {
     case 0, 1, 2, 3, 4, 5:
         jogador.construir();
         break;
    
     case 6, 7, 8:
         jogador.coletarMadeira();
         break;
    
     case 9:
         jogador.minerar();
         break;

    }
    }
    
    private static void tomarDano(JogadorMinecraft jogador) {
      var geradorV3 = new Random();
      int probDano = geradorV3.nextInt(4);
        if (probDano == 0) {
            System.out.println();
            jogador.levarDano();
            System.out.println();
        }
    }

    private static void atacarRandom(JogadorMinecraft jogador, JogadorMinecraft jogador2) {
        var geradorV4 = new Random();
        int probAtacar = geradorV4.nextInt(2);
        if (jogador.estaVivo() && jogador2.estaVivo()){
            if (probAtacar == 0){
                System.out.println(String.format("%s atacou o %s!", jogador.nome, jogador2.nome));
                jogador2.vida --;          
            } else {
                System.out.println(String.format("%s atacou o %s!", jogador2.nome, jogador.nome));
                jogador.vida --; 
            }
        }
    }
}
