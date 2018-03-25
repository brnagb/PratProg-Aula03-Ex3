package test;


import static org.junit.Assert.assertEquals;
import model.Cliente;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.ClienteService;

@SuppressWarnings("unused")
class TestPais {
	Pais pais,copia;
	static int id = 5;
	
	@Before
	public void setUp() throws Exception {
		System.out.println	("Setup");
		pais   = new Pais	(id,"TesteP", 1343490, 24543.00);
		copia  = new Pais	(id, "TesteP", 1343490, 24543.00);
		System.out.println	(pais);
		System.out.println	(copia);
	}
   	@Test
	public void testCarregar() {
		System.out.println("carregar");
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Carlos Drummond de Andrade");
		fixture.setPopulacao("(11) 91234-4321");
		fixture.setArea("cda@usjt.br");
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}
	@Test
	public void testCriar() {
		System.out.println	("Incluir");
		pais.incluir(0, null, 0, 0);
		id = pais.getId();
		copia.setId(id);
		assertEquals(pais.getId(),copia.getId(),"Teste Criar");
	}
	@Test
	public void testAtualizar() {
		System.out.println	("atualizar");
		pais.setNome		(null);
		copia.setNome		(null);
		pais.atualizar(0, null, 0, 0);
		assertEquals(pais.getNome(),copia.getNome(),"Teste Atualizar");
	}
	@Test
	public void testExcluir() {
		System.out.println	("Excluir");
		pais.setId(id);
		copia.setId(-1);
		pais.excluir(0);
		assertEquals(pais.getId(),copia.getId(),"Teste Excluir");
	}
	@Test
	public void testMaiorPopulacao() {
		System.out.println("Maior populacao");

	    pais.maiorPopulacao();
		long populacao = pais.getPopulacao();
		copia.setPopulacao(populacao);
		assertEquals(pais.getPopulacao(),copia.getPopulacao(),"Teste Maior Populacao");
	}	
	@Test
	public void testMenorArea() {
		System.out.println	("menorArea");
		pais.menorArea();
		double area = pais.getArea();
		copia.setArea(area);
		assertEquals(pais.getArea(),copia.getArea(),"Teste Menor Area");
	}
	public void testVetorTresPaises() {
		System.out.println	("Vetor de Tres Paises");
		String[] vet = pais.vetorPaises();
		assertEquals(vet.length,3,"Teste Vetor");
	}
}