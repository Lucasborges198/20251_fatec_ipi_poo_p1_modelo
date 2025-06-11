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
                    int nr_derrotas = rs.getInt("nr_derrotas");
                    int nr_vitorias = rs.getInt("nr_vitorias");
                    double prob_mineirar = rs.getDouble("prob_mineirar");
                    double prob_madeira = rs.getDouble("prob_madeira");
                    double prob_construir = rs.getDouble("prob_construir");

                    JogadorDTO personagem = new JogadorDTO(id, nome, prob_construir, prob_madeira, prob_mineirar,
                            nr_vitorias, nr_derrotas);
                    listaPersonagens.add(personagem);
                }
            }
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
        }
        return listaPersonagens;
    }

    public static void atualizarValoresDb(JogadorMinecraft jogador) {

        String sql = "UPDATE tb_personagem SET nr_vitorias = ?, nr_derrotas = ? WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "p2poo");
                PreparedStatement pre = conexao.prepareStatement(sql)) {
                    pre.setInt(1, jogador.vencedor);
                    pre.setInt(2, jogador.derrotas);
                    pre.setInt(3, jogador.id);
                    pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Não foi possivel realizar o update na tabela");
        }
    }
}