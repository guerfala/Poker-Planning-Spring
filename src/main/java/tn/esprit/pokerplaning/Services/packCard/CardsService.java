    package tn.esprit.pokerplaning.Services.packCard;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import tn.esprit.pokerplaning.Entities.packCard.Cards;
    import tn.esprit.pokerplaning.Repositories.packCard.CardsRepository;


    import java.util.List;

    @Service
    public class CardsService {
        @Autowired
        private CardsRepository repository;

        public Cards saveCards(Cards cards) {
            return repository.save(cards);
        }
        public List<Cards> saveCards(List<Cards>cards) {
            return repository.saveAll(cards);
        }
        public List<Cards> getCards(){
            return repository.findAll();
        }

        public Cards getCardsById(Long id){
            return repository.findById(id).orElse(null);
        }

        public String deleteCards(Long id){
            repository.deleteById(id);
            return "card  with id ="+id+" removed !!";
        }
        public Cards updateCards(Cards cards){
            Cards existingCards=repository.findById(cards.getCardId()).orElse(null);
            existingCards.setValue(cards.getValue());
            existingCards.setPack(cards.getPack());
            return repository.save(existingCards);
        }
    }
