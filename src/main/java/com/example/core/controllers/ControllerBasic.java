package com.example.core.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.core.model.Languages;
import com.example.core.model.Post;

import configuration.Paginas;


@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	public List<Post> getPosts(){
		ArrayList<Post> post = new ArrayList<>();
		post.add(new Post(1, "Desarrollo web integrado con springboot", "http://localhost/img/genial.jpg", new Date(), "DESARROLLO WEB" ));
		post.add(new Post(2, "Desarrollo web integrado con springboot", "http://localhost/img/genial.jpg", new Date(), "DESARROLLO FRONTEND" ));
		post.add(new Post(3, "Desarrollo web integrado con springboot", "http://localhost/img/genial.jpg", new Date(), "DESARROLLO BACKEND" ));
		post.add(new Post(4, "Desarrollo web integrado con springboot", "http://localhost/img/genial.jpg", new Date(), "DESARROLLO UI/UX" ));

		
		return post;
	}
	
	@GetMapping(path = {"/posts", "/"})
	public String saludar(Model model) {
		model.addAttribute("posts", this.getPosts());  
		model.addAttribute("idioma", getLanguages());
		return "index";				//este metodo debe retornar el nombre de la vista
	}
	
	@GetMapping(path = "/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
//		ModelAndView modelAndView = new ModelAndView("index");    //Esta es otra forma de excribirlo, osea igual index al index
		modelAndView.addObject("posts", this.getPosts());
		modelAndView.addObject("idioma", getLanguages());
		return null;
	}
	
	//Esto bes el envio de parametros de peticion normales y por REQUEST & PATH
	@GetMapping(path = {"/post", "post/{post}"})
	public ModelAndView getPostIndividual(
			//@RequestParam(defaultValue = "1", name="id", required = false) 
			@PathVariable(required = true, name = "post") int id
			
			){
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		
		//Esta es la parte de filtrado, se conecta con la clases donde esta los getter y setter
		List<Post> postFiltrado = this.getPosts().stream()
								.filter( (p)->{
									return p.getId() == id;
								}).collect(Collectors.toList());
		
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
	}
	
	
	//De aqui comienza el video 13
	// Video de Formulario
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post", new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model) {
		List<Post> posts = this.getPosts();
		posts.add(post);
		model.addAttribute("posts", posts);
		return "index";
	}
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public List<Languages> getLanguages(){
		ArrayList<Languages> dev = new ArrayList<>();
		
		dev.add(new Languages(1, "Java", "Es un lenguaje de programación", "http://localhost/img/ij.png"));
		dev.add(new Languages(1, "Java", "Es un lenguaje de programación", "http://localhost/img/python.png"));
		dev.add(new Languages(1, "Java", "Es un lenguaje de programación", "http://localhost/img/kotlin.png"));
		dev.add(new Languages(1, "Java", "Es un lenguaje de programación", "http://localhost/img/js.png"));
		
		return dev;
		
	}
	
	
	
//	@GetMapping(path = {"/language", "/"})
//	public String holi(Model model) {  
//		model.addAttribute("idioma", getLanguages());
//		return "index";				//este metodo debe retornar el nombre de la vista
//	}
	
	

	
	
	
	
	
}


