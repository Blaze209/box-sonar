package com.callstack.reactnativebrownfield;

import android.os.Bundle;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropsBundle.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u00030\u0007j\f\u0012\u0004\u0012\u00020\b\u0012\u0002\b\u0003`\t¨\u0006\n"}, d2 = {"Lcom/callstack/reactnativebrownfield/PropsBundle;", "", "<init>", "()V", "fromHashMap", "Landroid/os/Bundle;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PropsBundle {
    public static final PropsBundle INSTANCE = new PropsBundle();

    private PropsBundle() {
    }

    public final Bundle fromHashMap(HashMap<String, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Bundle bundle = new Bundle();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof ArrayList) {
                String key = entry.getKey();
                Object value2 = entry.getValue();
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type java.util.ArrayList<*>");
                bundle.putSerializable(key, (ArrayList) value2);
            } else if (value instanceof ReadableArray) {
                String key2 = entry.getKey();
                Object value3 = entry.getValue();
                Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableArray");
                bundle.putSerializable(key2, ((ReadableArray) value3).toArrayList());
            } else if (value instanceof HashMap) {
                String key3 = entry.getKey();
                PropsBundle propsBundle = INSTANCE;
                Object value4 = entry.getValue();
                Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, *>");
                bundle.putBundle(key3, propsBundle.fromHashMap((HashMap) value4));
            } else if (value instanceof ReadableMap) {
                String key4 = entry.getKey();
                PropsBundle propsBundle2 = INSTANCE;
                Object value5 = entry.getValue();
                Intrinsics.checkNotNull(value5, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
                bundle.putBundle(key4, propsBundle2.fromHashMap(((ReadableMap) value5).toHashMap()));
            } else if (value instanceof Boolean) {
                String key5 = entry.getKey();
                Object value6 = entry.getValue();
                Intrinsics.checkNotNull(value6, "null cannot be cast to non-null type kotlin.Boolean");
                bundle.putBoolean(key5, ((Boolean) value6).booleanValue());
            } else if (value instanceof Integer) {
                String key6 = entry.getKey();
                Object value7 = entry.getValue();
                Intrinsics.checkNotNull(value7, "null cannot be cast to non-null type kotlin.Int");
                bundle.putInt(key6, ((Integer) value7).intValue());
            } else if (value instanceof String) {
                String key7 = entry.getKey();
                Object value8 = entry.getValue();
                Intrinsics.checkNotNull(value8, "null cannot be cast to non-null type kotlin.String");
                bundle.putString(key7, (String) value8);
            } else if (value instanceof Double) {
                String key8 = entry.getKey();
                Object value9 = entry.getValue();
                Intrinsics.checkNotNull(value9, "null cannot be cast to non-null type kotlin.Double");
                bundle.putDouble(key8, ((Double) value9).doubleValue());
            } else {
                bundle.putSerializable(entry.getKey(), null);
            }
        }
        return bundle;
    }
}
