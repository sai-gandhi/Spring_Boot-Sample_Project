package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AdminController 
{
  @Autowired
  private AdminService adminService;
  
  @GetMapping("adminlogin")
  public ModelAndView adminlogin()
  {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("adminlogin");
    return mv;
  }
  @GetMapping("adminhome")
  public ModelAndView adminhome()
  {
    ModelAndView mv=new ModelAndView("adminhome");
    long count=adminService.customercount();
    mv.addObject("count",count);
    return mv;
  }
  @PostMapping("checkadminlogin")
  public ModelAndView checkadminlogin(HttpServletRequest request)
  {
    ModelAndView mv=new ModelAndView();
    String auname=request.getParameter("auname");
    String apwd=request.getParameter("apwd");
    
    Admin admin=adminService.checkAdminLogin(auname, apwd);
    if(admin!=null)
    {
      mv.setViewName("adminhome");
      
      long count=adminService.customercount();
      mv.addObject("count",count);
;    }
    else
    {
      mv.setViewName("adminloginfail");
      mv.addObject("msg","Login Failed");
    }
    return mv;
  }
  
  @GetMapping("viewallcustomers")
  public ModelAndView viewallcustomers() {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("viewallcustomers");
    long count=adminService.customercount();
    mv.addObject("count",count);
    List<Customer> customers=adminService.viewAllCustomers();
    mv.addObject("customerlist",customers);
;    return mv;
  }
  
    
    
  
  
}