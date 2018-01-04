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
        String jsonRespuesta = "{\"payment\":{\"platformId\":9624304,\"internalId\":\"5a427202f1ffef5c5a966105\",\"externalId\":\"\",\"status\":\"approved\"},\"customer\":{\"platformId\":\"279730978-HmsQRzJzcIliBW\",\"internalId\":\"59ee51444624cc19c072136f\"},\"subscription\":{\"internalId\":\"5a427200f1ffef5c5a966104\",\"externalId\":\"4539450328864110\"},\"insurance\":{\"PolNum\":2342,\"result\":{\"Cnlcomextcod\":16,\"Cnlsubcomextcod\":\"1\",\"Cnlcomlinemi\":\"41\",\"Nrocotizacion\":null,\"Emisionsdt\":{\"EmpCod\":\"C\",\"SucCod\":\"CC\",\"ArtCod\":2310,\"SpolNum\":731,\"SpolSspoNum\":\"0\",\"RamCod\":\"23\",\"CertNum\":656,\"PolNum\":2342,\"EndNum\":0,\"SpolNumRef\":0,\"TipOpCod\":\"1\",\"TipOpSt\":\"4\",\"MonCod\":\"1\",\"OpDetFecEmi\":\"2017-11-30T00:00:00.000Z\",\"OpFecIniVig\":\"2017-12-26T00:00:00.000Z\",\"OpFecFinVig\":\"2018-04-26T00:00:00.000Z\",\"OpDetFecHasFac\":\"2018-04-26T00:00:00.000Z\",\"OpeDafCod\":253901,\"VendIntTip\":\"1\",\"VendInt1Cod\":110,\"Prima\":\"430.24\",\"Premio\":\"533.98\",\"Comisiones\":\"0.00\",\"SumaAsegurada\":\"6000000.00\",\"FechaAlta\":\"2017-12-26T00:00:00.000Z\",\"Usuario\":\"PORTALPROD\"},\"Sehpdisdt\":{\"wscolSehPdiSDT.Item\":[{\"TipOpPrt\":\"P\",\"EmpCod\":\"C\",\"SucCod\":\"CC\",\"ArtCod\":2310,\"SpolNum\":731,\"SpolSspoNum\":\"0\",\"ParPlaCod\":\"CG\"},{\"TipOpPrt\":\"P\",\"EmpCod\":\"C\",\"SucCod\":\"CC\",\"ArtCod\":2310,\"SpolNum\":731,\"SpolSspoNum\":\"0\",\"ParPlaCod\":\"CM\"},{\"TipOpPrt\":\"P\",\"EmpCod\":\"C\",\"SucCod\":\"CC\",\"ArtCod\":2310,\"SpolNum\":731,\"SpolSspoNum\":\"0\",\"ParPlaCod\":\"FA\"},{\"TipOpPrt\":\"P\",\"EmpCod\":\"C\",\"SucCod\":\"CC\",\"ArtCod\":2310,\"SpolNum\":731,\"SpolSspoNum\":\"0\",\"ParPlaCod\":\"PO\"}]},\"Coderror\":\"0\",\"Descerror\":\"\"}}}";
        return jsonRespuesta;
    }


}
