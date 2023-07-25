package singleton;

import java.util.HashMap;
import java.util.Map;

public class Caching {

    private  Map<String,String> cacheMap;
    private static Caching caching;

    private Caching(){
        loadCache();
    }
    public static  Caching getInstance(){
        synchronized (Caching.class) {
            if (caching == null) {
                caching=new Caching();
            }
        }
        return caching;
    }

    private  void loadCache() {
        cacheMap= new HashMap<>();
        cacheMap.put("key1","value1");
        cacheMap.put("key2","value1");
        cacheMap.put("key3","value1");
        cacheMap.put("key4","value1");

    }

    public String getValue(String key){
        if(cacheMap.containsKey(key))
            return  cacheMap.get(key);
        return null;

    }
    public void addValue(String key,String value){
        cacheMap.put(key,value);
    }

    public void deleteKey(String key){
        cacheMap.remove(key);
    }

    public boolean hasKey(String key){
        return cacheMap.containsKey(key);
    }
}
