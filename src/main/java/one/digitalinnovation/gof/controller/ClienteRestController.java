package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;
//Primeira classe a ser acionada no Projeto
//Ele é a interface de consumo
/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController // Indica que a classe é um controlador REST, que recebe requisições HTTP e retorna dados, geralmente em JSON.
@RequestMapping("clientes") // Define o caminho base de todas as rotas deste controller: /clientes.
public class ClienteRestController { // Declara a classe responsável por atender às requisições relacionadas aos clientes.

	@Autowired // Pede ao Spring para fornecer automaticamente uma instância de ClienteService.
	private ClienteService clienteService; // Declara o serviço que contém as operações e regras de negócio dos clientes.

	@GetMapping // Mapeia requisições GET para /clientes.
	public ResponseEntity<Iterable<Cliente>> buscarTodos() { // Metodo que retorna uma coleção de clientes dentro de uma resposta HTTP.
		return ResponseEntity.ok(clienteService.buscarTodos()); // Busca todos os clientes pelo service e retorna HTTP 200 (OK) com os dados.
	}

	@GetMapping("/{id}") // Mapeia requisições GET para /clientes/{id}, como /clientes/1.
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) { // Recebe o ID da URL e retorna o cliente correspondente.
		return ResponseEntity.ok(clienteService.buscarPorId(id)); // Busca o cliente pelo ID e retorna HTTP 200 com o resultado.
	}

	@PostMapping // Mapeia requisições POST para /clientes, utilizadas para cadastrar clientes.
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) { // Converte o JSON enviado no corpo da requisição em um objeto Cliente.
		clienteService.inserir(cliente); // Solicita ao service que cadastre o cliente.
		return ResponseEntity.ok(cliente); // Retorna HTTP 200 (OK) com o objeto cliente enviado.
	}

	@PutMapping("/{id}") // Mapeia requisições PUT para /clientes/{id}, utilizadas para atualizar um cliente.
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) { // Recebe o ID pela URL e os novos dados pelo corpo da requisição.
		clienteService.atualizar(id, cliente); // Solicita ao service que atualize o cliente identificado pelo ID.
		return ResponseEntity.ok(cliente); // Retorna HTTP 200 (OK) com o objeto cliente recebido.
	}

	@DeleteMapping("/{id}") // Mapeia requisições DELETE para /clientes/{id}, utilizadas para excluir um cliente.
	public ResponseEntity<Void> deletar(@PathVariable Long id) { // Recebe o ID do cliente que será excluído.
		clienteService.deletar(id); // Solicita ao service que exclua o cliente pelo ID.
		return ResponseEntity.ok().build(); // Retorna HTTP 200 (OK) sem conteúdo no corpo da resposta.
	}
}
