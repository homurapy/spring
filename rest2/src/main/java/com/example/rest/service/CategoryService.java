package com.example.rest.service;

import com.example.rest.dto.CategoryDto;
import com.example.rest.dto.ProductDto;
import com.example.rest.model.Category;
import com.example.rest.model.Product;
import com.example.rest.repository.CategoryRepo;
import com.example.rest.service.spec.ProductSpec;
import com.example.rest.utils.MappingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public List<CategoryDto> findAll() {
        return categoryRepo.findAll().stream()
                .map(MappingUtil::categoryDto)
                .collect(Collectors.toList());
    }
    public  void deleteById(Long id){
        categoryRepo.deleteById(id);
    }
    public Category save(CategoryDto dto){
        Category category = MappingUtil.dtoToCategory(dto, categoryRepo.count()+1);
        return categoryRepo.save(category);
    }
}
