package dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.cool.android_networking.R;

/**
 * Created by rajesh on 4/29/2016.
 */
public class CustomDialog extends ProgressDialog {

    private AnimationDrawable animationDrawable;

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }


    public CustomDialog(Context context) {
        super(context);
    }


    public static ProgressDialog creator(Context ctx) {

        CustomDialog customDialog = new CustomDialog(ctx);
        customDialog.setIndeterminate(true);
        customDialog.setCancelable(false);
        return customDialog;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_progress_dialog);
        ImageView animate = (ImageView) findViewById(R.id.animation);
        animate.setBackgroundResource(R.drawable.custom_progress_dialog_animation);
        animationDrawable = (AnimationDrawable) animate.getBackground();


    }//oncreate


    @Override
    public void show() {
        super.show();
        animationDrawable.start();
    }


    @Override
    public void dismiss() {
        super.dismiss();
        animationDrawable.stop();
    }


}//CustomDialog
