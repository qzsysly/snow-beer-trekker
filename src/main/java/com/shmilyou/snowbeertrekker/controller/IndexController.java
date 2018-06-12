package com.shmilyou.snowbeertrekker.controller;

import com.shmilyou.snowbeertrekker.entity.Footage;
import com.shmilyou.snowbeertrekker.entity.Review;
import com.shmilyou.snowbeertrekker.service.FootageService;
import com.shmilyou.snowbeertrekker.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    ReviewService reviewService;
    @Autowired
    FootageService footageService;

    @RequestMapping(value = {"/","index","index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("review")
    public String review(ModelMap modelMap) {
        List<Review> reviews = reviewService.findAllReview();
        modelMap.addAttribute("reviews", reviews);
        return "review";
    }

    @RequestMapping("footage")
    public ModelAndView footage(ModelAndView modelAndView){
        List<Footage> footages = footageService.findAll();
        modelAndView.addObject("footages",footages);
        modelAndView.setViewName("footage");
        return modelAndView;
    }
}
