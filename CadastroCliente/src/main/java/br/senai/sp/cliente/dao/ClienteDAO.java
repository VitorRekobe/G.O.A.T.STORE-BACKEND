package br.senai.sp.cliente.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.senai.sp.cliente.model.Cliente;



@Repository
public class ClienteDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;

	public List<Cliente> ListarTodos() {
		   String sql = "SELECT * FROM CadastroCliente";
		     
		    List<Cliente> listCliente = jdbcTemplate.query(sql,
		                BeanPropertyRowMapper.newInstance(Cliente.class));
		     
		    for (Cliente Cliente : listCliente) {
		        System.out.println(Cliente);
		    }
		return listCliente;
	}


	public Cliente buscarPorId(int id) {
		String sql = "SELECT * FROM WHERE id = ? ";
		Object[] params = {id};
		Cliente Cliente = jdbcTemplate.queryForObject(sql,
	        BeanPropertyRowMapper.newInstance(Cliente.class),params);
	         
	    System.out.println(Cliente);
	    return Cliente;
	}
	
	public int Novo(Cliente c) {
		
		String sql = "INSERT INTO  CadastroPessoal (nome, email , senha) VALUES (?, ?, ?)";
        
        int result = jdbcTemplate.update(sql, c.getNome(), c.getEmail(), c.getSenha());
        
        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
         
			return result;
			
	}
	
	public int Editar(Cliente c, int id) {
		
		String sql = "UPDATE CadastroCliente set nome=?, email=?, senha=? WHERE id=?";
	    Object[] params = {c.getNome(), c.getEmail() ,c.getSenha(), id};
	    int result = jdbcTemplate.update(sql, params);
	     
	    if (result > 0) {
	        System.out.println("Update successfully.");
	    }
			return result;
			
	}
	
	public int Deletar(int id) {
		
		String sql = "DELETE FROM CadastroCliente WHERE id=?";
	    Object[] params = {id};
	    int result = jdbcTemplate.update(sql, params);
	    
	    if (result > 0) {
		    System.out.println("Delete successfully.");
		}
			return  result;
			
	}
}
