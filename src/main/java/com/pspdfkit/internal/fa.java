package com.pspdfkit.internal;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.configuration.policy.DefaultApplicationPolicy;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class fa {
    public final Context a;
    public final List<String> b;
    public final Lazy c;

    public static final class a {
        public final String a;
        public final qb b;

        public a(String str, qb qbVar) {
            str.getClass();
            this.a = str;
            this.b = qbVar;
        }
    }

    public fa(Context context) {
        context.getClass();
        this.a = context;
        this.b = CollectionsKt.listOf("text/plain");
        this.c = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.fa$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return fa.a(this.f$0);
            }
        });
    }

    public static final ClipboardManager a(fa faVar) {
        return (ClipboardManager) ContextCompat.getSystemService(faVar.a, ClipboardManager.class);
    }

    public final a b() {
        Uri uri;
        String queryParameter;
        String queryParameter2;
        UInt uIntOrNull;
        ClipData.Item itemC = c();
        qb qbVar = null;
        b9Var = null;
        b9 b9Var = null;
        qbVar = null;
        qbVar = null;
        qbVar = null;
        qbVar = null;
        qbVar = null;
        qbVar = null;
        qbVar = null;
        CharSequence text = itemC != null ? itemC.getText() : null;
        if (text == null) {
            return null;
        }
        String string = text.toString();
        ClipData.Item itemC2 = c();
        if (itemC2 != null && (uri = itemC2.getUri()) != null && Intrinsics.areEqual(uri.getScheme(), "content") && Intrinsics.areEqual(uri.getAuthority(), "pspdfkit.clipboard") && Intrinsics.areEqual(uri.getLastPathSegment(), "contentediting") && (queryParameter = uri.getQueryParameter("tid")) != null && (queryParameter2 = uri.getQueryParameter("v")) != null && (uIntOrNull = UStringsKt.toUIntOrNull(queryParameter2)) != null) {
            int data = uIntOrNull.getData();
            String queryParameter3 = uri.getQueryParameter("f");
            Integer intOrNull = queryParameter3 != null ? StringsKt.toIntOrNull(queryParameter3) : null;
            String queryParameter4 = uri.getQueryParameter("t");
            Integer intOrNull2 = queryParameter4 != null ? StringsKt.toIntOrNull(queryParameter4) : null;
            if (intOrNull != null) {
                int iIntValue = intOrNull.intValue();
                if (intOrNull2 != null) {
                    b9Var = new b9(iIntValue, intOrNull2.intValue());
                }
            }
            qbVar = new qb(queryParameter, data, b9Var);
        }
        return new a(string, qbVar);
    }

    public final ClipData.Item c() {
        ClipData primaryClip;
        ClipDescription description;
        ClipboardManager clipboardManager = (ClipboardManager) this.c.getValue();
        if (clipboardManager == null || !MAMClipboard.hasPrimaryClip(clipboardManager) || (primaryClip = MAMClipboard.getPrimaryClip(clipboardManager)) == null || (description = primaryClip.getDescription()) == null) {
            return null;
        }
        List<String> list = this.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (description.hasMimeType((String) it.next())) {
                    ClipData.Item itemAt = primaryClip.getItemAt(0);
                    if (itemAt == null) {
                        return null;
                    }
                    return itemAt;
                }
            }
        }
        return null;
    }

    public final boolean a() {
        ApplicationPolicy applicationPolicy;
        ClipboardManager clipboardManager;
        ClipDescription primaryClipDescription;
        synchronized (ar.class) {
            if (ar.f == null) {
                ar.f = new DefaultApplicationPolicy();
            }
            applicationPolicy = ar.f;
        }
        if (applicationPolicy.hasPermissionForEvent(ApplicationPolicy.PolicyEvent.TEXT_COPY_PASTE) && (clipboardManager = (ClipboardManager) this.c.getValue()) != null && MAMClipboard.hasPrimaryClip(clipboardManager) && (primaryClipDescription = MAMClipboard.getPrimaryClipDescription(clipboardManager)) != null) {
            return primaryClipDescription.hasMimeType("text/plain");
        }
        return false;
    }

    public static void a(fa faVar, i50 i50Var) {
        String str;
        faVar.getClass();
        i50Var.getClass();
        ClipboardManager clipboardManager = (ClipboardManager) faVar.c.getValue();
        if (clipboardManager == null) {
            return;
        }
        g70 g70Var = i50Var.e;
        t00 t00Var = g70Var.h;
        if (t00Var == null || (str = t00Var.c) == null) {
            str = (String) g70Var.i.getValue();
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority("pspdfkit.clipboard");
        builder.path("contentediting");
        builder.appendQueryParameter("tid", i50Var.c);
        builder.appendQueryParameter("v", Integer.toUnsignedString(i50Var.e.g));
        try {
            MAMClipboard.setPrimaryClip(clipboardManager, new ClipData("content", (String[]) faVar.b.toArray(new String[0]), new ClipData.Item(str, null, builder.build())));
        } catch (Exception unused) {
        }
    }
}
