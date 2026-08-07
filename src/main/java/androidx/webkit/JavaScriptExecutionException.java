package androidx.webkit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes9.dex */
public class JavaScriptExecutionException extends Exception {
    public static final int ERROR_FRAME_DESTROYED = 1;
    public static final int ERROR_GENERIC = 0;
    private final int mErrorType;

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorType {
    }

    public JavaScriptExecutionException(int i, String str) {
        super(str == null ? "" : str);
        this.mErrorType = i;
    }

    public int getErrorType() {
        return this.mErrorType;
    }
}
