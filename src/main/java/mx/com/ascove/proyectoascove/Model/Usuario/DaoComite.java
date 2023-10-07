package mx.com.ascove.proyectoascove.Model.Usuario;
import mx.com.ascove.proyectoascove.Model.BeanEmpleados;
import mx.com.ascove.proyectoascove.Model.Usuario.BeanComite;
import mx.com.ascove.proyectoascove.Model.DaoEmpleados;
import mx.com.ascove.proyectoascove.Service.ConnectionMySQL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DaoComite {

    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;


    final private Logger CONSOLE = LoggerFactory.getLogger(DaoComite.class);

    public boolean create (BeanComite beanComite) {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call createComite(?,?,?,?,?,?,?)}");

            cstm.setInt(1,beanComite.getIdRolComite());
            cstm.setString(2, beanComite.getColonia());
            cstm.setInt(3,beanComite.getNumIntegrantes());
            cstm.setString(4,beanComite.getNombre());
            cstm.setString(5, beanComite.getaPaterno());
            cstm.setString(6, beanComite.getaPaterno());
            cstm.setInt(7,beanComite.getTelefono());
            cstm.execute();

            flag = true;

        } catch (SQLException e) {
            CONSOLE.error("No funciona: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
    public List<BeanComite> findComite() {
        List<BeanComite> listComite = new ArrayList<>();

        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call findComite}");
            rs = cstm.executeQuery();

            while (rs.next()){
                BeanComite comite = new BeanComite();

                comite.setIdComite(rs.getInt("idComite"));
                comite.setIdComite(rs.getInt("idRolComite"));
                comite.setColonia(rs.getString("colonia"));
                comite.setNumIntegrantes(rs.getInt("NumIntegrantes"));
                comite.setNombre(rs.getString("aPaterno"));
                comite.setaMaterno(rs.getString("aMaterno"));
                comite.setTelefono(rs.getInt("telefono"));


                listComite.add(comite);
            }
        }catch(SQLException e){
            CONSOLE.error("Falló: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return listComite;
    }
}
