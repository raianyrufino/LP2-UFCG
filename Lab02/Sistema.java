package lab4_RaianyRufino;
import java.util.HashMap;

public class Sistema {
	
	private HashMap<String, Aluno> mapaMatriculaAlunos;
	
    public Sistema() {
    	this.mapaMatriculaAlunos = new HashMap<>();
    }
	
	public String cadastraAluno(String matricula, String nome, String curso) {
		Aluno aluno = new Aluno(matricula, nome, curso);
		boolean existe = this.mapaMatriculaAlunos.containsKey(matricula);
		if(existe == true) {
			return "Matrícula já cadastrada.";
		} else {
			this.mapaMatriculaAlunos.put(matricula, aluno);
			return "Cadastro realizado.";
		}
	}
	
	public boolean existeAluno(String matricula) {
		return this.mapaMatriculaAlunos.containsKey(matricula);
	}

}
