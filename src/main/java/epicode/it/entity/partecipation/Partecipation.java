package epicode.it.entity.partecipation;

import epicode.it.entity.event.Event;
import epicode.it.entity.person.Person;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.collection.spi.PersistentSortedMap;

@Data
@Entity
@NamedQuery(name = "findAll_Partecipation", query = "SELECT a FROM Partecipation a")
@Table(name="participations")
public class Partecipation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Event event;

    @Enumerated(EnumType.STRING)
    private Status status;
}