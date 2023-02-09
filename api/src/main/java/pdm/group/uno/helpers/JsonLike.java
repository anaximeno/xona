package pdm.group.uno.helpers;

import java.util.HashMap;

public class JsonLike extends HashMap<String, Object> {
    public JsonLike add(String key, Object object) {
        this.put(key, object);
        return this;
    }
}
