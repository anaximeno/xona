package pdm.group.uno.helpers;

import java.util.HashMap;

public abstract class Responder {
    public static HashMap<String, Object> newResponse() {
        return new HashMap<String , Object>();
    }

    public static HashMap<String, Object> message(String message) {
        final HashMap<String, Object> msg = newResponse();

        msg.put("message", message);

        return msg;
    }

    public static HashMap<String, Object> messageWithData(String message, Object data) {
        final HashMap<String, Object> msg = message(message);

        msg.put("data", data);

        return msg;
    }

    public static HashMap<String, Object> data(Object data) {
        final HashMap<String, Object> d = newResponse();

        d.put("data", data);

        return d;
    }
}
