import lombok.*;
import javax.persistence.*;


@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "Mage")
public class Mage
{
    Mage(String name,Integer lvl, Tower tower)
    {
        this.setName(name);
        this.setLevel(lvl);
        this.setTower(tower);
    }
    @Getter
    @Setter
    @Id
    private String name;

    @Getter
    @Setter
    private int level;

    @Getter
    @Setter
    @ManyToOne
    private Tower tower;
}
