package com.utility;

import com.mapper.UserMapper;
import com.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Component
public class Log {
      private Logger logger=Logger.getLogger(Log.class);
    @Autowired
  private   UserMapper userMapper;
    public  String log(User user1, DESUtil desUtil, HttpServletResponse response) throws Exception {
      String view;
       logger.info(user1);
    User  user2=  userMapper.select1(user1.getUsername());
      logger.info(user2);
      logger.info(user2.getUsername());
      if (user2.getUsername()==null){
          view="absent";
      }else if (user2.getPassword().equals(MD5str.getMD5Str(user1.getUsername()+user1.getPassword()))){
          view="loged";
          //对Cookie进行加密
          long time = System.currentTimeMillis();
          user2.setUpdate_time(time);
          String str1=desUtil.encryptFromLong(time);
          String str2=desUtil.encryptFromLong(user2.getId());
          String token = desUtil.encrypt(str1+"|"+user2.getUsername()+"|"+str2);
          Cookie nameCookie=new Cookie("name",user2.getUsername());
          Cookie tokenCookie=new Cookie("token",token);
          nameCookie.setMaxAge(30*60);
          nameCookie.setPath("/");
          tokenCookie.setMaxAge(30*60);
          tokenCookie.setPath("/");
          response.addCookie(nameCookie);
          response.addCookie(tokenCookie);

      }else {
          view="errorlog";
      }
      return view;
    }
}
