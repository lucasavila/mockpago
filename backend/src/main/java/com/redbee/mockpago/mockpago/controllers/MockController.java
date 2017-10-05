package com.redbee.mockpago.mockpago.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lucas on 04/10/17.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class MockController {

    private String generarUUID() {

        String uuid = UUID.randomUUID().toString();

        return uuid;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/url", method = RequestMethod.GET, produces = "application/json")
    public Map<String, String> getIdAndUrl() {

        Map mapa = new HashMap<String, String>();
        String uuid = generarUUID();
        String url = "sepdesa.colonseguros.com.ar/mockfront/";
        mapa.put("id", uuid);
        mapa.put("url", url);

        return mapa;
    }

}
