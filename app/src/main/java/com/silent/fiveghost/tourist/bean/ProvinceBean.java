package com.silent.fiveghost.tourist.bean;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(这里用一句话描述这个类的作用)
 * @date 2018/3/14 20:31
 * <p>
 * ${TAGS}
 */
public class ProvinceBean {

	/**
	 * errcode : 1
	 * errmsg : ok
	 * data : [{"id":1,"name":"北京","parent_id":0,"sort":0,"deep":1},{"id":2,"name":"天津","parent_id":0,"sort":0,"deep":1},{"id":3,"name":"河北省","parent_id":0,"sort":0,"deep":1},{"id":4,"name":"山西省","parent_id":0,"sort":0,"deep":1},{"id":5,"name":"内蒙古自治区","parent_id":0,"sort":0,"deep":1},{"id":6,"name":"辽宁省","parent_id":0,"sort":0,"deep":1},{"id":7,"name":"吉林省","parent_id":0,"sort":0,"deep":1},{"id":8,"name":"黑龙江省","parent_id":0,"sort":0,"deep":1},{"id":9,"name":"上海","parent_id":0,"sort":0,"deep":1},{"id":10,"name":"江苏省","parent_id":0,"sort":0,"deep":1},{"id":11,"name":"浙江省","parent_id":0,"sort":0,"deep":1},{"id":12,"name":"安徽省","parent_id":0,"sort":0,"deep":1},{"id":13,"name":"福建省","parent_id":0,"sort":0,"deep":1},{"id":14,"name":"江西省","parent_id":0,"sort":0,"deep":1},{"id":15,"name":"山东省","parent_id":0,"sort":0,"deep":1},{"id":16,"name":"河南省","parent_id":0,"sort":0,"deep":1},{"id":17,"name":"湖北省","parent_id":0,"sort":0,"deep":1},{"id":18,"name":"湖南省","parent_id":0,"sort":0,"deep":1},{"id":19,"name":"广东省","parent_id":0,"sort":0,"deep":1},{"id":20,"name":"广西壮族自治区","parent_id":0,"sort":0,"deep":1},{"id":21,"name":"海南省","parent_id":0,"sort":0,"deep":1},{"id":22,"name":"重庆","parent_id":0,"sort":0,"deep":1},{"id":23,"name":"四川省","parent_id":0,"sort":0,"deep":1},{"id":24,"name":"贵州省","parent_id":0,"sort":0,"deep":1},{"id":25,"name":"云南省","parent_id":0,"sort":0,"deep":1},{"id":26,"name":"西藏自治区","parent_id":0,"sort":0,"deep":1},{"id":27,"name":"陕西省","parent_id":0,"sort":0,"deep":1},{"id":28,"name":"甘肃省","parent_id":0,"sort":0,"deep":1},{"id":29,"name":"青海省","parent_id":0,"sort":0,"deep":1},{"id":30,"name":"宁夏回族自治区","parent_id":0,"sort":0,"deep":1},{"id":31,"name":"新疆维吾尔自治区","parent_id":0,"sort":0,"deep":1},{"id":32,"name":"台湾省","parent_id":0,"sort":0,"deep":1},{"id":33,"name":"香港特别行政区","parent_id":0,"sort":0,"deep":1},{"id":34,"name":"澳门特别行政区","parent_id":0,"sort":0,"deep":1},{"id":35,"name":"海外","parent_id":0,"sort":0,"deep":1}]
	 */

	private int errcode;
	private String errmsg;
	private List<DataBean> data;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public List<DataBean> getData() {
		return data;
	}

	public void setData(List<DataBean> data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * id : 1
		 * name : 北京
		 * parent_id : 0
		 * sort : 0
		 * deep : 1
		 */

		private int id;
		private String name;
		private int parent_id;
		private int sort;
		private int deep;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getParent_id() {
			return parent_id;
		}

		public void setParent_id(int parent_id) {
			this.parent_id = parent_id;
		}

		public int getSort() {
			return sort;
		}

		public void setSort(int sort) {
			this.sort = sort;
		}

		public int getDeep() {
			return deep;
		}

		public void setDeep(int deep) {
			this.deep = deep;
		}
	}
}
