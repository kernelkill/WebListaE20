package br.com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Venda;
import br.com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class VendaDAO {

	Connection con = ConexaoFactory.getConexao();

	public void cadastrarVenda(Venda vend) {
		String sql = "INSERT INTO venda(valor, data) values (?, ?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setDouble(1, vend.getValor());
			preparador.setDate(2, vend.getData());

			preparador.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao cadastrar o Usuario!!", e);
		}

	}

	public void alteraVenda(Venda vend) {

		String sql = "UPDATE venda SET valor=?, data=? WHERE id=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setDouble(1, vend.getValor());
			preparador.setDate(2, vend.getData());
			preparador.setInt(3, vend.getId());

			preparador.execute();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao Alterar o Usuario!!", e);
		}

	}

	public List<Venda> buscaTodasVenda() {

		String sql = "SELECT * FROM venda ";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			List<Venda> listaretorno = new ArrayList<Venda>();
			ResultSet result = preparador.executeQuery();

			while (result.next()) {

				Venda vend = new Venda();

				vend.setId(result.getInt("ID"));
				vend.setValor(result.getDouble("Valor"));
				vend.setData(result.getDate("Data"));

				listaretorno.add(vend);
			}
			return listaretorno;

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao buscar no banco", e);
		}
	}

	public List<Venda> buscaVendaData(Date data) {

		String sql = "SELECT * FROM venda where data = ? ";
		
		List<Venda> listaretorno = new ArrayList<Venda>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setDate(1, data);
			ResultSet result = preparador.executeQuery();

			if (result.next()) {

				while (result.next()) {
					Venda vend = new Venda();

					vend.setId(result.getInt("id"));
					vend.setValor(result.getDouble("valor"));
					vend.setData(result.getDate("data"));

					listaretorno.add(vend);
				}
			} else {
				System.out.println("Data nao Encontrada...");
			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao pesquisar venda por data", e);
		}
		return listaretorno;
	}

}
