package pe.edu.autonoma.laboral.dao;

import pe.edu.autonoma.laboral.conexion.Conexion;
import pe.edu.autonoma.laboral.entity.Actividad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActividadDao {
    private Connection conn;
    private PreparedStatement ps;

    public ActividadDao() {
        conn = Conexion.openConnection();
    }
    // Métodos CRUD
    // Create
    public void insert( Actividad Actividad ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "INSERT INTO Actividad (descripcion) VALUES (?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, Actividad.getDescripcion());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
    // READ
    // findAll, listar, list, fetchAll, getAll
    public List<Actividad> list() {
        List<Actividad> Actividades = new ArrayList<>();
        try {
            String sql = "SELECT * FROM actividad";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                Actividad Actividad = new Actividad( rs.getInt("id"), rs.getString("descripcion"));
                Actividades.add(Actividad);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return Actividades;
    }
    // findById, GetById, GetEntity, listarId, findId
    public Optional<Actividad> findId(Integer id) {
        Optional<Actividad> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  Actividad WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                Actividad Actividad = new Actividad( rs.getInt("id"), rs.getString("descripcion"));

                optional = Optional.of(Actividad);
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
    public void update( Actividad Actividad ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "UPDATE Actividad SET descripcion = ? WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, Actividad.getDescripcion());
            ps.setInt(2, Actividad.getId());

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
            String sql = "DELETE FROM Actividad WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }


}
