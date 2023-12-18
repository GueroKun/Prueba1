package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void testCaso1(){
        Inventario inventario = new Inventario();
        inventario.AgregarProducto(1L, "iphone", "T", 5000, 10);
        assertEquals(1, inventario.productos.size());
    }


    @Test
    public void testCaso2(){
        Inventario inventario = new Inventario();
        inventario.AgregarProducto(1L, "iphone", "T", 5000, 10);
        inventario.ActualizarCantidad(1L, 15);
        for (Producto producto: inventario.productos){
            if (producto.idPro == 1L){
                assertEquals(15, producto.cantidad);
                return;
            }
        }
        fail("No econtrado");
    }

    @Test
    public void testCaso3(){
        Inventario inventario =  new Inventario();
        inventario.AgregarProducto(1L, "iphone", "T", 5000, 10);
        inventario.RealizarVenta(1L, "iphone", 8);
        assertEquals(1, inventario.ventas.size());
    }

    @Test
    public void testCaso4(){
        Inventario inventario = new Inventario();
        inventario.AgregarProducto(1L, "iphone", "T", 5000, 10);
        inventario.RealizarVenta(1L, "iphone", 8);
        for (Producto producto: inventario.productos){
            if (producto.idPro == 1L){
                assertEquals(2, producto.cantidad);
                return;
            }
        }
       fail("No encontrado");
    }
}