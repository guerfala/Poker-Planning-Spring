package tn.esprit.pokerplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Entities.Cards;
import tn.esprit.pokerplanning.Entities.Pack;
import tn.esprit.pokerplanning.service.CardsService;
import tn.esprit.pokerplanning.service.PackService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PackController {
    @Autowired
    private PackService service;
    @PostMapping("/addPack")
    public Pack addPack (@RequestBody Pack Pack){
        return service.savePack(Pack);
    }
    @PostMapping("/addsPack")
    public List<Pack> addPack (@RequestBody List <Pack> Pack){
        return service.savePack(Pack);
    }
    @GetMapping("/Pack")
    public List<Pack>findAll(){
        return service.getPack();
    }
    @GetMapping("/Packid/{id}")
    public Pack findPackById(@PathVariable Long id){
        return service.getPackById(id);
    }
    @GetMapping("/Pack/{name}")
    public Pack findPackByName(@PathVariable String name){
        return service.getPackByName(name);
    }

    @PutMapping("/updatePack/{id}")
    public Pack updatePack (@RequestBody Pack pack,@PathVariable Long id)
    {
        pack.setPackId(id);
        return service.updatePack(pack);
    }
    @GetMapping("/highest-recommended")
    public ResponseEntity<Pack> getPackWithHighestRecommendedValue() {
        Pack pack = service.getPackWithHighestRecommendedValue();
        if (pack != null) {
            return new ResponseEntity<>(pack, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updatePack2/{id}")
    public Pack updatePack2 (@PathVariable Long id)
    {
        Pack p = new Pack();
        p= service.getPackById(id);
        p.setRecommended(p.getRecommended()+1);
        return service.updatePack(p);
    }

    @DeleteMapping("/Pack/{id}")
    public ResponseEntity<Map<String, Boolean>> deletepack(@PathVariable Long id){
        Pack pack = service.getPackById(id);
            service.deletePack(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);

    }

}
