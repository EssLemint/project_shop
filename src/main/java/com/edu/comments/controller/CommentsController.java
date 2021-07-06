package com.edu.comments.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edu.comments.service.CommentsService;

@Controller
public class CommentsController {

private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
	
	@Autowired
	private CommentsService commentsrService;
	
}
