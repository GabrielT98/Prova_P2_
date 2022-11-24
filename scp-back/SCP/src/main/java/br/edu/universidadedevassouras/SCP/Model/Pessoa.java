package br.edu.universidadedevassouras.SCP.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
    public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private int matricula;
    @Column(nullable = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date nascimento;
    @Column(nullable = true)
    private char genero;
    @Column(nullable = true)
    @Lob
    private String foto;

    @Column(nullable = true, unique = true)
    private String username;
    @Column(nullable = true)
    private String password;
}
