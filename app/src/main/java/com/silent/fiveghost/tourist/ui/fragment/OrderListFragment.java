package com.silent.fiveghost.tourist.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.PublishedOrderAdapter;
import com.silent.fiveghost.tourist.adapter.RecommendGuideAdapter;
import com.silent.fiveghost.tourist.adapter.RecommendHotPathAdapter;
import com.silent.fiveghost.tourist.bean.HomeBean;
import com.silent.fiveghost.tourist.bean.OrderEntity;
import com.silent.fiveghost.tourist.bean.PublishedOrderBean;
import com.silent.fiveghost.tourist.bean.TabEntity;
import com.silent.fiveghost.tourist.manager.FullyLinearLayoutManager;
import com.silent.fiveghost.tourist.presenter.IPresenter;
import com.silent.fiveghost.tourist.ui.BaseFragment;
import com.silent.fiveghost.tourist.ui.BaseFragment2;
import com.silent.fiveghost.tourist.ui.activity.GuideDetailActivity;
import com.silent.fiveghost.tourist.ui.activity.LoginActivity;
import com.silent.fiveghost.tourist.ui.activity.OrderDetailsActivity;
import com.silent.fiveghost.tourist.ui.activity.RoadDetailsActivity;
import com.silent.fiveghost.tourist.utils.UrlUtils;
import com.silent.fiveghost.tourist.view.IView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OrderListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OrderListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderListFragment extends BaseFragment2 {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private TabEntity mParam1;

    private OnFragmentInteractionListener mListener;
    @BindView(R.id.mSwipeRefreshLayout)
    public SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.mRecyclerView)
    public RecyclerView mRecyclerView;
    private IPresenter presenter;

    private Unbinder unbinder;
    private String mToken;
    private List<PublishedOrderBean.DataBean.ItemsBean> mList = new ArrayList<>();
    private PublishedOrderAdapter adapter;

    public OrderListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OrderListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderListFragment newInstance(TabEntity entity) {
        OrderListFragment fragment = new OrderListFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, entity);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initData() {
        SharedPreferences preferences = getActivity().getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
        mToken = preferences.getString("accessToken", "");
        presenter = new IPresenter(new IView<PublishedOrderBean>() {
            @Override
            public void success(PublishedOrderBean homeBean) {
                if (mSwipeRefreshLayout != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                    mSwipeRefreshLayout.setEnabled(true);
                }
                onSuccess(homeBean);
            }

            @Override
            public void defeat(String s) {
                mSwipeRefreshLayout.setRefreshing(false);
                mSwipeRefreshLayout.setEnabled(true);
                Log.e("HomeActivity", s);
            }
        });
        Map<String,String> mMap = new HashMap<>();
        mMap.put("accessToken",mToken);
        mMap.put("type",mParam1.getType());
        mMap.put("status",mParam1.getStatus());
        presenter.DoRequest(UrlUtils.ORDER_LIST + mToken,mMap);
    }
    //请求成功后数据渲染
    private void onSuccess(PublishedOrderBean homeBean) {
        if (homeBean.getData() != null) {
            if (homeBean.getData().getItems() != null) {
                mList.addAll(homeBean.getData().getItems());
                adapter.notifyDataSetChanged();
            } else {
                showToast("数据加载失败！");
            }
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (TabEntity) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }
    public void initView(){
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });
        FullyLinearLayoutManager manager = new FullyLinearLayoutManager(getActivity());
        DividerItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.custom_divider));
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addOnItemTouchListener(new com.chad.library.adapter.base.listener.OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), OrderDetailsActivity.class);
                intent.putExtra("order_id",mList.get(position).getOrder_id());
                startActivity(intent);
            }
        });
        adapter = new PublishedOrderAdapter(getContext(),mList);
        mRecyclerView.setAdapter(adapter);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
