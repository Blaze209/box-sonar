package com.google.androidbrowserhelper.trusted;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.browser.customtabs.CustomTabsCallback;

/* JADX INFO: loaded from: classes13.dex */
public class QualityEnforcer extends CustomTabsCallback {
    static final String CRASH = "quality_enforcement.crash";
    static final String KEY_CRASH_REASON = "crash_reason";
    static final String KEY_SUCCESS = "success";
    private static final String TAG = "TwaQualityEnforcement";
    private final Delegate mDelegate;

    interface Delegate {
        void crash(String str);
    }

    public QualityEnforcer() {
        this.mDelegate = new Delegate() { // from class: com.google.androidbrowserhelper.trusted.QualityEnforcer$$ExternalSyntheticLambda1
            @Override // com.google.androidbrowserhelper.trusted.QualityEnforcer.Delegate
            public final void crash(String str) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.androidbrowserhelper.trusted.QualityEnforcer$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        QualityEnforcer.lambda$new$0(str);
                    }
                });
            }
        };
    }

    static /* synthetic */ void lambda$new$0(String str) {
        throw new RuntimeException(str);
    }

    QualityEnforcer(Delegate delegate) {
        this.mDelegate = delegate;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public Bundle extraCallbackWithResult(String str, Bundle bundle) {
        String string = bundle != null ? bundle.getString(KEY_CRASH_REASON) : null;
        if (string == null) {
            return Bundle.EMPTY;
        }
        Bundle bundle2 = new Bundle();
        if (str.equals(CRASH)) {
            bundle2.putBoolean("success", true);
            this.mDelegate.crash(string);
        }
        return bundle2;
    }
}
