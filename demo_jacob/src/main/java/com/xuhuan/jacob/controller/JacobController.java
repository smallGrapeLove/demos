package com.xuhuan.jacob.controller;

import com.xuhuan.jacob.utils.JacobTools;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

/**
 * @author huan.xu
 * @Time 2019-06-26 14:58
 */
@Controller
@RequestMapping("/jacob")
public class JacobController {

    private static Logger logger = Logger.getLogger(JacobController.class);

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String world(ModelMap modelMap) {
        String timeStr = Calendar.getInstance().getTimeInMillis() + "";
        String srcPath = "D:\\git_repositorys\\demo_repository\\demo_jacob\\data\\doctemplate.doc";
        String destPath = "D:\\git_repositorys\\demo_repository\\demo_jacob\\data\\doctemplate_" + timeStr + ".html";

        JacobTools.extractDoc(srcPath, destPath);

        return "success! destFile:" + destPath;
    }
}
