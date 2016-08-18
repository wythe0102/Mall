package com.wythe.mall.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.wythe.mall.R;
import com.wythe.mall.utils.DPIUtil;


public class PerLayout extends RelativeLayout {

    private static final String TAG = "PerLayout";
    private final ViewDragHelper mDragHelper;
    private boolean isFirstIn = false;
    private boolean mInLayout = false;
    private boolean isRefreshing = false;
    private boolean isMove = false;
    private boolean isPenTap = false;
    private boolean isTapUp = false;
    private boolean isPressed = false;
    private boolean isDown = false;

    private View mTouchView;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mDragRange;
    private int mTop;
    private int mLeft;
    private float mDragOffset;
    private float mDragOffsetH;

    public PerLayout(Context context) {
        this(context, null);
    }

    public PerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mDragHelper = ViewDragHelper.create(this, 1f, new DragHelperCallback());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTouchView = findViewById(R.id.personal_kf);
        mTop = getPaddingTop();
        isFirstIn = true;
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            invalidate();
            isRefreshing = true;
        } else if (isRefreshing) {
            isRefreshing = false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if (mTouchView.getVisibility() != View.VISIBLE) {
            return super.onInterceptTouchEvent(ev);
        }

        final int action = MotionEventCompat.getActionMasked(ev);

        if ((action != MotionEvent.ACTION_DOWN)) {
            mDragHelper.cancel();
            return super.onInterceptTouchEvent(ev);
        }

        final float x = ev.getX();
        final float y = ev.getY();
        boolean interceptTap = false;

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mInitialMotionX = x;
                mInitialMotionY = y;
                interceptTap = mDragHelper.isViewUnder(mTouchView, (int) x, (int) y);
                break;
            }

        }

        if (mDragHelper.shouldInterceptTouchEvent(ev) || interceptTap) {
            return true;
        } else {
            return super.onInterceptTouchEvent(ev);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        final float x = ev.getX();
        final float y = ev.getY();

        boolean isHeaderViewUnder = mDragHelper.isViewUnder(mTouchView, (int) x, (int) y);
        switch (action & MotionEventCompat.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                mInitialMotionX = x;
                mInitialMotionY = y;
                isMove = false;
                isTapUp = false;
                isDown = true;
                isPenTap = false;
                if (isHeaderViewUnder) {
                    mTouchView.setPressed(true);
                    isPressed = true;
                } else {
                    isPressed = false;
                }
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                if (isDown) {
                    isDown = false;
                    isPenTap = true;
                }
                if (!isMove) {
                    final float dx = x - mInitialMotionX;
                    final float dy = y - mInitialMotionY;
                    final int slop = (mDragHelper.getTouchSlop() / 2);
                    if (dx * dx + dy * dy >= slop * slop && isPressed) {
                        isMove = true;
                        isPenTap = false;
                    }
                }
                break;
            }

            case MotionEvent.ACTION_UP: {
                final float dx = x - mInitialMotionX;
                final float dy = y - mInitialMotionY;
                final int slop = (mDragHelper.getTouchSlop() / 2);
                if (!isMove && dx * dx + dy * dy < slop * slop && isHeaderViewUnder) {

                    isTapUp = true;

                    mTouchView.setPressed(false);
                    isMove = false;
                    isDown = false;
                    isPressed = false;
                    isPenTap = false;

//                    PersonalInfoManager personalInfoManager = PersonalInfoManager.getInstance();
//
//                    if (personalInfoManager != null && personalInfoManager.isAvailable()) {
//                        final String url = personalInfoManager.mCustomerService != null ? personalInfoManager.mCustomerService.url : null;
//                        if (!TextUtils.isEmpty(url)) {
//
//                            final Runnable mTokenRunnable = new Runnable() {
//                                public void run() {
//
//                                    URLParamMap param = new URLParamMap();
//                                    param.put("to", url);
//                                    CommonUtil.queryBrowserUrl("to", param, new CommonBase.BrowserUrlListener() {
//
//                                        @Override
//                                        public void onComplete(final String url) {
//                                            post(new Runnable() {
//                                                public void run() {
//
//                                                    if (Log.D) {
//                                                        Log.d(TAG, " onComplete -->>  : ");
//                                                    }
//                                                    Intent intent = new Intent(getContext(), WebActivity.class);
//                                                    intent.putExtra("url", url);
//                                                    getContext().startActivity(intent);
//                                                }
//                                            });
//
//                                        }
//                                    });
                                    //先跳转到webActivity然后gentoken
//                                    Intent intent = new Intent(getContext(), WebActivity.class);
//                                    SerializableContainer container=new SerializableContainer();
//                                    container.setMap(param);
//                                    intent.putExtra(WebActivity.URL_PARAMS,container);
//                                    intent.putExtra(WebActivity.URL_ACTION,"to");
//                                    getContext().startActivity(intent);
//
//                                }
//                            };
//                            LoginUser.getInstance().executeLoginRunnable((BaseActivity) getContext(), mTokenRunnable);
//
//                            JDMtaUtils.onClick(getContext(), "MyJD_PersonalCSFloat", JDPersonalFragment.class.getName());
//                        }
//                    }
//
//                } else {
//                    isTapUp = false;
                }
                mTouchView.setPressed(false);
                isMove = false;
                isDown = false;
                isPressed = false;
                break;
            }
        }
        boolean notProcess = isPenTap && ((action & MotionEventCompat.ACTION_MASK) == MotionEvent.ACTION_MOVE);
        if (!notProcess) {
            try {
                mDragHelper.processTouchEvent(ev);
            } catch (Exception e) {
            }
        }
        if (isPenTap) {
            if ((action & MotionEventCompat.ACTION_MASK) == MotionEvent.ACTION_UP || (action & MotionEventCompat.ACTION_MASK) == MotionEvent.ACTION_CANCEL) {
                isPenTap = false;
            }
        }
        return isHeaderViewUnder && isViewHit(mTouchView, (int) x, (int) y);
    }

    private boolean isViewHit(View view, int x, int y) {
        int[] viewLocation = new int[2];
        view.getLocationOnScreen(viewLocation);
        int[] parentLocation = new int[2];
        this.getLocationOnScreen(parentLocation);
        int screenX = parentLocation[0] + x;
        int screenY = parentLocation[1] + y;
        return screenX >= viewLocation[0] && screenX < viewLocation[0] + view.getWidth() &&
                screenY >= viewLocation[1] && screenY < viewLocation[1] + view.getHeight();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mInLayout = true;

        super.onLayout(changed, l, t, r, b);

        if (mTouchView.getVisibility() == View.VISIBLE && mTouchView.getWidth() > 0) {
            mDragRange = getHeight() - mTouchView.getHeight();

            if (isFirstIn) {
                isFirstIn = false;

                if (DPIUtil.getWidth() == 720 && DPIUtil.getHeight() > 1000) {
                    mTop = 765;
                } else if (DPIUtil.getWidth() == 1080 && DPIUtil.getHeight() > 1350) {
                    mTop = 1140;
                } else {
                    mTop = (getHeight() / 2);
                }

                mLeft = getWidth() - mTouchView.getWidth();
            }

            mTouchView.layout(
                    mLeft,
                    mTop,
                    mLeft + mTouchView.getMeasuredWidth(),
                    mTop + mTouchView.getMeasuredHeight());
        }

        mInLayout = false;
    }

    @Override
    public void requestLayout() {
        if (!mInLayout) {
            super.requestLayout();
        }
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child == mTouchView;
        }

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            if (!isPenTap) {
                isRefreshing = true;
                mTop = top;
                mLeft = left;
                mDragOffset = (float) top / mDragRange;
                mDragOffsetH = (float) left / (getWidth() - mTouchView.getWidth());
                requestLayout();
            }
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {

            if (isTapUp) {
                isTapUp = false;
                return;
            }

            if (mDragOffsetH <= mDragOffset && (mDragOffsetH + mDragOffset) >= 1.0f) {
                int finalLeft = Math.max(getPaddingLeft(), Math.min(releasedChild.getLeft(), getWidth() - getPaddingLeft() - getPaddingRight() - releasedChild.getWidth()));
                mDragHelper.settleCapturedViewAt(finalLeft, /*mDragRange*/getHeight() - releasedChild.getHeight() - getPaddingTop());
                invalidate();
            } else if (mDragOffsetH >= mDragOffset && (mDragOffsetH + mDragOffset) <= 1.0f) {
                int finalLeft = Math.max(getPaddingLeft(), Math.min(releasedChild.getLeft(), getWidth() - getPaddingLeft() - getPaddingRight() - releasedChild.getWidth()));
                mDragHelper.settleCapturedViewAt(finalLeft, getPaddingTop());
                invalidate();
            } else if (mDragOffsetH >= mDragOffset && (mDragOffsetH + mDragOffset) >= 1.0f) {
                int finalTop = Math.max(getPaddingTop(), Math.min(releasedChild.getTop(), getHeight() - getPaddingTop() - getPaddingBottom() - releasedChild.getHeight()));
                mDragHelper.settleCapturedViewAt(getWidth() - releasedChild.getWidth() /*- getPaddingRight()*/, finalTop);
                invalidate();
            } else if (mDragOffsetH <= mDragOffset && (mDragOffsetH + mDragOffset) <= 1.0f) {
                int finalTop = Math.max(getPaddingTop(), Math.min(releasedChild.getTop(), getHeight() - getPaddingTop() - getPaddingBottom() - releasedChild.getHeight()));
                mDragHelper.settleCapturedViewAt(getPaddingLeft(), finalTop);
                invalidate();
            }


        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return mDragRange;
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return getWidth() - mTouchView.getWidth();
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            final int topBound = getPaddingTop() - child.getHeight();
            final int bottomBound = getHeight() - getPaddingBottom();

            final int newTop = Math.min(Math.max(top, topBound), bottomBound);

            return newTop;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            final int leftBound = getPaddingLeft() - child.getWidth();
            final int rightBound = getWidth() - getPaddingLeft() - getPaddingRight();

            final int newLeft = Math.min(Math.max(left, leftBound), rightBound);

            return newLeft;
        }

        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }
    }
}
