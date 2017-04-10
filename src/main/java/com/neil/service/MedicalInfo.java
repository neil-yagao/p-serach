package com.neil.service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.neil.pojo.Medical;
import com.neil.pojo.MedicalList;
import com.neil.pojo.PrisonMedicalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhu on 4/4/2017.
 */
@Service
public class MedicalInfo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public JSONObject getPrisonMedicalInfo(String id){
        JSONObject medicalInfo = new JSONObject().fluentPut("id",id);
        medicalInfo.put("img","img/panda.jpg" );
        List<Medical> medicals = new ArrayList<>();
        medicals.add(new Medical("诺氟沙星",2.0));
        medicals.add(new Medical("黄连素",1.0));
        medicalInfo.put("medicals",medicals);
        return medicalInfo;
    }

    /**
     * System will add num if record existed
     * otherwise create new record
     * */
    public void insertOrUpdateMedicalInfo(List<Medical> medicalInfo){
        DBCollection medicals = mongoTemplate.getCollection("medicals");
        for(Medical medical: medicalInfo ){
            medicals.update(new BasicDBObject("name", medical.getName()),
                    new BasicDBObject("$inc", new BasicDBObject("num", medical.getNum())), true, false);
        }
    }

    public MedicalList getMedicals() {
        DBCollection medicals = mongoTemplate.getCollection("medicals");
        DBCursor cursor = medicals.find();
        MedicalList list = new MedicalList();
        while (cursor.hasNext()){
            DBObject data = cursor.next();
            Medical medical = new JSONObject(data.toMap()).toJavaObject(Medical.class);
            list.add(medical);
        }
        return list;
    }


}
