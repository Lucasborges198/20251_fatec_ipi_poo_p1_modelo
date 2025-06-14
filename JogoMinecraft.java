import java.util.List;
import java.util.Random;

public class JogoMinecraft {
    public static void main(String[] args) throws Exception{
        List<JogadorDTO> listaPersonagem = PreencherJogador.buscarPersonagens();

        JogadorMinecraft cacador = new JogadorMinecraft(listaPersonagem.get(0));
        JogadorMinecraft steveConstrutor = new JogadorMinecraft(listaPersonagem.get(1));   
        while(true) {
            if (cacador.foraDoJogo && steveConstrutor.foraDoJogo){
                PreencherJogador.atualizarValoresDb(cacador);
                PreencherJogador.atualizarValoresDb(steveConstrutor);
                return;
            }
            System.out.println();
            acoesPersonagem(cacador);
            acoesPersonagem(steveConstrutor);
            System.out.println();
            atacarRandom(cacador, steveConstrutor);
            tomarDano(steveConstrutor);
            tomarDano(cacador);
            verificarSeEstaVivo(cacador, steveConstrutor);
            verificarSeEstaVivo(steveConstrutor, cacador);

            if (cacador.estaVivo()) {
                System.out.println(cacador); 
                System.out.println();
            } 
            if (steveConstrutor.estaVivo()){
                System.out.println(steveConstrutor);
                System.out.println();
            }
            System.out.println("=============================================================");
            Thread.sleep(1000);
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

    private static void acoesPersonagem(JogadorMinecraft jogador) {
        double probConstruir = jogador.probConstruir; 
        double probMadeira = jogador.probMadeira; 

        var geradorV2 = new Random();
        double stevePrioridade = geradorV2.nextDouble(1); 

        if (stevePrioridade < probConstruir) {
            jogador.construir();
            jogador.randProbs();
            PreencherJogador.atualizarValoresDb(jogador);
        } else if (stevePrioridade < probMadeira + probConstruir) { 
            jogador.coletarMadeira();
            jogador.randProbs();
            PreencherJogador.atualizarValoresDb(jogador);
        } else {    
            jogador.minerar();
            jogador.randProbs();
            PreencherJogador.atualizarValoresDb(jogador);
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
                if (!jogador2.estaVivo()){
                    jogador.vencedor = jogador.vencedor +  1;
                    jogador2.derrotas = jogador2.derrotas + 1;
                }         
            } else {
                System.out.println(String.format("%s atacou o %s!", jogador2.nome, jogador.nome));
                jogador.vida --;
                if (!jogador.estaVivo()){
                    jogador2.vencedor = jogador2.vencedor +  1;
                    jogador.derrotas = jogador.derrotas + 1;
                } 
            }
        }
    }
}
