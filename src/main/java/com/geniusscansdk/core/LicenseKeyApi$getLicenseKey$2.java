package com.geniusscansdk.core;

import com.google.gson.GsonBuilder;
import com.microsoft.identity.client.internal.MsalUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LicenseKeyApi.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/geniusscansdk/core/LicenseKeyApi$Response;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.core.LicenseKeyApi$getLicenseKey$2", f = "LicenseKeyApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LicenseKeyApi$getLicenseKey$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends LicenseKeyApi.Response>>, Object> {
    final /* synthetic */ String $baseLicenseKey;
    final /* synthetic */ LicenseKeyApi.QueryParams $params;
    int label;
    final /* synthetic */ LicenseKeyApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LicenseKeyApi$getLicenseKey$2(LicenseKeyApi.QueryParams queryParams, LicenseKeyApi licenseKeyApi, String str, Continuation<? super LicenseKeyApi$getLicenseKey$2> continuation) {
        super(2, continuation);
        this.$params = queryParams;
        this.this$0 = licenseKeyApi;
        this.$baseLicenseKey = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LicenseKeyApi$getLicenseKey$2(this.$params, this.this$0, this.$baseLicenseKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends LicenseKeyApi.Response>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<LicenseKeyApi.Response>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<LicenseKeyApi.Response>> continuation) {
        return ((LicenseKeyApi$getLicenseKey$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        Object objM14780constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List listMutableListOf = CollectionsKt.mutableListOf("device_id=" + this.$params.getDeviceId(), "sdk_version=" + this.$params.getSdkVersion(), "framework=" + this.$params.getFramework(), "os=android", "os_version=" + this.$params.getOsVersion());
        String appVersion = this.$params.getAppVersion();
        if (appVersion != null) {
            Boxing.boxBoolean(listMutableListOf.add("app_version=" + appVersion));
        }
        String integrationMode = this.$params.getIntegrationMode();
        if (integrationMode != null) {
            Boxing.boxBoolean(listMutableListOf.add("integration_mode=" + integrationMode));
        }
        String keyRefresh = this.$params.getKeyRefresh();
        if (keyRefresh != null) {
            Boxing.boxBoolean(listMutableListOf.add("key_refresh=" + keyRefresh));
        }
        URLConnection uRLConnectionOpenConnection = new URL(this.this$0.baseUrl + "/license_key/" + this.$baseLicenseKey + (!listMutableListOf.isEmpty() ? MsalUtils.QUERY_STRING_SYMBOL + CollectionsKt.joinToString$default(listMutableListOf, MsalUtils.QUERY_STRING_DELIMITER, null, null, 0, null, null, 62, null) : "")).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        try {
            try {
                Integer numBoxInt = Boxing.boxInt(httpURLConnection.getResponseCode());
                if (numBoxInt.intValue() == 200) {
                    numBoxInt = null;
                }
                if (numBoxInt != null) {
                    int iIntValue = numBoxInt.intValue();
                    Result.Companion companion = Result.INSTANCE;
                    Result resultM14779boximpl = Result.m14779boximpl(Result.m14780constructorimpl(ResultKt.createFailure(new LicenseKeyApi.HttpException(iIntValue))));
                    httpURLConnection.disconnect();
                    return resultM14779boximpl;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    LicenseKeyApi.Response response = (LicenseKeyApi.Response) new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ").create().fromJson(text, LicenseKeyApi.Response.class);
                    Result.Companion companion2 = Result.INSTANCE;
                    objM14780constructorimpl = Result.m14780constructorimpl(response);
                    httpURLConnection.disconnect();
                    return Result.m14779boximpl(objM14780constructorimpl);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                IOException iOException = e;
                if (iOException instanceof UnknownHostException) {
                    iOException = new IOException("No Internet connection");
                }
                Result.Companion companion3 = Result.INSTANCE;
                objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(iOException));
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }
}
