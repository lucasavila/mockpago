package com.redbee.mockpago.mockpago.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment environment;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/url", method = RequestMethod.POST, produces = "application/json")
    public Map<String, String> getIdAndUrl(@RequestBody String jsonEntrada) {
        log.info("jsonEntrada: " + jsonEntrada);
        JSONObject retornoJson = new JSONObject(jsonEntrada);
        log.info("jsonEntrada: " + retornoJson);

        Map rutas = new HashMap<String, String>();

        rutas.put("localhost","http://localhost:9989");
        rutas.put("testing","https://ecommercetest.ecolon.com.ar");
        rutas.put("preprod","https://ecommercepreprod.ecolon.com.ar");

        String server = (String) rutas.get(environment.getActiveProfiles()[0]);

        String uuid = generarUUID();
        String url = server + "/#!/redirect/"+ uuid + "/" + environment.getActiveProfiles()[0];

        Map mapa = new HashMap<String, String>();
        mapa.put("url", url);
        mapa.put("id", uuid);
        return mapa;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/emision", method = RequestMethod.POST, produces = "application/json")
    public String emitir(@RequestBody String jsonEntrada) {
        log.info("jsonEntrada: " + jsonEntrada);
        JSONObject retornoJson = new JSONObject(jsonEntrada);
        log.info("jsonEntrada: " + retornoJson);
        String jsonRespuesta = "{\"payment\":{\"platformId\":7578163,\"internalId\":\"59e0fb760fa4c13c99cdfcc6\",\"externalId\":\"\",\"status\":\"approved\"},\"plan\":{\"platformId\":\"d76790ee9095474cbd18a9593d3012cc\",\"internalId\":\"59e0fb7c0fa4c13c99cdfcc8\",\"externalId\":\"\"},\"subscription\":{\"platformId\":\"9fa6b496954f4f7b930c91514459731f\",\"internalId\":\"59e0fb7d0fa4c13c99cdfcc9\",\"status\":\"authorized\",\"externalReference\":\"4929199484374152\"},\"customer\":{\"platformId\":\"152324733-CNIkMQIAIBA0cS\",\"internalId\":\"59dfbf300fa4c13c99cdfc7a\"}}";
        return jsonRespuesta;
    }


}
