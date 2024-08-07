package br.com.escola.regesc;

import br.com.escola.regesc.orm.Professor;
import br.com.escola.regesc.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegescApplication implements CommandLineRunner {

	@Autowired
	private ProfessorRepository professorRepository;

	public RegescApplication(ProfessorRepository professorRepository){
		this.professorRepository = professorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RegescApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Professor professor = new Professor("Jack", "Balduei");
		System.out.println("professor antes" + professor);
		this.professorRepository.save(professor);
		System.out.println("professor depois" + professor);

	}
}
