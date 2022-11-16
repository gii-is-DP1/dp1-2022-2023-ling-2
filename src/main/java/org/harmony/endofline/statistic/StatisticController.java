package org.harmony.endofline.statistic;

import org.harmony.endofline.user.User;
import org.harmony.endofline.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private UserService userService;

    private static final String VIEWS_STATISTICS = "statistic/statistics";

    @GetMapping("/statistics")
    public String getUserStatistics(Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        List<Statistic> personal = new ArrayList<>();
        personal.add(statisticService.getStatisticByUserId(user.getId()));
        model.put("personal", personal);
        model.put("single", statisticService.getLeaderBoardSingleWins());
        model.put("multi", statisticService.getLeaderBoardMultiWins());
        return VIEWS_STATISTICS;
    }
}
