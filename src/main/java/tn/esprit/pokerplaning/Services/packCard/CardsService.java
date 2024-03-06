    package tn.esprit.pokerplaning.Services.packCard;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import tn.esprit.pokerplaning.Entities.packCard.Cards;
    import tn.esprit.pokerplaning.Entities.packCard.Pack;
    import tn.esprit.pokerplaning.Repositories.packCard.CardsRepository;
    import tn.esprit.pokerplaning.Repositories.packCard.PackRepository;


    import java.util.List;

    @Service
    public class CardsService {
        @Autowired
        private CardsRepository repository;
        @Autowired
        private PackRepository packRepository;

        private  PackService packService = new PackService();


        public Cards saveCards(Cards cards) {

             repository.save(cards);
            return cards;
        }
        public Cards saveCards(Cards cards,Long id) {
            Pack pack = packRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pack not found"));
            cards.setPack(pack);
            return  repository.save(cards);
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
            existingCards.setImage(cards.getImage());

            return repository.save(existingCards);
        }

        public List<Cards> getCardsOfPack(Long packId) {
            // Retrieve the pack from the database
            Pack pack = packRepository.findById(packId)
                    .orElseThrow(() -> new IllegalArgumentException("Pack not found"));

            // Get the list of cards associated with the pack
            return pack.getCardsList();
        }
    }
