package com.Keyush.Retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.List;

public class TodoService {

  private final TodoApi todoApi;

  public TodoService() {
    Retrofit retrofit = RetrofitClient.getClient();
    todoApi = retrofit.create(TodoApi.class);
  }

  public List<Todo> getAllTodos() {
    Call<List<Todo>> call = todoApi.getAllTodos();
    try {
      return call.execute().body();
    } catch (Exception e) {
      throw new RuntimeException("Failed to get todos", e);
    }
  }

  public Todo getTodoById(int id) {
    Call<Todo> call = todoApi.getTodoById(id);
    try {
      return call.execute().body();
    } catch (Exception e) {
      throw new RuntimeException("Failed to get todo", e);
    }
  }

}

