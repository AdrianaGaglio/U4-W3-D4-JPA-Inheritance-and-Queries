package epicode.it;

import com.github.javafaker.Faker;
import epicode.it.DAO.ConcertDAO;
import epicode.it.DAO.EventDAO;
import epicode.it.DAO.SoccerMatchDAO;
import epicode.it.entity.concert.Concert;
import epicode.it.entity.soccer_match.SoccerMatch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        ConcertDAO concertDAO = new ConcertDAO(em);
        SoccerMatchDAO soccerMatchDAO = new SoccerMatchDAO(em);

        List<Concert> streamingConcerts = concertDAO.findInStreaming(true);
        streamingConcerts.forEach(System.out::println);

        List<Concert> noStreamingConcerts = concertDAO.findInStreaming(false);
        noStreamingConcerts.forEach(System.out::println);

        List<SoccerMatch> soccerMatchesHome = soccerMatchDAO.findHomeWin("Bari sheep");
        System.out.println("Bari sheep wins (home): " + soccerMatchesHome.size());

        List<SoccerMatch> soccerMatchesAway = soccerMatchDAO.findAwayWin("Padova zombies");
        System.out.println("Padova zombies wins (away): " + soccerMatchesAway.size());

    }
}