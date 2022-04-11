package com.murilonerdx.java8;

import java.util.*;
import java.util.function.Consumer;
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

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", alunos=" + alunos +
                '}';
    }

    public static class ExemploCursos{
        public static void main(String[] args){
            List<Curso> cursos = new ArrayList<Curso>();
            cursos.add(new Curso("Python", 45));
            cursos.add(new Curso("JavaScript", 150));
            cursos.add(new Curso("Java 8", 113));
            cursos.add(new Curso("C", 55));

            cursos.sort(Comparator.comparingInt(Curso::getAlunos));

            cursos.forEach(System.out::print);
            cursos.forEach(Curso::getNome);

            cursos.stream()
                    .filter(c -> c.getAlunos() >= 100)
                    .map(Curso::getAlunos)
                    .forEach(System.out::println);

            int sum = cursos.stream()
                    .filter(c -> c.getAlunos() >= 100)
                    .mapToInt(Curso::getAlunos)
                    .sum();

            System.out.println(sum);

            Optional<Curso> optionalCurso = cursos.stream()
                    .filter(c -> c.getAlunos() >= 100)
                    .findAny();

            Curso curso = optionalCurso.get();

            cursos.stream()
                    .filter(c -> c.getAlunos() >= 100)
                    .collect(Collectors.toList());

            Map<String, Integer> collect = cursos.stream()
                    .filter(c -> c.getAlunos() >= 100)
                    .collect(Collectors.toMap(
                            Curso::getNome,
                            Curso::getAlunos
                    ));

            System.out.println(collect);

            cursos.stream()
                    .filter(c -> c.getAlunos() >= 100)
                    .collect(Collectors.toMap(
                            Curso::getNome,
                            Curso::getAlunos
                    )).forEach((s1, s2) -> System.out.printf("O curso %s tem %d alunos\n", s1, s2));

        }
    }
}


