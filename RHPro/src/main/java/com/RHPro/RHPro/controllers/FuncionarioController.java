package com.RHPro.RHPro.controllers;


import com.RHPro.RHPro.models.Dependentes;
import com.RHPro.RHPro.models.Funcionario;
import com.RHPro.RHPro.repository.DependentesRepository;
import com.RHPro.RHPro.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository fr;

    @Autowired
    private DependentesRepository dr;

    @RequestMapping(value="/cadastrarFuncionario", method = RequestMethod.GET)
    public String form () {
        return "funcionario/formFuncionario";
    }

    @RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.POST)
    public String form(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {

        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/cadastrarFuncionario";
        }

        fr.save(funcionario);
        attributes.addFlashAttribute("mensagem", "Funcionario cadastrado com sucesso!");
        return "redirect:/cadasrtrarFuncionario";

    }

    //listar os funcionários
    @RequestMapping("/funcionarios")
    public ModelAndView listaFuncionarios() {
        ModelAndView mv = new ModelAndView("funcionario/listaFuncionario");
        Iterable<Funcionario> funcionarios = fr.findAll();
        mv.addObject("funcionarios", funcionarios);
        return mv;
    }

    //listar os dependentes
    @RequestMapping(value = "/dependentes/{id}", method = RequestMethod.GET)
    public ModelAndView dependentes(@PathVariable("id") long id) {
        Funcionario funcionario = fr.findById(id);
        ModelAndView mv = new ModelAndView("funcionario/dependentes");
        mv.addObject("funcionario", funcionario);

        //lista de dependentes de acordo com o funcionario
        Iterable<Dependentes> dependentes = dr.findByFuncionario(funcionario);
        mv.addObject("dependentes", dependentes);

        return mv;
    }

    //adicionar os dependentes
    @RequestMapping(value="/dependentes/{id}", method = RequestMethod.POST)
    public String dependentesPost(@PathVariable("id") long id, Dependentes dependentes, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos.");
            return "redirect:/dependentes/{id}";
        }
        if(dr.findByCpf(dependentes.getCpf()) != null) {
            attributes.addFlashAttribute("mensagem_erro", "CPF duplicado");
            return "redirect:/dependentes/{id}";
        }

        Funcionario funcionario = fr.findById(id);
        dependentes.setFuncionario(funcionario);
        dr.save(dependentes);
        attributes.addFlashAttribute("mensagem", "Dependente adicionado com sucesso!");
        return "redirect:/dependentes/{id}";
    }

}
