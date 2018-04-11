package org.donald.duck.bean;

import java.math.BigDecimal;
import java.util.Date;

public class DonaldDuckFlyPlan {
	
    private Integer id;

    private String airlineCompany;

    private String aircraftNo;

    private String aircraftType;

    private String takeOffTime;

    private String takeOffAirport;

    private String goThrough;

    private String laddingTime;

    private String landlingAirport;

    private String punctualityRate;

    private String gift;

    private String floorPrice;

    private String spiderBatch;
    
    private Date createTime;
    
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany == null ? null : airlineCompany.trim();
    }

    public String getAircraftNo() {
        return aircraftNo;
    }

    public void setAircraftNo(String aircraftNo) {
        this.aircraftNo = aircraftNo == null ? null : aircraftNo.trim();
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType == null ? null : aircraftType.trim();
    }

    public String getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(String takeOffTime) {
        this.takeOffTime = takeOffTime == null ? null : takeOffTime.trim();
    }

    public String getTakeOffAirport() {
        return takeOffAirport;
    }

    public void setTakeOffAirport(String takeOffAirport) {
        this.takeOffAirport = takeOffAirport == null ? null : takeOffAirport.trim();
    }

    public String getGoThrough() {
        return goThrough;
    }

    public void setGoThrough(String goThrough) {
        this.goThrough = goThrough == null ? null : goThrough.trim();
    }

    public String getLaddingTime() {
        return laddingTime;
    }

    public void setLaddingTime(String laddingTime) {
        this.laddingTime = laddingTime == null ? null : laddingTime.trim();
    }

    public String getLandlingAirport() {
        return landlingAirport;
    }

    public void setLandlingAirport(String landlingAirport) {
        this.landlingAirport = landlingAirport == null ? null : landlingAirport.trim();
    }

    public String getPunctualityRate() {
        return punctualityRate;
    }

    public void setPunctualityRate(String punctualityRate) {
        this.punctualityRate = punctualityRate == null ? null : punctualityRate.trim();
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift == null ? null : gift.trim();
    }

    public String getFloorPrice() {
		return floorPrice;
	}

	public void setFloorPrice(String floorPrice) {
		this.floorPrice = floorPrice;
	}

	public String getSpiderBatch() {
        return spiderBatch;
    }

    public void setSpiderBatch(String spiderBatch) {
        this.spiderBatch = spiderBatch == null ? null : spiderBatch.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}