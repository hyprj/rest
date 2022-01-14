package com.pracownia.rest.Services;

import com.pracownia.rest.Models.Studio;
import com.pracownia.rest.Repo.StudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {
    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public List<Studio> getStudios() {
        List<Studio> studios = studioRepository.findAll();
        return studios;
    }

    public Studio addStudio(Studio studio){
        Optional<Studio> studioFromDb = studioRepository.findById(studio.getName());
        if (studioFromDb.isPresent()){
            return null;
        }
        else{
            Studio newStudio = studioRepository.save(studio);
            return newStudio;
        }
    }

    public Optional<Studio> getSingleStudio(String name){
        return studioRepository.findById(name);
    }

    public Studio editStudio(Studio studio){
        Optional<Studio> studioFromDb = studioRepository.findById(studio.getName());
        if (studioFromDb.isEmpty()){
            return null;
        }
        else {
            Studio studioEdited = studioRepository.findById(studio.getName()).orElseThrow();
            studioEdited.setAddress(studio.getAddress());
            studioRepository.save(studioEdited);
            return studioEdited;
        }

    }

    public List<Studio> getStudioByAdress(String adres){
        return studioRepository.getStudioByAdress(adres);
    }
}
