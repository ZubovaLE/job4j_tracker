package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        boolean flag = true;
        for (String str : value) {
            rsl++;
            if (str.equals(key)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new ElementNotFoundException("Element is not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"test", "test2", "test3"}, "test4"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
