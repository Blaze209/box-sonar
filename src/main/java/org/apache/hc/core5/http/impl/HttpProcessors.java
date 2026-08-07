package org.apache.hc.core5.http.impl;

import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.HttpResponseInterceptor;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.http.protocol.HttpProcessorBuilder;
import org.apache.hc.core5.http.protocol.RequestConformance;
import org.apache.hc.core5.http.protocol.RequestConnControl;
import org.apache.hc.core5.http.protocol.RequestContent;
import org.apache.hc.core5.http.protocol.RequestExpectContinue;
import org.apache.hc.core5.http.protocol.RequestTargetHost;
import org.apache.hc.core5.http.protocol.RequestUserAgent;
import org.apache.hc.core5.http.protocol.RequestValidateHost;
import org.apache.hc.core5.http.protocol.ResponseConformance;
import org.apache.hc.core5.http.protocol.ResponseConnControl;
import org.apache.hc.core5.http.protocol.ResponseContent;
import org.apache.hc.core5.http.protocol.ResponseDate;
import org.apache.hc.core5.http.protocol.ResponseServer;
import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.VersionInfo;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpProcessors {
    private static final String SOFTWARE = "Apache-HttpCore";

    public static HttpProcessorBuilder customServer(String str) {
        HttpProcessorBuilder httpProcessorBuilderCreate = HttpProcessorBuilder.create();
        HttpResponseInterceptor[] httpResponseInterceptorArr = new HttpResponseInterceptor[5];
        httpResponseInterceptorArr[0] = ResponseConformance.INSTANCE;
        httpResponseInterceptorArr[1] = ResponseDate.INSTANCE;
        if (TextUtils.isBlank(str)) {
            str = VersionInfo.getSoftwareInfo(SOFTWARE, "org.apache.hc.core5", HttpProcessors.class);
        }
        httpResponseInterceptorArr[2] = new ResponseServer(str);
        httpResponseInterceptorArr[3] = ResponseContent.INSTANCE;
        httpResponseInterceptorArr[4] = ResponseConnControl.INSTANCE;
        return httpProcessorBuilderCreate.addAll(httpResponseInterceptorArr).addAll(RequestValidateHost.INSTANCE, RequestConformance.INSTANCE);
    }

    public static HttpProcessor server(String str) {
        return customServer(str).build();
    }

    public static HttpProcessor server() {
        return customServer(null).build();
    }

    public static HttpProcessorBuilder customClient(String str) {
        HttpProcessorBuilder httpProcessorBuilderCreate = HttpProcessorBuilder.create();
        HttpRequestInterceptor[] httpRequestInterceptorArr = new HttpRequestInterceptor[5];
        httpRequestInterceptorArr[0] = RequestTargetHost.INSTANCE;
        httpRequestInterceptorArr[1] = RequestContent.INSTANCE;
        httpRequestInterceptorArr[2] = RequestConnControl.INSTANCE;
        if (TextUtils.isBlank(str)) {
            str = VersionInfo.getSoftwareInfo(SOFTWARE, "org.apache.hc.core5", HttpProcessors.class);
        }
        httpRequestInterceptorArr[3] = new RequestUserAgent(str);
        httpRequestInterceptorArr[4] = RequestExpectContinue.INSTANCE;
        return httpProcessorBuilderCreate.addAll(httpRequestInterceptorArr);
    }

    public static HttpProcessor client(String str) {
        return customClient(str).build();
    }

    public static HttpProcessor client() {
        return customClient(null).build();
    }
}
