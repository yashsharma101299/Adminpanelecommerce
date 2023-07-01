package com.day8.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.day8.dto.ProductDTO;
import com.day8.model.Category;
import com.day8.model.Product;
import com.day8.service.CategoryService;
import com.day8.service.ProductService;
import com.day8.service.Purchasereportservice;
import com.day8.service.Userservice;

@Controller
public class AdminController {

	
	public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	@Autowired
	private Userservice userservice;
	@Autowired
	private Purchasereportservice purchasereportservice;
	
	@GetMapping({"/", "/admin"})
	public String adminHome()
	{return "adminHome";}
	
	
	@GetMapping("/logout")
	public String logout()
	{
		return "goodbye";
	}
	
	// category controller handlers
	
	@GetMapping("/admin/categories")
	public String getCat(Model model)
	{
		model.addAttribute("categories",categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCatAdd(Model model)
	{
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCatAdd(@ModelAttribute("category") Category category)
	{
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat( @PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id, Model model)
	{
		Optional<Category> category = categoryService.getCategoryById(id);
		if(category.isPresent())
			{
			model.addAttribute("category", category.get());
			return "categoriesAdd";
			}
		else
		{
			return "404";
		}
	}
	
	
	//product controller handlers
	
	@GetMapping("/admin/products")
	public String products(Model model)
	{
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
	
	@GetMapping("/admin/products/add")
	public String productAddGet(Model model)
	{
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "productsAdd";
		
	}
	
	
	@PostMapping("/admin/products/add")
	public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
								 @RequestParam("productImage") MultipartFile file,
								 @RequestParam("imgName") String imgName) throws IOException
	{
		
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
		product.setPrice(productDTO.getPrice());
		product.setWeight(productDTO.getWeight());
		product.setDescription(productDTO.getDescription());
		
		String imageUUID;
		if(!file.isEmpty())
		{
			imageUUID= file.getOriginalFilename();//image
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);//storing
			
			Files.write(fileNameAndPath, file.getBytes());
		}
		else
		{
			imageUUID = imgName;
		}
		
		product.setImageName(imageUUID);

		productService.addProduct(product);
	  return "redirect:/admin/products";
	}
	
	
	
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable long id)
	{
		productService.removeProductById(id);
		return "redirect:/admin/products";
		
	}
	
	
	@GetMapping("/admin/product/update/{id}")
	public String updateProductGet(@PathVariable long id, Model model)
	{
		Product product = productService.getProductById(id).get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight(product.getWeight());
		productDTO.setDescription(product.getDescription());
		productDTO.setImageName(product.getImageName());
		
		
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("productDTO", productDTO);
		
		return "productsAdd";
		
	}
	
	//users controller handlers
	
	@GetMapping("/admin/userlist")
	public String getallusers(Model m) 
	{
		m.addAttribute("userlist",userservice.allusers());
		return "users";
	}
	@PostMapping("/admin/users/find")
	public String filteruser(@RequestParam("finduser") String username, Model m) 
	{
		m.addAttribute("userfilterlist",userservice.usersbyname(username));
		return "userfilter";
	}
	@GetMapping("/admin/users/find/back")
	public String returnback(Model m) {
		m.addAttribute("userlist",userservice.allusers());
		return "users";
	}
	
	
	//purchasereports controller handlers
	
	@GetMapping("/admin/reports")
	public String getallreports(Model m) 
	{
		m.addAttribute("reportlist",purchasereportservice.purchasereportslist());
		return "purchasereport";
	}
	@PostMapping("/admin/users/find/bydate")
	public String getreportsbydate(@RequestParam("findreportbydate") String date,Model m) 
	{	
		m.addAttribute("reportsbydate",purchasereportservice.reportsbydate(date));
		return "purchasereportbydate";
	}
	@PostMapping("/admin/users/find/byid")
	public String getreportbyuserid(@RequestParam("findreportbyuserid") Integer uid,Model m) 
	{
		m.addAttribute("reportsbyid", purchasereportservice.reportsbyuserid(uid));
		return "purchasereportbyid";
	}
	
	
	
	
	

	
	
}
