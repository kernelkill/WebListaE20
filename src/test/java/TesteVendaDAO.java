import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import br.com.fabricadeprogramador.persistencia.dao.VendaDAO;
import br.com.fabricadeprogramador.persistencia.entidade.Venda;


public class TesteVendaDAO {

	public static void main(String[] args) {
		
		//Instancia Classe Teclado
		Scanner teclado = new Scanner(System.in);
		
		Venda vend = new Venda();
		
		VendaDAO dao = new VendaDAO();
		
		DateFormat formatadata = new SimpleDateFormat("dd/mm/yyyy");
		
		Date data = null;
		//cadastraVenda(vend, teclado, dao);
		//alteraVenda(vend, teclado, dao);
		//buscaTodasVendas(dao);
		buscaVendaPorData(data , vend, teclado, dao, formatadata);

		
		teclado.close();
	}
	public static void cadastraVenda(Venda vend, Scanner teclado, VendaDAO dao) {
		
		
		DateFormat formatadata = new SimpleDateFormat("dd/mm/yyyy");

		Date data = null;
		
		System.out.println("Digite o Valor: ");
		vend.setValor(teclado.nextDouble());
		
		System.out.println("Digite a Data: ");
		String datadigitada = teclado.next();
		try {
			data = new Date(formatadata.parse(datadigitada).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//seto o parametro data passado no meu syso(digite a data) que foi jogado dentro da string datadigitada. 
		vend.setData(data);
		
		//Invoca o metodo cadastrar usuario.
		dao.cadastrarVenda(vend);
		
		System.out.println("Venda Cadastrado com Sucesso!!!");
	}
	
	public static void alteraVenda(Venda vend, Scanner teclado, VendaDAO dao) {
		
		DateFormat formatadata = new SimpleDateFormat("dd/mm/yyyy");
		Date data = null;
		
		System.out.println("Digite o ID: ");
		vend.setId(teclado.nextInt());
		teclado.nextLine();
		
		System.out.println("Digite o Valor a ser Corrigido: ");
		vend.setValor(teclado.nextDouble());
		
		System.out.println("Digite a Data da alteração: ");
		String datadigitada = teclado.next();
		try {
			data = new Date(formatadata.parse(datadigitada).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		vend.setData(data);
		
		dao.alteraVenda(vend);
		
		System.out.println("venda Alterada com Sucesso!!!");	
	}
	
	public static void buscaTodasVendas(VendaDAO dao){
		
		
		List<Venda> lista = dao.buscaTodasVenda();
		
		for (Venda venda : lista) {
			System.out.println("");
			System.out.println("ID: " + venda.getId());
			System.out.println("Valor: " + venda.getValor());
			System.out.println("Data: " + venda.getData());
			System.out.println("");
			
		}
	}
	
	public static void buscaVendaPorData(Date data, Venda vend, Scanner teclado, VendaDAO dao, DateFormat formatadata){
		
		
		Date dataconpra = null;
				
		System.out.println("Digite a data: ");
		String datadigitada = teclado.next();
		
		try {
			dataconpra = new Date(formatadata.parse(datadigitada).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Venda> lista = dao.buscaVendaData(dataconpra);
		
		for (Venda venda : lista) {
			
			System.out.println();
			System.out.println("ID: " + venda.getId());
			System.out.println("Valor: " + venda.getValor());
			System.out.println("Data: " + venda.getData());			
		}
	}
}
