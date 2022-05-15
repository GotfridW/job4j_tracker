package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User find : users) {
            if (login.equals(find.getUsername())) {
                user = find;
                break;
            } else {
                throw new UserNotFoundException("User not found");
            }
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!(user.isValid()) && user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid user");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("John Smith", true)
        };
        try {
            User user = findUser(users, "John Smith");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException inv) {
            inv.printStackTrace();
        }
    }
}