package com.edu.bimage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.edu.bimage.service.BimageService;
import com.edu.board.controller.BoardController;
import com.edu.board.service.BoardService;

@Controller
public class BimageController {

	private static final Logger logger = LoggerFactory.getLogger(BimageController.class);

	@Autowired
	private BimageService bimageService;
	
}
