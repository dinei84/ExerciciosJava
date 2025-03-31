import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Parâmetros de conexão (exemplo para MySQL)
        String url = "jdbc:mysql://localhost:3306/dev"; // Substitua "seu_banco_de_dados"
        String user = "root"; // Substitua pelo seu usuário (ex.: "root")
        String password = "@Dynnand"; // Substitua pela sua senha

        try {
            // Estabelecer a conexão
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");

            // Criar um statement para executar comandos SQL
            Statement statement = connection.createStatement();

            // Executar uma consulta (exemplo: selecionar dados de uma tabela)
            String query = "SELECT * FROM coursejdbc"; // Substitua "sua_tabela"
            ResultSet resultSet = statement.executeQuery(query);

            // Processar os resultados
            while (resultSet.next()) {
                // Substitua "coluna1" e "coluna2" pelos nomes reais das colunas da sua tabela
                System.out.println("Coluna1: " + resultSet.getString("coluna1") +
                        ", Coluna2: " + resultSet.getString("coluna2"));
            }

            // Fechar os recursos
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Conexão fechada.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}