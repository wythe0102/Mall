package com.wythe.mall.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wythe.mall.R;

public class MallDialogFactory {

    private static MallDialogFactory instance;

    public static synchronized MallDialogFactory getInstance() {
        if (instance == null) {
            instance = new MallDialogFactory();
        }
        return instance;
    }

    /**
     * 创建样式1的dialog 只有文案和底部一个button
     *
     * @param context
     * @param message    提示消息内容
     * @param buttonText 底部按钮内容
     * @return
     * @throws IllegalArgumentException
     */
    public MallDialog createMallDialogWithStyle1(Context context, String message, String buttonText) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        if (TextUtils.isEmpty(message)) {
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(buttonText)) {
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        }

        MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_1);
        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.messageView.setText(message);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        dialog.posButton.setText(buttonText);
        dialog.useCancelClickEvent(dialog.posButton);

        return dialog;
    }

    public MallDialog createMallDialogWithStyle1_redbg(Context context, String message, String buttonText) {
        return createMallDialogWithStyle1_redbg(context, message, buttonText, -1);
    }

    public MallDialog createMallDialogWithStyle1_redbg(Context context, String message, String buttonText, int gravityParam) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        if (TextUtils.isEmpty(message)) {
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(buttonText)) {
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        }

        MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_1);
        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.messageView.setText(message);
        if (gravityParam != -1)
            dialog.messageView.setGravity(gravityParam);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        dialog.posButton.setText(buttonText);
        dialog.posButton.setBackgroundResource(R.drawable.button_a);
        dialog.posButton.setTextColor(context.getResources().getColorStateList(R.color.button_a_font_color));
        dialog.useCancelClickEvent(dialog.posButton);

        return dialog;
    }

    /**
     * 创建样式2的dialog 只有文案和底部两个button
     *
     * @param context
     * @param message         提示消息内容
     * @param leftButtonText  左边按钮的内容
     * @param rightButtonText 右边按钮的内容
     * @return
     * @throws IllegalArgumentException
     */
    public MallDialog createMallDialogWithStyle2(Context context, String message, String leftButtonText, String rightButtonText) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        if (TextUtils.isEmpty(message)) {
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(leftButtonText)) {
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(rightButtonText)) {
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        }

        MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_2);
        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.messageView.setText(message);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        dialog.posButton.setText(leftButtonText);
        dialog.useCancelClickEvent(dialog.posButton);

        dialog.negButton = (Button) dialog.findViewById(R.id.mall_dialog_neg_button);
        dialog.negButton.setText(rightButtonText);
        dialog.useCancelClickEvent(dialog.negButton);

        return dialog;
    }

    /**
     * 创建样式3的dialog 只有文案和底部两个button 中间输入框和图片
     *
     * @param context
     * @param message         提示消息内容
     * @param editHint        输入框的提示文案
     * @param imageUrl        输入框右边的图片imageUrl 如果要动态刷新此图片，可使用 JDImageLoaderUtil.displayImage(imageUrl, dialog.imageView); 进行动态刷新
     * @param leftButtonText  左边按钮的内容
     * @param rightButtonText 右边按钮的内容
     * @return
     * @throws IllegalArgumentException
     */
    public MallDialog createMallDialogWithStyle3(Context context, String message, String editHint, String imageUrl, String leftButtonText, String rightButtonText) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        if (TextUtils.isEmpty(message)) {
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(leftButtonText)) {
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(rightButtonText)) {
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        }

        MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_3);
        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.messageView.setText(message);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        dialog.posButton.setText(leftButtonText);

        dialog.useCancelClickEvent(dialog.posButton);

        dialog.negButton = (Button) dialog.findViewById(R.id.mall_dialog_neg_button);
        dialog.negButton.setText(rightButtonText);

        dialog.useCancelClickEvent(dialog.negButton);

        dialog.editText = (EditText) dialog.findViewById(R.id.mall_dialog_input_edit);
        dialog.imageView = (ImageView) dialog.findViewById(R.id.mall_dialog_input_image);

        if (!TextUtils.isEmpty(editHint)) {
            dialog.editText.setHint(editHint);
        }

        if (!TextUtils.isEmpty(imageUrl)) {
            //JDImageUtils.displayImage(imageUrl, dialog.imageView);
        }

        return dialog;
    }


    /**
     * 创建样式5的dialog 主标题和文案和底部一个button
     *
     * @param context
     * @param title      标题内容
     * @param message    提示消息内容
     * @param buttonText 底部按钮内容
     * @return
     * @throws IllegalArgumentException
     */
    public MallDialog createMallDialogWithStyle5(Context context, String title, String message, String buttonText) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        if (TextUtils.isEmpty(title)) {
            throw new IllegalArgumentException("the param title can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(message)) {
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(buttonText)) {
            throw new IllegalArgumentException("the param buttonText can not be empty in this dialog style");
        }

        MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_5);
        dialog.titleView = (TextView) dialog.findViewById(R.id.mall_dialog_title);
        dialog.titleView.setText(title);

        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.messageView.setText(message);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        dialog.posButton.setText(buttonText);
        dialog.useCancelClickEvent(dialog.posButton);

        return dialog;
    }

    /**
     * 创建样式6的dialog 标题和文案和底部两个button
     *
     * @param context
     * @param title           标题内容
     * @param message         提示消息内容
     * @param leftButtonText  左边按钮的内容
     * @param rightButtonText 右边按钮的内容
     * @return
     * @throws IllegalArgumentException
     */
    public MallDialog createMallDialogWithStyle6(Context context, String title, CharSequence message, String leftButtonText, String rightButtonText) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        if (TextUtils.isEmpty(title)) {
            throw new IllegalArgumentException("the param title can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(leftButtonText)) {
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(rightButtonText)) {
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        }

        MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_6);
        dialog.titleView = (TextView) dialog.findViewById(R.id.mall_dialog_title);
        dialog.titleView.setText(title);

        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.setMessage(message);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        dialog.posButton.setText(leftButtonText);
        dialog.useCancelClickEvent(dialog.posButton);

        dialog.negButton = (Button) dialog.findViewById(R.id.mall_dialog_neg_button);
        dialog.negButton.setText(rightButtonText);
        dialog.useCancelClickEvent(dialog.negButton);

        return dialog;
    }


    /**
     * 创建样式7的dialog 右标题和文案和底部两个button 中间输入框，输入框下提示文字
     *
     * @param context
     * @param title           标题
     * @param message         提示消息内容
     * @param editHint        输入框的提示文案
     * @param tipMessage      输入框下的提示文字
     * @param leftButtonText  左边按钮的内容
     * @param rightButtonText 右边按钮的内容
     * @return
     * @throws IllegalArgumentException
     */
    public MallDialog createMallDialogWithStyle7(final Context context, String title, String message, String editHint, String tipMessage, String leftButtonText, String rightButtonText) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        if (TextUtils.isEmpty(title)) {
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(message)) {
            throw new IllegalArgumentException("the param message can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(tipMessage)) {
            throw new IllegalArgumentException("the param tipMessage can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(leftButtonText)) {
            throw new IllegalArgumentException("the param leftButtonText can not be empty in this dialog style");
        }

        if (TextUtils.isEmpty(rightButtonText)) {
            throw new IllegalArgumentException("the param rightButtonText can not be empty in this dialog style");
        }

        final MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_7);
        dialog.titleView = (TextView) dialog.findViewById(R.id.mall_dialog_title);
        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.titleView.setText(title);
        dialog.messageView.setText(message);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        dialog.posButton.setText(leftButtonText);
        dialog.useCancelClickEvent(dialog.posButton);

        dialog.negButton = (Button) dialog.findViewById(R.id.mall_dialog_neg_button);
        dialog.negButton.setText(rightButtonText);

        dialog.editText = (EditText) dialog.findViewById(R.id.mall_dialog_input_edit);
        //获取EditText的DrawableRight
        final Drawable mClearDrawable = context.getResources().getDrawable(R.drawable.delete_selector);
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
        dialog.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Drawable right = charSequence.length() > 0 ? mClearDrawable : null;
                dialog.editText.setCompoundDrawables(dialog.editText.getCompoundDrawables()[0],
                        dialog.editText.getCompoundDrawables()[1], right, dialog.editText.getCompoundDrawables()[3]);
                if (charSequence.length() > 0) {
                    dialog.negButton.setBackgroundResource(R.drawable.button_a);
                    dialog.negButton.setTextColor(context.getResources().getColor(R.color.button_a_font_color));
                    dialog.negButton.setClickable(true);
                } else {
                    dialog.negButton.setBackgroundResource(R.drawable.dialog_style7_button_bg);
                    dialog.negButton.setTextColor(context.getResources().getColor(R.color.c_BFBFBF));
                    dialog.negButton.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        dialog.editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (dialog.editText.getCompoundDrawables()[2] != null) {
                        boolean touchable = event.getX() > (dialog.editText.getWidth() - dialog.editText.getTotalPaddingRight())
                                && (event.getX() < ((dialog.editText.getWidth() - dialog.editText.getPaddingRight())));

                        if (touchable) {
                            dialog.editText.setText("");
                        }
                    }
                }
                return false;
            }
        });
        dialog.tipLayout = (LinearLayout) dialog.findViewById(R.id.mall_dialog_tip_layout);
        dialog.tipTextView = (TextView) dialog.findViewById(R.id.mall_dialog_tip_message);
        dialog.tipTextView.setText(tipMessage);

        if (!TextUtils.isEmpty(editHint)) {
            dialog.editText.setHint(editHint);
        }

        return dialog;
    }

    /**
     * 创建样式9的dialog 标题和文案，底部两个button，和一个自定义区域
     *
     * @param context
     * @param title           标题内容
     * @param message         提示消息内容
     * @param view            自定义区域需要添加的view
     * @param leftButtonText  左边按钮的内容
     * @param rightButtonText 右边按钮的内容
     * @return
     * @throws IllegalArgumentException
     */
    public MallDialog createMallDialogWithStyle9(Context context, String title, String message, View view, String leftButtonText, String rightButtonText) throws IllegalArgumentException {

        if (context == null) {
            throw new IllegalArgumentException("the param context can not be null in this dialog style");
        }

        MallDialog dialog = new MallDialog(context);
        dialog.setContentView(R.layout.mall_common_dialog_style_9);
        dialog.titleView = (TextView) dialog.findViewById(R.id.mall_dialog_title);
        dialog.setTitle(title);

        dialog.messageView = (TextView) dialog.findViewById(R.id.mall_dialog_message);
        dialog.messageView.setMovementMethod(LinkMovementMethod.getInstance());
        dialog.setMessage(message);

        dialog.posButton = (Button) dialog.findViewById(R.id.mall_dialog_pos_button);
        if (TextUtils.isEmpty(leftButtonText)) {
            dialog.posButton.setVisibility(View.GONE);
        } else {
            dialog.posButton.setText(leftButtonText);
            dialog.useCancelClickEvent(dialog.posButton);
        }

        dialog.negButton = (Button) dialog.findViewById(R.id.mall_dialog_neg_button);
        if (TextUtils.isEmpty(rightButtonText)) {
            dialog.negButton.setVisibility(View.GONE);
        } else {
            dialog.negButton.setText(rightButtonText);
            dialog.useCancelClickEvent(dialog.negButton);
        }
        //当两button同时显示时，设置两button之接的距离
        if (!TextUtils.isEmpty(leftButtonText) && !TextUtils.isEmpty(rightButtonText)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dialog.negButton.getLayoutParams();
            layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.base_ui_mall_dialog_style9_button_child_margin);
            dialog.negButton.requestLayout();
        }

        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.bottomLayout);
        if (view == null) {
            linearLayout.setVisibility(View.GONE);
        } else {
            linearLayout.addView(view);
        }

        return dialog;
    }
}
