package com.serviceLocator;
import java.util.HashMap;
import java.util.Map;
import com.external.ScoreComp;
import com.external.ScoreCompImpl;
public class ScoreCompServiceLocator {
    private static Map<String,ScoreComp> cache = new HashMap<>();

    public ScoreComp getService(){
        if(!cache.containsKey("icc")){
            cache.put("icc",new ScoreCompImpl());
        }
        return cache.get("icc");
    }
}
