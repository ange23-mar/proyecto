package com.example.ms_provedores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ms_provedores.dto.DtoResponseProvedor;
import com.example.ms_provedores.modelo.Provedor;
import com.example.ms_provedores.repository.ProvedorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
@RequiredArgsConstructor
public class ProvedorService {
    private final ProvedorRepository provedorRepository;


   
    private DtoResponseProvedor mapToDto(Provedor provedor){
        return new DtoResponseProvedor(
                provedor.getProvedorId(),
                provedor.getRazonSocial(),
                provedor.getRut(),
                provedor.getEmail(),
                provedor.getTelefono(),
                provedor.getEstado()
        );
    }
    
    public List<DtoResponseProvedor> obtenerProvedores() {
        return provedorRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(java.util.stream.Collectors.toList());
    }
    //verifica si el servicio existe
    public Optional<DtoResponseProvedor>obtenerPorId1(Long id) {
        return provedorRepository.findById(id).map(this::mapToDto);
    }    

    public DtoResponseProvedor guardar(DtoResponseProvedor dtoProvedor){
        Provedor provedor = new Provedor(
                dtoProvedor.getProvedorId(),
                dtoProvedor.getRazonSocial(),
                dtoProvedor.getRut(),
                dtoProvedor.getEmail(),
                dtoProvedor.getTelefono(),
                dtoProvedor.getEstado());
        return mapToDto(provedorRepository.save(provedor));
    }

    public Optional<DtoResponseProvedor> actualizar(Long provedorId, DtoResponseProvedor dtoProvedor) {
        return provedorRepository.findById(provedorId).map(provedor -> {
            provedor.setRazonSocial(dtoProvedor.getRazonSocial());
            provedor.setRut(dtoProvedor.getRut());
            provedor.setEmail(dtoProvedor.getEmail());
            provedor.setTelefono(dtoProvedor.getTelefono());
            provedor.setEstado(dtoProvedor.getEstado());
            return mapToDto(provedorRepository.save(provedor));
        });
    }




    public Optional<DtoResponseProvedor> obtenerProvedores(Long provedorId) {
        return provedorRepository.findById(provedorId).map(this::mapToDto);
    }








    public Optional<Provedor> obtenerPorId(Long id) {
        return provedorRepository.findById(id);
    }

    public Provedor guardar(Provedor  provedor) {
        return provedorRepository.save(provedor);
    }

    public void eliminar(Long id) {
        provedorRepository.deleteById(id);
    }
}