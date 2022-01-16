//package com.pracownia.rest.controllers;
//
//import com.mysql.cj.Session;
//import com.pracownia.rest.Controller.ActorController;
//import com.pracownia.rest.Models.Actor;
//import com.pracownia.rest.Repo.ActorsRepository;
//import com.pracownia.rest.Services.ActorService;
//import org.hibernate.SessionFactory;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.util.Assert;
//
//import javax.sql.rowset.serial.SerialStruct;
//import java.util.List;
//
////@DataJpaTest
//@SpringBootTest
////@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
//@ExtendWith(SpringExtension.class)
//public class ActorControllerTest {
//
//
//
//
//    @Autowired
//    private ActorsRepository actorsRepository;
//
////    Mock ar = Mock(ActorsRepository);
//
//    @Test
//    void saveActorToRepo() {
//        Actor actor = new Actor();
//        actor.setFirstName("jan");
//        actor.setLastName("kowalski");
//        actorsRepository.save(actor);
//        Actor actorFroMDb = actorsRepository.getById(1l);
//
////        Assert.
////        System.out.println(actorFroMDb.toString());
//    }
//    @Test
//    void getAllActorsFromRepository() {
//        actorsRepository.findAll();
//    }
//
//
//    @Test
//    void getFirstActorFromRepository() {
////        actorsRepository.getB
//    }
//
//
//
//    void sadasdsad() {}
//}
