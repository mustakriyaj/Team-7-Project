package com.cg.onlineshopping_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping_application.dto.CategoryDto;
import com.cg.onlineshopping_application.dto.SuccessMessageDto;
import com.cg.onlineshopping_application.entity.Category;
import com.cg.onlineshopping_application.exception.CategoryIdException;
import com.cg.onlineshopping_application.exception.ValidateCategoryException;
import com.cg.onlineshopping_application.service.ICategoryServiceImp;
import com.cg.onlineshopping_application.util.ShoppingConstants;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryServiceImp categoryService;

    @PostMapping("/addcategory")
    public SuccessMessageDto addCategory(@RequestBody CategoryDto categoryDto) throws ValidateCategoryException
    {
        Category category= categoryService.addCategory(categoryDto);
        return new SuccessMessageDto(ShoppingConstants.CATEGORY_ADDED+ category.getCatId());
    }

    @PutMapping("/updatecategory")
    public SuccessMessageDto updateCategory(@RequestBody CategoryDto categoryDto) throws ValidateCategoryException, CategoryIdException 
    {
        Category category= categoryService.updateCategory(categoryDto);
        return new SuccessMessageDto(ShoppingConstants.CATEGORY_UPDATED+ category.getCatId());
    }
}

