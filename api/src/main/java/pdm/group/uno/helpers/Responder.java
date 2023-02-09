package pdm.group.uno.helpers;

public abstract class Responder {
    public static JsonLike JsonLike() {
        return new JsonLike();
    }

    public static JsonLike message(String message) {
        return JsonLike().add("message", message);
    }

    public static JsonLike data(Object data) {
        return JsonLike().add("data", data);
    }

    public static JsonLike messageWithData(String message, Object data) {
        return message(message).add("data", data);
    }
}
