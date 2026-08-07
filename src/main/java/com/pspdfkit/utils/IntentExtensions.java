package com.pspdfkit.utils;

import android.content.Intent;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"getSupportParcelableExtra", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Intent;", "key", "", "clazz", "Ljava/lang/Class;", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class IntentExtensions {
    public static final <T> T getSupportParcelableExtra(Intent intent, String str, Class<T> cls) {
        intent.getClass();
        str.getClass();
        cls.getClass();
        return Build.VERSION.SDK_INT >= 33 ? (T) intent.getParcelableExtra(str, cls) : (T) intent.getParcelableExtra(str);
    }
}
