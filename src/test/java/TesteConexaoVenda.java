import br.com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;


public class TesteConexaoVenda {

	public static void main(String[] args) {
		testeConexao();
		System.out.println("Conexao bem sucedida!");
	}
	
	public static void testeConexao(){
		ConexaoFactory.getConexao();
	}

}
