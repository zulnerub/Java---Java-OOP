package WORKSHOP_TWO.structure.core;

import WORKSHOP_TWO.structure.common.ConstantMessages;
import WORKSHOP_TWO.structure.core.factory.Factory;
import WORKSHOP_TWO.structure.core.factory.FactoryImpl;
import WORKSHOP_TWO.structure.core.interfaces.ManagerController;
import WORKSHOP_TWO.structure.models.battleFields.BattleFieldImpl;
import WORKSHOP_TWO.structure.models.battleFields.interfaces.Battlefield;
import WORKSHOP_TWO.structure.models.cards.interfaces.Card;
import WORKSHOP_TWO.structure.models.players.interfaces.Player;
import WORKSHOP_TWO.structure.repositories.CardRepositoryImpl;
import WORKSHOP_TWO.structure.repositories.PlayerRepositoryImpl;
import WORKSHOP_TWO.structure.repositories.interfaces.CardRepository;
import WORKSHOP_TWO.structure.repositories.interfaces.PlayerRepository;

import java.util.List;


public class ManagerControllerImpl implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Factory factory;
    private Battlefield battlefield;


    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.factory = new FactoryImpl();
        this.battlefield = new BattleFieldImpl();

    }

    @Override
    public String addPlayer(String type, String username) {
        if (this.playerRepository.find(username) != null){
            throw new IllegalArgumentException(String.format("Player %s already exists!", username));
        }
        this.playerRepository.add(this.factory.createPlayer(type, username));
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        if (this.cardRepository.find(name) != null){
            throw new IllegalArgumentException(String.format("Card %s already exists!", name));
        }
        Card card = this.factory.createCard(type, name);
        this.cardRepository.add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Card card = this.cardRepository.find(cardName);
        Player player = this.playerRepository.find(username);

        player.getCardRepository().add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);
        this.battlefield.fight(attacker, enemy);
        return String.format(ConstantMessages.FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        List<Player> players = this.playerRepository.getPlayers();
        players.forEach(pl -> {
            List<Card> cards = pl.getCardRepository().getCards();
            report.append(String.format(ConstantMessages.PLAYER_REPORT_INFO,
                    pl.getUsername(),
                    pl.getHealth(),
                    pl.getCardRepository().getCount()))
                    .append(System.lineSeparator());

            cards.forEach(cd -> report.append(String.format(ConstantMessages.CARD_REPORT_INFO,
                    cd.getName(),
                    cd.getDamagePoints()))
                    .append(System.lineSeparator()));

            report.append(ConstantMessages.DEFAULT_REPORT_SEPARATOR).append(System.lineSeparator());
        });

        return report.toString().trim();
    }
}
