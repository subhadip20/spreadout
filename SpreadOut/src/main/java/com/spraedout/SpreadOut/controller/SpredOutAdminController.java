package com.spraedout.SpreadOut.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spraedout.SpreadOut.modal.Product;
import com.spraedout.SpreadOut.services.ProductService;

@Controller
public class SpredOutAdminController {

	 public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/img/product-image";
	@Autowired
	ProductService productService;

	@GetMapping("/admin")
	private String adminHome() {
		return "admin-home";
	}

	@GetMapping("/product-fun")
	public String productFun(Model model) {
		System.out.println("size-->"+productService.getAllProducts().size());
		int j=0;
		
		List<Product> l =productService.getAllProducts();
		while ( j < l.size()) {
			System.out.println(l.get(j).getProductId());
			j++;
		}
		model.addAttribute("products",l);
		return "admin-product";
	}
	
	@GetMapping("/admin-product-add")
	public String adminProductAdd(Model model) {
		model.addAttribute("product",new Product());
		return "admin-product-add";
	}
	
	@PostMapping("/admin-product-add")
	public String adminProductAddNew(@Valid Product product,Model model) {
		productService.save(product);
		
		//model.addAttribute("product",new Product());
		return "admin-product";
	}
	
	
	@ResponseBody
	 @RequestMapping(value="/admin-upload-product-image", method = RequestMethod.POST)
	  public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
		  StringBuilder fileNames = new StringBuilder();
		  String image="";
		  for (MultipartFile file : files) {
			  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			  fileNames.append(file.getOriginalFilename()+" ");
			  System.out.println("Hello--->"+file.getOriginalFilename());
			  image=file.getOriginalFilename();
			  try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
				 return "error";
			}
		  }
		  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
		  return image;
	  }
	

}
