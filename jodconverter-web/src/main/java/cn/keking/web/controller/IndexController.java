package cn.keking.web.controller;

import cn.keking.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 主要页面映射
 *
 * @author Sandeepin
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 管理页面
     *
     * @return 页面
     */
    @RequestMapping("/old")
    public ModelAndView admin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String userName = user.getUserName();
        ModelAndView modelAndView = new ModelAndView("old");
        modelAndView.addObject("author", userName);
        return modelAndView;
    }

    /**
     * onlineplayer页面
     *
     * @return 页面
     */
    @RequestMapping("/onlineplayer")
    public ModelAndView onlineplayer(HttpServletRequest request, String fileName, String filePath) {
        User user = (User) request.getSession().getAttribute("user");
        String userName = (user==null)?"null":user.getUserName();
        ModelAndView modelAndView = new ModelAndView("onlineplayer");
        modelAndView.addObject("author", userName);
        modelAndView.addObject("fileName", fileName);
        modelAndView.addObject("filePath", filePath);
        return modelAndView;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String go2Index(){
        return "index2";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:/index";
    }
}
