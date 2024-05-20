package com.cibertec.services;

import com.cibertec.dtos.AutomovilCreateDTO;
import com.cibertec.dtos.AutomovilDTO;
import com.cibertec.dtos.AutomovilUpdateDTO;
import com.cibertec.mappers.AutomovilMappers;
import com.cibertec.model.Automovil;
import com.cibertec.repository.AutomovilRepository;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AutomovilServiceImpl implements AutomovilService{

    private final AutomovilRepository automovilRepository;

    private final TemplateEngine templateEngine;

    public AutomovilServiceImpl(AutomovilRepository automovilRepository,
                                TemplateEngine templateEngine) {
        this.automovilRepository = automovilRepository;
        this.templateEngine = templateEngine;
    }
    @Override
    public List<AutomovilDTO> listarAutomovil() {
        return AutomovilMappers.instancia.listaAutomovilAListaAutomovilDTO(automovilRepository.findAll());
    }

    @Override
    public AutomovilDTO obtenerAutomovilPorID(Integer id) {
        Optional<Automovil> automovil = automovilRepository.findById(id);
        return automovil.map(AutomovilMappers.instancia::automovilAAutomovilDTO).orElse(null);
    }

    @Override
    public AutomovilDTO registrarAutomovil(AutomovilCreateDTO automovilCreateDTO) {
        Automovil automovil = AutomovilMappers.instancia.automovilCreateDTOAAutomovil(automovilCreateDTO);
        Automovil respuestaEntity = automovilRepository.save(automovil);
        return AutomovilMappers.instancia.automovilAAutomovilDTO(respuestaEntity);
    }

    @Override
    public AutomovilDTO actualizarAutomovil(AutomovilUpdateDTO automovilUpdateDTO) {
        Automovil automovil = AutomovilMappers.instancia.automovilUpdateDTOAAutomovil(automovilUpdateDTO);
        Automovil respuestaEntity = automovilRepository.save(automovil);
        return AutomovilMappers.instancia.automovilAAutomovilDTO(respuestaEntity);
    }

    @Override
    public HashMap eliminarAutomovil(Integer id) {
        Optional<Automovil> productoOptional = automovilRepository.findById(id);
        HashMap hashMap = new HashMap();
        if (productoOptional.isPresent()) {
            automovilRepository.delete(productoOptional.get());
            hashMap.put("mensaje", "Registro Eliminado");
        } else {
            hashMap.put("mensaje", "No se pudo realizar la eliminación");
        }
        return hashMap;
    }
    @Override
    public String generarPdftoBase64() {
        List<AutomovilDTO> listaAutomovil = listarAutomovil();

        Context context = new Context();
        context.setVariable("listaAutomovil", listaAutomovil);

        // Generar el HTML del reporte utilizando Thymeleaf
        String htmlContent = templateEngine.process("report-template", context);

        // Convertir el HTML a PDF utilizando html2pdf
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(htmlContent, outputStream, converterProperties);

        // Convertir el PDF a Base64
        byte[] pdfBytes = outputStream.toByteArray();
        String base64Content = Base64.getEncoder().encodeToString(pdfBytes);

        return base64Content;
    }

}