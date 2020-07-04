package pe.edu.autonoma.laboral.entity;

public class Actividad {
    private Integer id;
    private String descripcion;

    // Se utiliza para obtener elementos
    public Actividad(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    // Nuevo elementos
    public Actividad(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
