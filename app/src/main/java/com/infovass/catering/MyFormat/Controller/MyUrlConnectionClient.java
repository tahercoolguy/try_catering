package com.infovass.catering.MyFormat.Controller;
import retrofit.client.UrlConnectionClient;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedByteArray;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MyUrlConnectionClient extends UrlConnectionClient {
    private static final int CONNECT_TIMEOUT_MILLIS = 15 * 1000;
    private static final int READ_TIMEOUT_MILLIS = 20 * 1000;


    @Override
    protected HttpURLConnection openConnection(retrofit.client.Request request) throws IOException {
        HttpURLConnection connection = super.openConnection(request);

        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
            connection.setConnectTimeout(3*60 * 1000);
            connection.setReadTimeout(30 * 1000);
            // Disable SSL certificate verification
            httpsConnection.setHostnameVerifier((hostname, session) -> true);
            httpsConnection.setSSLSocketFactory(createTrustAllSSLSocketFactory());
        }

        return connection;
    }

    private SSLSocketFactory createTrustAllSSLSocketFactory() {
        try {
            // Create a trust manager that trusts all certificates
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            }};

            // Create an SSL context that uses the trust manager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Return the SSL socket factory
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Rest of the class implementation remains the same
    // ...
}

