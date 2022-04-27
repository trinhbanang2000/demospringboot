package com.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.converter.NewConverter;
import com.springboot.dto.NewDTO;
import com.springboot.entity.NewEntity;
import com.springboot.repository.NewRepository;
import com.springboot.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.getOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(long ids) {
			newRepository.deleteById(ids);
	}


	@Override
	public List<NewDTO> findAll( ) {
		List<NewDTO> results = new ArrayList<NewDTO>();
		List<NewEntity> entityes = newRepository.findAll();
		for (NewEntity item : entityes) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	
	

	
		
	



}
