package com.pracownia.rest.Controller;

import com.pracownia.rest.Models.Ceo;
import com.pracownia.rest.Services.CeoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CeoController {
    private final CeoService ceoService;

    public CeoController(CeoService ceoService) {
        this.ceoService = ceoService;
    }

    @GetMapping("/ceos")
    public ResponseEntity<List<Ceo>> getCeos() {
        return ResponseEntity.ok(ceoService.getCeos());
    }

    @PostMapping("/ceos")
    public ResponseEntity<Ceo> addPrezes(@RequestBody Ceo ceo){
        Ceo ceoFromDb = ceoService.addCeo(ceo);
        if (ceoFromDb == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        else{
            return ResponseEntity.ok(ceoFromDb);
        }
    }

    @GetMapping("/ceos/{id}")
    public ResponseEntity<Optional<Ceo>> getSinglePrezes(@PathVariable long id){
        Optional<Ceo> ceoFromDb = ceoService.getSingleCeo(id);
        if (ceoFromDb.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ceoFromDb);
    }

    @PutMapping("/ceos")
    public ResponseEntity<Ceo> editCeo(@RequestBody Ceo ceo){
        Ceo ceoFromDb = ceoService.editCeo(ceo);
        if (ceoFromDb == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ceoFromDb);
    }

    @DeleteMapping("ceos/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable long id){
        try {
            ceoService.deleteCeo(id);
        }
        catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ceos/highestSalary")
    public ResponseEntity<Ceo> getCeoWithTheHighestSalary(){
        return ResponseEntity.ok(ceoService.getCeoWithTheHighestSalary());
    }
}
