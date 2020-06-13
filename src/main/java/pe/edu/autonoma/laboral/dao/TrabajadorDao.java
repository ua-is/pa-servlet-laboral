package pe.edu.autonoma.laboral.dao;

import pe.edu.autonoma.laboral.conexion.Conexion;
import pe.edu.autonoma.laboral.entity.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TrabajadorDao {
    private Connection conn;

    public TrabajadorDao() {
        conn = Conexion.openConnection();
    }
    // Métodos CRUD
    // Create
    public void insert( Trabajador trabajor ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "INSERT INTO trabajador (apellido_nombre, dni, fecha_nacimiento, direccion_personal, " +
                    "nombre_empresa, actividad, direccion_laboral ) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, trabajor.getApellidoNombre());
            ps.setString(2, trabajor.getDni());
            ps.setString(3, trabajor.getFechaNacimiento());
            ps.setString(4, trabajor.getDireccionPersonal());
            ps.setString(5, trabajor.getNombreEmpresa());
            ps.setString(6, trabajor.getActividad());
            ps.setString(7, trabajor.getDireccionLaboral());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

        }
    }

}
