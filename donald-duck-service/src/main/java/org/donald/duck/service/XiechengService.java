package org.donald.duck.service;

import java.util.Date;
import java.util.List;

import org.donald.duck.bean.DonaldDuckFlyPlan;
import org.donald.duck.dao.DonaldDuckFlyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XiechengService {

	@Autowired
	private DonaldDuckFlyPlanMapper xiecheng;

	public void insertBatch(List<DonaldDuckFlyPlan> flyList) {
		Date createTime = new Date();
		for (DonaldDuckFlyPlan fly : flyList) {
			fly.setCreateTime(createTime);
			fly.setSpiderBatch(createTime.getTime() + "");
			xiecheng.insertSelective(fly);
		}
	}

}
