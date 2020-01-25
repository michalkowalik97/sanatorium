package com.sanatorium.sanatorium.helpers;

import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionResolwer {

    UserRepo repo;

    @Autowired
    public PermissionResolwer(UserRepo repo) {
        this.repo = repo;
    }

    /**
     * Metoda zwracająca odpowiednią stronę domową dla użytkownika
     * @param login - login użytkownika
     * @return - nazwa widoku strony domowej
     */
    public String selectHome(String login) {

        User user = repo.findUserByLogin(login);

        if (user != null) {
            if (user.getPermId() == 1) {
                return "adminPanel";

            } else if (user.getPermId() == 2) {
                return "home";

            }
        }

        return "home";
    }
}
