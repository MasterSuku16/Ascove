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

public class DaoSolicitud {

    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;


    final private Logger CONSOLE = LoggerFactory.getLogger(DaoSolicitud.class);


    public List<BeanSolicitud> findSoli() {
        List<BeanSolicitud> listSoli = new ArrayList<>();

        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call findSoli}");
            rs = cstm.executeQuery();

            while (rs.next()){
                BeanSolicitud soli = new BeanSolicitud();

                soli.setNumSolicitud(rs.getInt("NumeroSolicitud"));
                soli.setDescripcion(rs.getString("Descripcion"));
                soli.setServicioAsignado(rs.getString("ServicioAsignado"));
                soli.setStatus(rs.getInt("status"));
                soli.setFechaInicio(rs.getString("Fecha_Inicio"));
                soli.setFechaCierre(rs.getString("Fecha_Cierre"));
                soli.setIdSolicitante(rs.getInt("idSolicitante"));
                soli.setIdEnlace(rs.getInt("idEnlace"));


                listSoli.add(soli);
            }
        }catch(SQLException e){
            CONSOLE.error("Falló4 : " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return listSoli;
    }

    public boolean create (BeanSolicitud beanSolicitud) {
        boolean flag = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call createSoli(?,?,?,?,?)}");

            cstm.setString(1, beanSolicitud.getDescripcion());
            cstm.setString(2,beanSolicitud.getServicioAsignado());
            cstm.setString(3,beanSolicitud.getFechaInicio());
            cstm.setInt(4,beanSolicitud.getIdSolicitante());
            cstm.setInt(5,beanSolicitud.getIdEnlace());
            cstm.execute();

            flag = true;

        } catch (SQLException e) {
            CONSOLE.error("No funciona: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public List<BeanSolicitud> findSoliById(int id) {
        List<BeanSolicitud> listSoliById = new ArrayList<>();

        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call findSoliById(?)}");
            cstm.setInt(1, id);
            rs = cstm.executeQuery();

            while (rs.next()){
                BeanSolicitud soli = new BeanSolicitud();

                soli.setNumSolicitud(rs.getInt("idSolicitud"));
                soli.setDescripcion(rs.getString("descripcion"));
                soli.setServicioAsignado(rs.getString("servicioAsignado"));
                soli.setStatus(rs.getInt("status"));
                soli.setFechaInicio(rs.getString("fechaInicio"));
                soli.setFechaCierre(rs.getString("fechaCierre"));
                soli.setIdSolicitante(rs.getInt("idSolicitante"));
                soli.setIdEnlace(rs.getInt("idEnlace"));


                listSoliById.add(soli);
            }
        }catch(SQLException e){
            CONSOLE.error("Falló3: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return listSoliById;
    }

}
