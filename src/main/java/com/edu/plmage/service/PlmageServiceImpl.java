package com.edu.plmage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.plmage.dao.PlmageDao;
import com.edu.plmage.model.PlmageDto;

@Service
public class PlmageServiceImpl implements PlmageService{
	@Autowired
	PlmageDao pimageDao;

}
