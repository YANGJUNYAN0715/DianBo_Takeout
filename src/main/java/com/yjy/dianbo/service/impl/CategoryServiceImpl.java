package com.yjy.dianbo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yjy.dianbo.entity.Category;
import com.yjy.dianbo.mapper.CategoryMapper;
import com.yjy.dianbo.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{
}
