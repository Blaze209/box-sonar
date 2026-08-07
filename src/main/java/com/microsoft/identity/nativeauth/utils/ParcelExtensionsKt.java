package com.microsoft.identity.nativeauth.utils;

import android.os.Build;
import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParcelExtensions.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"serializable", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/io/Serializable;", "msal_distRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ParcelExtensionsKt {
    public static final /* synthetic */ <T extends Serializable> T serializable(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (Build.VERSION.SDK_INT < 33) {
            T t = (T) parcel.readSerializable();
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ClassLoader classLoader = Serializable.class.getClassLoader();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) parcel.readSerializable(classLoader, Serializable.class);
    }
}
