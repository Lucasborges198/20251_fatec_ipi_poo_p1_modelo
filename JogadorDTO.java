import java.util.List;

public class JogadorDTO {
    public int id;
    public String nome;
    public double prob_construir;
    public double prob_madeira;
    public double prob_mineirar;
    public double nr_vitorias;
    public double nr_derrotas;
    public List<String> inventario;

    public JogadorDTO(int id, String nome, double prob_construir, double prob_madeira, double prob_mineirar, double nr_vitorias, double nr_derrotas) {
        this.id = id;
        this.nome = nome;
        this.prob_construir = prob_construir;
        this.prob_madeira = prob_madeira;
        this.prob_mineirar = prob_mineirar;
        this.nr_vitorias = nr_vitorias;
        this.nr_derrotas = nr_derrotas;
    }
}