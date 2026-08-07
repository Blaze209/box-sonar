package com.pspdfkit.document.providers;

import android.content.Context;
import com.pspdfkit.internal.n5;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0004¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/document/providers/ContextDataProvider;", "Lcom/pspdfkit/document/providers/DataProvider;", "<init>", "()V", "getContext", "Landroid/content/Context;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ContextDataProvider implements DataProvider {
    public static final int $stable = 0;

    public final Context getContext() {
        Context context = n5.a;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
    }
}
