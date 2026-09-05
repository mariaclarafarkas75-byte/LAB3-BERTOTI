package com.thehecklers.sburrestdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:8080", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/flores")
class RestApiDemoController {

	private final FlorRepository florRepository;

	public RestApiDemoController(FlorRepository florRepository) {
		this.florRepository = florRepository;
	}

	@GetMapping
	Iterable<Flor> getFlores() {
		return florRepository.findAll();
	}

	@GetMapping("/{id}")
	ResponseEntity<Flor> getFlorById(@PathVariable String id) {
		Optional<Flor> flor = florRepository.findById(id);

		return flor.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/cor/{cor}")
	List<Flor> getFloresPorCor(@PathVariable String cor) {
		return florRepository.findByCorIgnoreCase(cor);
	}

	@GetMapping(params = "nome")
	List<Flor> buscarPorNome(@RequestParam String nome) {
		return florRepository.findByNomeContainingIgnoreCase(nome);
	}

	@PostMapping
	ResponseEntity<Flor> postFlor(@Valid @RequestBody Flor flor) {
		Flor salva = florRepository.save(flor);
		return new ResponseEntity<>(salva, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	ResponseEntity<Flor> putFlor(@PathVariable String id, @Valid @RequestBody Flor flor) {
		boolean existia = florRepository.existsById(id);
		Flor salva = florRepository.save(flor);

		return existia
				? new ResponseEntity<>(salva, HttpStatus.OK)
				: new ResponseEntity<>(salva, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteFlor(@PathVariable String id) {
		if (!florRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		florRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
