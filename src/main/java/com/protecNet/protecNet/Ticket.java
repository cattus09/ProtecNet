package com.protecNet.protecNet;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class Ticket {
    private String id;
    private String estado;
    private String url;
    private Date fechaCreacion;
    private String marcaAfectada;
    private String correoProveedor;
	private String correoCustomer;

    public Ticket() {
        // Constructor por defecto
    }

    public Ticket(String id, String estado, String url, Date fechaCreacion, String marcaAfectada, String correoProveedor, String correoCustomer) {
        this.id = id;
        this.estado = estado;
        this.url = url;
        this.fechaCreacion = fechaCreacion;
        this.marcaAfectada = marcaAfectada;
        this.correoProveedor = correoProveedor;
		this.correoCustomer = correoCustomer;
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getMarcaAfectada() {
        return marcaAfectada;
    }

    public void setMarcaAfectada(String marcaAfectada) {
        this.marcaAfectada = marcaAfectada;
    }

    public String getCorreoProveedor() {
        return correoProveedor;
    }

    public void setCorreoProveedor(String correoProveedor) {
        this.correoProveedor = correoProveedor;
    }

	public String getCorreoCustomer() {
        return correoCustomer;
    }

    public void setCorreoCustomerr(String correoCustomer) {
        this.correoCustomer = correoCustomer;
    }
}