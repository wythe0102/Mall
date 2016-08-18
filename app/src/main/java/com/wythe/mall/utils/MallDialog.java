package com.wythe.mall.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wythe.mall.R;

public class MallDialog extends Dialog {

    /**
     * 左边按钮或上面按钮
     */
    public Button posButton;

    /**
     * 右边按钮或下面按钮
     */
    public Button negButton;

    // ------------------------------------------------

    /**
     * 输入框的包裹View
     */
    public LinearLayout inputLayout;

    /**
     * 输入框
     */
    public EditText editText;

    /**
     * 输入框右边图片
     */
    public ImageView imageView;

    /**
     * 输入框右下方的提示文案
     */
    public LinearLayout tipLayout;
    public TextView tipTextView;

    /**
     * 消息控件
     */
    public TextView titleView;

    /**
     * 副标题控件
     */
    public TextView secondTitleView;

    /**
     * 消息控件
     */
    public TextView messageView;

    /**
     * 消息控件2
     */
    public TextView secondMessageView;


    // ------------------------------------------------

    public MallDialog(Context context) {
        super(context, R.style.Mall_Dialog_Common);
        setCancelable(false);
    }

    public MallDialog(Context context, int style) {
        super(context, style);
        setCancelable(false);
    }

    /**
     * 点击事件，点击后取消界面显示
     */
    private View.OnClickListener cancelClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cancel();
        }
    };

    /**
     * 设置dialog里的标题内容
     *
     * @param title 具体标题内容，不能为空
     */
    public void setTitle(String title) {
        if (titleView != null) {
            if (!TextUtils.isEmpty(title)) {
                titleView.setVisibility(View.VISIBLE);
                titleView.setText(title);
            } else {
                titleView.setVisibility(View.GONE);
            }
        }
    }

    public void setSecondTitle(String secondTitle) {
        if (secondTitleView != null) {
            if (!TextUtils.isEmpty(secondTitle)) {
                secondTitleView.setText(secondTitle);
            } else {
                secondTitleView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置dialog里的消息内容
     *
     * @param message 具体消息内容，不能为空
     */
    public void setMessage(CharSequence message) {
        if (messageView != null) {
            if (!TextUtils.isEmpty(message)) {
                messageView.setVisibility(View.VISIBLE);
                messageView.setText(message);
            } else {
                messageView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置dialog里的消息内容的对齐方式
     *
     * @param position Gravity.LEFT  Gravity.CENTER等
     */
    public void setMessagePosition(int position) {
        if (messageView != null) {
            messageView.setGravity(position);
        }
    }


    public void setSecondMessage(String message) {
        if (secondMessageView != null) {
            if (!TextUtils.isEmpty(message)) {
                secondMessageView.setText(message);
            } else {
                secondMessageView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 设置dialog里的消息内容的颜色
     *
     * @param color 具体消息内容的颜色
     */
    public void setMessageColor(int color) {
        if (messageView != null) {
            messageView.setTextColor(color);
        }
    }

    /**
     * 设置dialog里输入框的提示内容
     *
     * @param hint
     */
    public void setEditTextHint(String hint) {
        if (editText != null && hint != null) {
            editText.setHint(hint);
        }
    }

    /**
     * 设置dialog里输入框的内容
     *
     * @param content
     */
    public void setEditText(String content) {
        if (editText != null && content != null) {
            editText.setText(content);
        }
    }

    /**
     * 设置dialog里提示内容的点击事件
     *
     * @param listener
     */
    public void setTipMessageClickListener(View.OnClickListener listener) {
        if (tipLayout != null && listener != null) {
            tipLayout.setOnClickListener(listener);
        }
    }


    /**
     * 适配某个view点击后，销毁dialog
     *
     * @param view
     */
    public void useCancelClickEvent(View view) {
        if (view != null) {
            view.setOnClickListener(cancelClickListener);
        }
    }

    /**
     * 设置左边或上面按钮点击事件
     *
     * @param clickListener
     */
    public void setOnLeftButtonClickListener(View.OnClickListener clickListener) {
        if (posButton != null) {
            posButton.setOnClickListener(clickListener);
        }
    }

    /**
     * 设置右边或下面按钮点击事件
     * style 1 的情况下没有此方法
     *
     * @param clickListener
     */
    public void setOnRightButtonClickListener(View.OnClickListener clickListener) {
        if (negButton != null) {
            negButton.setOnClickListener(clickListener);
        }
    }

    /**
     * 设置右边或下面按钮点击事件
     * clickable 按钮是否可点击
     *
     * @param clickListener
     */
    public void setOnRightButtonClickListener(View.OnClickListener clickListener, boolean clickable) {
        if (negButton != null) {
            negButton.setOnClickListener(clickListener);
            negButton.setClickable(clickable);
        }
    }

    //设置ListView的最大高度为dialog内容的最大高度
    protected void setTotalHeightofListView(ListView listView) {
        ListAdapter mAdapter = listView.getAdapter();
        if (mAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View mView = mAdapter.getView(i, null, listView);
            mView.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += mView.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        int contentMaxHeight = (int) (getContext().getResources().getDimension(R.dimen.base_ui_mall_dialog_content_maxheight));
        if (height > contentMaxHeight) {
            params.height = contentMaxHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();
        }
    }

}
