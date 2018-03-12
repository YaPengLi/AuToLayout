package com.silent.fiveghost.tourist.bean;

import java.util.List;

/**
 * Created by 韩学文 on 2018/2/24.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public class HomeBean {

    /**
     * errcode : 1
     * errmsg : ok
     * data : {"advert":[{"img":"https://www.baidu.com/img/bd_logo1.png","href":"https://www.baidu.com/"},{"img":"https://www.baidu.com/img/bd_logo1.png","href":"https://www.baidu.com/"},{"img":"https://www.baidu.com/img/bd_logo1.png","href":"https://www.baidu.com/"}],"route":[{"rid":104,"name":"路线测试1","img":"http://120.79.137.110/assets/images/logo2.png"},{"rid":105,"name":"路线测试2","img":"http://120.79.137.110/assets/images/logo2.png"},{"rid":106,"name":"路线测试2","img":"http://120.79.137.110/assets/images/logo2.png"},{"rid":107,"name":"路线测试2","img":"http://120.79.137.110/assets/images/logo2.png"}],"guide":[{"gid":10,"username":"导游账户","avatar":"http://120.79.137.110/assets/images/logo2.png","good_line_desc":"擅长线路擅长线路擅长线路擅长线路擅长线路"},{"gid":10,"username":"导游账户","avatar":"http://120.79.137.110/assets/images/logo2.png","good_line_desc":"擅长线路擅长线路擅长线路擅长线路擅长线路"},{"gid":10,"username":"导游账户","avatar":"http://120.79.137.110/assets/images/logo2.png","good_line_desc":"擅长线路擅长线路擅长线路擅长线路擅长线路"}]}
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
        private List<AdvertBean> advert;
        private List<RouteBean> route;
        private List<GuideBean> guide;

        public List<AdvertBean> getAdvert() {
            return advert;
        }

        public void setAdvert(List<AdvertBean> advert) {
            this.advert = advert;
        }

        public List<RouteBean> getRoute() {
            return route;
        }

        public void setRoute(List<RouteBean> route) {
            this.route = route;
        }

        public List<GuideBean> getGuide() {
            return guide;
        }

        public void setGuide(List<GuideBean> guide) {
            this.guide = guide;
        }

        public static class AdvertBean {
            /**
             * img : https://www.baidu.com/img/bd_logo1.png
             * href : https://www.baidu.com/
             */

            private String img;
            private String href;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class RouteBean {
            /**
             * rid : 104
             * name : 路线测试1
             * img : http://120.79.137.110/assets/images/logo2.png
             */

            private int rid;
            private String name;
            private String img;
            private String desc;

            public int getRid() {
                return rid;
            }

            public void setRid(int rid) {
                this.rid = rid;
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

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }

        public static class GuideBean {
            /**
             * gid : 10
             * username : 导游账户
             * avatar : http://120.79.137.110/assets/images/logo2.png
             * good_line_desc : 擅长线路擅长线路擅长线路擅长线路擅长线路
             */

            private int gid;
            private String username;
            private String avatar;
            private String good_line_desc;

            public int getGid() {
                return gid;
            }

            public void setGid(int gid) {
                this.gid = gid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getGood_line_desc() {
                return good_line_desc;
            }

            public void setGood_line_desc(String good_line_desc) {
                this.good_line_desc = good_line_desc;
            }
        }
    }
}
