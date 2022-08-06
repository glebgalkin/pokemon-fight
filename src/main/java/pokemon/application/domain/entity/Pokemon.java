package pokemon.application.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String weight;
    private String height;
    public final int healthPoints = 20;

    public Pokemon(){};

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }
}
