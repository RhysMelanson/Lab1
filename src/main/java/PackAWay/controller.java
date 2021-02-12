package PackAWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class controller {



    public AddressBook address;

    public static void main(String[] args) {
        SpringApplication.run(controller.class, args);

        System.out.println("I am running");

        AddressBook add = new AddressBook();
        add.addBuddy("Jim", "89 Crescent", "892 283 8372");


    }



}
