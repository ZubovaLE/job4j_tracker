package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void getInfo() {
        System.out.println("Error is active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error network = new Error(true, 8, "Internet connection error");
        Error access = new Error(true, 5, "Access denied");
        first.getInfo();
        network.getInfo();
        access.getInfo();
    }
}
