package com.example.controledefinancas.services;

import com.example.controledefinancas.model.Financa;
import com.example.controledefinancas.repository.FinancaRepository;
import com.example.controledefinancas.service.FinancaService;
import org.junit.Before;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TestServices {

    @Mock
    private FinancaRepository financaRepository;

    @InjectMocks
    private FinancaService financaService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllFinanca() {
        List<Financa> FinancaList = new ArrayList<Financa>();
        FinancaList.add(new Financa(1, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(2, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(3, "poupanca", 14.3, "entrada","04/05/2001"));
        when(financaRepository.findAll()).thenReturn(FinancaList);
        List<Financa> result = financaService.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void saveFinanca() {
        Financa Financa = new Financa(1, "poupanca", 14.3, "entrada","04/05/2001");
        when(financaRepository.save(Financa)).thenReturn(Financa);
        Financa result = financaService.save(Financa);
        assertEquals(1, result.getId());
        assertEquals("poupanca", result.getTitle());
    }

    @Test
    public void removeFinanca() {
        List<Financa> FinancaList = new ArrayList<Financa>();
        FinancaList.add(new Financa(1, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(2, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(3, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.remove(new Financa(3, "poupanca", 14.3, "entrada","04/05/2001"));
        when(financaRepository.findAll()).thenReturn(FinancaList);
        List<Financa> result = financaService.findAll();
        assertEquals(2, result.size());
    }

//    @Test
//    public void testGetFinancaById() {
//        Financa Financa = new Financa(new Financa(1l, "poupanca", 14.3, "entrada","04/05/2001");
//
//    }

}
