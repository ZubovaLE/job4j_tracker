package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        boolean flag = true;
        for (String str: value) {
            rsl++;
            if (str.equals(key)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new ElementNotFoundException("Element is not Found");
        }
        return rsl;
    }
}
