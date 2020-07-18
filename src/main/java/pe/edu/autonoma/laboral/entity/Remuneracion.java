package pe.edu.autonoma.laboral.entity;

/**
 * Nomenclatura Java
 *  upper Camel Case: Class
 *  lower Camel case: method, attribute
 */

public class Remuneracion {
    private Integer id;
    private Trabajador trabajador;
    private Integer ano;
    private Integer mes;
    private Float montoBruta;
    private Float descuento;
    private Float montoLiquido;

    public Remuneracion(Integer id, Trabajador trabajador, Integer ano, Integer mes, Float montoBruta, Float descuento, Float montoLiquido) {
        this.id = id;
        this.trabajador = trabajador;
        this.ano = ano;
        this.mes = mes;
        this.montoBruta = montoBruta;
        this.descuento = descuento;
        this.montoLiquido = montoLiquido;
    }

    public Remuneracion(Trabajador trabajador, Integer ano, Integer mes, Float montoBruta, Float descuento, Float montoLiquido) {
        this.trabajador = trabajador;
        this.ano = ano;
        this.mes = mes;
        this.montoBruta = montoBruta;
        this.descuento = descuento;
        this.montoLiquido = montoLiquido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Float getMontoBruta() {
        return montoBruta;
    }

    public void setMontoBruta(Float montoBruta) {
        this.montoBruta = montoBruta;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getMontoLiquido() {
        return montoLiquido;
    }

    public void setMontoLiquido(Float montoLiquido) {
        this.montoLiquido = montoLiquido;
    }
}
