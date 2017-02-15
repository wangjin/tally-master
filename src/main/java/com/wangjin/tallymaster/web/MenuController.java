package com.wangjin.tallymaster.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/15 上午9:14.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("menu/list");

        return modelAndView;
    }

}
