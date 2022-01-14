package com.pracownia.rest.Services;

import com.pracownia.rest.Models.Actor;
import com.pracownia.rest.Repo.ActorsRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorsRepository actorsRepository;
    private static final int PAGE_SIZE = 2;

//    should work fine
    public ActorService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }


    public List<Actor> getActors(){
//        Pageable pageable = PageRequest.of(page,PAGE_SIZE);
//        return actorsRepository.findAllActors(pageable);
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


//    public Actor editActor(long id, Actor actor){
//        Optional<Actor> actorFromDb = actorsRepository.findById(actor.getId());
//        if (actorFromDb.isEmpty()){
//            return null;
//        }
//        else {
//            Actor actorEdited = actorsRepository.findById(actor.getId()).orElseThrow();
//            actorEdited.setFirstName(actor.getFirstName());
//            actorEdited.setLastName(actor.getLastName());
//            actorsRepository.save(actorEdited);
//            return actorEdited;
//        }
//    }