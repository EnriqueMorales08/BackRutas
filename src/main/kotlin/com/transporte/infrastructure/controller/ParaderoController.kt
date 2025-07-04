package com.transporte.infrastructure.controller

import com.transporte.application.ParaderoService
import com.transporte.domain.Paradero
import com.transporte.infrastructure.dto.ParaderoDto

import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/api/paraderos")
class ParaderoController(
    private val paraderoService: ParaderoService
) {

   @GetMapping("/cercano")
fun obtenerParaderoMasCercano(
    @RequestParam lat: Double,
    @RequestParam lng: Double,
    @RequestParam rutaId: Long
): ParaderoDto {
    val p = paraderoService.obtenerParaderoMasCercano(lat, lng, rutaId)
    return ParaderoDto(p.id, p.nombre, p.latitud, p.longitud)
}

}
