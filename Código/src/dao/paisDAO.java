package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class paisDAO {
	

		public int criar(Pais pais) {
			String sql = "INSERT INTO Pais(id, nome, populacao, area) VALUES (?, ?, ?, ?)";
			try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);) {
				stm.setString(1, pais.getNome());
				stm.setLong  (2, pais.getPopulacao());
				stm.setDouble(3, pais.getArea());
			   stm.execute();
				} catch (SQLException e) {
				e.printStackTrace();
			    }
			return pais.getId();
		}

		public void atualizar(Pais pais) {
			String sql = "UPDATE Pais SET nome=?, area=?, populacao=? WHERE id=?";
			try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);) {
				stm.setString(1, pais.getNome());
				stm.setLong  (2, pais.getPopulacao());
				stm.setDouble(3, pais.getArea());
			    stm.execute();
				} catch (Exception e) {
				e.printStackTrace();
			    }
		}
	
		public void excluir(int id){
			String sql = "DELETE FROM Pais WHERE id = ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sql);) {
				stm.setInt   (1, id);
				stm.execute  ();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		public Pais carregar(int id) {
			Pais pais = new Pais();
			pais.setId(id);
			String sqlSelect = "SELECT nome, populacao, area FROM cliente WHERE cliente.id = ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
			   PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			   stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
					} else {
					setId(-1);
					setNome(null);
					setPopulacao(-1);
					setArea(-1);
				}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return pais;
	    }
			
		private int getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		//maiorPopulacao
		public void maiorPopulacao() {
			String sql = "SELECT * FROM Pais WHERE populacao = (SELECT MAX(populacao) FROM Pais)";
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(sql);	
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					setNome(rs.getString    ("nome"));
					setPopulacao(rs.getLong ("populacao"));
					setId(rs.getInt         ("id"));
					setArea(rs.getDouble    ("area"));
				}else {
					System.out.println("Error Result Set");
				}
				
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		private void setNome(String string) {
			// TODO Auto-generated method stub
			
		}

		//menorArea
		public void menorArea() {
			String get = "SELECT * FROM pais WHERE area = (SELECT Min(area) FROM Pais)";
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(get);
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					setNome(rs.getString    ("nome"));
					setPopulacao(rs.getLong ("populacao"));
					setId(rs.getInt			("id"));
					setArea(rs.getDouble    ("area"));
				}else {
					System.out.println("ERROR RESULT SET");
				}
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		private void setArea(double double1) {
			// TODO Auto-generated method stub
			
		}

		private void setId(int int1) {
			// TODO Auto-generated method stub
			
		}

		private void setPopulacao(long long1) {
			// TODO Auto-generated method stub
			
		}

		//vetorTresPaises
		public String[] vetorTresPaises() {	
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
	