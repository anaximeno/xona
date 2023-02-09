package pdm.group.uno.helpers;

public abstract class Responder {
    public static JsonLike newResponse() {
        return new JsonLike();
    }

    public static JsonLike message(String message) {
        final JsonLike msg = newResponse();

        msg.put("message", message);

        return msg;
    }

    public static JsonLike messageWithData(String message, Object data) {
        final JsonLike msg = message(message);

        msg.put("data", data);

        return msg;
    }

    public static JsonLike data(Object data) {
        final JsonLike d = newResponse();

        d.put("data", data);

        return d;
    }
}
