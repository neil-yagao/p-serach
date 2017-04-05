package com.neil.controller;

import com.alibaba.fastjson.JSONObject;
import com.neil.service.MedicalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by nhu on 3/31/2017.
 */
@RestController
public class MedicalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalController.class);
    @Autowired
    private MedicalInfo medicalInfo;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "medical/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public JSONObject medicalInfo(@PathVariable String id){
        LOGGER.debug("query medical info:" + id);
        return medicalInfo.getPrisonMedicalInfo(id);
    }
}
