package com.neil.service;

import com.alibaba.fastjson.JSONObject;
import com.neil.pojo.Medical;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhu on 4/4/2017.
 */
@Service
public class MedicalInfo {

    public JSONObject getPrisonMedicalInfo(String id){
        JSONObject medicalInfo = new JSONObject().fluentPut("id",id);
        medicalInfo.put("img","img/panda.jpg" );
        List<Medical> medicals = new ArrayList<>();
        medicals.add(new Medical("诺氟沙星",2.0));
        medicals.add(new Medical("黄连素",1.0));
        medicalInfo.put("medicals",medicals);
        return medicalInfo;
    }
}
