package br.sceweb.modelo;

import org.apache.log4j.Logger;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.SQLException;
import br.sceweb.servico.*;

public class EmpresaDAO {
	
	public int adiciona(Empresa empresa){
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try (Connection conn = new fabricaDeConexoes().getConnection()){
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into empresa(cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone)  values(?,?,?,?,?)");
		ps.setString(1,empresa.getCnpj());
		ps.setString(2,empresa.getNomeDaEmpresa());
		ps.setString(3,empresa.getNomeFantasia());
		ps.setString(4,empresa.getEndereco());
		ps.setString(5,empresa.getTelefone());
		codigoRetorno = ps.executeUpdate();
		ps.close();
		
		
		}catch (SQLException e){
				throw new RuntimeException(e);
		}
		
		return codigoRetorno;
	}
	
	/*
	 * exclui uma empesa no db
	 * entrada string contendo o cnpj
	 * said - o numero de linhas afetadas com a operação
	 */
	
	public int exclui(String cnpj){
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try (Connection conn = new fabricaDeConexoes().getConnection()){
			ps = (PreparedStatement) conn.prepareStatement(
					"delete from empresa where cnpj = ?");
		ps.setString(1,cnpj);
		
		codigoRetorno = ps.executeUpdate();
		ps.close();
		
		
		}catch (SQLException e){
				throw new RuntimeException(e);
		}
		
		return codigoRetorno;
	}
	//Logger logger = Logger.getLogger(EmpresaDAO.class);
	
	//public int adiciona(Empresa empresa){
	//	logger.info("chamou o método adiciona");
	//	return 1;
	//}

}
