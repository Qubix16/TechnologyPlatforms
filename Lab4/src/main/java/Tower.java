import lombok.*;
import javax.persistence.*;
import java.util.List;


@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "Tower")
public class Tower {

     Tower(String name,Integer height, List<Mage> mages)
     {
          this.setName(name);
          this.setHeight(height);
          this.setMages(mages);
     }
     @Id
     @Getter
     @Setter
     private String name;

     @Getter
     @Setter
     private int height;

     @Getter
     @Setter
     @OneToMany(mappedBy = "tower")
     private List<Mage> mages;

}
