package contexto;

import datos.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase medicamento del contexto problema
 */
public class Medicamento {

    /**
     *
     */
    private DB db;
    private Statement consulta;

    private String region;
    private String nombre;
    private String farmacia;
    private int codigo;
    private String dosis;
    private String presentacion;
    private String marca;
    private int precio;
    private String direccion;
    private String comuna;

    /**
     * Constructor de la clase Buscador
     *
     * @param region      region en donde buscar el medicamento
     * @param nombre Nombre de medicamento a buscar
     * @param farmacia    farmacia en donde buscar el medicamento
     * @throws SQLException Excepcion en MySQL
     */
    public Medicamento(String region, String nombre, String farmacia) throws SQLException {
        this.db = new DB();
        this.consulta = db.getConnection().createStatement();
        this.region = region;
        this.nombre = nombre;
        this.farmacia = farmacia;
    }

    /**
     * Constructor con parametros de Medicamento
     *
     * @param codigo       Codigo del medicamento
     * @param nombre  Nombre del medicamento
     * @param dosis        Dosis del medicamento
     * @param presentacion Presentacion del medicamento
     * @param marca        Marca del medicamento
     * @param farmacia     Farmacia del medicamento
     * @param precio       Precio del medicamento
     * @param direccion    Direccion de la farmacia del medicamento
     * @param comuna       Comuna de la farmacia del medicamento
     * @param region       Region de la farmacia del medicamento
     */
    public Medicamento(int codigo, String nombre, String dosis,
                       String presentacion, String marca, String farmacia,
                       int precio, String direccion, String comuna, String region) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dosis = dosis;
        this.presentacion = presentacion;
        this.marca = marca;
        this.farmacia = farmacia;
        this.precio = precio;
        this.direccion = direccion;
        this.comuna = comuna;
        this.region = region;
    }

    /**
     * @return
     */
    public DB getDb() {
        return db;
    }

    /**
     * Retorna consulta a base de datos en formato ResultSet
     *
     * @param tabla nombre de la tabla en formato database.tabla
     * @return consulta como ResultSet
     * @throws SQLException Excepcion en MySQL
     */
    public ResultSet resp(String tabla) throws SQLException {
        String consultaString = String.format("SELECT * FROM %s WHERE 1=1 ", tabla);
        if (null != region && !"".endsWith(region)) {
            consultaString = consultaString + " AND región like '%" + region.replace("\'", "''") + "%'";
        }
        if (null != nombre && !"".endsWith(nombre)) {
            consultaString = consultaString + " AND medicamento LIKE '%" + nombre + "%'";
        }
        if (null != farmacia && !"".endsWith(farmacia)) {
            consultaString = consultaString + " AND farmacía = '" + farmacia + "'";
        }
        return this.consulta.executeQuery(consultaString);
    }

    /**
     * @return
     */
    public Object[] toArray() {
        Object[] obj = new Object[10];
        obj[0] = codigo;
        obj[1] = nombre;
        obj[2] = dosis;
        obj[3] = presentacion;
        obj[4] = marca;
        obj[5] = farmacia;
        obj[6] = precio;
        obj[7] = direccion;
        obj[8] = comuna;
        obj[9] = region;
        return obj;
    }

    /**
     * Edita el codigo del medicamento
     *
     * @param codigo Codigo del medicamento
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param dosis
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     * @param presentacion
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @param farmacia
     */
    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    /**
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @param comuna
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }


}
