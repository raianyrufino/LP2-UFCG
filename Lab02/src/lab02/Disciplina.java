package lab02;

public class Disciplina {
    
    private String nomeDisciplina;
    private int horas;
    private float nota;
    private float valorNota;
    private int somatoriaHoras;
    private double media;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    
    public void cadastraHoras(int horas) {
        this.somatoriaHoras = 0;
        this.horas = horas;
        
        this.somatoriaHoras += horas;
    }
    
    public void cadastraNota(int nota, double valorNota) {
        
        this.nota = nota;
        this.valorNota = (float)valorNota;
        
        if(this.nota == 1) {
            this.nota1 = valorNota;
        }
        else if(this.nota == 2) {
        	this.nota2 = valorNota;
        }
        else if(this.nota == 3) {
        	this.nota3 = valorNota;
        }
        else {
        	this.nota4 = valorNota;
        }
        
        media = (nota1+nota2+nota3+nota4)/4.0;
    }
    
    public boolean aprovado() {
        if(this.media >= 7.0) {
            return true;
        } else
            return false;
        
    }
    
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.somatoriaHoras + " " + media + " [" + this.nota1 + ", " + this.nota2 + ", " + this.nota3 + ", " + this.nota4 + "]";
    }
}

// PROGRAMACAO 2 4 7.0 [5.0, 6.0, 7.0, 10.0]
