package algorithms.medium.time_based_key_value_store_981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
["TimeMap","set","set","get","get","get","get","get"]
[[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 */
public class TimeMap {
    Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<Pair> list = map.get(key);

        if (list == null) {
            list = new ArrayList<>();
            list.add(new Pair(timestamp, value));
            map.put(key, list);
        } else {
            int i = 0;
            while (i < list.size() && list.get(i).key < timestamp) {
                i++;
            }
            list.add(i, new Pair(timestamp, value));
//            int l = 0, r = list.size() - 1;
//            int mid = 0;
//            while (l <= r) {
//                mid = (l + r) / 2;
//                Pair current = list.get(mid);
//                if (current.key == timestamp) {
//                    current.value = value;
//                    return;
//                } else if (current.key < timestamp) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            list.add(mid, new Pair(timestamp, value));
        }
    }

    public String get(String key, int timestamp) {
        ArrayList<Pair> list = map.get(key);
        if (list == null) return "";
        int l = 0, r = list.size() - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            Pair current = list.get(mid);
            if (current.key == timestamp)
                return list.get(mid).value;
            else if (current.key < timestamp) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (list.get(mid).key < timestamp)
            return list.get(mid).value;
        else return "";
    }

    private static class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        timeMap.get("foo", 5);         // return "bar2"    }
    }
}
