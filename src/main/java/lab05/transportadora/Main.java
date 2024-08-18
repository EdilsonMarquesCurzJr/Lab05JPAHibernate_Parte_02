package lab05.transportadora;

import jakarta.persistence.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab_jpa");

        System.out.println(factory.getProperties() );

        factory.close();


    }
}