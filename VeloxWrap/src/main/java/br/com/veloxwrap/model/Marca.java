package br.com.veloxwrap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer idMarca;
ss
    @Column(name = "nome_marca")
    private String nomeMarca;

    @Column(name = "sigla_marca")
    private String siglaMarca;

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getSiglaMarca() {
        return siglaMarca;
    }

    public void setSiglaMarca(String siglaMarca) {
        this.siglaMarca = siglaMarca;
    }
}