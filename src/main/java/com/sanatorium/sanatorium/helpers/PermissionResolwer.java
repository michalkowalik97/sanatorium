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
         //   System.out.println(user.toString());
            if (user.getPermission().getLevel() == 1) {
                return "adminPanel";

            } else if (user.getPermission().getLevel() == 2) {
                return "home";

            }
        }

        return "index";
    }
}
