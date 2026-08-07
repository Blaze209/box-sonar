package com.geniusscansdk.scanflow;

import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.gson.Gson;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromiseResult.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rBU\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R0\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/geniusscansdk/scanflow/PromiseResult;", "", "isError", "", "errorCode", "", "errorMessage", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "resultAsJSON", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromiseResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final String errorCode;
    public final String errorMessage;
    public final boolean isError;
    public final HashMap<String, Object> result;

    @JvmStatic
    public static final PromiseResult reject(String str, String str2) {
        return INSTANCE.reject(str, str2);
    }

    @JvmStatic
    public static final PromiseResult resolve() {
        return INSTANCE.resolve();
    }

    @JvmStatic
    public static final PromiseResult resolve(HashMap<String, Object> map) {
        return INSTANCE.resolve(map);
    }

    private PromiseResult(boolean z, String str, String str2, HashMap<String, Object> map) {
        this.isError = z;
        this.errorCode = str;
        this.errorMessage = str2;
        this.result = map;
    }

    /* synthetic */ PromiseResult(boolean z, String str, String str2, HashMap map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : map);
    }

    public final String resultAsJSON() {
        HashMap<String, Object> map = this.result;
        if (map != null) {
            return new Gson().toJson(map);
        }
        return null;
    }

    /* JADX INFO: compiled from: PromiseResult.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J,\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`\tH\u0007J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\r"}, d2 = {"Lcom/geniusscansdk/scanflow/PromiseResult$Companion;", "", "<init>", "()V", Gen204FileActivityEventLogger.ACTION_RESOLVE, "Lcom/geniusscansdk/scanflow/PromiseResult;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "reject", "errorCode", "errorMessage", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PromiseResult resolve() {
            return new PromiseResult(false, null, null, null, 15, null);
        }

        @JvmStatic
        public final PromiseResult resolve(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            return new PromiseResult(false, null, null, result, 7, null);
        }

        @JvmStatic
        public final PromiseResult reject(String errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            return new PromiseResult(true, errorCode, errorMessage, null, 8, null);
        }
    }
}
