package epicode.it.DAO;

import epicode.it.entity.athletics_competition.AthleticsCompetition;
import epicode.it.entity.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AthleticsCompetitionDAO {
    private EntityManager em;

    public void save(AthleticsCompetition competition) {
        em.getTransaction().begin();
        em.persist(competition);
        em.getTransaction().commit();
    }

    public AthleticsCompetition findById(Long id) {
        return em.find(AthleticsCompetition.class, id);
    }

    public List<AthleticsCompetition> findAll() {
        return this.em.createNamedQuery("findAll_AthleticsCompetition", AthleticsCompetition.class).getResultList();
    }

    public void update(AthleticsCompetition competition) {
        em.getTransaction().begin();
        em.merge(competition);
        em.getTransaction().commit();
    }

    public void delete(AthleticsCompetition competition) {
        em.getTransaction().begin();
        em.remove(competition);
        em.getTransaction().commit();
    }

    public AthleticsCompetition findByWinner(Person person) {
        return em.createNamedQuery("findByWinner_AthleticsCompetition", AthleticsCompetition.class)
                .setParameter("winner", person).getSingleResult();
    }
}