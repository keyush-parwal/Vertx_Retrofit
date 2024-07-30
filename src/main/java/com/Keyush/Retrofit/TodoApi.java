package com.Keyush.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface TodoApi {

  @GET("/todos")
  Call<List<Todo>> getAllTodos();

  @GET("/todos/{id}")
  Call<Todo> getTodoById(@Path("id") int id);
}
