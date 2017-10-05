package com.redbee.mockpago.mockpago.controllers;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
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

    private static final Logger log = Logger.getLogger(MockController.class);

    private String generarUUID() {

        String uuid = UUID.randomUUID().toString();

        return uuid;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/url", method = RequestMethod.POST, produces = "application/json")
    public Map<String, String> getIdAndUrl(@RequestBody String jsonEntrada) {
        log.info("jsonEntrada: " + jsonEntrada);
        JSONObject retornoJson = new JSONObject(jsonEntrada);
        log.info("jsonEntrada: " + retornoJson);
        Map mapa = new HashMap<String, String>();
        String uuid = generarUUID();
        String url = "sepdesa.colonseguros.com.ar/mockfront/#!/redirect/"+ uuid;

        mapa.put("url", url);
        mapa.put("id", uuid);
        return mapa;
    }


}
