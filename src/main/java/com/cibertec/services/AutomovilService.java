package com.cibertec.services;

import com.cibertec.dtos.AutomovilCreateDTO;
import com.cibertec.dtos.AutomovilDTO;
import com.cibertec.dtos.AutomovilUpdateDTO;

import java.util.HashMap;
import java.util.List;

public interface AutomovilService {

    List<AutomovilDTO> listarAutomovil();
    AutomovilDTO obtenerAutomovilPorID(Integer id);
    AutomovilDTO registrarAutomovil(AutomovilCreateDTO automovilCreateDTO);
    AutomovilDTO actualizarAutomovil(AutomovilUpdateDTO automovilUpdateDTO);
    HashMap eliminarAutomovil(Integer id);

    String generarPdftoBase64();
}
