/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeViewController {

    @GetMapping(value = { "" })
    public String index () {
        return "dist/index.html";
    }
}
