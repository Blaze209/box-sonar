package androidx.media3.session.legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class LegacyParcelableUtil {
    private LegacyParcelableUtil() {
    }

    public static <T extends Parcelable, U extends Parcelable> T convert(U u, Parcelable.Creator<T> creator) {
        if (u == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            u.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static <T extends Parcelable, U extends Parcelable> ArrayList<T> convertList(List<U> list, Parcelable.Creator<T> creator) {
        if (list == null) {
            return null;
        }
        MAMEnrolledIdentitiesCache.CacheEntry.AnonymousClass1 anonymousClass1 = (ArrayList<T>) new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            anonymousClass1.add(convert(list.get(i), creator));
        }
        return anonymousClass1;
    }
}
