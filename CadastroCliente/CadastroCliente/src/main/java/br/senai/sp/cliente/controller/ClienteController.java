package br.senai.sp.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.cliente.dao.ClienteDAO;
import br.senai.sp.cliente.model.Cliente;


@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	ClienteDAO dao;
	
	@GetMapping
	public List<Cliente> buscarTodos() {
		
		return dao.ListarTodos();
	}
	
	
	@GetMapping("/{id}")
	public Cliente buscarId(@PathVariable int id) {
		
		return dao.buscarPorId(id);
	}
	
	@PostMapping
	public Cliente inserir (@RequestBody Cliente cliente) {
		dao.Novo(cliente);
		return cliente;
	}
	
	@PutMapping("/{id}")
	public Cliente alterar(@RequestBody Cliente cliente, @PathVariable int id) {
		
		dao.Editar(cliente, id);
		
		return cliente;
	}
	
	@DeleteMapping("/{id}")
	public int deletar(@PathVariable int id) {
		
		dao.Deletar(id);
		
		return id;
	}
	
}
