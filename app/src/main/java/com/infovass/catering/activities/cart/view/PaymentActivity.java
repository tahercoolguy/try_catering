package com.infovass.catering.activities.cart.view;

import androidx.appcompat.app.AppCompatActivity;

import com.infovass.catering.R;
import com.infovass.catering.activities.ThankuActivity;
import com.infovass.catering.activities.cart.model.PaymentResponse;
import com.infovass.catering.activities.cart.presenter.PaymentImpl;
import com.infovass.catering.activities.cart.presenter.PaymentPresenter;
import com.infovass.catering.activities.network.Constants;
import com.infovass.catering.activities.network.SharedPreferencesUtils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends AppCompatActivity implements PaymentView {

    int page = 0;
    @BindView(R.id.webPayment)
    WebView webPayment;
    @BindView(R.id.backButton)
    ImageButton backButton;
    String payment_id;
    PaymentPresenter presenter;

    @OnClick({R.id.backButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.backButton:
                try {
                    finish();
                } catch (Exception g) {
                }
                break;
        }
    }

    String invoice_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        invoice_id = getIntent().getStringExtra("invoiceid");
        ButterKnife.bind(this);
        presenter = new PaymentImpl(this);
        WebSettings webSettings = webPayment.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webPayment.loadUrl(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.URL, ""));
        webPayment.setWebViewClient(new MyWebViewClient());


    }

    @Override
    public void onSuccessGetPayment(PaymentResponse cartResponse) {
        Log.d("ss", "ss");

        if(cartResponse.getStatus()){
            Intent intent = new Intent(PaymentActivity.this, ThankuActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(PaymentActivity.this, "Transaction Failed", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onNoInternet() {

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //You can add some custom functionality here
            Log.i("KTM", "112121");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //You can add some custom functionality here
            Log.i("KTM", "KTM");
            page = page + 1;

            if (page == 10) {
                try {
//                Intent intent= new Intent(PaymentActivity.this , ThankuActivity.class);
//                startActivity(intent);
//                finish();
                } catch (Exception g) {
                }
                ;
            }
            try {
                if (url.contains("PaymentID")) {
                    Uri uri = Uri.parse(url);
                    payment_id = uri.getQueryParameter("PaymentID");
                }

                if (url.contains("result")) {
                    Uri uri = Uri.parse(url);
                    String results = uri.getQueryParameter("result");
                    if (results.contains("NOT CAPTURED")) {
                        String Transaction_number = uri.getQueryParameter("reference_code");
                        String track_id = uri.getQueryParameter("transaction_id");
                        presenter.getPayment(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.order_id, ""), payment_id, false, "", "", invoice_id);


                    } else if (results.contains("CAPTURED")) {
                        String Transaction_number = uri.getQueryParameter("reference_code");
                        String track_id = uri.getQueryParameter("transaction_id");

                        presenter.getPayment(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.order_id, ""), payment_id, true, Transaction_number, track_id, invoice_id);

//
                    }
                }

//                if (url.contains("payment-success")) {
//                    presenter.getPayment(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.order_id, ""), payment_id, true);
//
//                } else if (url.contains("payment-fail")) {
//                    presenter.getPayment(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.order_id, ""), payment_id, false);
//                }

//                if (url.contains("payment-success")) {
//                    presenter.getPayment(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.order_id, ""), payment_id, true);
//
//                } else if (url.contains("payment-fail")) {
//                    presenter.getPayment(SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.TOKEN, ""), SharedPreferencesUtils.getInstance(getApplicationContext()).getValue(Constants.order_id, ""), payment_id, false);
//                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            //You can add some custom functionality here
            Log.i("KTM", "22222");
        }
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_in);
    }
    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.right_slide_in, R.anim.left_slide_out);
        super.onBackPressed();
    }

}