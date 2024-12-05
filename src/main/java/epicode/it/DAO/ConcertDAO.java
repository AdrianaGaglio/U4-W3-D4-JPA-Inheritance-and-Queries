package epicode.it.DAO;

import epicode.it.entity.concert.Concert;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConcertDAO {
    private EntityManager em;

    public void save(Concert concert) {
        em.getTransaction().begin();
        em.persist(concert);
        em.getTransaction().commit();
    }

    public Concert findById(Long id) {
        return em.find(Concert.class, id);
    }

    public void update(Concert concert) {
        em.getTransaction().begin();
        em.merge(concert);
        em.getTransaction().commit();
    }

    public void delete(Concert concert) {
        em.getTransaction().begin();
        em.remove(concert);
        em.getTransaction().commit();
    }
}