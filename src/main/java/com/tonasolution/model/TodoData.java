package com.tonasolution.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {

    // == fields ==
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    //== constructors ==
    public TodoData() {

        items.add(new TodoItem("Learn java", "Learn java master class", LocalDate.now()));
        items.add(new TodoItem("Learn c++", "Learn c++ master class", LocalDate.now()));
        items.add(new TodoItem("Learn php", "Learn php master class", LocalDate.now()));
    }

    // == public methods ==
    public List<TodoItem> getItems() {

        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem todoItem) {

        todoItem.setId(idValue);
        items.add(todoItem);
        idValue++;
    }

    public void removeItem (int id) {

        ListIterator<TodoItem> iterator = items.listIterator();

        while (iterator.hasNext()) {

            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {

        for (TodoItem item : items) {

            if (item.getId() == id) {

                return item;
            }
        }

        return null;
    }

    public void updateItem(@NonNull TodoItem item) {

        ListIterator<TodoItem> iterator = items.listIterator();

        while (iterator.hasNext()) {

            if (iterator.next().equals(item)) {

                iterator.set(item);
                break;
            }
        }
    }
}


