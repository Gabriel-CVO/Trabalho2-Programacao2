package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.Interface;
import javabanco.ConnectionFactory;
import model.Contato;

public class ContatoDao implements Interface {
	private Connection con;
	
	public ContatoDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql = "insert into contatos(nome, email, endereco) values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		
		stmt.execute();
		
		stmt.close();
		
	}
	
	public List<Contato> getLista() throws SQLException {
		String query = "select * from contatos";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rset = stmt.executeQuery();
		List<Contato> contatos = new ArrayList<Contato>();
		
		while (rset.next()) {
			Contato contato = new Contato();
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			contatos.add(contato);
		}
		
		rset.close();
		stmt.close();
		
		return contatos;
	}
	
	public List<Contato> buscarContatosPorInicial(String inicial) throws SQLException {
		String sql = "SELECT * FROM contatos WHERE nome LIKE ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, inicial + "%");
		ResultSet rset = stmt.executeQuery();
		List<Contato> contatos = new ArrayList<Contato>();
		
		while (rset.next()) {
			Contato contato = new Contato();
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			contatos.add(contato);
		}
		
		rset.close();
		stmt.close();
		
		return contatos;
	}
	
	public Contato buscarContatoPorId(long id) throws SQLException {
		String sql = "SELECT * FROM contatos WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rset = stmt.executeQuery();
		Contato contato = null;
		
		if (rset.next()) {
			contato = new Contato();
			contato.setId(rset.getLong("id"));
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
		}
		
		rset.close();
		stmt.close();
		
		return contato;
	
	}
	
	public void atualizarContato(Contato contato) throws SQLException {
		String sql = "UPDATE contatos SET nome = ?, email = ?, endereco = ? WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setLong(4, contato.getId());
		
		stmt.executeUpdate();
		
		stmt.close();
	}
	
	
	public void removerContato(long id) throws SQLException {
		String sql = "DELETE FROM contatos WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setLong(1, id);
		
		stmt.executeUpdate();
		
		stmt.close();
	}

	public void close() throws SQLException {
        con.close();
    }

	
	
}
