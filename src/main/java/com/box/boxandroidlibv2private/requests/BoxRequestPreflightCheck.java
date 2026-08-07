package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxConstants;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestPreflightCheck extends BoxRequest<BoxObject, BoxRequestPreflightCheck> {
    public static final String FILE_URI = "files/%s/content";
    public static final String URI = "files/content";

    public BoxRequestPreflightCheck(String str, BoxSession boxSession) {
        super(null, str, boxSession);
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected BoxObject onSend() throws BoxException {
        HttpResponse httpResponseSendPreflightCheck = sendPreflightCheck();
        StatusLine statusLine = httpResponseSendPreflightCheck.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 401 && refresh()) {
            httpResponseSendPreflightCheck = sendPreflightCheck();
            statusLine = httpResponseSendPreflightCheck.getStatusLine();
            statusCode = statusLine.getStatusCode();
        }
        logDebug(statusLine, statusCode);
        if (statusCode < 200 || statusCode >= 300) {
            throw createBoxExceptionFromHttpResponse(httpResponseSendPreflightCheck);
        }
        return null;
    }

    private BoxException createBoxExceptionFromHttpResponse(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        try {
            return new BoxException(statusLine.getReasonPhrase(), statusLine.getStatusCode(), convertStreamToString(httpResponse.getEntity().getContent()), null);
        } catch (IOException e) {
            BoxLogUtils.e("createFromHttpResponse", e);
            return new BoxException(statusLine.getReasonPhrase(), statusLine.getStatusCode(), null, null);
        }
    }

    private static String convertStreamToString(InputStream inputStream) {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }

    private void logDebug(StatusLine statusLine, int i) {
        logRequest();
        BoxLogUtils.i(BoxConstants.TAG, String.format(Locale.ENGLISH, "Preflight Check Response (%s):  %s", Integer.valueOf(i), statusLine.getReasonPhrase()));
    }

    private boolean refresh() throws BoxException {
        try {
            BoxResponse boxResponse = this.mSession.refresh().get();
            if (boxResponse.isSuccess()) {
                return true;
            }
            if (boxResponse.getException() == null || !(boxResponse.getException() instanceof BoxException.RefreshFailure)) {
                return false;
            }
            throw ((BoxException.RefreshFailure) boxResponse.getException());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            BoxLogUtils.e("oauthRefresh", "Interrupted Exception", e);
        } catch (ExecutionException e2) {
            BoxLogUtils.e("oauthRefresh", "Interrupted Exception", e2);
        }
        return false;
    }

    private HttpResponse sendPreflightCheck() throws BoxException {
        try {
            HttpOptionsWithBody httpOptionsWithBodyPrepareRequest = prepareRequest();
            HttpClientBuilder httpClientBuilderCreate = HttpClientBuilder.create();
            if (this.mTimeout > 0) {
                httpClientBuilderCreate.setConnectionTimeToLive(this.mTimeout, TimeUnit.MILLISECONDS);
            } else {
                httpClientBuilderCreate.setConnectionTimeToLive(5L, TimeUnit.SECONDS);
            }
            httpOptionsWithBodyPrepareRequest.addHeader("Connection", HeaderElements.CLOSE);
            CloseableHttpClient closeableHttpClientBuild = null;
            try {
                try {
                    closeableHttpClientBuild = httpClientBuilderCreate.build();
                    CloseableHttpResponse closeableHttpResponseExecute = closeableHttpClientBuild.execute((HttpUriRequest) httpOptionsWithBodyPrepareRequest);
                    if (closeableHttpClientBuild != null) {
                        try {
                            closeableHttpClientBuild.close();
                            return closeableHttpResponseExecute;
                        } catch (Exception e) {
                            BoxLogUtils.e("unable to close connection", e);
                        }
                    }
                    return closeableHttpResponseExecute;
                } catch (Throwable th) {
                    if (closeableHttpClientBuild != null) {
                        try {
                            closeableHttpClientBuild.close();
                        } catch (Exception e2) {
                            BoxLogUtils.e("unable to close connection", e2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw new BoxException(e3.getMessage(), e3);
            }
        } catch (Exception e4) {
            throw new BoxException(e4.getMessage(), e4);
        }
    }

    private HttpOptionsWithBody prepareRequest() throws BoxException, IOException {
        HttpOptionsWithBody httpOptionsWithBody = new HttpOptionsWithBody();
        try {
            httpOptionsWithBody.setURI(buildUrl().toURI());
            createHeaderMap();
            for (Map.Entry<String, String> entry : this.mHeaderMap.entrySet()) {
                httpOptionsWithBody.addHeader(entry.getKey(), entry.getValue());
            }
            if (!this.mBodyMap.isEmpty()) {
                httpOptionsWithBody.setEntity(new StringEntity(getStringBody()));
            }
            return httpOptionsWithBody;
        } catch (URISyntaxException e) {
            throw new BoxException("URISyntaxException:" + e.getMessage());
        }
    }

    public BoxRequestPreflightCheck setName(String str) {
        this.mBodyMap.put("name", str);
        return this;
    }

    public BoxRequestPreflightCheck setParent(String str) {
        this.mBodyMap.put("parent", BoxFolder.createFromId(str));
        return this;
    }

    public BoxRequestPreflightCheck setSize(long j) {
        this.mBodyMap.put("size", Long.toString(j));
        return this;
    }

    public static class HttpOptionsWithBody extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "OPTIONS";

        @Override // cz.msebera.android.httpclient.client.methods.HttpRequestBase, cz.msebera.android.httpclient.client.methods.HttpUriRequest
        public String getMethod() {
            return "OPTIONS";
        }
    }
}
