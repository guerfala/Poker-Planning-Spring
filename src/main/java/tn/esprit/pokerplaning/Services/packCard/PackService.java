package tn.esprit.pokerplaning.Services.packCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplaning.Entities.packCard.Pack;
import tn.esprit.pokerplaning.Repositories.packCard.PackRepository;


import java.util.List;

@Service
public class PackService {
    @Autowired
    private PackRepository repository;
    public Pack savePack(Pack Pack) {


        return repository.save(Pack);
    }
    public List<Pack> savePack(List<Pack>Pack) {
        return repository.saveAll(Pack);
    }
    public List<Pack> getPack(){
        return repository.findAll();
    }
    public Pack getPackByName(String packName){
        return repository.findBypackName(packName);
    }
    public Pack getPackById(Long id){
        return repository.findById(id).orElse(null);
    }

    public String deletePack(Long id){
        repository.deleteById(id);
        return "pack  with id ="+id+" removed !!";
    }
    public Pack updatePack(Pack pack){
        Pack existingPack=repository.findById(pack.getPackId()).orElse(null);
        existingPack.setPackName(pack.getPackName());
        existingPack.setPackDescription(pack.getPackDescription());
        existingPack.setNbCards(pack.getNbCards());
        existingPack.setCardsList(pack.getCardsList());
        existingPack.setProjectList(pack.getProjectList());


        return repository.save(existingPack);
    }

}
