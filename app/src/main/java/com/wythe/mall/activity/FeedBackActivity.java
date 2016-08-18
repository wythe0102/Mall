package com.wythe.mall.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wythe.mall.R;
import com.wythe.mall.view.PersonalItemTitle;

/**
 * Created by wythe on 2016/7/17.
 */
public class FeedBackActivity extends BaseActivity {

    private PersonalItemTitle mFeebackTypeSelector;

    private EditText mFeedbackContent, mFeedbackContact;
    private TextView mInputCount;

    private String[] items;
    private int mFeedbackTypeIndex = 0;
    private final int MAX_LENGTH = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        super.setNormalTitle(R.string.feedback);
        // data
        items = getResources().getStringArray(R.array.pg_new_feedback_contact_type);
        mFeebackTypeSelector = (PersonalItemTitle) findViewById(R.id.feedback_type_view);
        mFeebackTypeSelector.setMessage(items[0]);
        mFeedbackTypeIndex = 0;
        mFeebackTypeSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FeedBackActivity.this);
                alertDialogBuilder.setTitle(R.string.pg_new_feedback_type);
                alertDialogBuilder.setSingleChoiceItems(items, mFeedbackTypeIndex, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mFeedbackTypeIndex = which;
                        mFeebackTypeSelector.setMessage(items[which]);

                    }
                });
                alertDialogBuilder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialogBuilder.show();
            }
        });

        mFeedbackContent = (EditText) findViewById(R.id.feedback_content);// 意见反馈内容

        mFeedbackContact = (EditText) findViewById(R.id.feedback_contact_content);// 意见反馈人的联系方式

        mInputCount = (TextView) findViewById(R.id.feedback_content_count);
        mInputCount.setText(0 + "/" + MAX_LENGTH);
        mFeedbackContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mInputCount.setText(s.toString().length() + "/" + MAX_LENGTH);
            }
        });

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
