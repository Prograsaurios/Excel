/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Busca informacion dentro de la base de datos
 */
public class Buscador {
    private Statement consulta;
    private String region;
    private String medicamento;
    private String farmacia;
    public DB db;

    /**
     *
     * @return
     */
    public Statement getConsulta() {
        return consulta;
    }

    /**
     *
     * @param consulta
     */
    public void setConsulta(Statement consulta) {
        this.consulta = consulta;
    }

    /**
     *
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     *
     * @return
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     *
     * @param medicamento
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    /**
     *
     * @return
     */
    public String getFarmacia() {
        return farmacia;
    }

    /**
     *
     * @param farmacia
     */
    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    /**
     *
     * @return
     */
    public DB getDb() {
        return db;
    }

    /**
     *
     * @param db
     */
    public void setDb(DB db) {
        this.db = db;
    }

    /**
     * Constructor de la clase Buscador
     * @param region region en donde buscar el medicamento
     * @param medicamento medicamento a buscar
     * @param farmacia farmacia en donde buscar el medicamento
     * @throws SQLException Excepcion en MySQL
     */
    public Buscador(String region, String medicamento, String farmacia) throws SQLException {
        this.db=new DB();
        this.consulta = (Statement) db.getConn().createStatement();
        this.region = region;
        this.medicamento = medicamento;
        this.farmacia = farmacia;
    }

    /**
     * Retorna consulta a base de datos en formato ResultSet
     * @param tabla nombre de la tabla en formato database.tabla
     * @return consulta como ResultSet
     * @throws SQLException Excepcion en MySQL
     */
    public ResultSet resp(String tabla) throws SQLException{
        String consulta = String.format("SELECT * FROM %s WHERE 1=1 ",tabla);
        if (null != region && !"".endsWith(region)) {
            consulta = consulta + " AND región like '%" + region.replace("'", "") + "%'";
        }
        if (null != medicamento && !"".endsWith(medicamento)) {
            consulta = consulta + " AND medicamento LIKE '%" + medicamento + "%'";
        }
        if (null != farmacia && !"".endsWith(farmacia)) {
            consulta = consulta + " AND farmacía = '" + farmacia + "'";
        }
        ResultSet rs = this.consulta.executeQuery(consulta);
        return rs;
    }
}
