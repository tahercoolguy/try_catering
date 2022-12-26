package com.infovass.catering.activities.utill;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.infovass.catering.R;

public class ProgressHUD extends Dialog {
   public static  ProgressHUD dialog;
    public ProgressHUD(Context context) {
        super(context);
    }


    public ProgressHUD(Context context, int theme) {
        super(context, theme);
    }

    public static ProgressHUD create(Context context, CharSequence message, boolean cancelable,
                                   OnCancelListener cancelListener, Typeface font) {
          dialog = new ProgressHUD(context, R.style.ProgressHUD);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_hud);
        if (message == null || message.length() == 0) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView) dialog.findViewById(R.id.message);
            txt.setTypeface(font);
            txt.setText(message);
        }
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
//        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        return dialog;

    }

    public static void showDialog(){
        if(dialog!=null){
            dialog.show();
        }

    }

    public void onWindowFocusChanged(boolean hasFocus) {
//        ImageView imageView = (ImageView) findViewById(R.id.spinnerImageView);
//        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
//        spinner.start();
    }

    public void setMessage(CharSequence message, Typeface font) {
        if (message != null && message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.message);
            txt.setText(message);
            txt.setTypeface(font);
            txt.invalidate();
        }
    }
}
