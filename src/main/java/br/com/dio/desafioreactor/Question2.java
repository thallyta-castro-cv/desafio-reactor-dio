package br.com.dio.desafioreactor;

import reactor.core.publisher.Mono;

import java.util.List;

public class Question2 {

    public Mono<Long> countAdmins(final List<User> users) {
        return Mono.just(users)
                .flatMapIterable(userList -> userList)
                .filter(User::isAdmin)
                .count();
    }

    public static void main(String[] args) {
        Question2 userCounter = new Question2();

        List<User> users = List.of(
                new User(1L, "User 1", "user1@example.com", "password1", false),
                new User(2L, "User 2", "user2@example.com", "password2", true),
                new User(3L, "User 3", "user3@example.com", "password3", false),
                new User(4L, "User 4", "user4@example.com", "password4", true),
                new User(5L, "User 5", "user5@example.com", "password5", true)
        );

        Mono<Long> adminCountMono = userCounter.countAdmins(users);

        adminCountMono.subscribe(
                count -> System.out.println("Quantos usuários são admin? " + count),
                error -> System.err.println("Erro: " + error),
                () -> System.out.println("Processamento completo!")
        );
    }

}
