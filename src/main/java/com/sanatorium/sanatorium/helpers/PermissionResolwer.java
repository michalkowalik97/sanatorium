package com.sanatorium.sanatorium.helpers;

import com.sanatorium.sanatorium.models.User;
import com.sanatorium.sanatorium.models.Visit;
import com.sanatorium.sanatorium.repo.UserRepo;
import com.sanatorium.sanatorium.repo.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Service
public class PermissionResolwer {

    UserRepo repo;
    VisitRepo visitRepo;

    @Autowired
    public PermissionResolwer(UserRepo repo, VisitRepo visitRepo) {
        this.repo = repo;
        this.visitRepo = visitRepo;
    }
/*

    @Autowired
    public PermissionResolwer(UserRepo repo) {
        this.repo = repo;
    }
*/

    /**
     * Metoda zwracająca odpowiednią stronę domową dla użytkownika
     * @param login - login użytkownika
     * @return - nazwa widoku strony domowej
     */
    public ModelAndView selectHome(String login) {
        ModelAndView mav = new ModelAndView();
        User user = repo.findUserByLogin(login);

        if (user != null) {
         //   System.out.println(user.toString());
            if (user.getPermission().getLevel() == 1) { //admin

                 mav.setViewName("adminPanel");
                 return mav;

            } else if (user.getPermission().getLevel() == 2) { //recepcjonista
                mav.setViewName("home");
                return mav;


            }else if (user.getPermission().getLevel() == 3) { //lekarz
                Date date = new Date();
                List<Visit> visits = visitRepo.findTop5ByActiveAndDoctorOrderByDateTimeAsc(true, user);
                //List<Visit> visits = visitRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
                mav.addObject("visits", visits);
                mav.setViewName("doctor/home");
                return mav;

            }
        }
        mav.setViewName("index");
        return mav;

    }
}
