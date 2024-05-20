package com.cibertec.mappers;

import com.cibertec.dtos.AutomovilCreateDTO;
import com.cibertec.dtos.AutomovilDTO;
import com.cibertec.dtos.AutomovilUpdateDTO;
import com.cibertec.model.Automovil;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutomovilMappers {
    AutomovilMappers instancia= Mappers.getMapper(AutomovilMappers.class);

    AutomovilDTO automovilAAutomovilDTO(Automovil automovil);
    Automovil automovilDTOAAutomovil(AutomovilDTO automovilDTO);
    Automovil automovilCreateDTOAAutomovil(AutomovilCreateDTO automovilCreateDTO);
    Automovil automovilUpdateDTOAAutomovil(AutomovilUpdateDTO automovilUpdateDTO);
    List<AutomovilDTO> listaAutomovilAListaAutomovilDTO (List<Automovil> listaAutomovil);
}