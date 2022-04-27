package com.springboot.service;

import java.util.List;

import com.springboot.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
//	NewDTO update(NewDTO newDTO);
	void delete(long ids);
	List<NewDTO> findAll();

}
