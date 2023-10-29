package pe.edu.cibertec.apprestcl2.controller;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.apprestcl2.exception.ResourceNotFoundException;
import pe.edu.cibertec.apprestcl2.model.Producto;
import pe.edu.cibertec.apprestcl2.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

        private ProductoService productoService;

        @GetMapping("")
        public ResponseEntity<List<Producto>> listarProductos(){
            List<Producto> productoList = new ArrayList<>();
            productoService.getAllProductos().forEach(productoList::add);
            if(productoList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productoList, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Producto> obtenerProducto(
                @PathVariable("id") Integer id){
            Producto producto = productoService
                    .getProductoById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                            id + " no existe."));

            return new ResponseEntity<>(producto, HttpStatus.OK);
        }

        @PostMapping("")
        public ResponseEntity<Producto> registrarProducto(
                @RequestBody Producto producto
        ){
            return new ResponseEntity<>(
                    productoService.saveProducto(producto), HttpStatus.CREATED
            );
        }

        @PutMapping("/{id}")
        public ResponseEntity<Producto> actualizarProducto(
                @PathVariable("id") Integer id,
                @RequestBody Producto producto
        ){
            Producto oldProducto = productoService
                    .getProductoById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                            id + " no existe."));
            oldProducto.setNombre(producto.getNombre());
            oldProducto.setDescripcion(producto.getDescripcion());
            return new ResponseEntity<>(
                    productoService.saveProducto(oldProducto), HttpStatus.OK
            );
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id") Integer id) {
        Producto producto = productoService.getProductoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. " +
                        id + " no existe."));
        productoService.deleteProducto(id);
        return new ResponseEntity<>("Producto con ID " +
                id + " ha sido eliminado", HttpStatus.OK);
    }

}
