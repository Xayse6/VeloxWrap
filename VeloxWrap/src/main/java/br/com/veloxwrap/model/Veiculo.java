package br.com.veloxwrap.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Integer idVeiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @Column(
            name = "placa",
            nullable = false,
            unique = true,
            length = 8
    )
    private String placa;

    @Column(
            name = "cor",
            nullable = false,
            length = 30
    )
    private String cor;

    @Column(
            name = "apelido",
            length = 50
    )
    private String apelido;

    @Column(
            name = "data_cadastro",
            nullable = false,
            updatable = false
    )
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist() {

        this.dataCadastro = LocalDateTime.now();

        if (this.placa != null) {
            this.placa = this.placa.toUpperCase();
        }

    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
