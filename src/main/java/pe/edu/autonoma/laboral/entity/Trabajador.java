package pe.edu.autonoma.laboral.entity;

// Upper Camel Case: Clases
// lower Camel Case: Atibutos y métodos
public class Trabajador {
    private Integer id;
    private String apellidoNombre;
    private String dni;
    private String fechaNacimiento;
    private String direccionPersonal;
    private String nombreEmpresa;
    private String actividad;
    private String direccionLaboral;

    public Trabajador(Integer id, String apellidoNombre, String dni, String fechaNacimiento, String direccionPersonal, String nombreEmpresa, String actividad, String direccionLaboral) {
        this.id = id;
        this.apellidoNombre = apellidoNombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionPersonal = direccionPersonal;
        this.nombreEmpresa = nombreEmpresa;
        this.actividad = actividad;
        this.direccionLaboral = direccionLaboral;
    }

    public Trabajador(String apellidoNombre, String dni, String fechaNacimiento, String direccionPersonal, String nombreEmpresa, String actividad, String direccionLaboral) {
        this.apellidoNombre = apellidoNombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionPersonal = direccionPersonal;
        this.nombreEmpresa = nombreEmpresa;
        this.actividad = actividad;
        this.direccionLaboral = direccionLaboral;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidoNombre() {
        return apellidoNombre;
    }

    public void setApellidoNombre(String apellidoNombre) {
        this.apellidoNombre = apellidoNombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionPersonal() {
        return direccionPersonal;
    }

    public void setDireccionPersonal(String direccionPersonal) {
        this.direccionPersonal = direccionPersonal;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDireccionLaboral() {
        return direccionLaboral;
    }

    public void setDireccionLaboral(String direccionLaboral) {
        this.direccionLaboral = direccionLaboral;
    }
}
