/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Contexto;

/**
 * Clase medicamento del contexto problema
 */
public class Medicamento {

    private int codigo;
    private String medicamento;
    private String dosis;
    private String presentacion;
    private String marca;
    private String farmacia;
    private int precio;
    private String direccion;
    private String comuna;
    private String region;

    /**
     * Constructor sin parametros de Medicamento
     */
    public Medicamento() {
    }

    /**
     * Constructor con parametros de Medicamento
     *
     * @param codigo Codigo del medicamento
     * @param medicamento Medicamento del medicamento
     * @param dosis Dosis del medicamento
     * @param presentacion Presentacion del medicamento
     * @param marca Marca del medicamento
     * @param farmacia Farmacia del medicamento
     * @param precio Precio del medicamento
     * @param direccion Direccion de la farmacia del medicamento
     * @param comuna Comuna de la farmacia del medicamento
     * @param region Region de la farmacia del medicamento
     */
    public Medicamento(int codigo, String medicamento, String dosis, String presentacion, String marca, String farmacia, int precio, String direccion, String comuna, String region) {
        this.codigo = codigo;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.presentacion = presentacion;
        this.marca = marca;
        this.farmacia = farmacia;
        this.precio = precio;
        this.direccion = direccion;
        this.comuna = comuna;
        this.region = region;
    }
    public void toObject(){
        Object[] h;
    }

    /**
     * Retorna codigo del medicamento
     *
     * @return este codigo
     */
    public int getCodigo() {
        return codigo;
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
    public String getDosis() {
        return dosis;
    }

    /**
     *
     * @param dosis
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     *
     * @return
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     *
     * @param presentacion
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
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
    public int getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getComuna() {
        return comuna;
    }

    /**
     *
     * @param comuna
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
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

}
//traer clase buscador aca y setear los valores encontrados por el metodo respuesta a los atributos,luego con el get de cada atributo agregar estos datos a cada fila y con esto setear el defaulttablemodel

