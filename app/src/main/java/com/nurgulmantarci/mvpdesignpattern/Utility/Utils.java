package com.nurgulmantarci.mvpdesignpattern.Utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.Build;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.gson.Gson;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;
import com.nurgulmantarci.mvpdesignpattern.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Response;

public class Utils {

    public static String getCurrentLanguage(){
        return Locale.getDefault().getLanguage();
    }

    public static void setCurrentLanguage(Activity activity,String languageCode ){
        Locale locale=null;
        languageCode=languageCode.toLowerCase();
        if(languageCode.equals("tr")){
            locale=new Locale("tr","TR");
        }else{
            locale=new Locale("en_US");
        }

        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        activity.getBaseContext().getResources().updateConfiguration(config,activity.getBaseContext().getResources().getDisplayMetrics());
    }


    public static ProgressDialog showLoadingDialog(Context context){
        ProgressDialog progressDialog=new ProgressDialog(context);
        progressDialog.show();
        if(progressDialog.getWindow()!=null){
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }


    public static void changeActivity(Activity activity, Class<?> goClass){
        Intent intent=new Intent(activity,goClass);
        activity.startActivity(intent);
    }

    public static String getUdid(Context context){
        String udid= Settings.Secure.getString(context.getContentResolver(),Settings.Secure.ANDROID_ID);
        return udid;
    }

    public static String getAppVersion(Context context){
        PackageManager manager=context.getPackageManager();
        try{
            PackageInfo info= manager.getPackageInfo(context.getPackageName(),0);
            return String.valueOf(info.versionCode);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getVersionOfApp(){
        return String.valueOf(Build.VERSION.SDK_INT);
    }


    public static void shareToOtherPlartforms(Activity activity,String title, String text){
        Intent shareIntent=new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,title);
        shareIntent.putExtra(Intent.EXTRA_TEXT,text);
        shareIntent.setType("text/plain");
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(Intent.createChooser(shareIntent,title));
    }

    public static String longToddMMMyyyy(long date){
        String dateString= new SimpleDateFormat("dd MMM yyyy").format(new Date(date));
        return dateString;
    }

    public static String longTohhmm(long date){
        String dateString=new SimpleDateFormat("HH:mm").format(new Date(date));
        return dateString;
    }

    public static String longToddMMyyyy(long date) {
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date(date));
        return dateString;
    }

    public static String longTodd(long date) {
        String dateString = new SimpleDateFormat("dd").format(new Date(date));
        return dateString;
    }

    public static String longToMMM(long date) {
        String dateString = new SimpleDateFormat("MMM").format(new Date(date));
        return dateString;
    }

    public static CommonResponse errorHandler(Response<?> response){
        CommonResponse errorResponce=null;
        try{
            Gson gson = new Gson();
            errorResponce=gson.fromJson(response.errorBody().string(), CommonResponse.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return errorResponce;
    }


    public static void openKeyboard(EditText editText,Activity activity){
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

}











