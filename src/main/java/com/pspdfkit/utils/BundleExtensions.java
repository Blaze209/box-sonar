package com.pspdfkit.utils;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.internal.vu;
import com.pspdfkit.ui.PdfFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a>\u0010\b\u001a\u0016\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\tj\n\u0012\u0004\u0012\u0002H\u0001\u0018\u0001`\n\"\b\b\u0000\u0010\u0001*\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\u001a\u001c\u0010\f\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"getSupportParcelable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Bundle;", "key", "", "clazz", "Ljava/lang/Class;", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getSupportParcelableArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Landroid/os/Parcelable;", "generateBundleForPdfFragment", "sources", "", "Lcom/pspdfkit/document/DocumentSource;", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BundleExtensions {
    public static final Bundle generateBundleForPdfFragment(List<DocumentSource> list, PdfConfiguration pdfConfiguration) {
        boolean z;
        list.getClass();
        pdfConfiguration.getClass();
        if (list.isEmpty()) {
            z = true;
            break;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            if (!vu.a((DocumentSource) it.next())) {
                z = false;
                break;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(PdfFragment.PARAM_CONFIGURATION, pdfConfiguration);
        if (z) {
            vu[] vuVarArr = new vu[list.size()];
            for (int i = 0; i < list.size(); i++) {
                vuVarArr[i] = new vu(list.get(i));
            }
            bundle.putParcelableArray(PdfFragment.PARAM_SOURCES, vuVarArr);
        }
        return bundle;
    }

    public static final <T> T getSupportParcelable(Bundle bundle, String str, Class<T> cls) {
        bundle.getClass();
        str.getClass();
        cls.getClass();
        return Build.VERSION.SDK_INT >= 33 ? (T) bundle.getParcelable(str, cls) : (T) bundle.getParcelable(str);
    }

    public static final <T extends Parcelable> ArrayList<T> getSupportParcelableArrayList(Bundle bundle, String str, Class<T> cls) {
        bundle.getClass();
        str.getClass();
        cls.getClass();
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelableArrayList(str, cls) : bundle.getParcelableArrayList(str);
    }
}
