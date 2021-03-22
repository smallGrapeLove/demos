package com.xuhuan.demo.mybatis.generator.dao;

import com.xuhuan.demo.mybatis.generator.entity.TAccount;

public interface TAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TAccount record);

    int insertSelective(TAccount record);

    TAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAccount record);

    int updateByPrimaryKey(TAccount record);
}