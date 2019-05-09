package lab05_RaianyRufino;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Representação de um Controller de Clientes. Um Controller possui o mapeamento do objeto Cliente pelo seu número de cpf. 
 * Além de possibilitar adicionar, exibir, editar e remover os Clientes.
 * 
 * @author Raiany Rufino - 118110466
 *
 */
public class ControllerCliente {
	
	private HashMap<String, Cliente> clientes;
	
	/**
	 * Constrói um controller e inicializa seu mapa de Clientes.
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}
	
	/**
	 * Método que invoca o construtor de um cliente, e o adiciona no mapa, com seu
	 * cpf como chave, caso ele não tenha sido adicionado ainda.
	 * @param cpf O número de cpf do cliente.
	 * @param nome O nome do cliente.
	 * @param email O email do cliente.
	 * @param localizacao A localização do cliente.
	 * @return O número de cpf do cliente.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		Cliente cliente = new Cliente(cpf, nome, email, localizacao);
		if(this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		} else {
			this.clientes.put(cpf, cliente);
			return cpf;
		  }
	}
	
	public boolean existeCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			return true;
		} return false;
	}
	
	/**
	 * Método que procura um cliente no mapa pelo seu cpf, e retorna sua representação em String.
	 * @param cpf O número de cpf do cliente.
	 * @return a representação em String do cliente.
	 */
	public String exibeCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			return this.clientes.get(cpf).toString();
		} else {
		    throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		  }
	}
    
	/**
	 * Método que procura um cliente no mapa pelo seu cpf, e edita o atributo passado.
	 * @param cpf O número de cpf do cliente.
	 * @param atributo O atributo que será alterado, podendo ser o nome, localizacao ou email do cliente.
	 * @param novoValor O novo valor que substituirá o valor anterior do atributo dado.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).editaAtributo(atributo, novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}

	/**
	 * Método que procura um cliente no mapa pelo seu cpf, e o remove.
	 * @param cpf O número de cpf do cliente.
	 */
	public void removeCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Imprime todos os clientes que foram cadastrados. 
	 * @return a representação em string dos clientes cadastrados.
	 */
	public String exibeClientes() {
		List<String> clientes = new ArrayList<>();
		for(Cliente cliente : this.clientes.values()) {
			clientes.add(cliente.toString());
		}
		Collections.sort(clientes);
		return clientes.stream().map(cliente -> cliente.toString()).collect(Collectors.joining(" | "));
	}
	
	public String getNome(String cpf) {
		return this.clientes.get(cpf).getNome();
	}
}