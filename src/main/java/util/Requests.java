package util;


import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by fgj on 2017/3/2.
 */
public class Requests {

    static OkHttpClient httpClient;

    static {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {

                }
            }}, new SecureRandom());

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);


            httpClient = new OkHttpClient.Builder()
                    .sslSocketFactory(sc.getSocketFactory())
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String s, SSLSession sslSession) {
                            return true;
                        }
                    })
                    .addInterceptor(logging)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Response get(String uri) throws IOException {
        Request request = new Request.Builder()
                .url(uri)
                .build();
        return fire(request);
    }

    public static Response get(HttpUrl url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return fire(request);
    }

    public static Response post(String uri, String payload, MediaType mediaType) throws IOException {
        RequestBody body = RequestBody.create(mediaType, payload);
        Request request = new Request.Builder()
                .url(uri)
                .post(body)
                .build();
        return fire(request);
    }

    public static Response put(String uri, String payload, MediaType mediaType) throws IOException {
        RequestBody body = RequestBody.create(mediaType, payload);
        Request request = new Request.Builder()
                .url(uri)
                .put(body)
                .build();
        return fire(request);
    }

    public static Response post(HttpUrl url) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{}");
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return fire(request);
    }

    private static Response fire(Request request) throws IOException {
        return httpClient.newCall(request).execute();
    }
}
