package com.example.controledefinancas.controledefinancas.services;

import com.example.controledefinancas.controledefinancas.model.Financa;
import com.example.controledefinancas.controledefinancas.repository.FinancaRepository;
import com.example.controledefinancas.controledefinancas.service.FinancaService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestServices {

    @Mock
    private com.example.controledefinancas.controledefinancas.repository.FinancaRepository FinancaRepository;

    @InjectMocks
    private com.example.controledefinancas.controledefinancas.service.FinancaService FinancaService;

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
        System.out.println(FinancaRepository.findAll());

    }

}
