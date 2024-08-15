package br.com.escola.regesc;

import br.com.escola.regesc.orm.Professor;
import br.com.escola.regesc.repository.ProfessorRepository;
import br.com.escola.regesc.service.CrudProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RegescApplication implements CommandLineRunner {
	private CrudProfessorService professorService;

	@Autowired
	private ProfessorRepository professorRepository;

	//obetos injetados automaticamente pelo spring
	public RegescApplication(CrudProfessorService professorService){
		this.professorService = professorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RegescApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while (isTrue){

			System.out.println("Qual entidade você deseja interagir?");
			System.out.println("0 - sair");
			System.out.println("1 - professor");

			int opcao = scanner.nextInt();

			switch (opcao){
				case 1:
					this.professorService.menu(scanner);
					break;
				default: isTrue = false;
					break;
			}


		}


	}
}
