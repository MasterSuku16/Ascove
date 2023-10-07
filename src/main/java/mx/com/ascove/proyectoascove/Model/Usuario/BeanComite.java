package mx.com.ascove.proyectoascove.Model.Usuario;

public class BeanComite {
    private int idComite;
    private int idRolComite;
    private String colonia;
    private int NumIntegrantes;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private int telefono;

    public BeanComite() {
    }

    public BeanComite(int idComite, int idRolComite, String colonia, int numIntegrantes, String nombre, String aPaterno, String aMaterno, int telefono) {
        this.idComite = idComite;
        this.idRolComite = idRolComite;
        this.colonia = colonia;
        NumIntegrantes = numIntegrantes;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.telefono = telefono;
    }

    public int getIdComite() {
        return idComite;
    }

    public void setIdComite(int idComite) {
        this.idComite = idComite;
    }

    public int getIdRolComite() {
        return idRolComite;
    }

    public void setIdRolComite(int idRolComite) {
        this.idRolComite = idRolComite;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getNumIntegrantes() {
        return NumIntegrantes;
    }

    public void setNumIntegrantes(int numIntegrantes) {
        NumIntegrantes = numIntegrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
