package epicode.it.entity.soccer_match;

import epicode.it.entity.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "findAll_SoccerMatch", query = "SELECT a FROM SoccerMatch a")
@Table(name="soccer_matches")
public class SoccerMatch extends Event {
    private String homeTeam;
    private String awayTeam;
    private String winner;
    @Column(name="score_home_team")
    private Integer scoreHomeTeam;
    @Column(name="score_away_team")
    private Integer scoreAwayTeam;
}