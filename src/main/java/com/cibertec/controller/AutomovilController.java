package com.cibertec.controller;

import com.cibertec.dtos.AutomovilCreateDTO;
import com.cibertec.dtos.AutomovilDTO;
import com.cibertec.dtos.AutomovilUpdateDTO;
import com.cibertec.services.AutomovilService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AutomovilController {
    private final AutomovilService automovilService;
    public AutomovilController(AutomovilService automovilService){
        this.automovilService=automovilService;
    }

    @Operation(summary = "Endpoint que  permite listar los automovil", description = "Endpoint que  permite listar los automovil")
    @GetMapping("automovil")
    public ResponseEntity<List<AutomovilDTO>> listarAutomovil(){
        return   new ResponseEntity<>(automovilService.listarAutomovil(), HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que  permite obtener un automovil por ID", description = "Endpoint que  permite obtener un automovil por ID")
    @GetMapping("/automovil/{automovilId}")
    public ResponseEntity<AutomovilDTO> obtenerAutomovilPorId(@PathVariable("automovilId") Integer automovilId){
        return  new ResponseEntity<> ( automovilService.obtenerAutomovilPorID(automovilId),HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que  permite registrar un nuevo automovil", description = "Endpoint que  permite registrar un nuevo automovil")
    @PostMapping("automovil")
    public ResponseEntity<AutomovilDTO> registrarAutomovil(@RequestBody AutomovilCreateDTO automovilCreateDTO){
        return  new ResponseEntity <>( automovilService.registrarAutomovil(automovilCreateDTO) ,HttpStatus.OK) ;
    }

    @Operation(summary = "Endpoint que  permite actualizar un automovil existente", description = "Endpoint que  permite actualizar un automovil existente")
    @PutMapping("automovil")
    public ResponseEntity<AutomovilDTO> actualizarAutomovil(@RequestBody AutomovilUpdateDTO automovilUpdateDTO){
        return new ResponseEntity<>(automovilService.actualizarAutomovil(automovilUpdateDTO),HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que  permite eliminar un automovil por ID", description = "Endpoint que  permite eliminar un automovil por ID")
    @DeleteMapping("/automovil/{automovilId}")
    public ResponseEntity<?> eliminarAutomovil(@PathVariable("automovilId") Integer automovilId) {
        return new ResponseEntity<>( automovilService.eliminarAutomovil(automovilId),HttpStatus.OK);
    }

    @Operation(summary = "Endpoint que  permite generar reporte de automovil", description = "Endpoint que  permite generar reporte de automovil")
    @GetMapping("/automovil/reporte")
    public ResponseEntity<String> generateReportBase64() throws Exception {
        return   new ResponseEntity<> (automovilService.generarPdftoBase64(),HttpStatus.OK);
    }
}
