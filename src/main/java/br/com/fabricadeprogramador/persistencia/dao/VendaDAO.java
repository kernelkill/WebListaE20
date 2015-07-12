package br.com.fabricadeprogramador.persistencia.dao;

import java.sql.Connection;

import br.com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class VendaDAO {
	
	Connection con = ConexaoFactory.getConexao();

}
