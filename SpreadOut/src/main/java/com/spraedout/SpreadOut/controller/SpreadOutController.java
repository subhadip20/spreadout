package com.spraedout.SpreadOut.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spraedout.SpreadOut.modal.Authority;
import com.spraedout.SpreadOut.modal.Product;
import com.spraedout.SpreadOut.modal.TempRegistration;
import com.spraedout.SpreadOut.modal.TempUser;
import com.spraedout.SpreadOut.modal.User;
import com.spraedout.SpreadOut.repository.UserRepository;
import com.spraedout.SpreadOut.services.JwtAuthenticationResponse;
import com.spraedout.SpreadOut.services.ProductService;
import com.spraedout.SpreadOut.services.TempUserService;

@Controller
public class SpreadOutController {
	@Autowired
	ProductService productService;
	@Autowired
	TempUserService tempUserService;
	
	@Autowired
	UserRepository userRepository;
	@GetMapping("/")
	public String landing() {
				
		return "index";
	}
	@GetMapping("/products")
	public String userProducts(Model model) {
		
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	@GetMapping("/products/{id}")
	public String userProductsById(@PathVariable Long id,Model model) {
		System.out.println(id);	
		System.out.println(productService.getFindById(id).getName());
		model.addAttribute("product", productService.getFindById(id));
		return "product-page";
		
	}
	
	@RequestMapping(value="/otp", method=RequestMethod.POST)
	public ResponseEntity<?> sendsms(@RequestBody TempUser tempUser,Model model) {
		
		System.out.println(tempUser.getMobile());
		/*
		 * try { // Construct data String apiKey = "apikey=" +
		 * URLEncoder.encode("	0zJzFtYfBEU-MzfG9d1PLSjoatHTLW4OXTII8br7tC", "UTF-8");
		 * String message = "&message=" + URLEncoder.encode("Hi baby", "UTF-8"); String
		 * sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8"); String numbers =
		 * "&numbers=" + URLEncoder.encode("917003185446", "UTF-8");
		 * 
		 * // Send data String data = "https://api.textlocal.in/send/?" + apiKey +
		 * numbers + message + sender; URL url = new URL(data); URLConnection conn =
		 * url.openConnection(); conn.setDoOutput(true);
		 * 
		 * // Get the response BufferedReader rd = new BufferedReader(new
		 * InputStreamReader(conn.getInputStream())); String line; String sResult="";
		 * while ((line = rd.readLine()) != null) { // Process line...
		 * sResult=sResult+line+" "; } rd.close(); System.out.println("sent"+sResult);
		 * return "index"; } catch (Exception e) { System.out.println("Error SMS "+e);
		 * return "Error "+e; }
		 */
		tempUser.setVerificationCode("654321");
		tempUser.setTimestampcode("12.34");
		tempUserService.save(tempUser);
		System.out.println("mobile number");
		
		return ResponseEntity.ok(tempUser.getMobile());
	}
	
	@RequestMapping(value="/otp/verify", method=RequestMethod.POST)
	public ResponseEntity<?> verifyOtp(@RequestBody TempUser tempUser,Model model) {
		
		System.out.println(tempUser.getMobile());		
		
		TempUser user = tempUserService.getTempUserByMobile(tempUser.getMobile());
		boolean otpStatus = tempUserService.verifyOtp(user,tempUser);
		if(otpStatus==true) {
			user.setVerify(true);
			tempUserService.save(user);
			return ResponseEntity.ok(user);
		}
		tempUser.setVerificationCode("0");
		return ResponseEntity.ok(tempUser);
	}
	
	@RequestMapping(value="/otp/create", method=RequestMethod.POST)
	public ResponseEntity<?> createAccount(@RequestBody String  password,@RequestBody String  mobile,Model model) {
		
		System.out.println(password);		
		
		TempUser user = tempUserService.getTempUserByMobile(mobile);
		if(user.isVerify()) {
			User u = new User();
			//userRepository.save(u,new Authority());
		}
		
		return ResponseEntity.ok("");
	}
}
