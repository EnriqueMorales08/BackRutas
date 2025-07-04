package com.transporte.infrastructure.controller

import com.transporte.application.RutaService
import com.transporte.domain.Ruta
import com.transporte.infrastructure.dto.CoordenadaDto

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rutas")
class RutaController(
    private val rutaService: RutaService
) {
    @GetMapping("/{id}/coordenadas")
    fun obtenerCoordenadas(@PathVariable id: Long): List<CoordenadaDto> {
        val coordenadas = rutaService.obtenerCoordenadasRuta(id)
        return coordenadas.map { CoordenadaDto(it.latitud, it.longitud) }
    }

    @GetMapping
fun listarRutas(): List<Ruta> {
    return rutaService.listarTodasLasRutas()
}

}




