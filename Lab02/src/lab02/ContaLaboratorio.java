package lab02;

public class ContaLaboratorio {
    
    private String nomeLaboratorio;
    private int limiteDisponivel;
    private int limiteInicial;
    
    
    public ContaLaboratorio(String nomeLaboratorio) {
        this.limiteInicial = 2000;
        this.limiteDisponivel = 2000;
        this.nomeLaboratorio = nomeLaboratorio;
    }
    
    public ContaLaboratorio (String nomeLaboratorio, int limite) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.limiteDisponivel = limite;
        this.limiteInicial = limite;
    }
    
    public void consomeEspaco(int mbytes) {
        this.limiteDisponivel -= mbytes;
        
    }
    
    public void liberaEspaco(int mbytes) {
        if ((this.limiteInicial - this.limiteDisponivel) <= 0) {
            this.limiteDisponivel = 0;
        }else {
            this.limiteDisponivel += mbytes;
        }
        
    }
    
    public boolean atingiuCota() {
        if (this.limiteDisponivel <= 0) {
            return true;
        } else {
            return false;
        }    
    }
    
    @Override
    public String toString() {
        return this.nomeLaboratorio + " " + (this.limiteInicial - this.limiteDisponivel) + "/" + this.limiteInicial + " ";
    }
}
