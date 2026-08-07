package com.pspdfkit.utils;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a3\u0010\b\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"readSupportList", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Landroid/os/Parcel;", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "clazz", "Ljava/lang/Class;", "readSupportParcelable", "classLoader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;Ljava/lang/Class;)Landroid/os/Parcelable;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ParcelExtensions {
    public static final <T extends Parcelable> List<T> readSupportList(Parcel parcel, List<? extends T> list, Class<T> cls) {
        parcel.getClass();
        list.getClass();
        cls.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            List<T> parcelableList = parcel.readParcelableList(list, cls.getClassLoader(), cls);
            parcelableList.getClass();
            return parcelableList;
        }
        List<T> parcelableList2 = parcel.readParcelableList(list, cls.getClassLoader());
        parcelableList2.getClass();
        return parcelableList2;
    }

    public static final <T extends Parcelable> T readSupportParcelable(Parcel parcel, ClassLoader classLoader, Class<T> cls) {
        parcel.getClass();
        cls.getClass();
        return Build.VERSION.SDK_INT >= 33 ? (T) parcel.readParcelable(classLoader, cls) : (T) parcel.readParcelable(classLoader);
    }
}
