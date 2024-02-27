import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tickets") // Indica que esta entidad debe ser almacenada en la colección "tickets" de MongoDB
public class Ticket {
    @Id
    private String id;
    private String estado;
    private String url;
    private Date fechaCreacion;
    private String marcaAfectada;
    private String correoProveedor;
    private String correoCliente; // Nuevo campo para el correo de la marca afectada

    public Ticket() {
        // Constructor por defecto
    }

    public Ticket(String estado, String url, Date fechaCreacion, String marcaAfectada, String correoProveedor, String correoCliente) {
        this.estado = estado;
        this.url = url;
        this.fechaCreacion = fechaCreacion;
        this.marcaAfectada = marcaAfectada;
        this.correoProveedor = correoProveedor;
        this.correoCliente = correoCliente;
    }

    // Getters y setters para todos los campos

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

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}