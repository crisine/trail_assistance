package com.assistance.trial;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assistance.trial.articleboard.service.ArticleBoardService;
import com.assistance.trial.noticeboard.service.NoticeBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   //0828 최필규 추가 메인에서 공고, 공지 리스트 띄우기 위함.
   @Autowired
   NoticeBoardService noticeService;
   
   @Autowired
   ArticleBoardService articleService;
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      
      model.addAttribute("noticeList", noticeService.getMainList());
      
      model.addAttribute("articleList", articleService.articleMainList());
      
      return "home";
   }
   
}




















