package pl.sebastiancielma.MyAeroclub.category.model;

import jakarta.persistence.*;
import lombok.Getter;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.Airplane;

import java.util.List;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String slug;
}
