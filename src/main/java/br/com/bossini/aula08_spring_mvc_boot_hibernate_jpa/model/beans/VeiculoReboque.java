package br.com.bossini.aula08_spring_mvc_boot_hibernate_jpa.model.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_veiculo_reboque")
public class VeiculoReboque {

    @Id
    @GeneratedValue
    private Long id;
    private Date data;

    @ManyToMany

    private List<Veiculo> veiculo;

    @ManyToMany
    private List<Reboque> reboque;

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }

    public List<Reboque> getReboque() {
        return reboque;
    }

    public void setReboque(List<Reboque> reboque) {
        this.reboque = reboque;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VeiculoReboque)) return false;
        VeiculoReboque that = (VeiculoReboque) o;
        return getId().equals(that.getId()) &&
                getData().equals(that.getData()) &&
                getVeiculo().equals(that.getVeiculo()) &&
                getReboque().equals(that.getReboque());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getData(), getVeiculo(), getReboque());
    }

    @Override
    public String toString() {
        return "VeiculoReboque [id=" + id + "data" + data + "Veiculo" + veiculo + "Reboque" + reboque + "]";
    }
}