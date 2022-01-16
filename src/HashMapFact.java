import java.util.HashMap;
import java.util.Map;

public class HashMapFact {
    Map<String, Database> cache = new HashMap<>();

    public synchronized Database getData(String key){
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        Database dbentity = constructObjectFromDB(key);
        cache.put(dbentity);
        return cache.get(key);
    }
}

//OPTIMIZED CODE OF above here ::
public class HashMapFact {
    Map<String, Database> cache = new HashMap<>();

    public synchronized Database getData(String key){
//        if(cache.containsKey(key)){
//            return cache.get(key);
//        }
        Database database = cache.get(key);
        if(key != null){
            return  database;
        }

        Database dbentity = constructObjectFromDB(key);
        cache.put(dbentity);
        //return cache.get(key);
        return dbentity;
    }
}