package lab03;

/**
 * Representação de um Contato. O Contato pode ter um nome, sobrenome, e um
 * telefone.
 *
 * @author Raiany Rufino - 118110466
 * 
 */
public class Contato {
    
    /**
     * Recebe o nome do contato.
     */
    private String nome;
    
    /**
     * Recebe o sobrenome do contato.
     */
    private String sobrenome;
    
    /**
     * Recebe o telefone do contato.
     */
    private String telefone;
    
    /**
     * Armazena e concatena o nome, sobrenome e telefone do contato.
     */
    private String contato;
    
    /**
     * Constrói o contato a partir do seu nome, sobrenome e telefone.
     *
     * @param nome Recebe o nome do contato a ser construido.
     * @param sobrenome Recebe o sobrenome do contato a ser construido.
     * @param telefone Recebe o telefone do contato a ser construido.
     */
    public Contato(String nome, String sobrenome, String telefone) {
        if (nome == null || sobrenome == null || telefone == null) {
            throw new NullPointerException("Parâmetro Nulo!");
        } else if (nome.trim().equals("") || sobrenome.trim().equals("") || telefone.trim().equals("")) {
            throw new IllegalArgumentException("Parâmetro Vazio!");
          }
        
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    
    /**
     * Gera um inteiro que representa o hashCode do objeto a partir de seu nome.
     *
     * @return o inteiro representando o hashCode do objeto.
     */
    @Override
       public int hashCode() {
           final int prime = 31;
           int result = 1;
           result = prime * result + ((nome == null) ? 0 : nome.hashCode());
           result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
           return result;
       }
    
    /**
     * Metodo equals, que compara o objeto com outro a partir de seu nome.
     *
     * @param obj Objeto a ser comparado.
     * @return um valor booleano que indica se os objetos tem o mesmo nome ou nao.
     */
       @Override
       public boolean equals(Object obj) {
           if (this == obj)
               return true;
           if (obj == null)
               return false;
           if (getClass() != obj.getClass())
               return false;
           Contato other = (Contato) obj;
           if (nome == null) {
               if (other.nome != null)
                   return false;
           } else if (!nome.equals(other.nome))
               return false;
           if (sobrenome == null) {
               if (other.sobrenome != null)
                   return false;
           } else if (!sobrenome.equals(other.sobrenome))
               return false;
           return true;
       }
       
    /**
     * Retorna a representacao em String do contato construido, no seguinte formato:
     * Nome do contato Sobrenome do contato - numero de telefone do contato.
     */
    public String toString() {
       this.contato =  this.nome + " " + this.sobrenome + " - " + this.telefone;
       return this.contato;
    }
    
    /**
     * Metodo get para o nome do contato
     *
     * @return String que representa o nome do contato.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo get para o sobrenome do contato
     *
     * @return String que representa o sobrenome do contato.
     */
    public String getSobrenome() {
        return sobrenome;
    }

    
    
}

