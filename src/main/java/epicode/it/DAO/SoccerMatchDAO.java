package epicode.it.DAO;

import epicode.it.entity.soccer_match.SoccerMatch;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SoccerMatchDAO {
    private EntityManager em;

    public void save(SoccerMatch match) {
        em.getTransaction().begin();
        em.persist(match);
        em.getTransaction().commit();
    }

    public SoccerMatch findById(Long id) {
        return em.find(SoccerMatch.class, id);
    }

    public void update(SoccerMatch match) {
        em.getTransaction().begin();
        em.merge(match);
        em.getTransaction().commit();
    }

    public void delete(SoccerMatch match) {
        em.getTransaction().begin();
        em.remove(match);
        em.getTransaction().commit();
    }
}