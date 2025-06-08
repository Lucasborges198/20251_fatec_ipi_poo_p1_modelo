


public class JogadorDTO {
    public int id;
    public String nome;
    public int prob_construir;
    public int prob_madeira;
    public int prob_mineirar;
    public int nr_vitorias;
    public int nr_derrotas;

    public JogadorDTO(int id, String nome, int prob_construir, int prob_madeira, int prob_mineirar, int nr_vitorias, int nr_derrotas) {
        this.id = id;
        this.nome = nome;
        this.prob_construir = prob_construir;
        this.prob_madeira = prob_madeira;
        this.prob_mineirar = prob_mineirar;
        this.nr_vitorias = nr_vitorias;
        this.nr_derrotas = nr_derrotas;
    } 

    @Override
    public String toString() {
        return "JogadorDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prob_construir='" + prob_construir + '\'' +
                ", prob_madeira=" + prob_madeira + '\'' +
                ", nr_vitorias=" + nr_vitorias + '\'' +
                ", nr_derrotas=" + nr_derrotas + '\'' +
                '}';
    }
}