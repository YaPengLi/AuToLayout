package com.silent.fiveghost.tourist.bean;

import java.util.List;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(导游详情)
 * @date 2018/3/13 22:19
 * <p>
 * ${TAGS}
 */
public class GuideDetailBean {

	/**
	 * errcode : 1
	 * errmsg : ok
	 * data : {"name":"测试","avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","img":["https://www.baidu.com/img/bd_logo1.png","http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg"],"desc":"","car_type":"大巴车","star":"2","star_text":"二星级","order_city":"云南","tour_preference":["完美","ceshi","ceshi2"],"good_line_desc":"山东省打发斯蒂芬斯蒂芬是否是对方是否三打发斯蒂芬斯蒂芬胜多负少东方闪电发斯蒂芬斯蒂芬是胜多负少东方闪电发斯蒂芬斯蒂芬胜多负少\n\n","route":[{"img":["http://120.79.137.110/storage/upload/20180228/Nf_LNsA7T-GFhH2hkevrOyxgSFbxgW7BoGUT8xsw.jpg"],"id":"182","name":"北京五环"},{"img":["http://120.79.137.110/storage/upload/20180305/v_5lXV8vfeiacGJHFrzdJ2sa0OaYiNAsQvNOg7RS.jpg"],"id":"181","name":"北京-云南（申扬）"},{"img":["http://120.79.137.110/storage/upload/20180305/N3pg6e_zb-t2rl-Zi7dqn-UxXiq1UirlwkanQ9Su.jpg"],"id":"180","name":"北京1日游"},{"img":["http://120.79.137.110/storage/upload/20180301/CYkGd6OfZOnWeVo4VBq_C3qDszwiroqNIuW8_cqL.jpg","http://120.79.137.110/storage/upload/20180301/emy5dfkdwCOBjme4FKilOYt03IWzafByy4CdislT.jpg"],"id":"179","name":"北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180228/Zv83fbHFUNzNGmYmk-IhDa71N2aQIRJNniKCSxQM.jpg"],"id":"178","name":"Ggg北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180228/uia3g4AZwE6kWiA_RYFMvQWV86t9gOmLHSLBLgHG.jpg","http://120.79.137.110/storage/upload/20180225/BGDDRUKlloIWrvdL9mWo0Vf_dGKLbUGEyu2otpBB.jpg","http://120.79.137.110/storage/upload/20180225/7zfi8PjhnmfzsHYtytNhQbKx4fAeoRTPD4fpZXWW.jpg","http://120.79.137.110/storage/upload/20180228/WXdUoJgjvxfpIS3n897O0JOEOEYKvrbTPv1pzOBE.jpg"],"id":"177","name":"北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180225/BGDDRUKlloIWrvdL9mWo0Vf_dGKLbUGEyu2otpBB.jpg","http://120.79.137.110/storage/upload/20180225/7zfi8PjhnmfzsHYtytNhQbKx4fAeoRTPD4fpZXWW.jpg","http://120.79.137.110/storage/upload/20180228/WXdUoJgjvxfpIS3n897O0JOEOEYKvrbTPv1pzOBE.jpg","http://120.79.137.110/storage/upload/20180228/uia3g4AZwE6kWiA_RYFMvQWV86t9gOmLHSLBLgHG.jpg"],"id":"176","name":"北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg"],"id":"175","name":"旅行测试-20180204444"},{"img":["http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180228/Zv83fbHFUNzNGmYmk-IhDa71N2aQIRJNniKCSxQM.jpg"],"id":"174","name":"北京三日游"},{"img":null,"id":"173","name":"以吃货的名义，寻找藏匿在大理古城的美味"}],"comment_star":4.3,"comment":{"items":[{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客1","star":3,"time":"30分钟前"},{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客2","star":4,"time":"2018年1月5日"}],"pager":{"page":1,"page_count":1,"per_page":20,"total_count":11}}}
	 */

	private int errcode;
	private String errmsg;
	private DataBean data;

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

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * name : 测试
		 * avatar : http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg
		 * img : ["https://www.baidu.com/img/bd_logo1.png","http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg"]
		 * desc :
		 * car_type : 大巴车
		 * star : 2
		 * star_text : 二星级
		 * order_city : 云南
		 * tour_preference : ["完美","ceshi","ceshi2"]
		 * good_line_desc : 山东省打发斯蒂芬斯蒂芬是否是对方是否三打发斯蒂芬斯蒂芬胜多负少东方闪电发斯蒂芬斯蒂芬是胜多负少东方闪电发斯蒂芬斯蒂芬胜多负少


		 * route : [{"img":["http://120.79.137.110/storage/upload/20180228/Nf_LNsA7T-GFhH2hkevrOyxgSFbxgW7BoGUT8xsw.jpg"],"id":"182","name":"北京五环"},{"img":["http://120.79.137.110/storage/upload/20180305/v_5lXV8vfeiacGJHFrzdJ2sa0OaYiNAsQvNOg7RS.jpg"],"id":"181","name":"北京-云南（申扬）"},{"img":["http://120.79.137.110/storage/upload/20180305/N3pg6e_zb-t2rl-Zi7dqn-UxXiq1UirlwkanQ9Su.jpg"],"id":"180","name":"北京1日游"},{"img":["http://120.79.137.110/storage/upload/20180301/CYkGd6OfZOnWeVo4VBq_C3qDszwiroqNIuW8_cqL.jpg","http://120.79.137.110/storage/upload/20180301/emy5dfkdwCOBjme4FKilOYt03IWzafByy4CdislT.jpg"],"id":"179","name":"北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180228/Zv83fbHFUNzNGmYmk-IhDa71N2aQIRJNniKCSxQM.jpg"],"id":"178","name":"Ggg北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180228/uia3g4AZwE6kWiA_RYFMvQWV86t9gOmLHSLBLgHG.jpg","http://120.79.137.110/storage/upload/20180225/BGDDRUKlloIWrvdL9mWo0Vf_dGKLbUGEyu2otpBB.jpg","http://120.79.137.110/storage/upload/20180225/7zfi8PjhnmfzsHYtytNhQbKx4fAeoRTPD4fpZXWW.jpg","http://120.79.137.110/storage/upload/20180228/WXdUoJgjvxfpIS3n897O0JOEOEYKvrbTPv1pzOBE.jpg"],"id":"177","name":"北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180225/BGDDRUKlloIWrvdL9mWo0Vf_dGKLbUGEyu2otpBB.jpg","http://120.79.137.110/storage/upload/20180225/7zfi8PjhnmfzsHYtytNhQbKx4fAeoRTPD4fpZXWW.jpg","http://120.79.137.110/storage/upload/20180228/WXdUoJgjvxfpIS3n897O0JOEOEYKvrbTPv1pzOBE.jpg","http://120.79.137.110/storage/upload/20180228/uia3g4AZwE6kWiA_RYFMvQWV86t9gOmLHSLBLgHG.jpg"],"id":"176","name":"北京三日游"},{"img":["http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg"],"id":"175","name":"旅行测试-20180204444"},{"img":["http://120.79.137.110/storage/upload/20180225/LZzGqnhXP2Dif9TI5qZ2HPILdoyoUH9uVorBpdsE.jpg","http://120.79.137.110/storage/upload/20180228/Zv83fbHFUNzNGmYmk-IhDa71N2aQIRJNniKCSxQM.jpg"],"id":"174","name":"北京三日游"},{"img":null,"id":"173","name":"以吃货的名义，寻找藏匿在大理古城的美味"}]
		 * comment_star : 4.3
		 * comment : {"items":[{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客1","star":3,"time":"30分钟前"},{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客2","star":4,"time":"2018年1月5日"}],"pager":{"page":1,"page_count":1,"per_page":20,"total_count":11}}
		 */

		private String name;
		private String avatar;
		private String desc;
		private String car_type;
		private String star;
		private String star_text;
		private String order_city;
		private String good_line_desc;
		private double comment_star;
		private CommentBean comment;
		private List<String> img;
		public List<String> tour_preference;
		private List<RouteBean> route;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getCar_type() {
			return car_type;
		}

		public void setCar_type(String car_type) {
			this.car_type = car_type;
		}

		public String getStar() {
			return star;
		}

		public void setStar(String star) {
			this.star = star;
		}

		public String getStar_text() {
			return star_text;
		}

		public void setStar_text(String star_text) {
			this.star_text = star_text;
		}

		public String getOrder_city() {
			return order_city;
		}

		public void setOrder_city(String order_city) {
			this.order_city = order_city;
		}

		public String getGood_line_desc() {
			return good_line_desc;
		}

		public void setGood_line_desc(String good_line_desc) {
			this.good_line_desc = good_line_desc;
		}

		public double getComment_star() {
			return comment_star;
		}

		public void setComment_star(double comment_star) {
			this.comment_star = comment_star;
		}

		public CommentBean getComment() {
			return comment;
		}

		public void setComment(CommentBean comment) {
			this.comment = comment;
		}

		public List<String> getImg() {
			return img;
		}

		public void setImg(List<String> img) {
			this.img = img;
		}

		public List<String> getTour_preference() {
			return tour_preference;
		}

		public void setTour_preference(List<String> tour_preference) {
			this.tour_preference = tour_preference;
		}

		public List<RouteBean> getRoute() {
			return route;
		}

		public void setRoute(List<RouteBean> route) {
			this.route = route;
		}

		public static class CommentBean {
			/**
			 * items : [{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客1","star":3,"time":"30分钟前"},{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客2","star":4,"time":"2018年1月5日"}]
			 * pager : {"page":1,"page_count":1,"per_page":20,"total_count":11}
			 */

			private PagerBean pager;
			private List<ItemsBean> items;

			public PagerBean getPager() {
				return pager;
			}

			public void setPager(PagerBean pager) {
				this.pager = pager;
			}

			public List<ItemsBean> getItems() {
				return items;
			}

			public void setItems(List<ItemsBean> items) {
				this.items = items;
			}

			public static class PagerBean {
				/**
				 * page : 1
				 * page_count : 1
				 * per_page : 20
				 * total_count : 11
				 */

				private int page;
				private int page_count;
				private int per_page;
				private int total_count;

				public int getPage() {
					return page;
				}

				public void setPage(int page) {
					this.page = page;
				}

				public int getPage_count() {
					return page_count;
				}

				public void setPage_count(int page_count) {
					this.page_count = page_count;
				}

				public int getPer_page() {
					return per_page;
				}

				public void setPer_page(int per_page) {
					this.per_page = per_page;
				}

				public int getTotal_count() {
					return total_count;
				}

				public void setTotal_count(int total_count) {
					this.total_count = total_count;
				}
			}

			public static class ItemsBean {
				/**
				 * avatar : http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg
				 * username : 游客1
				 * star : 3
				 * time : 30分钟前
				 */

				private String avatar;
				private String username;
				private int star;
				private String time;

				public String getAvatar() {
					return avatar;
				}

				public void setAvatar(String avatar) {
					this.avatar = avatar;
				}

				public String getUsername() {
					return username;
				}

				public void setUsername(String username) {
					this.username = username;
				}

				public int getStar() {
					return star;
				}

				public void setStar(int star) {
					this.star = star;
				}

				public String getTime() {
					return time;
				}

				public void setTime(String time) {
					this.time = time;
				}
			}
		}

		public static class RouteBean {
			/**
			 * img : ["http://120.79.137.110/storage/upload/20180228/Nf_LNsA7T-GFhH2hkevrOyxgSFbxgW7BoGUT8xsw.jpg"]
			 * id : 182
			 * name : 北京五环
			 */

			private String id;
			private String name;
			private List<String> img;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public List<String> getImg() {
				return img;
			}

			public void setImg(List<String> img) {
				this.img = img;
			}
		}
	}
}
