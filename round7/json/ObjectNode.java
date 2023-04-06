

import java.util.Iterator;
import java.util.TreeMap;

public class ObjectNode extends Node implements Iterable<String> {
    private final TreeMap<String, Node> properties;
    public ObjectNode() {
        this.properties = new TreeMap<>();
    }
    
    public int size() {
        return properties.size();
    }

    public Node get(String key) {
        return properties.get(key);
    }
    
    public void set(String name, Node node) {
        properties.put(name, node);
    }

    @Override
    public Iterator<String> iterator() {
        return properties.keySet().iterator();
    }

}
