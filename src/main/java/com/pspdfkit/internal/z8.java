package com.pspdfkit.internal;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import com.pspdfkit.utils.PdfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z8 {
    @JvmStatic
    public static final boolean a(ClipData clipData, Context context, int i) {
        Context context2;
        boolean z;
        clipData.getClass();
        if (context == null) {
            context2 = n5.a;
            if (context2 == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
        } else {
            context2 = context;
        }
        ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context2, ClipboardManager.class);
        if (clipboardManager == null) {
            return false;
        }
        try {
            MAMClipboard.setPrimaryClip(clipboardManager, clipData);
            z = true;
        } catch (Throwable th) {
            PdfLog.w("Nutri.ClipboardUtils", th, "Error on setPrimaryClip", new Object[0]);
            z = false;
        }
        if (context != null && Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            String string = (!z || i <= 0) ? null : context.getString(i);
            if (string != null) {
                Toast.makeText(context, string, 0).show();
            }
        }
        return z;
    }

    public static boolean a(CharSequence charSequence, String str, Context context, int i, int i2) {
        if ((i2 & 4) != 0) {
            context = null;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        if (charSequence == null || charSequence.length() == 0) {
            charSequence = null;
        }
        if (charSequence == null) {
            return false;
        }
        ClipData clipDataNewPlainText = ClipData.newPlainText(str, charSequence);
        clipDataNewPlainText.getClass();
        return a(clipDataNewPlainText, context, i);
    }
}
