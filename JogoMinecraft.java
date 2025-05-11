import java.util.Random;


public class JogoMinecraft {
    public static void main(String[] args) throws Exception{

        var gerador = new Random();
        JogadorMinecraft cacador = new JogadorMinecraft("cacador");
        JogadorMinecraft steveConstrutor = new JogadorMinecraft ("Steve Construtor");

        // var acao =  gerador.nextInt(3);
        while(true) {
            int numeroAleatorio = gerador.nextInt(3);
            if (cacador.foraDoJogo && steveConstrutor.foraDoJogo){
                return;
            }
            // int Dano = ;

            switch (numeroAleatorio) {
                case 0:
                    cacador.coletarMadeira();
                    System.out.println();
                    acoesSteve(steveConstrutor);
                    System.out.println();
                    tomarDano(steveConstrutor);
                    tomarDano(cacador);
                    verificarSeEstaVivo(cacador);
                    verificarSeEstaVivo(steveConstrutor);
                     break;

                case 1:
                    cacador.construir();
                    System.out.println();
                    acoesSteve(steveConstrutor);
                    System.out.println();
                    tomarDano(steveConstrutor);
                    tomarDano(cacador);
                    verificarSeEstaVivo(cacador);
                    verificarSeEstaVivo(steveConstrutor);
                     break;

                case 2: 
                    cacador.minerar();
                    System.out.println();
                    acoesSteve(steveConstrutor);
                    System.out.println();
                    tomarDano(steveConstrutor);
                    tomarDano(cacador);
                    verificarSeEstaVivo(cacador);
                    verificarSeEstaVivo(steveConstrutor);
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

    private static void verificarSeEstaVivo(JogadorMinecraft jogador) {
        if (!jogador.estaVivo()) {
            System.out.printf("O personagem %s morreu!%n", jogador.nome);
            jogador.foraDoJogo = true; 
            // System.exit(0); 
        }
    }

    private static void acoesSteve(JogadorMinecraft jogador) {
    var geradorv2 = new Random();
    int stevePrioridade = geradorv2.nextInt(10);

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
      var geradorv3 = new Random();
      int probDano = geradorv3.nextInt(4);
        if (probDano == 0) {
            System.out.println();
            jogador.levarDano();
            System.out.println();
        }
    }
}
