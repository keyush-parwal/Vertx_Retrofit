package com.Keyush.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Todo {

  @SerializedName("userId")
  private int userId;

  @SerializedName("id")
  private int id;

  @SerializedName("title")
  private String title;

  @SerializedName("completed")
  private boolean completed;

  // Getters and Setters
  public int getUserId() { return userId; }
  public void setUserId(int userId) { this.userId = userId; }

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public boolean isCompleted() { return completed; }
  public void setCompleted(boolean completed) { this.completed = completed; }

  @Override
  public String toString() {
    return "Todo{" +
      "userId=" + userId +
      ", id=" + id +
      ", title='" + title + '\'' +
      ", completed=" + completed +
      '}';
  }
}
