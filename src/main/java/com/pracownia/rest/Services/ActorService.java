package com.pracownia.rest.Services;

import com.pracownia.rest.Models.Actor;
import com.pracownia.rest.Repo.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorsRepository actorsRepository;

//    should work fine
//    public ActorService(ActorsRepository actorsRepository) {
//        this.actorsRepository = actorsRepository;
//    }


    public List<Actor> getActors(){
        return actorsRepository.findAll();
    }


    public Actor addActor(Actor actor){
        Optional<Actor> actorFromDb = actorsRepository.findById(actor.getId());
        if (actorFromDb.isPresent()){
            return null;
        }
        else{
            return actorsRepository.save(actor);
        }
    }

    public Optional<Actor> getSingleActor(long id){
        return actorsRepository.findById(id);
//        Optional<Actor> actorFromDb = actorsRepository.findById(id);
//            return actorFromDb;
        }

    public Actor editActor(long id, Actor actor){
        Optional<Actor> actorFromDb = actorsRepository.findById(id);
        if (actorFromDb.isEmpty()){
            return null;
        }
        else {
            Actor actorEdited = actorsRepository.findById(actor.getId()).orElseThrow();
            actorEdited.setFirstName(actor.getFirstName());
            actorEdited.setLastName(actor.getLastName());
            actorsRepository.save(actorEdited);
            return actorEdited;
        }
    }

    public void deleteActor(long id){
        Actor actorFromDb = actorsRepository.findById(id).orElseThrow();
        actorsRepository.deleteById(id);
    }

    public List<String> getActorsMovies(long id){
        return actorsRepository.getActorsMovies(id);
    }
}