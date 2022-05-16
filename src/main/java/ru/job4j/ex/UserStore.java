package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User find : users) {
            if (login.equals(find.getUsername())) {
                user = find;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!(user.isValid())) {
            throw new UserInvalidException("Invalid user");
        } else if (user.getUsername().length() < 3) {
            throw new UserInvalidException(
                    "Username must be at least 3 characters long!");
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
        } catch (UserInvalidException inv) {
            inv.printStackTrace();
        } catch (UserNotFoundException nf) {
            nf.printStackTrace();
        }
    }
}