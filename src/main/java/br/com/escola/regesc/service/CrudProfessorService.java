package br.com.escola.regesc.service;

import br.com.escola.regesc.orm.Professor;
import br.com.escola.regesc.repository.ProfessorRepository;
import ch.qos.logback.core.joran.conditional.ElseAction;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
            System.out.println("2 - atualizar um professor");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrarProfessor(scanner);
                    break;
                case 2:
                    this.atualizarProfessor(scanner);
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

    private void atualizarProfessor(Scanner scanner){

        System.out.print("Digite o id do Professor a ser atualizado: ");
        Long id = scanner.nextLong();

        Optional<Professor> optional = this.professorRepository.findById(id);

        if (optional.isPresent()){

            Professor professor = optional.get();

            System.out.print("Digite o nome do Professor: ");
            String nome = scanner.next();

            System.out.print("Digite o prontuário do Professor: ");
            String prontuario = scanner.next();

            professor.setNome(nome);
            professor.setProntuario(prontuario);

            professorRepository.save(professor);

            System.out.println("Professor atualizado com sucesso!\n");

        }
        else{
            System.out.print("O id informado: " + id + " é invalido\n");
        }


    }

}
