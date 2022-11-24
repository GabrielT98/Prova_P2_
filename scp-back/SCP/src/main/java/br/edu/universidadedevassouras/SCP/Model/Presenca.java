package br.edu.universidadedevassouras.SCP.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Presenca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data;
    @Column(nullable = false)
    private Boolean situacao;
    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;

}
