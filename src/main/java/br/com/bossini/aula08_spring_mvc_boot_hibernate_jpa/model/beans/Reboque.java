package br.com.bossini.aula08_spring_mvc_boot_hibernate_jpa.model.beans;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_reboque")
public class Reboque {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 60)
    private String marca;

    @Column(nullable = false, length = 60)
    private String modelo;

    @Column(nullable = false)
    private int anoModelo;


    @OneToOne(optional = false)
    @JoinColumn(name = "jtb_identificador_placa")
    private Placa placa;

    //    EXERCERCICIO 2
    @ManyToMany
    private List<Pessoa> pessoas;

//   EXERCERCICIO 2.2
    @ManyToMany(mappedBy = "reboque")
    private List<VeiculoReboque> veiculoReboque;

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reboque)) return false;
        Reboque reboque = (Reboque) o;
        return getAnoModelo() == reboque.getAnoModelo() &&
                getId().equals(reboque.getId()) &&
                getMarca().equals(reboque.getMarca()) &&
                getModelo().equals(reboque.getModelo()) &&
                getPlaca().equals(reboque.getPlaca()) &&
                getPessoas().equals(reboque.getPessoas());
    }

    @Override
    public String toString() {
        return "Reboque [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anoModelo=" + anoModelo + ", placa="
                + placa + "]";
    }

}