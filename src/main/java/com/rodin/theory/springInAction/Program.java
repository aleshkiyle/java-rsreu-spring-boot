package com.rodin.theory.springInAction;

import com.rodin.theory.springInAction.configuration.ConfigurationClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigurationClass.class);
        for (String str: context.getBeanDefinitionNames()) {
            System.out.println(str);
        }
    }
}
