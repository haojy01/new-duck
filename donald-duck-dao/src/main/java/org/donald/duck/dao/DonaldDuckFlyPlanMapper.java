package org.donald.duck.dao;

import org.donald.duck.bean.DonaldDuckFlyPlan;

public interface DonaldDuckFlyPlanMapper {
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(DonaldDuckFlyPlan record);

    int insertSelective(DonaldDuckFlyPlan record);

    DonaldDuckFlyPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DonaldDuckFlyPlan record);

    int updateByPrimaryKey(DonaldDuckFlyPlan record);
}