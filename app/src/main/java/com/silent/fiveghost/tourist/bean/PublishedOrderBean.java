package com.silent.fiveghost.tourist.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/16.
 */

public class PublishedOrderBean implements Serializable{
    /**
     * errcode : 1
     * errmsg : ok
     * data : {"items":[{"id":"177","order_id":"2018022456086294","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":12,"recommend_num":13,"comment_num":19},{"id":"178","order_id":"2018022456157651","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":13,"recommend_num":7,"comment_num":20},{"id":"180","order_id":"2018022457819982","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":19,"recommend_num":9,"comment_num":17},{"id":"181","order_id":"2018022457891884","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":12,"recommend_num":10,"comment_num":15}],"pager":{"page":1,"page_count":1,"per_page":20,"total_count":4}}
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
         * items : [{"id":"177","order_id":"2018022456086294","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":12,"recommend_num":13,"comment_num":19},{"id":"178","order_id":"2018022456157651","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":13,"recommend_num":7,"comment_num":20},{"id":"180","order_id":"2018022457819982","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":19,"recommend_num":9,"comment_num":17},{"id":"181","order_id":"2018022457891884","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"游客定制线路","status":"1","payment_num":12,"recommend_num":10,"comment_num":15}]
         * pager : {"page":1,"page_count":1,"per_page":20,"total_count":4}
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
             * total_count : 4
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
             * id : 177
             * order_id : 2018022456086294
             * img : https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png
             * name : 游客定制线路
             * status : 1
             * payment_num : 12
             * recommend_num : 13
             * comment_num : 19
             */

            private String id;
            private String order_id;
            private String img;
            private String name;
            private String status;
            private int payment_num;
            private int recommend_num;
            private int comment_num;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getPayment_num() {
                return payment_num;
            }

            public void setPayment_num(int payment_num) {
                this.payment_num = payment_num;
            }

            public int getRecommend_num() {
                return recommend_num;
            }

            public void setRecommend_num(int recommend_num) {
                this.recommend_num = recommend_num;
            }

            public int getComment_num() {
                return comment_num;
            }

            public void setComment_num(int comment_num) {
                this.comment_num = comment_num;
            }
        }
    }
}
