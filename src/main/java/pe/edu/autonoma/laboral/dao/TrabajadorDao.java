package pe.edu.autonoma.laboral.dao;

import pe.edu.autonoma.laboral.conexion.Conexion;
import pe.edu.autonoma.laboral.entity.Actividad;
import pe.edu.autonoma.laboral.entity.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrabajadorDao {
    private Connection conn;
    private PreparedStatement ps;
    private ActividadDao actividadDao;

    public TrabajadorDao() {
        conn = Conexion.openConnection();
        actividadDao = new ActividadDao();
    }
    // Métodos CRUD
    // Create
    public void insert( Trabajador trabajador ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "INSERT INTO trabajador (apellido_nombre, dni, fecha_nacimiento, direccion_personal, " +
                    "nombre_empresa, actividad_id, direccion_laboral ) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, trabajador.getApellidoNombre());
            ps.setString(2, trabajador.getDni());
            ps.setString(3, trabajador.getFechaNacimiento());
            ps.setString(4, trabajador.getDireccionPersonal());
            ps.setString(5, trabajador.getNombreEmpresa());
            ps.setInt(6, trabajador.getActividad().getId());
            ps.setString(7, trabajador.getDireccionLaboral());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
    // READ
    // findAll, listar, list, fetchAll, getAll
    public List<Trabajador> list() {
        List<Trabajador> trabajadores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM  trabajador";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                // Creación del objeto actividad
                // Creación del objeto actividad
                int idActividad = rs.getInt("actividad_id");
                Optional<Actividad> optionalActividad = actividadDao.findId( idActividad );

                // id, apellido_nombre, dni, fecha_nacimiento, direccion_personal, nombre_empresa, actividad, direccion_laboral
                Trabajador trabajador = new Trabajador( rs.getInt("id"), rs.getString("apellido_nombre"),
                        rs.getString("dni"), rs.getString("fecha_nacimiento"),
                        rs.getString("direccion_personal"), rs.getString("nombre_empresa"),
                        optionalActividad.get(), rs.getString("direccion_laboral"));

                trabajadores.add(trabajador);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return trabajadores;
    }
    // findById, GetById, GetEntity, listarId, findId
    public Optional<Trabajador> findId(Integer id) {
        Optional<Trabajador> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  trabajador WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                // Creación del objeto actividad
                int idActividad = rs.getInt("actividad_id");
                Optional<Actividad> optionalActividad = actividadDao.findId( idActividad );
                // id, apellido_nombre, dni, fecha_nacimiento, direccion_personal, nombre_empresa, actividad, direccion_laboral
                Trabajador trabajador = new Trabajador( rs.getInt("id"), rs.getString("apellido_nombre"),
                        rs.getString("dni"), rs.getString("fecha_nacimiento"),
                        rs.getString("direccion_personal"), rs.getString("nombre_empresa"),
                        optionalActividad.get(), rs.getString("direccion_laboral"));

                optional = Optional.of(trabajador);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }
    // findBy____ : Buscar por un atributo, findByDni
    // fetchBy_____: Todos los demás queries, fetchByBornJanuary
    //

    //UPDATE
    // actualizar, update,
    public void update( Trabajador trabajador ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "UPDATE trabajador SET apellido_nombre = ?, dni = ?, fecha_nacimiento = ?, direccion_personal = ?, " +
                    "nombre_empresa = ?, actividad_id = ?, direccion_laboral = ?  " +
                    "WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, trabajador.getApellidoNombre());
            ps.setString(2, trabajador.getDni());
            ps.setString(3, trabajador.getFechaNacimiento());
            ps.setString(4, trabajador.getDireccionPersonal());
            ps.setString(5, trabajador.getNombreEmpresa());
            ps.setInt(6, trabajador.getActividad().getId());
            ps.setString(7, trabajador.getDireccionLaboral());
            ps.setInt(8, trabajador.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    //DELETE
    // borrarID, deleteId, deleteById,
    public void deleteId( Integer id ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "DELETE FROM trabajador WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }


}
