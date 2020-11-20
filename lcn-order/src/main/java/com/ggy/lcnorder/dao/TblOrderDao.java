package com.ggy.lcnorder.dao;

import com.ggy.lcnorder.entity.TblOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblOrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblOrder record);

    int insertSelective(TblOrder record);

    TblOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblOrder record);

    int updateByPrimaryKey(TblOrder record);
}