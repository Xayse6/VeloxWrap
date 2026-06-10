package br.com.veloxwrap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Integer idModelo;

    @Column(name = "nome_modelo", nullable = false)
    private String nomeModelo;

    @Column(name = "ano_lancamento", nullable = false)
    private Integer anoLancamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}