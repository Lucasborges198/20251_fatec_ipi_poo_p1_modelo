import java.util.*;

public class JogadorMinecraft {
    public String nome;
    public int vida;
    private int blocosColetados;
    private List<String> inventario;
    public boolean foraDoJogo;
    public boolean vencedor;
    public double probConstruir;
    public double probMadeira;
    public double probMineirar;

    


    public JogadorMinecraft(JogadorDTO dto) {
        this.nome = dto.nome;
        this.vida = 10;
        this.blocosColetados = 0;
        this.inventario = new ArrayList<>(dto.inventario);
        this.foraDoJogo = false;
        this.vencedor = false;
        this.probConstruir = dto.prob_construir;
        this.probMadeira = dto.prob_madeira;
        this.probMineirar = dto.prob_mineirar;
    }

    public void minerar() {
        if (estaVivo())
        System.out.println(nome + " está minerando...");
        blocosColetados++;
        inventario.add("Pedra");
    }

    public void coletarMadeira() {
        if (estaVivo())
        System.out.println(nome + " coletou madeira.");
        inventario.add("Madeira");
    }

    public void construir() {
        if (estaVivo())
        if (inventario.size() >= 2) {
            System.out.println(nome + " construiu algo com seus recursos!");
            inventario.remove(0);
            inventario.remove(0);
        } else {
            System.out.println(nome + " não tem blocos suficientes para construir.");
        }
    }

    public void levarDano() {
        if (estaVivo()) {
           vida--;
           System.out.println(nome + " levou dano! Vida atual: " + vida);
        }
    }

    public boolean estaVivo() {
        return vida > 0 && !foraDoJogo;
    }

    @Override
    public String toString() {
        return String.format(
            "%s - Vida: %d, Blocos: %d, Inventário: %s",
            nome, vida, blocosColetados, inventario
        );
    }
}
