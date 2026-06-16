package com.example.ms_provedores.confing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ms_provedores.modelo.Provedor;
import com.example.ms_provedores.repository.ProvedorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProvedorRepository provedorRepository;
     @Override
    public void run(String... args) {
        if (provedorRepository.count() > 0) {
            log.info(">>> DataInitializer: la BD ya tiene datos, se omite la carga.");
            return;
        }

        log.info(">>> DataInitializer: Insertando provedores de prueba...");

        // Usamos el constructor con Long al final para categoriaId
        provedorRepository.save(new Provedor(null, "Importadora del Sur S.A", 187648372, "Ang@gmail.com",98768763,"Disponible"));
        provedorRepository.save(new Provedor(null, "Servicios y Asesorías del Sur SpA", 187648373, "Proveedor2@gmail.com",98768764,"Disponible"));
        provedorRepository.save(new Provedor(null, "Empresa Individual de Responsabilidad Limitada", 187648374, "Proveedor3@gmail.com",98768765,"Disponible"));

        log.info(">>> DataInitializer: Provedores insertados con éxito.");
    }


}