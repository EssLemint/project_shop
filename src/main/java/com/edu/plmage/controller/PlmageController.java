package com.edu.plmage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.plmage.model.PlmageDto;
import com.edu.plmage.service.PlmageService;
import com.edu.product.controller.ProductController;
import com.edu.product.model.ProductDto;
import com.edu.product.service.ProductService;

@Controller
public class PlmageController {

private static final Logger logger = LoggerFactory.getLogger(PlmageController.class);
	
	@Autowired
	private PlmageService plmageService;
	
	
}
