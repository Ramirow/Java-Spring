package com.example.demo.Controller;

import com.example.demo.Service.*;
import com.example.demo.Entity.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DemoController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String studentList(@RequestParam(value = "search", required = false) String search, Model model) {
        model.addAttribute("title", "Task Lists:");
        List<Task> taskList = new ArrayList<>();
        if (search == null || search.length() == 0) {
            taskList = taskService.findAll();
        } else {
            taskList = taskService.TaskNamesStartingWith(search);
        }
        model.addAttribute("task", taskList);        
        model.addAttribute("search", search);        
        return "index";
    }

    @RequestMapping("/task-details")
    public String taskDetails(@RequestParam(value = "id", required = true) String id, Model model) {
        model.addAttribute("task", taskService.findById(Long.parseLong(id)));
        return "task-details";
    }

    @GetMapping("/solve-task")
    public String solveTask(@RequestParam(value = "id", required = true) String id, Model model) {
        model.addAttribute("task", taskService.findById(Long.parseLong(id)));
        model.addAttribute("submission", new Submission());
        return "solve-task";
    }

    @PostMapping("/submit-solve-task/{id}")
    public String solveTask(@PathVariable long id, @Valid Submission submission, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("task", taskService.findById(id));
            //model.addAttribute("submission", new Submission());        
            return "solve-task";
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Submission temp = new Submission();
        temp.setTaskid(id);
        temp.setUserid(this.getUserId());
        temp.setSubdate(dateFormat.format(date));
        temp.setSolve(submission.getSolve());
        submissionService.save(temp);
        return "redirect:/success?id=" + temp.getTaskid();
    }

    @RequestMapping("/success")
    public String success(@RequestParam(value = "id", required = true) String id, Model model) {

        List<Submission> subList = submissionService.findByTaskid(Long.parseLong(id));
        List<NewSubmission> newSubList = new ArrayList<>();
        for (Submission item : subList) {
            NewSubmission nsub = new NewSubmission();
            nsub.setId(item.getId());
            nsub.setTaskid(item.getTaskid());
            nsub.setSubdate(item.getSubdate());
            nsub.setUsername((userService.findById(item.getUserid())).getUsername());
            nsub.setSolve(item.getSolve());
            newSubList.add(nsub);
        }
        model.addAttribute("submissions", newSubList);
        model.addAttribute("task", taskService.findById(Long.parseLong(id)));
        return "success";
    }

    private long getUserId() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        com.example.demo.Entity.User u = userService.findByUsername(username);
        long user_id = u.getId();
        return user_id;
    }
}
