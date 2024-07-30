package com.Keyush.Retrofit;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.util.List;

public class TodoController implements Handler<RoutingContext> {

  private final TodoService todoService;

  public TodoController(Vertx vertx, Router router) {
    todoService = new TodoService();

    router.get("/todos/:id").handler(this::getTodoById);
    router.get("/todos").handler(this::getAllTodos);
  }

  private void getTodoById(RoutingContext context) {
    int id = Integer.parseInt(context.pathParam("id"));
    try {
      Todo todo = todoService.getTodoById(id);
      if (todo != null) {
        context.response()
          .setStatusCode(200)
          .end(Json.encodePrettily(todo));
      } else {
        context.response()
          .setStatusCode(404)
          .end();
      }
    } catch (Exception e) {
      context.response()
        .setStatusCode(500)
        .end("Internal Server Error: " + e.getMessage());
    }
  }

  private void getAllTodos(RoutingContext context) {
    try {
      List<Todo> todos = todoService.getAllTodos();
      context.response()
        .setStatusCode(200)
        .end(Json.encodePrettily(todos));
    } catch (Exception e) {
      context.response()
        .setStatusCode(500)
        .end("Internal Server Error: " + e.getMessage());
    }
  }

  @Override
  public void handle(RoutingContext event) {
    // No-op
  }
}
