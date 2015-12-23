package com.warmtel.expandtab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PopTwoListView extends LinearLayout {
    private ListView parentListView;
    private ListView childListView;
    private List<KeyValueBean> groups = new ArrayList<KeyValueBean>();
    private List<KeyValueBean> childrenItem = new ArrayList<KeyValueBean>();
    private List<ArrayList<KeyValueBean>> children = new ArrayList<ArrayList<KeyValueBean>>();

    private PopViewAdapter childListViewAdapter;
    private PopViewAdapter parentListViewAdapter;
    private int mParentPosition = 0;
    private String mSelectParentKey = "";

    private String mDefaultParentText = null;
    private String mDefaultChildredText = null;
    private String mDefaultParentkey = null;
    private String mDefaultChildredkey = null;

    private ExpandPopTabView mExpandPopTabView;
    private OnSelectListener mOnSelectListener;

    public interface OnSelectListener {
        void getValue(String showText, String parentKey, String childrenKey);
    }

    public PopTwoListView(Context context) {
        super(context);
        init(context);
    }

    public PopTwoListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.expand_tab_popview2_layout, this, true);
        parentListView = (ListView) findViewById(R.id.parent_listView);
        childListView = (ListView) findViewById(R.id.child_listView);

        parentListViewAdapter = new PopViewAdapter(context);
        parentListViewAdapter.setTextSize(16);
        parentListViewAdapter.setSelectorResId(R.drawable.expand_tab_parent_item_selected, R.drawable.expand_tab_popview_item_selector);
        parentListView.setAdapter(parentListViewAdapter);
        parentListViewAdapter.setOnItemClickListener(new PopViewAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(PopViewAdapter adapter, int position) {
                if (position < children.size()) {
                    mParentPosition = position;
                    KeyValueBean keyValueBean = (KeyValueBean) adapter.getItem(position);
                    mSelectParentKey = keyValueBean.getKey();
                    childrenItem.clear();
                    childrenItem.addAll(children.get(position));
                    childListViewAdapter.setList(childrenItem);
                }
            }
        });

        childListViewAdapter = new PopViewAdapter(context);
        childListViewAdapter.setTextSize(14);
        childListViewAdapter.setSelectorResId(R.drawable.expand_tab_popview1_select, R.drawable.expand_tab_popview2_chilred_item_selector);
        childListView.setAdapter(childListViewAdapter);
        childListViewAdapter
                .setOnItemClickListener(new PopViewAdapter.OnItemClickListener() {

                    @Override
                    public void onItemClick(PopViewAdapter adapter, int position) {
                        KeyValueBean keyValueBean = (KeyValueBean) adapter.getItem(position);
                        if (mOnSelectListener != null) {
                            mExpandPopTabView.onExpandPopView();
                            mExpandPopTabView.setToggleButtonText(keyValueBean.getValue());
                            mOnSelectListener.getValue(keyValueBean.getValue(), mSelectParentKey, keyValueBean.getKey());
                        }

                    }
                });
    }

    private void setDefaultSelect(){
        if(children.size() <= 0){
            return;
        }
        parentListViewAdapter.setSelectorText(mDefaultParentText);
        int position = 0;
        for(KeyValueBean keyValueBean : groups){
            if(keyValueBean.getValue().equals(mDefaultParentText)){
                break;
            }
            ++position;
        }
        childrenItem.clear();
        childrenItem.addAll(children.get(position));
        childListViewAdapter.setSelectorText(mDefaultChildredText);
        childListViewAdapter.setList(childrenItem);
    }

    private void setDefaultSelectBykey(){
        if(children.size() <= 0){
            return;
        }

        int position = 0;
        for(KeyValueBean keyValueBean : groups){
            if(keyValueBean.getKey().equals(mDefaultParentkey)){
                parentListViewAdapter.setSelectorText(keyValueBean.getValue());
                break;
            }
            ++position;
        }
        childrenItem.clear();
        childrenItem.addAll(children.get(position));

        for(KeyValueBean keyValueBean : childrenItem){
            if(keyValueBean.getKey().equals(mDefaultChildredkey)){
                childListViewAdapter.setSelectorText(keyValueBean.getValue());
                break;
            }
        }
        childListViewAdapter.setList(childrenItem);
    }

    /**
     * 设置默认选中项通过内容
     * @param text1
     * @param text2
     */
    public void setDefaultSelectByValue(String text1,String text2){
        mDefaultParentText = text1;
        mDefaultChildredText = text2;
    }

    /**
     * 设置默认选中项通过关键字Key
     * @param key1
     * @param key2
     */
    public void setDefaultSelectByKey(String key1,String key2){
        mDefaultParentkey = key1;
        mDefaultChildredkey = key2;
    }
    public void setOnSelectListener(OnSelectListener onSelectListener) {
        mOnSelectListener = onSelectListener;
    }

    public void setAdapterData(List<KeyValueBean> _groups, List<ArrayList<KeyValueBean>> _children) {
        groups = _groups;
        children = _children;
        parentListViewAdapter.setList(_groups);
        childrenItem.addAll(children.get(mParentPosition));
        childListViewAdapter.setList(childrenItem);
        if(mDefaultParentText == null && mDefaultParentkey == null){
            if(children.size() < 0 )
                return;
            parentListViewAdapter.setSelectorText(groups.get(0).getValue());
            childrenItem.addAll(children.get(0));
        }else {
            if (mDefaultParentText != null) {
                setDefaultSelect();
            } else {
                setDefaultSelectBykey();
            }
        }
    }

    public void setCallBackAndData(ExpandPopTabView expandPopTabView, List<KeyValueBean> _groups, List<ArrayList<KeyValueBean>> _children, OnSelectListener onSelectListener) {
        groups = _groups;
        children = _children;
        parentListViewAdapter.setList(_groups);
        childrenItem.addAll(children.get(mParentPosition));
        childListViewAdapter.setList(childrenItem);
        mExpandPopTabView = expandPopTabView;
        mOnSelectListener = onSelectListener;

        if(mDefaultParentText == null && mDefaultParentkey == null){
            if(children.size() < 0 )
                return;
            parentListViewAdapter.setSelectorText(groups.get(0).getValue());
//            childrenItem.addAll(children.get(0));
        }else {
            if (mDefaultParentText != null) {
                setDefaultSelect();
            } else {
                setDefaultSelectBykey();
            }
        }
    }

}
