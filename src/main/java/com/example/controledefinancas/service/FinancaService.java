package com.example.controledefinancas.service;

import com.example.controledefinancas.model.Financa;
import com.example.controledefinancas.repository.FinancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FinancaService {

    FinancaRepository repository;
    @Autowired
    public void setRepository(FinancaRepository repository) {
        this.repository = repository;
    }

    public Financa save(Financa f){
        repository.save(f);
        return f;
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }



    public Financa findById(Integer id){
        return repository.getById(id);
    }

    public List<Financa> findAll(){
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