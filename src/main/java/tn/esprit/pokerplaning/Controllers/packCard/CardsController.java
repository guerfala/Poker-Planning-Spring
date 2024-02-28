package tn.esprit.pokerplaning.Controllers.packCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplaning.Entities.packCard.Cards;
import tn.esprit.pokerplaning.Services.packCard.CardsService;


import java.util.List;
@RequestMapping("/cards")
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
