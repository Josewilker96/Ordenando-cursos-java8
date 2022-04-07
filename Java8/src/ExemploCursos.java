import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAlunos() {
		return alunos;
	}
}



public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Pyton", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		 OptionalDouble media = cursos.stream() // imprimindo quantidade de n�meros de alunos de 100 ou mais
				.filter(c -> c.getAlunos() >= 100 )
				.mapToInt(Curso::getAlunos)
				.average();
		
	//	System.out.println(media);
			
//		cursos.stream()
//			.filter(c-> c.getAlunos() >= 100 )
//			.findAny()
//			.ifPresent(c-> System.out.print(c.getNome()));
		
		 cursos.parallelStream()
				.filter(c -> c.getAlunos() >= 100 )
				.collect(Collectors.toMap(
						c -> c.getNome(),
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos "));
		 
		 
	}

}
