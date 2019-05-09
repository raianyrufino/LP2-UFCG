package lab05_RaianyRufino;

public class Sistema {
	
	private ControllerFornecedor sistemaFornecedor;
	private ControllerCliente sistemaCliente;
	
	public Sistema() {
		this.sistemaFornecedor = new ControllerFornecedor();
		this.sistemaCliente = new ControllerCliente();
	}

    /**
	* Retorna uma String com a informação a respeito do cadastro de um cliente. 
	* O cadastro pode não ser realizado, caso seus parâmetros sejam inválidos,
	* ou o produto já esteja cadastrado.
	* 
	* @param cpf Cpf do cliente.
	* @param nome Nome do cliente.
	* @param email Email do cliente.
	* @param localizacao Localização do cliente.
	* @return String com a informação a respeito do cadastro do cliente.
	*/	
    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
    	return this.sistemaCliente.adicionaCliente(cpf, nome, email, localizacao);
    }
	
    /**
	* Retorna uma String com a informação a respeito da consulta de um cliente,
	* no formato: "nome - localização - email".
	* A consulta pode não ser realizada, caso o cliente não esteja cadastrado, ou 
	* o cpf informado seja inválido.
	* 
	* @param cpf Cpf do cliente.
	* @return String com a informação a respeito do cliente.
	*/
    public String exibeCliente(String cpf) {
    	return this.sistemaCliente.exibeCliente(cpf);
    }
    
    /**
	* Retorna uma String com a informação a respeito da consulta de todos os
	* clientes no formato: "nome - localização - email | nome - localização - email".
	* 
	* @return String com as informações a respeito de todos os clientes.
	*/
    public String exibeClientes() {
    	return this.sistemaCliente.exibeClientes();
    }
	
    /**
	* Retorna a informação a respeito da alteração de um cliente.
	* A alteração não é feita caso os parametros sejam inválidos.
	* 
	* @param cpf Cpf do cliente
	* @param atributo O atributo a ser editado.
	* @param novoValor O novo valor do atributo a ser editado.
	* @return A informação a respeito da edição do cliente.
	*/
    public void editaCliente(String cpf, String atributo, String novoValor) {
    	this.sistemaCliente.editaCliente(cpf, atributo, novoValor);
    }
    
    /**
	* Retorna a informação a respeito da remoção do cliente.
	* A remoção não é feita caso o cliente não esteja cadastrado.
	* 
	* @param cpf Cpf do cliente.
	* @return A informação a respeito da remoção do cliente.
	*/	
    public void removeCliente(String cpf) {
    	this.sistemaCliente.removeCliente(cpf);
    }
    
    /**
	* Retorna uma String com a informação a respeito do cadastro de um fornecedor. 
	* O cadastro pode não ser realizado, caso seus parâmetros sejam inválidos,
	* ou o fornecedor já esteja cadastrado.
	* 
	* @param nome Nome do fornecedor.
	* @param email Email do fornecedor.
	* @param telefone Telefone do fornecedor.
	* @return String com a informação a respeito do cadastro do fornecedor.
	*/		
    public String adicionaFornecedor(String nome, String email, String telefone) {
    	return this.sistemaFornecedor.adicionaFornecedor(nome, email, telefone);
    }
    
    /**
	* Retorna uma String com a informação a respeito da consulta de um fornecedor,
	* no formato: "nome - email - telefone".
	* A consulta pode não ser realizada, caso o fornecedor não esteja cadastrado, ou 
	* o nome informado seja inválido.
	* 
	* @param nome Nome do cliente.
	* @return String com a informação a respeito do fornecedor.
	*/
    public String exibeFornecedor(String nome) {
    	return this.sistemaFornecedor.exibeFornecedor(nome);
    }
    
    /**
	* Retorna uma String com a informação a respeito da consulta de todos os
	* fornecedores no formato: "nome - email - telefone | nome - email - telefone".
	* 
	* @return String com as informações a respeito de todos os fornecedores.
	*/
    public String exibeFornecedores() {
    	return this.sistemaFornecedor.exibeFornecedores();
    }
    
    /**
	* Retorna a informação a respeito da alteração de um cliente.
	* A alteração não é feita caso os parametros sejam inválidos.
	* 
	* @param nome O nome do fornecedor
	* @param atributo O atributo a ser editado.
	* @param novoValor O novo valor do atributo a ser editado.
	* @return A informação a respeito da edição do fornecedor.
	*/
    public void editaFornecedor(String nome, String atributo, String novoValor) {
    	this.sistemaFornecedor.editaFornecedor(nome, atributo, novoValor);
    }
    
    /**
	* Retorna a informação a respeito da remoção do fornecedor.
	* A remoção não é feita caso o fornecedor não esteja cadastrado 
	* ou seu nome seja inválido.
	* 
	* @param nome Nome do fornecedor.
	* @return A informação a respeito da remoção do fornecedor.
	*/	
    public void removeFornecedor(String nome) {
    	this.sistemaFornecedor.removeFornecedor(nome);
    }
    
    /**
	* Retorna uma String com a informação a respeito do cadastro de um produto. 
	* O cadastro pode não ser realizado, caso os parâmetros sejam inválidos
	* ou o fornecedor não esteja cadastrado.
	* 
	* @param fornecedor Nome do fornecedor.
	* @param nome Nome do produto.
	* @param descricao Descricao do produto
	* @param preco Preço do produto.
	* @return String com a informação a respeito do cadastro do produto.
	*/
    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
    	this.sistemaFornecedor.adicionaProduto(fornecedor, nome, descricao, preco);
    }
    
    /**
   	* Retorna uma String com a informação a respeito do cadastro de um combo,
   	* que é formado por mais de um produto. 
   	* O cadastro pode não ser realizado, caso os parâmetros sejam inválidos
   	* ou o fornecedor não esteja cadastrado.
   	* 
   	* @param fornecedor Nome do fornecedor.
   	* @param nomeDoCombo Nome do combo.
   	* @param descricao Descricao do combo.
   	* @param fator O fator de desconto do combo.
   	* @param produtosDoCombo Os produtos que farão parte do combo.
   	* @return String com a informação a respeito do cadastro do combo.
   	*/
    public void adicionaCombo(String fornecedor, String nomeDoCombo, String descricao, double fator, String produtosDoCombo) {
    	this.sistemaFornecedor.adicionaCombo(fornecedor, nomeDoCombo, descricao, fator, produtosDoCombo);
    }
    
    /**
	* Retorna uma String com a informação a respeito da consulta de um produto,
	* no formato: "nomeDoProduto - descricao - preco".
	* A consulta pode não ser realizada, caso os parâmetros sejam inválidos
	* ou o fornecedor não esteja cadastrado.
	* 
	* @param nome Nome do produto.
	* @param descricao Descricao do produto.
	* @param fornecedor Nome do fornecedor.
	* @return String com a informação a respeito do produto.
	*/	
    public String exibeProduto(String nome, String descricao, String fornecedor) {
    	return this.sistemaFornecedor.exibeProduto(nome, descricao, fornecedor);
    }
    
    /**
	* Retorna uma String com a informação a respeito da consulta de todos os
	* produtos de um fornecedor no formato: "nomeDoFornecedor - nomeDoProduto - 
	* descricao - preco | nomeDoFornecedor - nomeDoProduto - descricao - preco |".
	* A consulta pode não ser realizada, caso os parâmetros sejam inválidos
	* ou o fornecedor não esteja cadastrado.
	* 
	* @return String com a informação a respeito dos produtos.
	*/	
    public String exibeProdutosFornecedor(String fornecedor) {
    	return this.sistemaFornecedor.exibeProdutosFornecedor(fornecedor);
    }
    
    /**
	* Retorna uma String com a informação a respeito da consulta de todos os
	* produtos cadastrados no formato: "nomeDoFornecedor - nomeDoProduto - 
	* descricao - preco | nomeDoFornecedor - nomeDoProduto - descricao - preco |".
	* A consulta pode não ser realizada, caso não hajam fornecedores cadastrados.
	* 
	* @return String com a informação a respeito dos produtos.
	*/
    public String exibeProdutos() {
    	return this.sistemaFornecedor.exibeProdutos();
    }
    
    /**
	* Retorna a informação a respeito da alteração do 
	* atributo que representa o preço do produto. 
	* A alteração pode não ser realizada, caso os parâmetros sejam inválidos
	* ou o fornecedor não esteja cadastrado.
	* 
	* @param nome O nome do produto.
	* @param descricao A descrição do produto.
	* @param fornecedor O nome do fornecedor.
	* @param novoPreco O novo preço do produto.
	* @return A informação a respeito da edição do produto.
	*/	
    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
    	this.sistemaFornecedor.editaProduto(nome, descricao, fornecedor, novoPreco);
    }
    
    /**
	* Retorna a informação a respeito da alteração do 
	* atributo que representa o fator de desconto do combo, e
	* consequentemente, seu preço. A alteração pode não ser 
	* realizada, caso os parâmetros sejam inválidos ou o 
	* fornecedor não esteja cadastrado.
	* 
	* @param nome O nome do combo.
	* @param descricao A descrição do combo.
	* @param fornecedor O nome do fornecedor.
	* @param novoFator O novo fator de desconto do combo.
	* @return A informação a respeito da edição do combo.
	*/	
    public void editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
    	this.sistemaFornecedor.editaCombo(nome, descricao, fornecedor, novoFator);
    }
    
    /**
	* Retorna a informação a respeito da remoção do produto.
	* A remoção pode não ser realizada, caso os parâmetros sejam inválidos
	* ou o fornecedor não esteja cadastrado.
	* 
	* @param nome O nome do produto.
	* @param descricao A descrição do produto.
	* @param fornecedor O nome do fornecedor.
	* @return A informação a respeito da remoção do produto
	*/	
    public void removeProduto(String nome, String descricao, String fornecedor) {
    	this.sistemaFornecedor.removeProduto(nome, descricao, fornecedor);
    }
    
    public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
    	if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		} else if(this.sistemaCliente.existeCliente(cpf)) {
    		this.sistemaFornecedor.adicionaCompra(cpf, fornecedor, data, nome_prod, desc_prod);
    	} else {
    		throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
    	}
    }
    
    /**
     * Acessa o débito de um cliente a partir de seu cpf e fornecedor.
     * @param cpf O número de Cpf do cliente.
     * @param fornecedor O nome do fornecedor.
     * @return o débito da conta.
     */
    public String getDebito(String cpf, String fornecedor) {
    	if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido."); 
    	} else if(!this.sistemaCliente.existeCliente(cpf)) {
    		throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
    	} else {
    		return this.sistemaFornecedor.getDebito(cpf, fornecedor);
    	}
    }
    
    /**
     * Exibe todas as contas.
     * @param cpf O número de Cpf do cliente.
     * @param fornecedor O nome do fornecedor.
     * @return A representação textual das contas.
     */
    public String exibeContas(String cpf, String fornecedor) {
    	if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		} else if(this.sistemaCliente.existeCliente(cpf)) {
    		return "Cliente: " + this.sistemaCliente.getNome(cpf) + " | " + this.sistemaFornecedor.exibeContas(cpf, fornecedor);
    	} else {
    		throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
    	}
    }
    
    /**
     * Exibe todas as contas de um cliente.
     * @param cpf O número de Cpf do cliente.
     * @param fornecedor O nome do fornecedor.
     * @return A representação textual do cliente e de suas contas.
     */
    public String exibeContasClientes(String cpf) {
    	if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		} else if(!this.sistemaCliente.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		} else {
			return "Cliente: " + this.sistemaCliente.getNome(cpf) + this.sistemaFornecedor.exibeContasClientes(cpf);
		}
    }
	
	
}
