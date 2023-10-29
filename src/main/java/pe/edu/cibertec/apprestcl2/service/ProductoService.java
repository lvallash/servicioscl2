package pe.edu.cibertec.apprestcl2.service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.cibertec.apprestcl2.model.Producto;
import pe.edu.cibertec.apprestcl2.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(int id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

    public Optional<Producto> obtenerProductoPorNombre(String nombre){
        Optional<Producto> producto = productoRepository.findByNombre(nombre);
        if(producto.isEmpty())
            return  Optional.empty();
        else
            return producto;
    }

    public List<Producto> obtenerProductosPorFiltro(String filtro){
        return productoRepository.filtrarProductosPorNombreSQL(filtro);
    }

    public Producto updateCategory(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}
