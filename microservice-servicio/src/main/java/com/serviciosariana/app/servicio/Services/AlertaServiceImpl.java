package com.serviciosariana.app.servicio.Services;

import com.serviciosariana.app.servicio.Model.dto.AlertaDTO;
import com.serviciosariana.app.servicio.Model.dto.ContadorAlertasDTO;
import com.serviciosariana.app.servicio.Repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaServiceImpl implements AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Override
    public Integer generarAutomaticas() {
        return alertaRepository.generarAutomaticas();
    }

    @Override
    public List<AlertaDTO> listarTodos(Integer nPersonalId, Boolean bSoloNoLeidas) {
        return alertaRepository.listarTodos(nPersonalId, bSoloNoLeidas);
    }

    @Override
    public ContadorAlertasDTO contadorNoLeidas(Integer nPersonalId) {
        return alertaRepository.contadorNoLeidas(nPersonalId);
    }

    @Override
    public void marcarLeida(Integer nAlertaId, Integer nUsuarioId) {
        alertaRepository.marcarLeida(nAlertaId, nUsuarioId);
    }

    @Override
    public Integer marcarTodasLeidas(Integer nPersonalId, Integer nUsuarioId) {
        return alertaRepository.marcarTodasLeidas(nPersonalId, nUsuarioId);
    }

    @Override
    public AlertaDTO obtenerPorId(Integer nAlertaId) {
        return alertaRepository.obtenerPorId(nAlertaId)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));
    }

    @Override
    public void marcarResuelta(Integer nAlertaId, Integer nUsuarioId) {
        alertaRepository.marcarResuelta(nAlertaId, nUsuarioId);
    }
}