package org.donald.duck.dao;

import org.apache.ibatis.annotations.Param;
import org.donald.duck.bean.DonaldDuckUser;

public interface DonaldDuckUserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(DonaldDuckUser record);

    int insertSelective(DonaldDuckUser record);

    DonaldDuckUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DonaldDuckUser record);

    int updateByPrimaryKey(DonaldDuckUser record);

	DonaldDuckUser verifPassword(@Param("password")String password, @Param("userName")String userName);
}