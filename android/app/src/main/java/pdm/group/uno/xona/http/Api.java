package pdm.group.uno.xona.http;

import com.fasterxml.jackson.databind.JsonSerializer;

import java.util.List;

import pdm.group.uno.xona.entities.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    // NOTE: On a shared network, the base address should be
    // changed to the host's machine ip address.
    String BASE_URL = "http://127.0.0.1:8080/api/";

    @GET("user")
    Call<List<User>> getUsers();

    @GET("user/{id}")
    Call<User> getUserById(@Path("id") Long userId);

    @POST("user")
    Call<User> createUser(@Body User user);

    @PUT("user/{id}")
    Call<User> updateUser(@Path("id") Long userId, @Body User user);

    @DELETE("user/{id}")
    Call<JsonSerializer.None> deleteUser(@Path("id") Long userId);
}
