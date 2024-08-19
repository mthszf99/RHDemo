package com.RHDemo.RHDemo.controllers;


import com.RHDemo.RHDemo.models.Vaga;
import com.RHDemo.RHDemo.repository.CandidatoRepository;
import com.RHDemo.RHDemo.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VagaController {

    private VagaRepository vr;
    private CandidatoRepository cr;

    //GET CADASTRAR A VAGA
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form() {
        return "templates.vaga/formVaga";
    }

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "verifique os campos");
            return "redirect:/cadastarVaga";
        }
        vr.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
        return "redirect:/cadastrarVaga";
    }

}
