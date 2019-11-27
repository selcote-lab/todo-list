package com.tonasolution.service;

import com.tonasolution.model.TodoData;
import com.tonasolution.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem todoItem);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem todoItem);

    TodoData getData();
}
