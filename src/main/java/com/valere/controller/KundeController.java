package com.valere.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valere.entities.Kunde;
import com.valere.pdfexport.KundePDFExporter;
import com.valere.services.KundeService;

import lombok.Data;

@Named
@ViewScoped
@Data
@Controller
public class KundeController {
 
    @Autowired
    private KundeService service;
    
    @RequestMapping("/*")
    public String viewHomePage(Model model) {
        List<Kunde> listkunden = service.listAll();
        model.addAttribute("listKunden", listkunden);
         
        return "layout.jsf";
    }
    
   
    @RequestMapping("/new")
    public String showNewKundePage(Model model) {
        Kunde kunde = new Kunde();
        model.addAttribute("kunde", kunde);
         
        return "kunde-form.jsf";
    }
        
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveKunde(@ModelAttribute("kunde") Kunde kunde) {
        service.save(kunde);
         
        return "layout.xhtml?faces-redirect=true";
    }
    
    @RequestMapping(value = "/export")
    public void exportToPDF(HttpServletResponse response) throws  IOException, com.itextpdf.text.DocumentException, DocumentException{
    	response.setContentType("application/pdf");
    	
    	DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
    	String currentTime = dateFormatter.format(new Date());
    	
    	String headerkey = "Content-Disposition";
    	String headervalue = "attachment; filename=kunde_" + currentTime + ".pdf";
    	
    	response.setHeader(headerkey, headervalue);
    	
    	List<Kunde> listKunden =  service.listAll();
    	
    	KundePDFExporter exporter = new KundePDFExporter(listKunden);
    	exporter.export(response);
    }
}