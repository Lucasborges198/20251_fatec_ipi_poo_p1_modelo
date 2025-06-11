import java.util.List;

public class JogadorDTO {
    public int id;
    public String nome;
    public double prob_construir;
    public double prob_madeira;
    public double prob_mineirar;
    public int nr_vitorias;
    public int nr_derrotas;
    public List<String> inventario;

    public JogadorDTO(int id, String nome, double prob_construir, double prob_madeira, double prob_mineirar, int nr_vitorias, int nr_derrotas) {
        this.id = id;
        this.nome = nome;
        this.prob_construir = prob_construir;
        this.prob_madeira = prob_madeira;
        this.prob_mineirar = prob_mineirar;
        this.nr_vitorias = nr_vitorias;
        this.nr_derrotas = nr_derrotas;
    }
}