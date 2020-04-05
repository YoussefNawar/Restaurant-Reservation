package Logic;

import java.util.*;

public class MultiMap<Key,Value> {

    private Map<Key, List<Value>> map;

    public MultiMap() {
        map = new HashMap<>();
    }

    public int size() {
        int c = 0  ;
        for (Key k : map.keySet() ) {
            c += map.get(k).size();
        }
        return c ;
    }

    public boolean isEmpty() {
        return size() == 0 ;
    }

    public void put(Key key, Value value) {
        List<Value> l = map.get(key);
        if ( l == null ) {
            List<Value> list = new ArrayList<>();
            list.add(value);
            map.put(key,list);
        } else {
            l.add(value);
        }
    }

    public List<Value> get(Key key) {
        if (map.get(key) == null ) {
            return new ArrayList<>();
        } else {
            return map.get(key);
        }
    }

    public boolean remove(Key key, Value value) {
        List<Value> l = map.get(key);
        if (l == null )
            return false;
        if (l.contains(value)) {
            for (int i = 0 ; i < l.size() ; i ++ ) {
                if (l.get(i) == value) {
                    l.remove(i);
                    return true;
                }
            }
        }

        return false;
    }
}