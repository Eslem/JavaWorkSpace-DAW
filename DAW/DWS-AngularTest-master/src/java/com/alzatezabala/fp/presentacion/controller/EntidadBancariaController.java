/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alzatezabala.fp.presentacion.controller;

import com.alzatezabala.fp.persistencia.EntidadBancariaDAO;
import com.alzatezabala.fp.persistencia.impl.EntidadBancariaDAOImplDataSource;
import com.alzatezabala.fp.pojo.EntidadBancaria;
import com.alzatezabala.fp.presentacion.json.JSONConverterImplJackson;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author eslem
 */
@Controller
public class EntidadBancariaController {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @RequestMapping(value = {"/EntidadBancaria"})
    public void prueba(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {
        String jsonString = new JSONConverterImplJackson().toJSON(entidadBancariaDAO.findAll());
        httpServletResponse.getWriter().println(jsonString);
    }

    @RequestMapping(value = {"/EntidadBancaria/{id}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int idEntidad) throws IOException {

        String jsonResponse = new JSONConverterImplJackson().toJSON(entidadBancariaDAO.get(idEntidad));
        httpServletResponse.getWriter().println(jsonResponse);
    }

    @RequestMapping(value = {"/EntidadBancaria/{id}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int idEntidad) throws IOException {
        if (entidadBancariaDAO.delete(idEntidad)) {
            httpServletResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }
    
    @RequestMapping(value = {"/EntidadBancaria/"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json){
        EntidadBancaria entidadBancaria = (EntidadBancaria) new JSONConverterImplJackson().fromJSON(json, EntidadBancaria.class);
        entidadBancariaDAO.insert(entidadBancaria);
    }
    
    

}
