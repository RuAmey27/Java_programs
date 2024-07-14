package OS_project;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    public LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }
}

class LRUPageReplacementAlgorithm {
    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>();

        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);
        lruCache.put(4, 40);

        System.out.println("LRU Cache: " + lruCache.keySet());

        lruCache.get(2);
        System.out.println("After accessing page 2: " + lruCache.keySet());

        lruCache.put(5, 50);
        System.out.println("After adding page 5: " + lruCache.keySet());

        // Output:
        // LRU Cache: [3, 4, 2]
        // After accessing page 2: [3, 4, 2]
        // After adding page 5: [4, 2, 5]
    }
}
