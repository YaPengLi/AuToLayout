package com.silent.fiveghost.tourist.bean;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/19 17:15
 * <p>
 * ${TAGS}
 */
public class TravelInfo {
	private int cityId;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getGuide_type() {
		return guide_type;
	}

	public void setGuide_type(int guide_type) {
		this.guide_type = guide_type;
	}

	public int getG_uid() {
		return g_uid;
	}

	public void setG_uid(int g_uid) {
		this.g_uid = g_uid;
	}

	public int getPlay_days() {
		return play_days;
	}

	public void setPlay_days(int play_days) {
		this.play_days = play_days;
	}

	public String getTravel_preference() {
		return travel_preference;
	}

	public void setTravel_preference(String travel_preference) {
		this.travel_preference = travel_preference;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	private int guide_type;
	private int g_uid;
	private int play_days;
	private String travel_preference;
	private String remarks;
}
