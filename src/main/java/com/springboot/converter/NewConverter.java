package com.springboot.converter;

import org.springframework.stereotype.Component;

import com.springboot.dto.NewDTO;
import com.springboot.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbail(dto.getThumbail());
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbail(entity.getThumbail());

		return dto;
	}
	
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbail(dto.getThumbail());
		return entity;
	}
}
