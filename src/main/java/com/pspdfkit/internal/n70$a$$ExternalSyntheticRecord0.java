package com.pspdfkit.internal;

import android.content.res.TypedArray;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n70$a$$ExternalSyntheticRecord0 {
    public static /* synthetic */ int m(Object obj, Object obj2) {
        return (Objects.hashCode(obj) * 31) + Objects.hashCode(obj2);
    }

    public static /* synthetic */ int m(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return (((((((Objects.hashCode(obj) * 31) + Objects.hashCode(obj2)) * 31) + Objects.hashCode(obj3)) * 31) + Objects.hashCode(obj4)) * 31) + Objects.hashCode(obj5);
    }

    public static /* synthetic */ String m(String str) {
        int length = str.length();
        while (length > 0) {
            int iCodePointBefore = Character.codePointBefore(str, length);
            if (!Character.isWhitespace(iCodePointBefore)) {
                break;
            }
            length -= Character.charCount(iCodePointBefore);
        }
        return str.substring(0, length);
    }

    public static /* synthetic */ String m(Object[] objArr, Class cls, String str) {
        String[] strArrSplit = str.length() == 0 ? new String[0] : str.split(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER);
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getSimpleName()).append("[");
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]).append(SimpleComparison.EQUAL_TO_OPERATION).append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m14051m(Object obj) throws Exception {
        if (obj instanceof AutoCloseable) {
            ((AutoCloseable) obj).close();
            return;
        }
        if (obj instanceof ExecutorService) {
            m((ExecutorService) obj);
        } else if (obj instanceof TypedArray) {
            ((TypedArray) obj).recycle();
        } else {
            m$1(obj);
        }
    }

    public static /* synthetic */ void m(ExecutorService executorService) {
        boolean zIsTerminated;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ boolean m14052m(String str) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return true;
    }

    public static /* synthetic */ void m$1(Object obj) {
        throw new IllegalArgumentException();
    }
}
