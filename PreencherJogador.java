import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class PreencherJogador {
    public List<String> ListaPersonagens;

    public static void main(String[] args) {
        String sql = "select * from tb_personagem";
        try {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "p2poo");
            if (conexao != null) {
                System.out.println("Conexao estabelecida com sucesso!");
                PreparedStatement pre = conexao.prepareStatement(sql);
                System.out.println(pre);
                List<JogadorDTO> listaPersonagens = new ArrayList<>();
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int nr_derrotas = rs.getInt("nr_derrotas");
                    int nr_vitorias = rs.getInt("nr_vitorias");
                    int prob_mineirar = rs.getInt("prob_mineirar");
                    int prob_madeira = rs.getInt("prob_madeira");
                    int prob_construir = rs.getInt("prob_construir");

                    JogadorDTO personagem = new JogadorDTO(id, nome, prob_construir, prob_madeira, prob_mineirar, nr_vitorias, nr_derrotas);
                    listaPersonagens.add(personagem);
                }
                System.out.println();
            } else {
                System.out.println("Conexao não estabelecida!");
            }
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
        }
    }
}
