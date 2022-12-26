package com.infovass.catering.activities.utill;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.infovass.catering.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Common {
    public static String CONTAINER_FRAGMENT = "BaseFragment";
    public static boolean isLoad = true;

    private static int screenHeight = 0;

    public static void makeToast(Context activity, String msg) {
        Toast toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
        View view = toast.getView();

        TextView view1 = (TextView) view.findViewById(android.R.id.message);
        view1.setTextColor(Color.WHITE);
        view.setBackgroundResource(R.drawable.toast_bg);
        toast.show();

    }

    public static void noInternet(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.no_network_title))
                .setMessage(activity.getString(R.string.network_content))
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    //getting device screen width.
    public static int getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = (int) size.x;
        //  int height = size.y;
        return width;
    }

    //getting device screen height.
    public static int getScreenHeight(Context c) {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = null;
            if (wm != null) {
                display = wm.getDefaultDisplay();
            }
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y / 3;
        }

        return screenHeight;
    }

    //getting device screen height.
    public static int getScreenFullHeight(Context c) {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = null;
            if (wm != null) {
                display = wm.getDefaultDisplay();
            }
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }

        return screenHeight;
    }


    //    Checking for all possible internet providers
    public static boolean isNetworkAvail(Context context) {
        boolean flag = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = null;
            if (connectivityManager != null) {
                info = connectivityManager.getActiveNetworkInfo();
            }

            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                //  System.out.println(info.getTypeName());
                flag = true;
            }
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                //    System.out.println(info.getTypeName());
                flag = true;
            }
        } catch (Exception exception) {
//           Toast.makeText(context,"Error is "+exception,Toast.LENGTH_LONG).show();
//                 System.out.println("Exception at network connection....."
//                         + exception);
        }
        return flag;
    }

    //    Hide keyboard if opened.
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            View view = activity.getCurrentFocus();
            IBinder iBinder = null;
            if (view != null) {
                iBinder = view.getWindowToken();
                inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
            }

        }
    }

    public static void showKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    //    Conversion dp to px.
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    //    Save signature to local and get path.
    public static String saveToInternalStorage(Context context, Bitmap bitmapImage) {
        ContextWrapper cw = new ContextWrapper(context);

        File folder = new File(Environment.getExternalStorageDirectory().getAbsolutePath());

        if (!folder.exists()) {
            boolean success = folder.mkdir();
        }

        File mypath = new File(folder, "signature" + System.currentTimeMillis() + ".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        btn_select_from_gallery.setText("Path: " + mypath.getPath());
        return mypath.getAbsolutePath();
    }

    // get From date picker with max date validation
    public static void getDateFromPicker(final TextView view, Context activity) {
        final String[] date = new String[1];

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String maxDate = mYear + "-" + (mMonth + 1) + "-" + (mDay);
        DateFormat dfMax = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date newDateMax = null;
        try {
            newDateMax = dfMax.parse(maxDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear + 1;

                if (dayOfMonth < 10) {
                    if (monthOfYear < 10) {
                        date[0] = "0" + dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = "0" + dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                } else {
                    if (monthOfYear < 10) {
                        date[0] = dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                }

                view.setText(getMMMDate(date[0]));
            }

        }, mYear, mMonth, mDay);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 0);
        datePickerDialog.getDatePicker().setMaxDate(newDateMax.getTime());
        datePickerDialog.show();

    }


    // get From date picker with max date validation
    public static void getDateFromPickerCU(final TextView view, Activity activity) {
        final String[] date = new String[1];

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear + 1;

                if (dayOfMonth < 10) {
                    if (monthOfYear < 10) {
                        date[0] = "0" + dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = "0" + dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                } else {
                    if (monthOfYear < 10) {
                        date[0] = dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                }

                view.setText(getMMMDate(date[0]));
            }

        }, mYear, mMonth, mDay);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 0);

        datePickerDialog.show();
    }

    // get to date picker min and max date validation.
    public static void getDateToPicker(final TextView view, Activity activity, String startDate) {
        final String[] date = new String[1];

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String maxDate = mYear + "-" + (mMonth + 1) + "-" + (mDay);

        DateFormat dfMin = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
        DateFormat dfMax = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date newDateMin = null, newDateMax = null;
        try {
            newDateMin = dfMin.parse(startDate);
            newDateMax = dfMax.parse(maxDate);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear + 1;

                if (dayOfMonth < 10) {
                    if (monthOfYear < 10) {
                        date[0] = "0" + dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = "0" + dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                } else {
                    if (monthOfYear < 10) {
                        date[0] = dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                }

                view.setText(getMMMDate(date[0]));
            }

        }, mYear, mMonth, mDay);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 0);

        if (newDateMin != null) {
            datePickerDialog.getDatePicker().setMinDate(newDateMin.getTime());
        }
        if (newDateMax != null) {
            datePickerDialog.getDatePicker().setMaxDate(newDateMax.getTime());
        }
        datePickerDialog.show();
    }


    // get to date picker min and max date validation.
    public static void getDateToPickerCU(final TextView view, Activity activity, String startDate) {
        final String[] date = new String[1];

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String maxDate = mYear + "-" + (mMonth + 1) + "-" + (mDay);

        DateFormat dfMin = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);

        Date newDateMin = null;
        try {
            newDateMin = dfMin.parse(startDate);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear + 1;

                if (dayOfMonth < 10) {
                    if (monthOfYear < 10) {
                        date[0] = "0" + dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = "0" + dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                } else {
                    if (monthOfYear < 10) {
                        date[0] = dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                }

                view.setText(getMMMDate(date[0]));
            }

        }, mYear, mMonth, mDay);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 0);

        if (newDateMin != null) {
            datePickerDialog.getDatePicker().setMinDate(newDateMin.getTime());
        }

        datePickerDialog.show();
    }


    public static void getDatePickerFuture(final TextView view, Activity activity) {
        final String[] date = new String[1];

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        String maxDate = mYear + "-" + (mMonth + 1) + "-" + (mDay + 1);
        DateFormat dfMax = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date newDateMin = null;
        try {
            newDateMin = dfMax.parse(maxDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear = monthOfYear + 1;

                if (dayOfMonth < 10) {
                    if (monthOfYear < 10) {
                        date[0] = "0" + dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = "0" + dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                } else {
                    if (monthOfYear < 10) {
                        date[0] = dayOfMonth + "-0" + monthOfYear + "-" + year;
                    } else {
                        date[0] = dayOfMonth + "-" + monthOfYear + "-" + year;
                    }
                }

                view.setText(date[0]);
            }

        }, mYear, mMonth, mDay);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 0);

        if (newDateMin != null) {
            datePickerDialog.getDatePicker().setMinDate(newDateMin.getTime());
        }

        datePickerDialog.show();
    }

//    public static void noInternet(final Activity activity) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setTitle(activity.getString(R.string.no_network_title))
//                .setMessage(activity.getString(R.string.network_content))
//                .setCancelable(false)
//                .setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//
//                    }
//                });
//
//        final AlertDialog alertDialog = builder.create();
//
//        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dlg) {
////                try {
////                    if (SharedPreferencesUtils.getInstance(activity).getValue(Constants.KEY_LANGUAGE, "").equalsIgnoreCase(Constants.ARABIC)) {
////                        alertDialog.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL); // set title and message direction to RTL
////                    } else {
////                        alertDialog.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR); // set title and message direction to RTL
////                    }
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//
//            }
//        });
//        alertDialog.show();
//
//
//    }

    public static String getMMMDate(String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);

//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return formattedDate.toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getDate(String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);

//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return formattedDate.toUpperCase();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getDateDay(String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("EE", Locale.ENGLISH);

//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            if (formattedDate.equalsIgnoreCase("mon")) {
                return 2;

            } else if (formattedDate.equalsIgnoreCase("tue")) {
                return 3;

            } else if (formattedDate.equalsIgnoreCase("wed")) {
                return 4;

            } else if (formattedDate.equalsIgnoreCase("thu")) {
                return 5;

            } else if (formattedDate.equalsIgnoreCase("fri")) {
                return 6;

            } else if (formattedDate.equalsIgnoreCase("sat")) {
                return 7;

            } else if (formattedDate.equalsIgnoreCase("sun")) {
                return 1;

            } else

                return 0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getConvertTimeSlot(String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);

        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        toDf.setTimeZone(TimeZone.getTimeZone("Asia/Bahrain"));

        Date d = null;
        try {
            d = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = toDf.format(d);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
//
//        SimpleDateFormat toDf = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
//
//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());
//
//        Date date = null;
//        try {
//            date = df.parse(dateStr);
//            String formattedDate = toDf.format(date);
//            return formattedDate;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return formatted;
    }


    public static String getConvertNotificationTime(String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);

        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        toDf.setTimeZone(TimeZone.getTimeZone("Asia/Bahrain"));

        Date d = null;
        try {
            d = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = toDf.format(d);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
//
//        SimpleDateFormat toDf = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
//
//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());
//
//        Date date = null;
//        try {
//            date = df.parse(dateStr);
//            String formattedDate = toDf.format(date);
//            return formattedDate;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return formatted;
    }


    public static String getCurrentTime(String dateStr, int booking_time) {
//        booking_time = 45;

        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
        SimpleDateFormat toDfH = new SimpleDateFormat("HH", Locale.ENGLISH);
        SimpleDateFormat toDfM = new SimpleDateFormat("mm", Locale.ENGLISH);

        Date d = null;
        try {
            d = df.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = toDf.format(d);

        int hours = Integer.valueOf(toDfH.format(d));
        int minutes = Integer.valueOf(toDfM.format(d));

        int hr = (int) booking_time / 60;
        int min = (int) booking_time % 60;

        hours = hours + hr;
        minutes = minutes + min;

        if (minutes > 60) {
            int hr1 = (int) minutes / 60;
            int min1 = (int) minutes % 60;
            hours = hours + hr1;

            minutes = min1;
        }

        String h = "" + hours, m = "" + minutes;
        if (hours < 10)
            h = "0" + hours;

        if (minutes < 10)
            m = "0" + minutes;

        formatted = h + ":" + m;
        Log.e("daaaaa   ", "" + formatted);

        return formatted;
    }

    public static String getCurrentTime24(String dateStr) {

        SimpleDateFormat df = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("HH:mm", Locale.ENGLISH);

        Date d = null;
        try {
            d = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = toDf.format(d);
        return formatted;
    }

    public static String getConvertDateTime(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);

        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        toDf.setTimeZone(TimeZone.getTimeZone("Asia/Bahrain"));

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getConvertDate(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getConvertToTimeHome(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0", Locale.ENGLISH);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getConvertToAMHome(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0", Locale.ENGLISH);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("a", Locale.ENGLISH);

//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getConvertToDayHome(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0", Locale.ENGLISH);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("dd", Locale.ENGLISH);

//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
//            if (Integer.parseInt(formattedDate) < 10) {
//                formattedDate = "0" + formattedDate;
//            }
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getConvertToMonthHome(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0", Locale.ENGLISH);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("MMM, yyyy", Locale.ENGLISH);

//        df.setTimeZone(TimeZone.getTimeZone("UTC"));
//        toDf.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getConvertToMonthHomeInt(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0", Locale.ENGLISH);

        SimpleDateFormat toDf = new SimpleDateFormat("MM", Locale.ENGLISH);

        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        toDf.setTimeZone(TimeZone.getTimeZone("Asia/Bahrain"));

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            return Integer.parseInt(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getConvertToDayInt(String dateStr) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000", Locale.ENGLISH);
        SimpleDateFormat toDf = new SimpleDateFormat("dd", Locale.ENGLISH);

        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        toDf.setTimeZone(TimeZone.getTimeZone("Asia/Bahrain"));

        Date date = null;
        try {
            date = df.parse(dateStr);
            String formattedDate = toDf.format(date);
            if (Integer.parseInt(formattedDate) < 10) {
                formattedDate = "0" + formattedDate;
            }
            return Integer.parseInt(formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getCurrentOrientation(Context context){
        return context.getResources().getConfiguration().orientation;
    }
}


