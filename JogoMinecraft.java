import java.util.Random;


public class JogoMinecraft {
    public static void main(String[] args) throws Exception{

        var gerador = new Random();
        JogadorMinecraft cacador = new JogadorMinecraft("cacador");
        // var acao =  gerador.nextInt(3);
        while(true) {
            int numeroAleatorio = gerador.nextInt(3);
            int probDano = gerador.nextInt(4);
            // int Dano = ;
            switch (numeroAleatorio) {
                case 0:
                    cacador.coletarMadeira();
                    if (probDano == 3){
                        cacador.levarDano();
                    }
                    if (!cacador.estaVivo()) {
                        System.out.println("Game Over! Seu personagem morreu!");
                        return;
                    } break;

                case 1:
                    cacador.construir();
                    if (probDano == 3){
                        cacador.levarDano();
                    }
                    if (!cacador.estaVivo()) {
                        System.out.println("Game Over! Seu personagem morreu!");
                        return;
                    } break;


                case 2: 
                    cacador.minerar();
                    if (probDano == 3){
                        cacador.levarDano();
                    }
                    if (!cacador.estaVivo()) {
                        System.out.println("Game Over! Seu personagem morreu!");
                        return;
                    } break;

                    
                }    

            System.out.println(cacador);
            System.out.println("============");
            Thread.sleep(1000);
        }
    }
}
