package br.com.tarefa48.controladores;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import br.com.tarefa48.entidades.Animal;
import br.com.tarefa48.repositorios.AnimalRepository;

@RestController
@RequestMapping("/animais")
public class AnimalControle {
	
	private AnimalRepository repository;
	
	public AnimalControle(AnimalRepository repository) {
		this.repository = repository;
		
	}
	@GetMapping
	private List<Animal> findAll(){
		return repository.findAll();
		
	}
	
	@PostMapping
	private Animal criar(@RequestBody Animal animal) {
		return repository.save(animal);
	}
	
	@GetMapping("nao-adotado")
	private List<Animal> findNotAdopted(){
		return repository.findNotAdopted();
	}
	
	@GetMapping("obito")
	private List<Animal> findObito(){
		return repository.findObito();
	}
	
	@GetMapping("adotado")
	private List<Animal> findAdopted(){
		return repository.findAdopted();
	}
	
	@GetMapping("dog")
	private List<Animal> findDog(){
		return repository.findDog();
	}
	
	@GetMapping("cat")
	private List<Animal> findCat(){
		return repository.findCat();
	}

}
