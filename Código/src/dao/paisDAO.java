package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class paisDAO {
	
		public void incluir(Pais pais) {
			String sqlInsert = "INSERT INTO cliente(id, nome, fone) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.setLong(3, pais.getPopulacao());
			stm.setDouble(4, pais.getArea());
			
			stm.execute();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}



		public void atualizar(Pais pais) {
			String sqlUpdate = "UPDATE cliente SET nome=?, fone=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(2, pais.getArea());
			
			stm.setInt(4, pais.getId());
			stm.execute();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}

	
		public void excluir(Pais pais) {
			
			String sqlDelete = "DELETE FROM cliente WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, pais.getId());
			stm.execute();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}

		
		public Pais carregar(int id) {
			Pais pais = new Pais();
			pais.setId(id);
			String sqlSelect = "SELECT nome, populacao, area FROM cliente WHERE cliente.id = ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
			   PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			   stm.setInt(1, pais.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					} else {
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return pais;
	    }

		//maiorPopulacao
		public void maiorPopulacao(long populacao) {
			Pais pais = new Pais();
			String sql = "SELECT * FROM Pais WHERE populacao = (SELECT MAX(populacao) FROM Pais)";
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(sql);	
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					pais.setNome(rs.getString    ("nome"));
					pais.setPopulacao(rs.getLong ("populacao"));
					pais.setId(rs.getInt         ("id"));
					pais.setArea(rs.getDouble    ("area"));
				}else {
					System.out.println("Error Result Set");
				}
				
			}catch (SQLException e) {
				System.out.println(e);
			}
		}

		//menorArea
		public void menorArea(double area) {
			Pais pais = new Pais();
			String get = "SELECT * FROM pais WHERE area = (SELECT Min(area) FROM Pais)";
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(get);
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					pais.setNome(rs.getString    ("nome"));
					pais.setPopulacao(rs.getLong ("populacao"));
					pais.setId(rs.getInt			("id"));
					pais.setArea(rs.getDouble    ("area"));
				}else {
					System.out.println("ERROR RESULT SET");
				}
			}catch (SQLException e) {
				System.out.println(e);
			}
		}

		//vetorTresPaises
		public String[] vetorTresPaises(Pais pais) {	
			String get = "SELECT nome FROM paises ORDER BY nome";
			String[] array = new String[3];
			int cont = 0 ;
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(get);
				ResultSet rs = stm.executeQuery();
				while(rs.next() && cont < 3 ) {
					array[cont] = rs.getString("nome");
					cont ++;
				}
			}catch (SQLException e) {
				System.out.println(e);
			}	
			
			return array;
		}
}
	