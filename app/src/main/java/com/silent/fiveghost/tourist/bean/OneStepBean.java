package com.silent.fiveghost.tourist.bean;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(一站发布 bean)
 * @date 2018/3/19 14:41
 * <p>
 * ${TAGS}
 */
public class OneStepBean {
	private String access_token;
	private int number;
	private int age_group;
	private String travel_time;
	public String travel_info;
	public String documents;
	private String contacts;
	private String contacts_tel;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAge_group() {
		return age_group;
	}

	public void setAge_group(int age_group) {
		this.age_group = age_group;
	}

	public String getTravel_time() {
		return travel_time;
	}

	public void setTravel_time(String travel_time) {
		this.travel_time = travel_time;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getContacts_tel() {
		return contacts_tel;
	}

	public void setContacts_tel(String contacts_tel) {
		this.contacts_tel = contacts_tel;
	}

//	public static class Documents {
//		private int type;
//		private String username;
//		private String birthday;
//		private int number;
//		private String remarks;
//
//
//		public int getType() {
//			return type;
//		}
//
//		public void setType(int type) {
//			this.type = type;
//		}
//
//		public String getUsername() {
//			return username;
//		}
//
//		public void setUsername(String username) {
//			this.username = username;
//		}
//
//		public String getBirthday() {
//			return birthday;
//		}
//
//		public void setBirthday(String birthday) {
//			this.birthday = birthday;
//		}
//
//		public int getNumber() {
//			return number;
//		}
//
//		public void setNumber(int number) {
//			this.number = number;
//		}
//
//		public String getRemarks() {
//			return remarks;
//		}
//
//		public void setRemarks(String remarks) {
//			this.remarks = remarks;
//		}
//	}
}
