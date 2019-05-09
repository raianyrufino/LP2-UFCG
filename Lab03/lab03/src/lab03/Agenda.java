package lab03;
import java.util.Arrays;

/**
 * Representacao de uma Agenda. A agenda pode conter ate 100 objetos do tipo Contato, podendo operar sobre eles.
 *
 * @author Raiany Rufino - 118110466
 * 
 */
public class Agenda {
    
    /**
     * Armazena os contatos cadastrados pelo usuario em uma lista com capacidade para 100 contatos.
     */
    private Contato[] listaContatos = new Contato[100];
    
    
    /**
     * Gera um inteiro que representa o hashCode do objeto a partir de seu Array de contatos.
     *
     * @return o inteiro representando o hashCode do objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(listaContatos);
        return result;
    }


    /**
     * Metodo equals, que compara o objeto com outro a partir de seu Array de contatos.
     *
     * @param obj Objeto a ser comparado.
     * @return um valor booleano que indica se os objetos tem o mesmo Array de contatos.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agenda other = (Agenda) obj;
        if (!Arrays.equals(listaContatos, other.listaContatos))
            return false;
        return true;
    }
 
    /**
     * Cadastra o contato a partir de seu nome, sobrenome, telefone e posicao.
     *
     * @param nome O nome do contato.
     * @param sobrenome O sobrenome do contato.
     * @param telefone O numero de telefone do contato.
     * @param posicao A posicao que sera cadastrado o contato.
     * @return uma String que informa se o cadastro foi concluido ou nao.
     */
    public String cadastraContato(String nome, String sobrenome, String telefone, int posicao) {
        if(posicao < 1 || posicao > 100) {
            return ("POSIÇÃO INVÁLIDA!");
        }    
        else {
        this.listaContatos[posicao-1] = new Contato(nome, sobrenome, telefone);
        return "Cadastro realizado com sucesso!";
        }
    }
    
    /**
     * Verifica se algum contato existe em determinada posicao.
     *
     * @param posicao A posicao do contato a ser verificado.
     * @return um boolean que retorna True para existencia do contato ou False caso nao exista.
     */
    public boolean existeContato(int posicao) {
        if(this.listaContatos[posicao-1] != null) {
            return true;
        }
        return false;
    }
    
    /**
     * Busca um contato pela sua posicao, e retorna sua representacao em String.
     *
     * @param posicao A posicao do contato a ser pesquisado.
     * @return a representacao em String de um contato.
     */
    public String buscaContato(int posicao) {
        if(posicao > 100 || posicao < 1) {
            throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
        }
        if(listaContatos[posicao-1] == null) {
            throw new NullPointerException("POSIÇÃO NULA!");
        }
        return listaContatos[posicao-1].toString();
    }
    
    /**
     * Lista todos os contatos existentes na agenda, no seguinte formato:
     * Posicao - Nome Sobrenome.
     *
     * @return uma String com todos os contatos existentes.
     */
    public String listaContatos() {
        String contatosExistentes = "";
        for(int i = 0; i < 100; i++) {
            if(existeContato(i+1) == true) {
                 contatosExistentes += (i+1) + " - " + listaContatos[i].getNome() + " " + listaContatos[i].getSobrenome() + "\n";
            }
        }
        return contatosExistentes;
    }
 }
