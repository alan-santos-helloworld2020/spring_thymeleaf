package com.base.spring_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.base.spring_thymeleaf.model.ClienteModel;
import com.base.spring_thymeleaf.repository.ClienteRepository;



@Controller
public class PagesController {

	@Autowired
	private ClienteRepository repo;

	@GetMapping("/")
	public String index(Model md) {
		md.addAttribute("nome", "Home");
		return "index";

	}

	@GetMapping("/cadastro")
	public String cadastro(Model md) {
		ClienteModel cliente = new ClienteModel();

		md.addAttribute("cliente", cliente).addAttribute("nome", "Formulário de Cadastro");
		return "cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Validated ClienteModel cliente) {
		repo.save(cliente);
		return "redirect:/clientes";

	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model md) {

		md.addAttribute("nome", "Editar Cliente").addAttribute("cliente", repo.findById(id));
		return "editar";
	}

	@GetMapping("/clientes")
	public String clientes(Model md) {

		md.addAttribute("clientes", repo.findAll()).addAttribute("nome", "Tabela de Clientes");
		return "clientes";
	}

	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/clientes";
	}

}
