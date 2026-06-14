package com.example.kardex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kardex.dto.MovimientoRequestDTO;
import com.example.kardex.dto.MovimientoResponseDTO;
import com.example.kardex.dto.StockResponseDTO;
import com.example.kardex.service.KardexService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/kardex")
public class KardexController {

    public KardexController(KardexService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "ms-kardex funcionando";
    }

    private final KardexService service;

    @PostMapping("/movimiento")
    public ResponseEntity<MovimientoResponseDTO> registrarMovimiento(@Valid @RequestBody MovimientoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarMovimiento(dto));
    }

    @GetMapping("/stock/producto/{productoId}/bodega/{bodegaId}")
    public ResponseEntity<StockResponseDTO> obtenerStock(@PathVariable Long productoId, @PathVariable Long bodegaId) {
        return ResponseEntity.ok(service.obtenerStock(productoId, bodegaId));
    }
}