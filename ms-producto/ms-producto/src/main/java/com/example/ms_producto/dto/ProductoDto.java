

package com.example.ms_producto.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductoDto {
    private Long productoId;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String nombre;



    @NotBlank(message = "El estado es obligatorio")
    private String sku;

    @NotBlank(message = "El estado es obligatorio")
    private int precio;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

}
