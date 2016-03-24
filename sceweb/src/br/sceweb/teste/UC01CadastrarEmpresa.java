package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import br.sceweb.modelo.*;


public class UC01CadastrarEmpresa {
	
	static EmpresaDAO empresaDAO;
	static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
			empresaDAO = new EmpresaDAO();
			empresa = new Empresa();
			//89.424.232/0001-90
			

			empresa.setNomeDaEmpresa("empresa y");
			empresa.setCnpj("89424232000190");
			empresa.setNomeFantasia("empresa x");
			empresa.setEndereco("rua taquari");
			empresa.setTelefone("2222");
			
	}
	/**
	 * obj - verificar o comportamento do sistema na inclusao
	 * de uma empesa com sucesso
	 */
	@Test
	public void CT01UC01FBCadatra_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	empresaDAO.exclui("89424232000190");
	}

	
}
