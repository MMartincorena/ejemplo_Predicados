package co.com.sofka.App;

public class Factura {
    String descripcion;
    int precio;

    //Agregados
    int codigo;
    int cantidad;
    String fecha;


    Factura(String descripcion,int precio, int codigo, int cantidad, String fecha){
        this.descripcion=descripcion;
        this.precio=precio;

        this.codigo = codigo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    int getImporte(){
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }
    /* Se generan los getters necesarios de cada atributo */
    public int getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }

}
