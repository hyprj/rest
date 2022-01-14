package com.pracownia.rest.Services;

import com.pracownia.rest.Models.Ceo;
import com.pracownia.rest.Repo.CeoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CeoService {
    private final CeoRepository ceoRepository;

    public CeoService(CeoRepository ceoRepository) {
        this.ceoRepository = ceoRepository;
    }

    public List<Ceo> getCeos(){
        List<Ceo> ceos = ceoRepository.findAll();
        return ceos;
    }

    public Ceo addCeo(Ceo ceo){
        Optional<Ceo> ceoFromDb = ceoRepository.findById(ceo.getId());
        if (ceoFromDb.isPresent()){
            return null;
        }
        else{
            return ceoRepository.save(ceo);
        }
    }

    public Optional<Ceo> getSingleCeo(long id){
        return ceoRepository.findById(id);
    }

    public Ceo editCeo(Ceo ceo){
        Optional<Ceo> ceoFromDb = ceoRepository.findById(ceo.getId());
        if (ceoFromDb.isEmpty()){
            return null;
        }
        else {
            Ceo editedCeo = ceoRepository.findById(ceo.getId()).orElseThrow();
            editedCeo.setFirstName(ceo.getFirstName());
            ceoRepository.save(editedCeo);
            return editedCeo;
        }
    }

    public void deleteCeo(long id) {
//        Optional<Ceo> ceoFromDb = ceoRepository.findById(id);
//        if (ceoFromDb.isPresent()) {
//            ceoRepository.deleteById(id);
//        } zly status http jak sie zrobi jak wyzej
        ceoRepository.deleteById(id);
    }

    public Ceo getCeoWithTheHighestSalary(){
        return ceoRepository.getCeoWithTheHighestSalary();
    }
}
