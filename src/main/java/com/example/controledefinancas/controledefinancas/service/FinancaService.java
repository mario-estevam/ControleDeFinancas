package com.example.controledefinancas.controledefinancas.service;

import com.example.controledefinancas.controledefinancas.model.Financa;
import com.example.controledefinancas.controledefinancas.repository.FinancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class FinancaService {

    FinancaRepository repository;
    @Autowired
    public void setRepository(FinancaRepository repository) {
        this.repository = repository;
    }

    public void save(Financa financa){
        repository.save(financa);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Financa findById(Long id){
        return repository.getById(id);
    }

    public List<Financa> listAll(){
        return repository.findAll();

    }
    public double getEntradas(){
        double total = 0;
        List<Financa> list = repository.findAll();

        for(var i=0; i<list.size(); i++){
            if(list.get(i).getCategory().equals("Entrada")){
                total+= list.get(i).getAmount();

            }

        }
        return total;
    }
    public double getSaidas(){
        double saida = 0;
        List<Financa> list = repository.findAll();

        for(var i=0; i<list.size(); i++){
            if(list.get(i).getCategory().equals("Saída")){
                saida+= list.get(i).getAmount();
            }

        }
        return saida;

    }

    public double getTotal(){

        double saida = 0;
        double entrada = 0;
        List<Financa> list = repository.findAll();
        for(var i=0; i<list.size(); i++){
            if(list.get(i).getCategory().equals("Entrada")){
                entrada+= list.get(i).getAmount();
            }else{
                saida+= list.get(i).getAmount();

            }


        }
        return entrada-saida;
    }

}