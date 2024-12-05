package epicode.it.entity.concert;

import epicode.it.entity.event.Event;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(name = "findAll_Concert", query = "SELECT a FROM Concert a")
@Table(name="concerts")
public class Concert extends Event {
    private Genre genre;

    @Column(name="in_streaming")
    private boolean inStreaming;

}