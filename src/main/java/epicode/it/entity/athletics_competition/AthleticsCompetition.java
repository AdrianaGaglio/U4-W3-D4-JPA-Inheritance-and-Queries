package epicode.it.entity.athletics_competition;

import epicode.it.entity.event.Event;
import epicode.it.entity.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "findAll_AthleticsCompetition", query = "SELECT a FROM AthleticsCompetition a")
@NamedQuery(name = "findByWinner_AthleticsCompetition", query = "SELECT a FROM AthleticsCompetition a WHERE a.winner = :winner")
@Table(name="athletics_competitions")

public class AthleticsCompetition extends Event {

    @ManyToMany(mappedBy = "competitions", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Person> athletes = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "winner_id")
    private Person winner;

}