package lab02;

public class ContaCantina {
    
    private String nomeDaCantina;
    private int qtdItens;
    private int valorGasto;
    private int valorCentavos;
    private int valorPago;
    
    public ContaCantina(String nomeDaCantina) {
        this.nomeDaCantina = nomeDaCantina;
    }
    
    public void cadastraLanche(int qtdItens, int valorCentavos) {
        this.qtdItens += qtdItens;
        this.valorCentavos = valorCentavos;
        this.valorGasto += this.valorCentavos;
    }
    
    public void pagaConta(int valorCentavos) {
    	this.valorPago = this.valorGasto;
        if(this.valorGasto >= valorCentavos) {
            this.valorPago -= valorCentavos;
        }
    }
    
    public int getFaltaPagar() {
        return (int)this.valorPago;
    }
    
    public String toString() {
        return this.nomeDaCantina + " " + this.qtdItens + " " + this.valorGasto;
    }
    
   
    
}
