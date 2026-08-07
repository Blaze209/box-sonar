package com.box.android.common.utilities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BundleExtension.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\n*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u000b\u001a&\u0010\f\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\n*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u000b\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\n*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a(\u0010\t\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\n*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"serializable", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "Landroid/os/Bundle;", "key", "", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "Landroid/content/Intent;", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/io/Serializable;", "parcelable", "Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "parcelableOrThrow", "parcelableListOrThrow", "", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BundleExtensionKt {
    public static final /* synthetic */ <T extends Serializable> T serializable(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) bundle.getSerializable(key, Serializable.class);
        }
        T t = (T) bundle.getSerializable(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final /* synthetic */ <T extends Serializable> T serializable(Intent intent, String key) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) intent.getSerializableExtra(key, Serializable.class);
        }
        T t = (T) intent.getSerializableExtra(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final /* synthetic */ <T extends Parcelable> T parcelable(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) bundle.getParcelable(key, Parcelable.class);
        }
        T t = (T) bundle.getParcelable(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final /* synthetic */ <T extends Parcelable> T parcelableOrThrow(Bundle bundle, String key) {
        T t;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            t = (T) bundle.getParcelable(key, Parcelable.class);
        } else {
            t = (T) bundle.getParcelable(key);
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        }
        if (t == null) {
            throw new IllegalArgumentException(("Parcelable with key " + key + " not found in Bundle").toString());
        }
        return t;
    }

    public static final /* synthetic */ <T extends Parcelable> List<T> parcelableListOrThrow(Bundle bundle, String key) {
        ArrayList<T> parcelableArrayList;
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            parcelableArrayList = bundle.getParcelableArrayList(key, Parcelable.class);
        } else {
            ArrayList<T> parcelableArrayList2 = bundle.getParcelableArrayList(key);
            parcelableArrayList = parcelableArrayList2 instanceof List ? parcelableArrayList2 : null;
        }
        if (parcelableArrayList != null) {
            return parcelableArrayList;
        }
        throw new IllegalArgumentException(("List of parcelables with key " + key + " not found in Bundle").toString());
    }

    public static final /* synthetic */ <T extends Parcelable> T parcelable(Intent intent, String key) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) intent.getParcelableExtra(key, Parcelable.class);
        }
        T t = (T) intent.getParcelableExtra(key);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }
}
