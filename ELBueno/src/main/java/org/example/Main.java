package org.example;

import java.util.ArrayList;
import java.util.List;

class Producto{
    Long idPro;
   String nombre;
   String categoria;
   int precio;
   int cantidad;


    public Producto(Long idPro, String nombre, String categoria, int precio, int cantidad) {
        this.idPro = idPro;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}

class Venta{
    Long idVen;
    String nombreProducto;
    int cantidadVendida;

    public Venta(Long idVen, String nombreProducto, int cantidadVendida) {
        this.idVen = idVen;
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
    }
}

class Inventario {
    List<Producto> productos;
    List<Venta> ventas;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public void AgregarProducto(Long idPro, String nombre, String categoria, int precio, int cantidad) {
        Producto producto = new Producto(idPro, nombre, categoria, precio, cantidad);
        productos.add(producto);
        System.out.println("Producto agregado: " + nombre);
    }

    public void ActualizarCantidad(Long idProAct, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.idPro == idProAct) {
                producto.cantidad = nuevaCantidad;
                System.out.println("Se actualizo la cantidad a: " + nuevaCantidad);
                return;
            }
        }
    }

    public void RealizarVenta(Long idPro, String nombreProducto, int cantidadVendida) {
        for (Producto producto : productos) {
            if (producto.idPro == idPro) {
                if (producto.cantidad >= cantidadVendida) {
                    Venta venta = new Venta(idPro, nombreProducto, cantidadVendida);
                    ventas.add(venta);
                    System.out.println("Venta realizada");
                   producto.cantidad = producto.cantidad - cantidadVendida;
                    return;
                } else {
                    System.out.println("No hay suficiente");
                }
            } else {
                System.out.println("No encontrado ");
            }
        }
    }

    public void ConsultarInventario() {
        System.out.println("INVENTARIO:");
        for (Producto producto : productos) {
            System.out.println("ID:" + producto.idPro + ", Nombre: " + producto.nombre +
                    ", categoria: " + producto.categoria + ", precio: " + producto.precio + ", cantidad: " + producto.cantidad);
        }
    }

    public void VentasRealizadas() {
        System.out.println("VENTAS;");
        for (Venta venta : ventas) {
            System.out.println("ID: " + venta.idVen + ", Nombre:  " + venta.nombreProducto +
                    ", cantidad: " + venta.cantidadVendida);
        }
    }
}

public class Main {
    public static void main(String[] args) {
          Inventario inventario = new Inventario();

          inventario.AgregarProducto(1L, "iphone", "T", 1000, 10);

          inventario.ConsultarInventario();

          inventario.RealizarVenta(1L, "iphone", 8);

          inventario.VentasRealizadas();

        inventario.ConsultarInventario();
    }
}



