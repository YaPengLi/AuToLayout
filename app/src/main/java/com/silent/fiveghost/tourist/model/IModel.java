package com.silent.fiveghost.tourist.model;

import java.util.Map;

/**
 * Created by 韩学文 on 2018/1/27.
 * 愿我余生从心所欲任性妄为
 * 宁愿做灯红酒绿中张牙舞爪的鬼
 * 也不做平淡生活里委曲求全的谁
 */

public interface IModel {
    void request(String url, Map<String, String> map, CallBack callBack);
    void GetRequst(String url,CallBack callBack);
}
