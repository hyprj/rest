package com.pracownia.rest.Controller;

import com.pracownia.rest.Models.Studio;
import com.pracownia.rest.Services.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudioController {
    private final StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping("/studios")
    public ResponseEntity<List<Studio>> getStudios(){
        return ResponseEntity.ok(studioService.getStudios());
    }

    @GetMapping("/studios/{name}")
    public ResponseEntity<Optional<Studio>> GetSingleStudio (@PathVariable String name){
        Optional<Studio> studioFromDb = studioService.getSingleStudio(name);
        if (studioFromDb.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studioFromDb);
    }

    @PostMapping("/studios")
    public ResponseEntity <Studio> addStudio(@RequestBody Studio studio) {
        Studio studioFromDb = studioService.addStudio(studio);
        if (studioFromDb == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        else{
            return ResponseEntity.ok(studioFromDb);
        }
    }

    @PutMapping("/studios")
    public ResponseEntity<Studio> editStudio(@RequestBody Studio studio){
        Studio studioFromDb = studioService.editStudio(studio);
        if (studioFromDb == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studioFromDb);
    }


    @GetMapping("/studios/addresses/{address}")
    public ResponseEntity<List<Studio>> getStudiosMovies(@PathVariable String address){
        return ResponseEntity.ok(studioService.getStudioByAdress(address));
    }

}
