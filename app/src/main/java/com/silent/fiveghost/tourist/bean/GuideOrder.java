package com.silent.fiveghost.tourist.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/18.
 */

public class GuideOrder {
    /**
     * errcode : 1
     * errmsg : ok
     * data : {"id":"205","name":"游客定制线路","img":"","order_id":"2018022797321626","desc":"","price":"0.00","children_price":"0.00","travel_time":"2018-01-01 00:00:00","tourist_num":11,"tourist_info":[{"id":22,"avatar":"http://120.79.137.110/assets/images/logo2.png"}],"comment_star":4.3,"comment":{"items":[{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客1","star":3,"time":"30分钟前"},{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客2","star":4,"time":"2018年1月5日"}],"pager":{"page":1,"page_count":1,"per_page":20,"total_count":11}}}
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
         * id : 205
         * name : 游客定制线路
         * img :
         * order_id : 2018022797321626
         * desc :
         * price : 0.00
         * children_price : 0.00
         * travel_time : 2018-01-01 00:00:00
         * tourist_num : 11
         * tourist_info : [{"id":22,"avatar":"http://120.79.137.110/assets/images/logo2.png"}]
         * comment_star : 4.3
         * comment : {"items":[{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客1","star":3,"time":"30分钟前"},{"avatar":"http://ww2.sinaimg.cn/bmiddle/8bab6b23gy1foquorigjzj20xc0tdwl3.jpg","username":"游客2","star":4,"time":"2018年1月5日"}],"pager":{"page":1,"page_count":1,"per_page":20,"total_count":11}}
         */

        private String id;
        private String name;
        private String img;
        private String order_id;
        private String desc;
        private String price;
        private String children_price;
        private String travel_time;
        private int tourist_num;
        private double comment_star;
        private CommentBean comment;
        private List<TouristInfoBean> tourist_info;

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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getChildren_price() {
            return children_price;
        }

        public void setChildren_price(String children_price) {
            this.children_price = children_price;
        }

        public String getTravel_time() {
            return travel_time;
        }

        public void setTravel_time(String travel_time) {
            this.travel_time = travel_time;
        }

        public int getTourist_num() {
            return tourist_num;
        }

        public void setTourist_num(int tourist_num) {
            this.tourist_num = tourist_num;
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

        public List<TouristInfoBean> getTourist_info() {
            return tourist_info;
        }

        public void setTourist_info(List<TouristInfoBean> tourist_info) {
            this.tourist_info = tourist_info;
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

        public static class TouristInfoBean {
            /**
             * id : 22
             * avatar : http://120.79.137.110/assets/images/logo2.png
             */

            private int id;
            private String avatar;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
