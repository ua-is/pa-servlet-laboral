package pe.edu.autonoma.laboral.dao;

import pe.edu.autonoma.laboral.conexion.Conexion;
import pe.edu.autonoma.laboral.entity.Actividad;
import pe.edu.autonoma.laboral.entity.Remuneracion;
import pe.edu.autonoma.laboral.entity.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RemuneracionDao {
    private Connection conn;
    private PreparedStatement ps;
    // Aqui colocar todos los Dao de los atributos tipo Objeto
    private TrabajadorDao trabajadorDao;

    public RemuneracionDao() {
        conn = Conexion.openConnection();
        trabajadorDao = new TrabajadorDao();
    }
    // Métodos CRUD
    // Create
    public void insert( Remuneracion remuneracion ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "INSERT INTO remuneracion (trabajador_id, ano, mes, monto_bruta, descuento, monto_liquido ) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, remuneracion.getTrabajador().getId());
            ps.setInt(2, remuneracion.getAno());
            ps.setInt(3, remuneracion.getMes());
            ps.setFloat(4, remuneracion.getMontoBruta());
            ps.setFloat(5, remuneracion.getDescuento());
            ps.setFloat(6, remuneracion.getMontoLiquido());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
    // READ
    // findAll, listar, list, fetchAll, getAll
    public List<Remuneracion> list() {
        List<Remuneracion> remuneraciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM remuneracion";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                // Obtener el Optional que contiene el trabajador
                int idTrabajador = rs.getInt("trabajador_id");
                Optional<Trabajador> optionalTrabajador = trabajadorDao.findId( idTrabajador );

                // trabajador_id, ano, mes, monto_bruta, descuento, monto_liquido
                Remuneracion remuneracion = new Remuneracion( rs.getInt("id"), optionalTrabajador.get(),
                        rs.getInt("ano"), rs.getInt("mes"), rs.getFloat("monto_bruta"),
                        rs.getFloat("descuento"), rs.getFloat("monto_liquido"));

                remuneraciones.add( remuneracion );
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return remuneraciones;
    }
    // findById, GetById, GetEntity, listarId, findId
    public Optional<Remuneracion> findId(Integer id) {
        Optional<Remuneracion> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM remuneracion WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                // Obtener el Optional que contiene el trabajador
                int idTrabajador = rs.getInt("trabajador_id");
                Optional<Trabajador> optionalTrabajador = trabajadorDao.findId( idTrabajador );

                // trabajador_id, ano, mes, monto_bruta, descuento, monto_liquido
                Remuneracion remuneracion = new Remuneracion( rs.getInt("id"), optionalTrabajador.get(),
                        rs.getInt("ano"), rs.getInt("mes"), rs.getFloat("monto_bruta"),
                        rs.getFloat("descuento"), rs.getFloat("monto_liquido"));

                optional = Optional.of( remuneracion );
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
    public void update( Remuneracion remuneracion ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            // trabajador_id, ano, mes, monto_bruta, descuento, monto_liquido
            String sql = "UPDATE remuneracion SET trabajador_id = ?, ano = ?, mes = ?, monto_bruta = ?, " +
                    "descuento = ?, monto_liquido = ? WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, remuneracion.getTrabajador().getId());
            ps.setInt(2, remuneracion.getAno());
            ps.setInt(3, remuneracion.getMes());
            ps.setFloat(4, remuneracion.getMontoBruta());
            ps.setFloat(5, remuneracion.getDescuento());
            ps.setFloat(6, remuneracion.getMontoLiquido());
            ps.setInt(7, remuneracion.getId());

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
            String sql = "DELETE FROM remuneracion WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }
}
