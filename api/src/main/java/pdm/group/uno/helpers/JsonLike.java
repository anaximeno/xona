package pdm.group.uno.helpers;

import java.util.HashMap;

public class JsonLike extends HashMap<String, Object> {
    public JsonLike add(String key, Object object) {
        this.put(key, object);
        return this;
    }

    public static JsonLike from(String key, Object obj) {
        return (new JsonLike()).add(key, obj);
    }

    public static JsonLike message(String message) {
        return JsonLike.from("message", message);
    }

    public static JsonLike data(Object data) {
        return JsonLike.from("data", data);
    }

    public static JsonLike messageWithData(String message, Object data) {
        return message(message).add("data", data);
    }
}
