package br.com.dio.desafioreactor;

import reactor.core.publisher.Flux;

import java.util.List;

public class Question1 {

    public Flux<Long> inc(final List<Long> numbers) {
        return Flux.fromIterable(numbers)
                .map(number -> number + 1L);
    }

    public static void main(String[] args) {
        Question1 incrementer = new Question1();

        List<Long> numbers = List.of(1L, 2L, 3L, 4L, 5L);
        Flux<Long> resultFlux = incrementer.inc(numbers);

        resultFlux.subscribe(
                value -> System.out.println("Valor incrementado: " + value),
                error -> System.err.println("Erro: " + error),
                () -> System.out.println("Processamento completo!")
        );
    }

}
