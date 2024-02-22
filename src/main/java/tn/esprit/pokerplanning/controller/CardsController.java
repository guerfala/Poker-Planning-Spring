package tn.esprit.pokerplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplanning.Entities.Cards;
import tn.esprit.pokerplanning.service.CardsService;

import java.util.List;

@RestController
public class CardsController {
    @Autowired
    private CardsService service;
    @PostMapping("/addCards")
    public Cards addCards (@RequestBody Cards cards){
        return service.saveCards(cards);
    }
    @PostMapping("/addsCards")
    public List<Cards> addCards (@RequestBody List <Cards> cards){
        return service.saveCards(cards);
    }
    @GetMapping("/cards")
    public List<Cards>findAll(){
        return service.getCards();
    }
    @GetMapping("/cards/{id}")
    public Cards findCardsById(@PathVariable Long id){
        return service.getCardsById(id);
    }

    @PutMapping("/updateCard")
    public Cards updateCard (@RequestBody Cards cards)
    {
        return service.updateCards(cards);
    }

    @DeleteMapping("/cards/{id}")
    public String deletecard(@PathVariable Long id){
        return service.deleteCards(id);
    }


}
