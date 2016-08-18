package com.wythe.mall.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Map;

/**
 * Created by wythe on 2015/9/1.
 */
public class GotoActivity {

    public static void gotoActiviy(Activity activity, Class c){
        gotoActiviy(activity,c,false);
    }

    public static void gotoActiviy(Activity context, Class target, boolean finish){
        Intent intent = new Intent(context,target);
        context.startActivity(intent);
        if (finish){
            context.finish();
        }
    }

    public static void gotoActiviy(Activity context, Class target, Bundle params){
        gotoActiviy(context,target,params,false);
    }

    public static void gotoActiviy(Activity context, Class target,Bundle params, boolean finish){
        Intent intent = new Intent(context,target);
        if (params != null){
            intent.putExtras(params);
        }
        context.startActivity(intent);
        if (finish){
            context.finish();
        }
    }

    public static void gotoActivityForResults(Activity context, Class target, int requestCode){
        gotoActivityForResults(context, target, requestCode);
    }

    public static void gotoActivityForResults(Activity context, Class target, Bundle params, int requestCode){
        Intent intent = new Intent(context,target);
        if (params != null){
            intent.putExtras(params);
        }
        context.startActivityForResult(intent, requestCode);
    }
}
