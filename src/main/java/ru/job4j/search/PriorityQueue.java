package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private final LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     *
     * @param task задача
     */
    public void put(Task task) {
        var index = 0;
        for (var element : tasks) {
            if (element.getPriority() <= task.getPriority()) {
                index++;
            } else {
                break;
            }
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
