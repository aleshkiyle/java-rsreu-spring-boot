package com.rodin.tacoCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
    Аннотация @SpringBootApplication ясно указывает, что это приложение Spring Boot.
    @SpringBootApplication - это составная аннотация, объединяющая три другие аннотации:

    * @SpringBootConfiguration - определяет этот класс как класс конфигурации.
    В данный момент в этом классе не определяется никаких конфигурационных параметров, но если
    понадобится, в него можно добавить настройки Spring Framework. Это аннотация, по сути, является
    специализированной формой аннотации @Configuration

    * @EnableAutoConfiguration - включает автоконфигурацию Spring Boot.
    Эта аннотация сообщает Spring Boot о необходимости автоматически настраивать любые
    компоненты, которые вам могут понадобиться

    * @ComponentScan - включает сканирование компонентов. Механизм сканирования позволяет
    объявлять другие классы с аннотациями, такими как @Component, @Controller и @Service,
    чтобы фреймворк Spring автоматически обнаруживал и регестрировал их как компоненты в
    контекстке приложения Spring.
 */
@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }
}
