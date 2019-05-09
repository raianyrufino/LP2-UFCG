package lab05_RaianyRufino;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representação de um Controller de Fornecedores. Um Controller possui o mapeamento do objeto Fornecedor pelo seu nome. 
 * Ele possibilita adicionar, exibir, editar e remover os fornecedores. 
 * Além disso, também permite adicionar, exibir, editar e remover produtos de um fornecedor.
 * 
 * @author Raiany Rufino - 118110466
 *
 */
public class ControllerFornecedor {
	
	private HashMap<String, Fornecedor> fornecedores;
	private ControllerCliente sistemaCliente;
	
	/**
	 * Constrói um controller e inicializa seu mapa de Fornecedores.
	 */
	public ControllerFornecedor(){
		this.fornecedores = new HashMap<>();
		this.sistemaCliente = new ControllerCliente();
	}
	
	/**
	 * Método que invoca o construtor de um fornecedor, e o adiciona no mapa, com seu
	 * nome como chave, caso ele não tenha sido adicionado ainda.
	 * @param nome O nome do fornecedor.
	 * @param email O e-mail do fornecedor.
	 * @param telefone O némero de telefone do fornecedor.
	 * @return O nome do fornecedor.
	 */
    public String adicionaFornecedor(String nome, String email, String telefone){
		
		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		if(this.fornecedores.containsKey(nome)){
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		} else {
			this.fornecedores.put(nome, fornecedor);
			return nome;
		  }
	}
    
    /**
	 * Método que procura um fornecedor no mapa pelo seu nome, e retorna sua representação em String.
	 * @param nome O nome do fornecedor.
	 * @return a representação em String do fornecedor.
	 */
    public String exibeFornecedor(String nome){
		if(this.fornecedores.containsKey(nome)){
			return this.fornecedores.get(nome).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		  }
	}
    
    /**
	 * Método que procura um fornecedor no mapa pelo seu nome, e edita o atributo passado.
	 * @param nome O nome do fornecedor.
	 * @param atributo O atributo que será alterado, podendo ser o nome, localizacao ou telefone do fornecedor.
	 * @param novoValor O novo valor que substituirá o valor anterior do atributo dado.
	 */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
		if (this.fornecedores.containsKey(nome)) {
			this.fornecedores.get(nome).editaAtributo(atributo, novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}
    
    /**
	 * Método que procura um fornecedor no mapa pelo seu nome, e o remove.
	 * @param nome O nome do fornecedor.
	 */
    public void removeFornecedor(String nome){
		if(this.fornecedores.containsKey(nome)){
			this.fornecedores.remove(nome);
		} else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		  }
	}
    
    /**
	 * Imprime todos os fornecedores que foram cadastrados. 
	 * @return a representação em string dos fornecedores cadastrados.
	 */
    public String exibeFornecedores() {
		List<String> fornecedores = new ArrayList<>();
		for(Fornecedor fornecedor: this.fornecedores.values()) {
			fornecedores.add(fornecedor.toString());
		}
		Collections.sort(fornecedores);
		return fornecedores.stream().map(fornecedor -> fornecedor.toString()).collect(Collectors.joining(" | "));
	}
    
    /**
     * Método que adiciona um produto a um fornecedor a partir de seu nome, descricao e preço.
     * @param fornecedor O nome do fornecedor.
     * @param nome O nome do produto.
     * @param descricao A descricao do produto.
     * @param preco O preco do produtos.
     */
    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
    	if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}if (descricao.trim().equals("") ) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		else {
			if (this.fornecedores.containsKey(fornecedor)) {
				Produto produto = new Produto(nome, descricao, preco);
				this.fornecedores.get(fornecedor).adicionaProduto(produto);
			} else {
				throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
			}
		}
	}
    
    /**
     * Método que exibe um produto seguindo o seguinte formato:
     * "nome do produto - descricao do produto - preço do produto".
     * @param nome O nome do produto.
     * @param descricao A descricao do produto.
     * @param fornecedor O nome do fornecedor.
     * @return A representação textual do produto.
     */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor.trim().equals("") ) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if(nome.trim().equals("") ) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}else if(descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}else {
			if(this.fornecedores.containsKey(fornecedor)) {

				return fornecedores.get(fornecedor).toStringProduto(nome, descricao);
			} else {
				throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
			}
		 }
	}
	
	/**
	 * Método que procura um fornecedor no seu mapa pelo nome dele, e em seguida o produto para alterá-lo.
	 * @param nome O nome do produto.
	 * @param descricao A descricao do produto.
	 * @param fornecedor O nome do fornecedor.
	 * @param novoPreco O preço do produto.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		 if(descricao.trim().equals("") ) {
				throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		 }else if(fornecedor.trim().equals("")){
				throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		 }else if(nome.trim().equals("")) {
				throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		 }else if(novoPreco < 0) {
				throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		  } else {
			  if(this.fornecedores.containsKey(fornecedor)) {
				Produto produto = new Produto(nome, descricao, 0.0);
				this.fornecedores.get(fornecedor).editaProduto(produto, novoPreco);
			  } else {
				  throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
				}
			}
	}
	
	/**
	 * Método que procura um fornecedor no seu mapa pelo nome dele, e em seguida o produto para removê-lo.
	 * @param nome O nome do produto.
	 * @param descricao A descricao do produto.
	 * @param fornecedor O nome do fornecedor.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		if( nome.trim().equals("") ) {
			throw new NullPointerException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}else if( descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}else if(fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else {
			if(this.fornecedores.containsKey(fornecedor)) {
				Produto produto = new Produto(nome, descricao, 0.0);
				this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
			} else {
				throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
			}
		}
	}
	
	/**
	 * Método que procura um fornecedor no seu mapa pelo nome dele, e em seguida lista todos os seus produtos cadastrados.
	 * @param fornecedor O nome do fornecedor.
	 * @return A representação em String de todos os seus produtos.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		if(fornecedor == null) {
			throw new NullPointerException("\nNOME DO FORNECEDOR Nï¿½O PODE SER NULO!\n");
		}else if(fornecedor.trim().equals("")){	
			throw new IllegalArgumentException("\nNOME DO FORNECEDOR Nï¿½O PODE SER VAZIO!\n");		
		} else { 
			if(this.fornecedores.containsKey(fornecedor)) {
				return this.fornecedores.get(fornecedor).listaProdutos();
			} else {
				throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
			}
		  }
	}

	/**
	 * Método que imprime todos os produtos cadastrados e seus respectivos fornecedores.
	 * @return A representação em String de todos os seus produtos.
	 */
	public String exibeProdutos() {
		if(this.fornecedores.size() == 0) {
			return "Nï¿½o existe nenhum fornecedor cadastrado";
		} else {
			ArrayList<String> arraySaida = new ArrayList<>();
			for(String fornecedor: this.fornecedores.keySet()) {
				arraySaida.add(fornecedor);
			}
			Collections.sort(arraySaida);
			String lista = "";
			for(int i = 0; i < arraySaida.size(); i++) {
				if(i != arraySaida.size()-1) {
					lista += this.fornecedores.get(arraySaida.get(i)).listaProdutos() + " | ";
				} else {
					lista += this.fornecedores.get(arraySaida.get(i)).listaProdutos();
				}
			}
			return lista;
		}
	} 
	
	/**
	  * Método que adiciona um combo a um fornecedor a partir de seu nome, descricao, preço e fator. 
	  * @param fornecedor O nome do fornecedor.
	  * @param nome O nome do combo.
	  * @param descricao A descrição do combo.
	  * @param fator O fator para desconto do preço do combo.
	  * @param produtosCombo A lista de produtos que o combo irá possuir.
	  */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtosCombo) {
		if (fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}else if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		} else if(descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		} else if(fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		} else if(produtosCombo.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		} else if (this.fornecedores.containsKey(fornecedor)) {
			String[] representacao = produtosCombo.split(", ");
			this.fornecedores.get(fornecedor).adicionaCombo(nome, descricao, representacao, fator);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
	}
	
	/**
	  * Edita o fator de um combo a partir do nome, descricao e fornecedor do combo, além do novo fator passado.
	  * @param nome O nome do combo.
	  * @param descricao A descrição do combo.
	  * @param fornecedor O nome do fornecedor.
	  * @param novoFator O novo fator que substituirá o antigo.
	  * @return
	  */
	public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		if(fornecedor.trim().equals("")){
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		} else if(nome.trim().equals("")){
			throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		} else if(descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		} else if(novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		} else if(this.fornecedores.containsKey(fornecedor)) {
			this.fornecedores.get(fornecedor).editaCombo(nome, descricao, novoFator);
		} else {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}
	}
	
	 /**
	  * Método que adiciona a compra a uma conta.
	  * @param cpf O número de Cpf do cliente.
	  * @param fornecedor O nome do fornecedor.
	  * @param data A data de quando foi adicionado.
	  * @param nome O nome do produto.
	  * @param descricao A descricao do produto.
	  */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {
		if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
    	} else if(data.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		} else if(data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		} else if(fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		} else if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		} else if(descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		} else if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		} else {
			this.fornecedores.get(fornecedor).adicionaCompra(cpf, nome, descricao, data);
		} 
	}

	/**
	  * Método que pega o débito da conta.
	  * @param cpf O número de Cpf do cliente.
	  * @param fornecedor O nome do fornecedor.
	  * @return O débito da conta.
	  */
	public String getDebito(String cpf, String fornecedor) {
		if(fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		} else if(this.fornecedores.containsKey(fornecedor)) {
			return this.fornecedores.get(fornecedor).getDebito(cpf);
		} else {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
	}
	
	/**
	 * Método que exibe todas as contas.
	 * @param cpf O número de Cpf do cliente.
	 * @return a representação textual de todas as contas do cliente.
	 */
	public String exibeContas(String cpf, String fornecedor) {
		if(fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		} else if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		} else if(this.fornecedores.get(fornecedor).exibeContas(cpf).equals("")){
			return this.fornecedores.get(fornecedor).exibeContas(cpf);
		} else {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}
	
	/**
	  * Método que exibe a conta de um determinado cliente.
	  * @param cpf O número de Cpf do cliente.
	  * @param fornecedor
	  * @return a representação textual da conta de um cliente.
	  */
	public String exibeContasClientes(String cpf) {
		List<String> totalDeContas = new ArrayList<>();
		for(String chave : this.fornecedores.keySet()) {
			totalDeContas.add(this.fornecedores.get(chave).exibeContas(cpf));
		}
		Collections.sort(totalDeContas);
		String contas = "";
		for(String conta : totalDeContas) {
			if (!conta.equals("")) {
			contas += " | " + conta;
			}
		}
		if(contas.equals("")) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		
		return contas;
	}
	 


}