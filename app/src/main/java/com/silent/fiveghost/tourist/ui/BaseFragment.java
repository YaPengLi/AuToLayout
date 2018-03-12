package com.silent.fiveghost.tourist.ui;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * @author FunChen
 * @ClassName: ${TYPE_NAME}
 * @Description: ${TODO}(Fragment 父类)
 * @date 2018/3/7 10:22
 * <p>
 * ${TAGS}
 */
public class BaseFragment extends Fragment {

	protected int pageSize = 20;
	protected int pageCurrent = 1;

	/**
	 * [简化Toast]
	 *
	 * @param msg
	 */
	protected void showToast(String msg) {
		Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
	}


}