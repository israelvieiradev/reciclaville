package reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "itens_declaracao")
public class ItemDeclaracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_declaracao", nullable = false)
    private Declaracao declaracao;

    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;

    @Column(name = "perc_compensacao", nullable = false, scale = 2)
    private double percCompensacao;

    @Column(name = "peso", nullable = false, scale = 2)
    private double peso;

    @Column(name = "toneladas_compensadas", nullable = false, scale = 2)
    private double toneladasCompensadas;
}
