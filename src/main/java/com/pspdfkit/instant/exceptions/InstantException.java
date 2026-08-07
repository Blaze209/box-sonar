package com.pspdfkit.instant.exceptions;

import com.pspdfkit.internal.jj;
import com.pspdfkit.internal.uw;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public class InstantException extends RuntimeException {
    private final InstantErrorCode errorCode;
    private final Integer underlyingError;

    public InstantException(String str, Throwable th) {
        super(str, th);
        this.errorCode = InstantErrorCode.UNKNOWN;
        this.underlyingError = null;
    }

    public InstantErrorCode getErrorCode() {
        return this.errorCode;
    }

    public Integer getUnderlyingError() {
        return this.underlyingError;
    }

    public boolean isRetriable() {
        boolean z;
        InstantErrorCode instantErrorCode = this.errorCode;
        instantErrorCode.getClass();
        switch (jj.a[instantErrorCode.ordinal()]) {
            case 1:
                z = false;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                z = true;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return !z;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String name = getClass().getName();
        String localizedMessage = getLocalizedMessage();
        return name + ": " + this.errorCode + (localizedMessage != null ? " ".concat(localizedMessage) : "");
    }

    public InstantException(InstantErrorCode instantErrorCode, Throwable th, String str, Object... objArr) {
        super(str != null ? String.format(Locale.US, str, objArr) : null, th);
        uw.a(instantErrorCode, "errorCode", null);
        this.errorCode = instantErrorCode;
        this.underlyingError = null;
    }

    public InstantException(InstantErrorCode instantErrorCode, String str, Object... objArr) {
        super(str != null ? String.format(Locale.US, str, objArr) : null, null);
        uw.a(instantErrorCode, "errorCode", null);
        this.errorCode = instantErrorCode;
        this.underlyingError = null;
    }

    public InstantException(InstantErrorCode instantErrorCode, String str, Integer num) {
        super(str);
        uw.a(instantErrorCode, "errorCode", null);
        this.errorCode = instantErrorCode;
        this.underlyingError = num;
    }
}
