package ru.job4j.tracker;

import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by id";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = memTracker.findById(id);
        out.println(Objects.requireNonNullElse(item, "Заявка с введённым id не найдена"));
        return true;
    }
}
