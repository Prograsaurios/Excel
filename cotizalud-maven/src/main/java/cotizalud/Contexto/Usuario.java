/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizalud.Contexto;

/**
 * Clase nombre del contexto problema
 */
public class Usuario {

    private int id;
    private String nombre;
    private String password;
    private int permiso;

    /**
     * Constructor de la clase Usuario
     *
     * @param nombre nombre del usuaario
     * @param password contraseña del usuario
     * @param permiso tipo de permiso del usuario
     */
    public Usuario(String nombre, String password, int permiso) {
        this.nombre = nombre;
        this.password = password;
        this.permiso = permiso;
    }

    /**
     * Retorna id del nombre
     *
     * @return este id
     */
    public int getId() {
        return id;
    }

    /**
     * Edita id del nombre
     *
     * @param id id del nombre
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna nombre del nombre
     *
     * @return este nombre del nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Edita nombre del usuario
     *
     * @param nombre nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna constraseña del usuario
     *
     * @return esta contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retorna contraseña del usuario
     *
     * @param password contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna tipo permiso del usuario como numero
     *
     * @return este permiso del usuario
     */
    public int getPermiso() {
        return permiso;
    }

    /**
     * Edita tipo permiso del usuario como numero
     *
     * @param permiso permiso del usuario
     */
    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }

}
