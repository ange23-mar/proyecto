package com.example.ms_producto.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ms_producto.modelo.Producto;
import com.example.ms_producto.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    @Override
    public void run(String... args) {
        if (productoRepository.count() > 0) {
            log.info(">>> DataInitializer: la BD ya tiene datos, se omite la carga.");
            return;
        }

        log.info(">>> DataInitializer: Insertando productos de prueba...");

        // Usamos el constructor con Long al final para categoriaId
        productoRepository.save(new Producto(null, "Laptop Gamer", "SKU001", 12000, "ACTIVO"));
        productoRepository.save(new Producto(null, "Mouse Inalámbrico", "SKU002", 2550, "ACTIVO"));
        productoRepository.save(new Producto(null, "Polera Algodón", "SKU003", 1500, "ACTIVO"));

        log.info(">>> DataInitializer: Productos insertados con éxito.");
    }
}