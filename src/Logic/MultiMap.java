package Logic;

import java.util.*;

public class MultiMap<Key,Value> {

    private Map<Key, List<Value>> map;

    /**
     * Creates a new MultiMap.
     */
    public MultiMap() {
        map = new HashMap<>();
    }

    /**
     * @return The number of (key, value) pairs in the MultiMap.
     */
    public int size() {
        int c = 0  ;
        for (Key k : map.keySet() ) {
            c += map.get(k).size();
        }
        return c ;
    }

    /**
     * @return True if the MultiMap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0 ;
    }

    /**
     * Adds the given (key, value) pair to the MultiMap.
     *
     * @param key Key for the new item.
     * @param value New item to add to the MultiMap.
     */
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

    /**
     * Returns all values in the MultiMap for the given key.
     *
     * @param key Key to return all entries for.
     * @return A list of all entries for the given key.
     *         If the key is not in the map, return an empty list.
     */
    public List<Value> get(Key key) {
        if (map.get(key) == null ) {
            return new ArrayList<>();
        } else {
            return map.get(key);
        }
    }

    /**
     * Removes the given (key, value) pair from the MultiMap.
     *
     * @param key Key for the value that should be removed.
     * @param value Value to remove.
     * @return True if removal was successful, false otherwise.
     */
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