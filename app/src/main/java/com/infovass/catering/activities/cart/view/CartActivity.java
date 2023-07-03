package com.infovass.catering.activities.cart.view;

import static com.infovass.catering.R.id;
import static com.infovass.catering.R.layout;
import static com.infovass.catering.R.string;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.infovass.catering.R;
import com.infovass.catering.activities.ThankuActivity;
import com.infovass.catering.activities.adapers.AdapterCartItemList;
import com.infovass.catering.activities.base.BaseActivity;
import com.infovass.catering.activities.cart.model.CartResponse;
import com.infovass.catering.activities.cart.model.PlaceOrderResponse;
import com.infovass.catering.activities.cart.model.PromoCodeResponse;
import com.infovass.catering.activities.cart.model.RemoveItemFromCart;
import com.infovass.catering.activities.cart.presenter.CartImpl;
import com.infovass.catering.activities.cart.presenter.CartPresenter;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;
import com.infovass.catering.activities.profile.AddressActivity;
import com.infovass.catering.activities.utill.AppSettings;
import com.infovass.catering.activities.utill.InputValidations;
import com.infovass.catering.activities.utill.ProgressHUD;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends BaseActivity implements CartView {

    String addressID = "";
    float totalAmount;
    List<CartResponse.Data.MainItem> items = new ArrayList<>();
    CartPresenter cartPresenter;
    @BindView(id.cartItemList)
    RecyclerView cartItemList;
    @BindView(id.addtoCartLayout)
    RelativeLayout addtoCartLayout;
    @BindView(id.tv_total)
    AppCompatTextView tv_total;
    @BindView(id.tv_address)
    AppCompatTextView tv_address;
    @BindView(id.img_addAddress)
    ImageButton img_addAddress;
    @BindView(id.cartCodeAppy)
    AppCompatTextView cartCodeAppy;
    @BindView(id.et_promoCode)
    EditText et_promoCode;
    @BindView(id.tv_serviceCharge)
    TextView tv_serviceCharge;
    @BindView(id.tv_discount)
    TextView tv_discount;
    @BindView(id.tv_totalAmount)
    TextView tv_totalAmount;
    @BindView(id.tv_GrandTotal)
    TextView tv_GrandTotal;
    @BindView(id.cart_temp)
    ImageView cart_temp;
    TextView tv_date, tv_time;
    private DatePicker datePicker;
    int hour, min;
    String time, Dates;

    AdapterCartItemList adapterCartItemList;
    private ProgressHUD progressHUD;
    RadioButton rb_knet, rb_COD;
    RadioGroup rg_payment;
    String payment_type = "", cod = "";
    List<PromoCodeResponse.Data> promoCode = new ArrayList<>();
    private View rootView;

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_cart);
        ButterKnife.bind(this);
        progressHUD = ProgressHUD.create(this, getString(string.loading), false, null, null);
        cartPresenter = new CartImpl(this);
        cartPresenter.getUserCartApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""));
        // cartPresenter.getUserCartApi("281|BCCf8SNGwQVg9bAdQNztRulHti8z55VAjp7Jm2Z7");
        rb_knet = findViewById(id.rb_knet);
        rb_COD = findViewById(id.rb_COD);
        rg_payment = findViewById(id.rg_payment);
        tv_time = findViewById(R.id.tv_time);
        tv_date = findViewById(id.tv_date);

        //for time and date'
//        String Dates = SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_DATE, "");
//        if (!Objects.equals(Dates, ""))
//            tv_date.setText(Dates);
//
//        String Times = SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_TIME, "");
//        if (!Objects.equals(Times, ""))
//            tv_time.setText(Times);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String date1 = bundle.getString("date");
            String time1 = bundle.getString("time");
            tv_date.setText(date1);
            tv_time.setText(time1);
        }
        if (!Objects.equals(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_DATE, ""), "") && !Objects.equals(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_TIME, ""), "")) {
            tv_date.setText(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_DATE, ""));
            tv_time.setText(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_TIME, ""));
        }

        rb_knet.setOnClickListener(view -> {
            payment_type = "KNET";
            rb_COD.setChecked(false);
            rb_knet.setChecked(true);
        });
        rb_COD.setOnClickListener(view -> {
            payment_type = "COD";
            rb_COD.setChecked(true);
            rb_knet.setChecked(false);
        });


        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime(hour, min);
            }
        });


        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        CartActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                tv_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                datePickerDialog.show();
//                String d=tv_date.getText().toString();
//                SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.KEY_DATE, d);
            }
        });
        //       }
//        else
//        {
//           tv_date.setText(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.KEY_DATE, ""));
//        }


        try {
            addressID = SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.addressID, "");
            tv_address.setText(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.address, ""));
        } catch (Exception h) {
        }

        adapterCartItemList = new AdapterCartItemList(getApplicationContext(), items);
        cartItemList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        cartItemList.setAdapter(adapterCartItemList);

        adapterCartItemList.setOnItemClickListener(new AdapterCartItemList.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView custom_tab_textView, LinearLayout detail_item_linearLayout) {

            }

            @Override
            public void onminClick(int position, AppCompatTextView tv_productCount) {
                try {
                    int itemCount = Integer.parseInt(tv_productCount.getText().toString());
                    itemCount = itemCount - 1;
                    if (itemCount == 0) {
                        Toast.makeText(CartActivity.this, "Cannot set item count 0.", Toast.LENGTH_SHORT).show();
                    } else {
                        tv_productCount.setText("" + itemCount);
                        float total = totalAmount - items.get(position).getTotalCost();
                        totalAmount = total;
                        tv_total.setText(total + " KWD");
                        tv_GrandTotal.setText(total + " KWD");
                    }
                } catch (Exception g) {
                }
            }

            @Override
            public void onmaxClick(int position, AppCompatTextView tv_productCount) {
                try {
                    int itemCount = Integer.parseInt(tv_productCount.getText().toString());
                    itemCount = itemCount + 1;
                    tv_productCount.setText("" + itemCount);
                    float total = totalAmount + items.get(position).getTotalCost();
                    totalAmount = total;
                    tv_total.setText(total + " KWD");
                    tv_GrandTotal.setText(total + " KWD");
                } catch (Exception g) {
                }
            }

            @Override
            public void deleteItem(int position) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivityContext());
                alertDialogBuilder.setMessage("Are you sure, You wanted to delete cart item.");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                cartPresenter.deleteCartItemApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), "" + items.get(position).getId());
                            }
                        });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

            @Override
            public void onAddOnClick(int position, RecyclerView cartAddOnItemList, AppCompatTextView tv_addOns, AppCompatImageView img_arrow) {
                cartAddOnItemList.setVisibility(View.VISIBLE);
            }
        });

        //for promo code
        cartCodeAppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartPresenter.getUserPromoCode(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), et_promoCode.getText().toString(),SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.addressID,"0"));
            }
        });

        //for remove promo code
        cart_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartPresenter.getUserPromoCode(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), "",SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.addressID,"0"));
                et_promoCode.setText("");
            }
        });
        try {
            String addressid= SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.addressID,"0");
            cartPresenter.getUserPromoCode(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), "",addressid);
        }catch (Exception ex)
        {

        }
    }

    void showTime(int hours, int minte) {
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(CartActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                tv_time.setText(selectedHour + ":" + selectedMinute);
                hour = selectedHour;
                min = selectedMinute;
            }
        }, hours, minte, false);//Yes 24 hour time
        // mTimePicker.setTitle("Select Time");
        mTimePicker.show();
//        time=tv_time.getText().toString();
//        String t= tv_time.getText().toString();
//        SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.KEY_TIME, t);

    }

    @OnClick({id.backButton, id.img_addAddress, id.addtoCartLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case id.img_addAddress:
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("date", tv_date.getText().toString());
                    bundle.putString("time", tv_time.getText().toString());
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.ClassName, "cart");
                    Intent intent = new Intent(CartActivity.this, AddressActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                } catch (Exception g) {
                }
                break;
            case id.addtoCartLayout:
                try {
                    if (isNetAvail()) {
//            Log.i("Yhan", "HAN");
                        if (isValid()) {
                            try {
//                                Date c = Calendar.getInstance().getTime();
//                                System.out.println("Current time => " + c);
//                                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
//                                String formattedDate = df.format(c);
//                                Log.i("vxvxv", formattedDate);
                                Log.i("vxvxv", addressID);
                                cartPresenter.plaseOrderApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""), addressID, tv_date.getText().toString(), payment_type, tv_time.getText().toString());
                            } catch (Exception j) {
                            }
                        }
                    }

                } catch (Exception g) {
                }
                break;

            case id.backButton:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;

        }

    }

    private boolean isValid() {
        boolean error = true;

        if (InputValidations.isNullOrEmpty(addressID)) {
            error = false;
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivityContext());
            alertDialogBuilder.setMessage("Please Select address .");
            alertDialogBuilder.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            arg0.dismiss();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        return error;
    }

    @Override
    public void onSuccessGetCartAPi(CartResponse cartResponse) {
        try {
            if (cartResponse.getStatus().equals(true)) {
                tv_total.setText(cartResponse.getData().getAllTotal() + " KWD");
                tv_GrandTotal.setText(cartResponse.getData().getAllTotal() + " KWD");
                tv_totalAmount.setText(cartResponse.getData().getTotalAmount() + " KWD");
//                float delivery_amount = Float.parseFloat(cartResponse.getData().getService_charges() + " KWD");
//                String Str_delivery_amount = String.valueOf(delivery_amount);
//                tv_serviceCharge.setText(Str_delivery_amount);

                items.clear();
                if (cartResponse.getData().getMainItem().size() == 0) {
//                lnr_noProduct.setVisibility(View.VISIBLE);
//                lnr_main.setVisibility(View.GONE);
                } else {
//                lnr_noProduct.setVisibility(View.GONE);
//                lnr_main.setVisibility(View.VISIBLE);
                    items.addAll(cartResponse.getData().getMainItem());
                    adapterCartItemList.notifyDataSetChanged();
                }
                addressID = "" + cartResponse.getData().getAddress().getId();
                tv_address.setText(cartResponse.getData().getAddress().getAddress());
                totalAmount = cartResponse.getData().getAllTotal();
            } else {
                Toast.makeText(getActivityContext(), cartResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception h) {
        }

    }

    @Override
    public void onSuccessDeleteItemCartAPi(RemoveItemFromCart removeItemFromCart) {
        try {
            if (removeItemFromCart.getStatus()) {
                Toast.makeText(getActivityContext(), "" + removeItemFromCart.getMessage(), Toast.LENGTH_SHORT).show();
                cartPresenter.getUserCartApi(SharedPreferencesUtils.getInstance(getActivityContext()).getValue(Constants.TOKEN, ""));
            }
        } catch (Exception f) {
        }
    }

    @Override
    public void onSuccessPlaseOrderAPi(PlaceOrderResponse placeOrderResponse) {
        try {
            if (placeOrderResponse.getStatus()) {
                if (Objects.equals(payment_type, "KNET")) {
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.URL, "" + placeOrderResponse.getData().getUrl());
                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.order_id, "" + placeOrderResponse.getData().getOrderId());
//                    SharedPreferencesUtils.getInstance(getActivityContext()).setValue(Constants.invoice_id, "" + placeOrderResponse.getData().getOrder().getInvoiceid());

                    Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                    intent.putExtra("invoiceid",placeOrderResponse.getData().getOrder().getInvoiceid().toString());
                    startActivity(intent);
                    finish();
                } else {
                    showLoading();
                    Intent intent = new Intent(CartActivity.this, ThankuActivity.class);
                    startActivity(intent);
                    finish();
                }

            } else {
                Toast.makeText(getActivityContext(), "" + placeOrderResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception h) {
        }

    }

    @Override
    public void onSuccessPromoCodeAPi(PromoCodeResponse promoCodeResponse) {
        // Log.d("ss", "ss");
        promoCode.clear();
        if (promoCodeResponse.getData() != null) {
//            if (promoCodeResponse.getData().getService_charge()!=0) {
            float delivery_amount = promoCodeResponse.getData().getService_charge();
            String Str_delivery_amount = String.valueOf(delivery_amount);
            tv_serviceCharge.setText(Str_delivery_amount);
            //    }
            //Discount
            Double amount = Double.valueOf(promoCodeResponse.getData().getDiscountAmount());
            String Dis_amounts = String.valueOf(amount);
            tv_discount.setText(Dis_amounts);
            //Total Amount
            Double total_amount = Double.valueOf(promoCodeResponse.getData().getTotalAmount());
            String Str_total_amount = String.valueOf(total_amount);
            tv_totalAmount.setText(Str_total_amount);
            //Total Grand Amount
            Double total_grand_amount = Double.valueOf(promoCodeResponse.getData().getGrandTotal());
            String Str_total_grand_amount = String.valueOf(total_grand_amount);
            tv_GrandTotal.setText(Str_total_grand_amount);
        }

    }

    @Override
    public void showLoading() {
        try {
            progressHUD.show();
            rootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressHUD.dismiss();
                }
            }, 4000);
        } catch (Exception f) {
        }
    }

    @Override
    public void hideLoading() {
        try {
            progressHUD.dismiss();
        } catch (Exception f) {
        }
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onNoInternet() {

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

    }
    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);
        Intent intent = new Intent();
        intent.putExtra("restart", "restart"); // Replace "KEY" with a unique identifier and "data" with the actual data you want to pass back
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}