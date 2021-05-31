package com.cg.onlineshopping_application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping_application.dto.CategoryDto;
import com.cg.onlineshopping_application.entity.Category;
import com.cg.onlineshopping_application.exception.CategoryIdException;
import com.cg.onlineshopping_application.exception.ValidateCategoryException;
import com.cg.onlineshopping_application.repository.ICategoryRepository;
import com.cg.onlineshopping_application.util.ShoppingConstants;



@Service
public class ICategoryServiceImp implements ICategoryService {

    @Autowired
    ICategoryRepository categoryDao;

    @Override
    public Category addCategory(CategoryDto categoryDto) throws ValidateCategoryException {
        validateCategory(categoryDto);
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        return categoryDao.save(category);
    }


    public Category updateCategory(CategoryDto categoryDto)throws ValidateCategoryException, CategoryIdException {
        validateCategory(categoryDto);
        Optional<Category> optCategory = categoryDao.findById(categoryDto.getCatId());
        if (!optCategory.isPresent())
            throw new CategoryIdException(ShoppingConstants.CATEGORY_NOT_FOUND);
        Category category = optCategory.get();
        category.setCategoryName(categoryDto.getCategoryName());
        return categoryDao.save(category);

    }

    public boolean validateCategory(CategoryDto categoryDto) throws ValidateCategoryException {
        if (categoryDto.getCategoryName()==null) 
            throw new ValidateCategoryException(ShoppingConstants.CATEGORY_CANNOT_BE_EMPTY);
    return true;
 }
}
