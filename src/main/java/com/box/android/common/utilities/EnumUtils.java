package com.box.android.common.utilities;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnumUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0010\b\u0000\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/common/utilities/EnumUtils;", "", "<init>", "()V", "findEnumByString", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "", "(Ljava/lang/String;)Ljava/lang/Enum;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EnumUtils {
    public static final EnumUtils INSTANCE = new EnumUtils();

    private EnumUtils() {
    }

    public final /* synthetic */ <T extends Enum<T>> T findEnumByString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
        Enum[] enumArr = new Enum[0];
        return null;
    }
}
