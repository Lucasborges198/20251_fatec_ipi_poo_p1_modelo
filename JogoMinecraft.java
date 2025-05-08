import java.util.Random;


public class JogoMinecraft {
    public static void main(String[] args) throws Exception{

        var gerador = new Random();
        JogadorMinecraft cacador = new JogadorMinecraft("cacador");
        // var acao =  gerador.nextInt(3);
        while(true) {
            int numeroAleatorio = gerador.nextInt(3);
            
            switch (numeroAleatorio) {
                case 0:
                    cacador.coletarMadeira();
                    break;
                    // return;
                case 1:
                    cacador.construir();
                    break;
                    // return;
                case 2: 
                    cacador.minerar();
                    break;
                    // return;
            }
            System.out.println(cacador);
            System.out.println("============");
            Thread.sleep(5000);
        }
    }
}
