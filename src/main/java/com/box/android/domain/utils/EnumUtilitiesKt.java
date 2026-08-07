package com.box.android.domain.utils;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumUtilities.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u001a2\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\u0006\u001a,\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001a4\u0010\t\u001a\u00020\n\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\f\u001a4\u0010\r\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\u000f\u001a.\u0010\u0010\u001a\u0004\u0018\u0001H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"enumFromString", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "", "default", "(Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "enumFromStringOrNull", "(Ljava/lang/String;)Ljava/lang/Enum;", "putEnumExtra", "Landroid/content/Intent;", "key", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Enum;)Landroid/content/Intent;", "getEnumExtra", "defaultValue", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "getEnumExtraOrNull", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/lang/Enum;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EnumUtilitiesKt {
    public static final /* synthetic */ <T extends Enum<T>> T enumFromString(String str, T t) {
        Intrinsics.checkNotNullParameter(t, "default");
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Enum[] enumArr = new Enum[0];
        return t;
    }

    public static final /* synthetic */ <T extends Enum<T>> T enumFromStringOrNull(String str) {
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Enum[] enumArr = new Enum[0];
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T>> Intent putEnumExtra(Intent intent, String key, T value) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intent intentPutExtra = intent.putExtra(key, value.name());
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    public static final /* synthetic */ <T extends Enum<T>> T getEnumExtra(Intent intent, String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        intent.getStringExtra(key);
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Enum[] enumArr = new Enum[0];
        return defaultValue;
    }

    public static final /* synthetic */ <T extends Enum<T>> T getEnumExtraOrNull(Intent intent, String key) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        intent.getStringExtra(key);
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Enum[] enumArr = new Enum[0];
        return null;
    }
}
