package com.infovass.catering.Helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by best on 11/13/2015.
 */
public class MessageBox {
    public enum MessageBoxResult
    {
        Positive, Negative, Ignore, Cancel, Closed
    };

    private static MessageBoxResult yesNoDialogResult;
    public static MessageBoxResult showYesNo(
            Context context, String title, String message, String positiveMessage, String negativeMessage )
    {
        yesNoDialogResult = MessageBoxResult.Closed;

        // make a handler that throws a runtime exception when a message is received
        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        // make a text input dialog and show it
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);

        alert.setPositiveButton(positiveMessage, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                yesNoDialogResult = MessageBoxResult.Positive;
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton(negativeMessage, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                yesNoDialogResult = MessageBoxResult.Negative;
                handler.sendMessage(handler.obtainMessage());
            }
        });

        alert.show();

        // loop till a runtime exception is triggered.
        try { Looper.loop(); }
        catch(RuntimeException e2) {}

        return yesNoDialogResult;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    private static MessageBoxResult okDialogResult;
    public static MessageBoxResult showOk(
            Context context, String title, String message, String okMessage)
    {
        okDialogResult = MessageBoxResult.Closed;

        // make a handler that throws a runtime exception when a message is received
        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);

        alert.setPositiveButton(okMessage, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {
                okDialogResult = MessageBoxResult.Positive;
                handler.sendMessage(handler.obtainMessage());
            }
        });

        AlertDialog dialog = alert.show();


        // align button to center
        Button b = (Button) dialog.findViewById(android.R.id.button1);
        b.setGravity(Gravity.CENTER_HORIZONTAL);

        // loop till a runtime exception is triggered.
        try { Looper.loop(); }
        catch(RuntimeException e2) {}

        return okDialogResult;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String inputBoxDialogResult;
    public static String showInput(
            Context context, String title, String message, String okMessage, boolean isPassword)
    {
        inputBoxDialogResult = null;

        // make a handler that throws a runtime exception when a message is received
        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message mesg)
            {
                throw new RuntimeException();
            }
        };

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);

        final EditText input = new EditText(context);
        input.setFocusable(true);

        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        if(isPassword)
        {
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
        else
        {
            input.setInputType(InputType.TYPE_CLASS_TEXT);
        }

        alert.setView(input);

        alert.setPositiveButton(okMessage, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int whichButton) {

                inputBoxDialogResult = input.getText().toString();
                handler.sendMessage(handler.obtainMessage());
            }
        });

        AlertDialog dialog = alert.show();


        // align button to center
        Button b = (Button) dialog.findViewById(android.R.id.button1);
        b.setGravity(Gravity.CENTER_HORIZONTAL);

        // loop till a runtime exception is triggered.
        try { Looper.loop(); }
        catch(RuntimeException e2) {}

        return inputBoxDialogResult;
    }
}
