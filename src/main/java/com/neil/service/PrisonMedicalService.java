package com.neil.service;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.neil.pojo.PrisonMedicalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhu on 4/9/2017.
 */
@Service
public class PrisonMedicalService {

    @Autowired
    private MongoTemplate template;

    public List<PrisonMedicalInfo> getPrisonMedicalInfo(String code){
        DBCollection prisonMedicalCollection = template.getCollection("inmate-medical");
        DBCursor cursor = prisonMedicalCollection.find(new BasicDBObject("code", code));
        List<PrisonMedicalInfo> medicalInfoList = new ArrayList<>();
        while(cursor.hasNext()){
            medicalInfoList.add(new JSONObject(cursor.next().toMap()).toJavaObject(PrisonMedicalInfo.class));

        }
        return medicalInfoList;
    }

    public void insertInmateMedicalInfo(List<PrisonMedicalInfo> prisonMedicalInfos){
        DBCollection inmateMedical = template.getCollection("inmate-medical");
        for(PrisonMedicalInfo pmi: prisonMedicalInfos){
            JSONObject mapPmi = (JSONObject) JSONObject.toJSON(pmi);
            inmateMedical.update(new BasicDBObject("code", pmi.getCode()).append("medical", pmi.getMedical()),
                    new BasicDBObject(mapPmi), true,false );

        }
    }
}
