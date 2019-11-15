package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.Account;
import com.fpt.t1708e.photoplatform.entity.Album;
import com.fpt.t1708e.photoplatform.entity.Category;
import com.fpt.t1708e.photoplatform.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

	public Category getCategoryById(long id) {
		return categoryRepository.findById(id).orElse(null);
	}

    public Category update(Category category) {
        category.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return categoryRepository.save(category);
    }

    public List<Category> getList() {
        return categoryRepository.findAll();
    }
}
