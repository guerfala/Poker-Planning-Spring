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
    @PostMapping("/addCards/{id}")
    public Cards addCards (@RequestBody Cards cards, @PathVariable Long id){

        return service.saveCards(cards,id);
    }
    @PostMapping("/addCards")
    public Cards addCardss (@RequestBody Cards cards){
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

    @GetMapping("/cardsofpack/{id}")
    public List<Cards>findcardofpack(@PathVariable Long id){
        return   service.getCardsOfPack(id);
    }
    @GetMapping("/cards/{id}")
    public Cards findCardsById(@PathVariable Long id){
        return service.getCardsById(id);
    }

    @PutMapping("/updateCard/{id}")
    public Cards updateCard (@RequestBody Cards cards,@PathVariable Long id)
    {
        cards.setCardId(id);

        return service.updateCards(cards);
    }

    @DeleteMapping("/cards/{id}")
    public String deletecard(@PathVariable Long id){
        return service.deleteCards(id);
    }


}
