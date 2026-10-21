
package com.ejemplo.apividrios.dto;

public record VidrioRequest(
    String referencia,
    String tipo,
    int espesor,
    double precio
) {
}
