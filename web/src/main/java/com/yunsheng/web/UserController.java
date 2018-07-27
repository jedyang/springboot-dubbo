package com.yunsheng.web;

import com.yunsheng.dto.ResultDto;
import com.yunsheng.dto.User;
import com.yunsheng.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 演示跳转到页面
     * 路径参数
     */
    @RequestMapping("/{id}")
    public String getUser(@PathVariable Integer id, Model model) {
        User demo = new User();
        demo.setId(11);
        demo.setName("demo");
        demo.setAge("12");
        demo.setAddress("山东省青岛市海尔路1号");
        model.addAttribute("user", demo);
        return "/user/detail";
    }

    /**
     * 演示返回json
     * ？id=xxx参数
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResultDto getUserJson(@RequestParam(required = false, name = "id") Integer id, Model model) {
        ResultDto resultDto = new ResultDto();
        User demo = new User();
        demo.setId(11);
        demo.setName("demo");
        demo.setAge("12");
        demo.setAddress("山东省青岛市海尔路1号");
        model.addAttribute("user", demo);

        resultDto.setData(demo);
        resultDto.setMsg("success");
        resultDto.setResult(true);
        return resultDto;
    }

    @RequestMapping("/list")
    public String listUser(Model model) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User demo = new User();
            demo.setId(i);
            demo.setName("demo" + i);
            demo.setAge("12");
            demo.setAddress("山东省青岛市海尔路1号");
            userList.add(demo);
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }

    @GetMapping("/all")
    @ResponseBody
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
        // 分页返回结果示例
        //        {"total":6,"list":[{"userId":null,"userName":null,"password":"123456","phone":"18888888"},{"userId":null,"userName":null,"password":"123456","phone":"18888888"},{"userId":null,"userName":null,"password":"123456","phone":"18888888"},{"userId":null,"userName":null,"password":"123456","phone":"18888888"}],
        // "pageNum":1,"pageSize":4,"size":4,"startRow":1,"endRow":4,"pages":2,"
        // prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2,"firstPage":1,"lastPage":2}
    }

    @PostMapping("/add")
    @ResponseBody
    public int addUser(com.yunsheng.model.User user) {
        return userService.addUser(user);
    }
}