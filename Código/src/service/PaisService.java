package service;

import model.Pais;
import dao.paisDAO;


public class PaisService {
	
	paisDAO dao = new paisDAO();
	
	public void criar(Pais pais) {
		dao.incluir(pais);
	}
	public void atualizar(Pais pais) {
		dao.atualizar(pais);
	}
	public void excluir(Pais pais) {
		dao.excluir(pais);
	}
	public Pais carregar(int id) {
		Pais pais = dao.carregar(id);
		return pais;
	}

	public long maiorPopulacao (long populacao) {
		
		 dao.maiorPopulacao(populacao);
		 return populacao;
	}
	
	public double menorArea (double area) {
		
		 dao.menorArea(area);
		 return area;
	}
	
	public String[] vetorTresPaises (Pais pais) {
		return dao.vetorTresPaises(pais);	
		
	}
	
}