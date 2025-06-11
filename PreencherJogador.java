import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PreencherJogador {
    public static List<JogadorDTO> buscarPersonagens() {
        List<JogadorDTO> listaPersonagens = new ArrayList<>();
        String sql = "select * from tb_personagem";
        try {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "p2poo");
            if (conexao != null) {
                PreparedStatement pre = conexao.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    double nr_derrotas = rs.getDouble("nr_derrotas");
                    double nr_vitorias = rs.getDouble("nr_vitorias");
                    double prob_mineirar = rs.getDouble("prob_mineirar");
                    double prob_madeira = rs.getDouble("prob_madeira");
                    double prob_construir = rs.getDouble("prob_construir");

                    JogadorDTO personagem = new JogadorDTO(id, nome, prob_construir, prob_madeira, prob_mineirar, nr_vitorias, nr_derrotas);
                    listaPersonagens.add(personagem);
                }
            }
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
        }
        return listaPersonagens;
    }
}