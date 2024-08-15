package br.com.escola.regesc.service;

import br.com.escola.regesc.orm.Professor;
import br.com.escola.regesc.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudProfessorService {

    private ProfessorRepository professorRepository;

    public CrudProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public void menu(Scanner scanner){

        boolean isTrue = true;

        while (isTrue) {

            System.out.println("\nQual ação deseja executar?");
            System.out.println("0 - voltar ao menu anterior");
            System.out.println("1 - cadastrar novo professor");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrarProfessor(scanner);
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();
    }

    private void cadastrarProfessor(Scanner scanner){

        System.out.print("Digite o nome do Professor: ");
        String nome = scanner.next();

        System.out.print("Digite o prontuário do Professor: ");
        String prontuario = scanner.next();

        Professor professor = new Professor(nome, prontuario);

        this.professorRepository.save(professor);
        System.out.println("Professor salvo com sucesso!\n");

    }

}
