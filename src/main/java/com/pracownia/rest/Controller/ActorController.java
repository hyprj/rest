package com.pracownia.rest.Controller;

import com.pracownia.rest.Models.Actor;
import com.pracownia.rest.Services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

//    public ActorController(ActorService actorService) {
//        this.actorService = actorService;
//    }

    @GetMapping("/actors")
    public List<Actor> getActors() {
        return actorService.getActors();
    }

    @PostMapping("/actors")
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor){
        Actor actorFromDb = actorService.addActor(actor);
        if (actorFromDb == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        else{
            return ResponseEntity.ok(actorFromDb);
        }
    }

    @GetMapping("/actors/{id}")
    public ResponseEntity<Optional<Actor>> getSingleActor(@PathVariable long id){
        Optional<Actor> actorFromDb = actorService.getSingleActor(id);
        if (actorFromDb.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actorFromDb);
    }

    @PutMapping("/actors/{id}")
    public ResponseEntity<Actor> editActor(@PathVariable long id, @RequestBody Actor actor){
        Actor actorFromDb = actorService.editActor(id, actor);
        if (actorFromDb == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actorFromDb);
    }

    @DeleteMapping("actors/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable long id){
        try{
            actorService.deleteActor(id);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/actors/{id}/movies")
    public ResponseEntity<List<String>> getActorMovies(@PathVariable long id){
        return ResponseEntity.ok(actorService.getActorsMovies(id));
    }
}
