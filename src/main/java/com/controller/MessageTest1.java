package com.controller;


import com.mapper.ExcellentMapper;
import com.mapper.JobMapper;
import com.mapper.UserMapper;
import com.model.Job;
import com.model.User;
import com.utility.DESUtil;
import com.utility.Log;
import com.utility.MD5str;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MessageTest1 {

    @Autowired
    private ExcellentMapper excellentMapper;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private UserMapper userMapper;
    private Logger logger = Logger.getLogger(MessageTest1.class);
    @Autowired
    Log log;
    @RequestMapping(value = "/firstPage", method = RequestMethod.GET)
    public ModelAndView test(ModelAndView modelAndView) {
        List list = excellentMapper.show();
        //查询已经结业的学员人数
        long count1 = excellentMapper.showNumber(1);
        //查询在学的学员人数
        long count2 = excellentMapper.showNumber(0);
        modelAndView.addObject("list", list);
        modelAndView.addObject("count", count2);
        modelAndView.addObject("counted", count1);
        modelAndView.setViewName("firstPage");
        return modelAndView;
    }

    @RequestMapping(value = "/secondPage", method = RequestMethod.GET)
    public ModelAndView test2(ModelAndView modelAndView) {

        modelAndView.addObject("code", -2);
        modelAndView.setViewName("secondPage");
        return modelAndView;
    }

    @RequestMapping(value = "/u/thirdPage", method = RequestMethod.GET)
    public ModelAndView test3(ModelAndView modelAndView) {
        List list = jobMapper.show();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();


        for (int i = 0; i < list.size(); i++) {
            Job job = (Job) list.get(i);
            if (job.getStatus().equals("前端开发方向")) {

                list1.add(job);
            }
            if (job.getStatus().equals("后端开发方向")) {

                list2.add(job);
            }
            if (job.getStatus().equals("运维方向")) {

                list3.add(job);
            }
        }
        long update = System.currentTimeMillis();
        logger.info(list1);

        modelAndView.addObject("job1", list1);
        modelAndView.addObject("job2", list2);
        modelAndView.addObject("job3", list3);
        modelAndView.addObject("time", update);
        modelAndView.setViewName("thirdPage");
        return modelAndView;

    }

    @RequestMapping(value = "/test11", method = RequestMethod.GET)
    public String test11() {
        return "test11";
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public ModelAndView logs(HttpServletResponse response, User user, ModelAndView modelAndView,DESUtil desUtil) throws Exception {
        logger.info(user);
       String view= log.log(user,desUtil,response);
        modelAndView.setViewName(view);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addUser(ModelAndView modelAndView, String username, String password) throws Exception {
        logger.info("用户名：" + username + "密码：" + password);
        String view;
        if (userMapper.select1(username) != null) {
            view = "repetition";
        } else {
            userMapper.add(username, MD5str.getMD5Str(username + password));
            view = "turn";

        }
        modelAndView.setViewName(view);

        return modelAndView;
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie[] = request.getCookies();

         if (cookie!=null&&cookie.length>0){
             for (Cookie c:cookie){
                 System.out.println(c.getName());
                 if (c.getName().equals("name")){
                     c.setMaxAge(0);
                     response.addCookie(c);
                     System.out.println("删除cookie");
                 }
             }
         }
         return "redirect:/firstPage";

    }
    @RequestMapping(value = "/guanwang",method = RequestMethod.GET)
    public String guan(){
        return "guanwang";
    }
}
