package co.com.sofka.App;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class App {

    //Objetos con el agregado de los nuevos atributos
    public static void main(String[] args) {
        Factura f=new Factura("ordenador",1000, 1, 10,"16/03/2022");
        Factura f2=new Factura("movil",300, 2, 20, "20/02/2022");
        Factura f3=new Factura("impresora",200, 3, 30,"01/01/2022");
        Factura f4=new Factura("imac",1500, 5, 25, "06/02/2022");

        List<Factura> lista= new ArrayList<Factura>();

        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("iteracion ");
                return t.getImporte()>300;
            }
        };

        // PREDICADOS AGREGADOS

        /**Predicado para filtro de Fecha menor que, utilizando la función de fecha "isBefore()" */
        Predicate<Factura> predicadoFechaMenor = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("iteracion ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

                //procesando formatos de fechas para la comparación
                LocalDate fechaFactura = LocalDate.parse(t.getFecha(), formatter);
                LocalDate localDate = LocalDate.parse("15/02/2022", formatter);

                return fechaFactura.isBefore(localDate);
            }
        };

        /**Predicado para filtro de Fecha mayor que, utilizando la función de fecha "isAfter()" */
        Predicate<Factura> predicadoFechaMayor = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("iteracion ");

                //procesando formatos de fechas para la comparación
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                LocalDate fechaFactura = LocalDate.parse(t.getFecha(), formatter);
                LocalDate localDate = LocalDate.parse("01/01/2022", formatter);

                return fechaFactura.isAfter(localDate);
            }
        };

        /**Predicado para filtro de factura con determinada cantidad ingresada */
        Predicate<Factura> predicadoPorCantidad= new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("iteracion ");


                return t.getCantidad() == 20;
            }
        };

        Factura facturaFiltro= lista.stream()
                .filter(predicado).findFirst().get();
        System.out.println("FACTURA UNICA "+facturaFiltro.getImporte());

//=====> Mostrando agregados nuevos <=====

//Mostrando resultado de filtro por fecha menor que
        Factura facturaFiltroFechaMenor= lista.stream()
                .filter(predicadoFechaMenor).findFirst().get();

        System.out.println("FACTURA UNICA - Menor a X Fecha" + "\n" +
                facturaFiltroFechaMenor.getDescripcion() + "\n" +
                facturaFiltroFechaMenor.getImporte() + "\n" +
                facturaFiltroFechaMenor.getFecha());

//Mostrando resultado de filtro por fecha mayor que
        Factura facturaFiltroFechaMayor= lista.stream()
                .filter(predicadoFechaMayor).findFirst().get();

        System.out.println("FACTURA UNICA - Mayor a X Fecha" + "\n" +
                facturaFiltroFechaMayor.getDescripcion() + "\n" +
                facturaFiltroFechaMayor.getImporte() + "\n" +
                facturaFiltroFechaMayor.getFecha());

//Mostrando resultado de filtro por cantidad de un producto.
        Factura facturaFiltroXCantidad= lista.stream()
                .filter(predicadoPorCantidad).findFirst().get();

        System.out.println("FACTURA UNICA - Mayor a X Fecha" + "\n" +
                facturaFiltroFechaMayor.getDescripcion() + "\n" +
                facturaFiltroFechaMayor.getImporte() + "\n" +
                facturaFiltroFechaMayor.getFecha());

        /*
        Factura facturaFiltro=lista.stream()
                .filter(elemento->elemento.getImporte()>300)
                .findFirst()
                .get();
        System.out.println(facturaFiltro.getImporte());
        */
    }
}
