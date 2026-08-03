package reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "declaracoes")
public class Declaracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "data_declaracao", nullable = false)
    private LocalDate dataDeclaracao;

    @Column(name = "data_inicial", nullable = false)
    private LocalDate dataInicial;

    @Column(name = "data_final", nullable = false)
    private LocalDate dataFinal;

    @Column(name = "peso_total_materiais", nullable = false, scale = 2)
    private double pesoTotalMateriais;

    @Column(name = "perc_total_compensacao", nullable = false, scale = 2)
    private double percTotalCompensacao;

    @OneToMany(mappedBy = "declaracao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDeclaracao> itens = new ArrayList();
}
