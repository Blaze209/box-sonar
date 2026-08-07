package com.microsoft.identity.common;

import android.os.Bundle;
import com.microsoft.identity.common.java.util.ported.PropertyBag;

/* JADX INFO: loaded from: classes14.dex */
public class PropertyBagUtil {
    public static Bundle toBundle(PropertyBag propertyBag) {
        if (propertyBag == null) {
            throw new NullPointerException("propertyBag is marked non-null but is null");
        }
        Bundle bundle = new Bundle();
        for (String str : propertyBag.keySet()) {
            bundle.putSerializable(str, propertyBag.get(str));
        }
        return bundle;
    }

    public static PropertyBag fromBundle(Bundle bundle) {
        if (bundle == null) {
            throw new NullPointerException("bundle is marked non-null but is null");
        }
        PropertyBag propertyBag = new PropertyBag();
        for (String str : bundle.keySet()) {
            propertyBag.put(str, bundle.getSerializable(str));
        }
        return propertyBag;
    }
}
