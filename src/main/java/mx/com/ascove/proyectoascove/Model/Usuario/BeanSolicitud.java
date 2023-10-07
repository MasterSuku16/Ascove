package mx.com.ascove.proyectoascove.Model.Usuario;

public class BeanSolicitud {
    private int numSolicitud;
    private String descripcion;
    private String servicioAsignado;
    private int status;
    private String fechaInicio;
    private String fechaCierre;
    private int idSolicitante;
    private int idEnlace;

    public BeanSolicitud() {
    }

    public BeanSolicitud(int numSolicitud, String descripcion, String servicioAsignado, int status, String fechaInicio, String fechaCierre, int idSolicitante, int idEnlace) {
        this.numSolicitud = numSolicitud;
        this.descripcion = descripcion;
        this.servicioAsignado = servicioAsignado;
        this.status = status;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.idSolicitante = idSolicitante;
        this.idEnlace = idEnlace;
    }

    public int getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(int numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getServicioAsignado() {
        return servicioAsignado;
    }

    public void setServicioAsignado(String servicioAsignado) {
        this.servicioAsignado = servicioAsignado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public int getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(int idEnlace) {
        this.idEnlace = idEnlace;
    }
}
