package com.example.controledefinancas.controller;


import com.example.controledefinancas.model.Financa;
import com.example.controledefinancas.service.FinancaService;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;


@Controller
public class FinancaController {
    FinancaService service;

    @Autowired
    public void setService(FinancaService service) {
        this.service = service;
    }


    @RequestMapping(value ={"/","/dashboard"} , method = RequestMethod.GET)
    public String getDashboard(Model model){
        var listInputsAndOutpus = service.findAll();
        model.addAttribute("Listfinanca", listInputsAndOutpus);

        Financa financa = new Financa();
        model.addAttribute("Rfinanca", financa);

        var entradas = service.getEntradas();
        model.addAttribute("entrada", entradas);

        var saidas = service.getSaidas();
        model.addAttribute("saida", saidas);

        var total = service.getTotal();
        model.addAttribute("total", total);



        return "dashboard";
    }

    @RequestMapping("/cadastro")
    public String getFormCadastro(Model model){
        Financa financa = new Financa();
        model.addAttribute("Rfinanca", financa);
        return "dashboard";
    }
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String Salvar (@ModelAttribute Financa financa){
        service.save(financa);
        return "redirect:/";
    }
    @RequestMapping("/deletar/{id}")
    public String deletar( @PathVariable(name = "id") Integer id){

        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView getFormEdit(@PathVariable(name="id") Integer id){
        ModelAndView modelAndView = new ModelAndView("editar");
        Financa financa = service.findById(id);
        modelAndView.addObject("formFinanca", financa);
        return modelAndView;

    }
}