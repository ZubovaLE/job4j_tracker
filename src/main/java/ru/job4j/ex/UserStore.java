package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean flag = true;
        for (User user : users) {
            if (user.equals(login)) {
                flag = false;
            }
        }

        if (flag) {
            throw new UserNotFoundException("The user is not found");
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("The user is not valid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ex) {
            ex.printStackTrace();
        }
    }
}
