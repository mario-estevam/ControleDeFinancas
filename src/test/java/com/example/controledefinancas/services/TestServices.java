package com.example.controledefinancas.services;

import com.example.controledefinancas.model.Financa;
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
    private com.example.controledefinancas.repository.FinancaRepository FinancaRepository;

    @InjectMocks
    private com.example.controledefinancas.service.FinancaService FinancaService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllFinanca() {
        List<Financa> FinancaList = new ArrayList<Financa>();
        FinancaList.add(new Financa(1l, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(2l, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(3l, "poupanca", 14.3, "entrada","04/05/2001"));
        when(FinancaRepository.findAll()).thenReturn(FinancaList);
        List<Financa> result = FinancaService.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void saveFinanca() {
        Financa Financa = new Financa(1l, "poupanca", 14.3, "entrada","04/05/2001");
        when(FinancaRepository.save(Financa)).thenReturn(Financa);
        Financa result = FinancaService.save(Financa);
        assertEquals(1l, result.getId());
        assertEquals("poupanca", result.getTitle());
    }

    @Test
    public void removeFinanca() {
        List<Financa> FinancaList = new ArrayList<Financa>();
        FinancaList.add(new Financa(1l, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(2l, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.add(new Financa(3l, "poupanca", 14.3, "entrada","04/05/2001"));
        FinancaList.remove(new Financa(3l, "poupanca", 14.3, "entrada","04/05/2001"));
        when(FinancaRepository.findAll()).thenReturn(FinancaList);
        List<Financa> result = FinancaService.findAll();
        assertEquals(2, result.size());
    }

//    @Test
//    public void testGetFinancaById() {
//        Financa Financa = new Financa(new Financa(1l, "poupanca", 14.3, "entrada","04/05/2001");
//
//    }

}
