package com.spraedout.SpreadOut.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {
	
	@RequestMapping(value="/test1" ,method = RequestMethod.GET)
    public String hello(Model model) {
		model.addAttribute("test","test");
        return "hello";
    }

}
