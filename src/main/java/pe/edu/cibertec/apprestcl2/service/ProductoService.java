package pe.edu.cibertec.apprestcl2.service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.cibertec.apprestcl2.model.Producto;
import pe.edu.cibertec.apprestcl2.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto saveCategory(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> getAllCategories() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getCategoryById(int categoryId) {
        return productoRepository.findById(categoryId);
    }

    public Producto updateCategory(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteCategory(int id) {
        productoRepository.deleteById(id);
    }
}
