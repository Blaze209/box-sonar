package com.margelo.nitro.core;

import com.facebook.jni.HybridData;
import dalvik.annotation.optimization.FastNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnyValue.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u0002\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\u0002\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u000e¢\u0006\u0004\b\u0002\u0010\u000fB\u001b\b\u0016\u0012\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00000\u0010j\u0002`\u0011¢\u0006\u0004\b\u0002\u0010\u0012B!\b\u0016\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u0013j\u0002`\u0014¢\u0006\u0004\b\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\nH\u0087 J\t\u0010\u0017\u001a\u00020\nH\u0087 J\t\u0010\u0018\u001a\u00020\nH\u0087 J\t\u0010\u0019\u001a\u00020\nH\u0087 J\t\u0010\u001a\u001a\u00020\nH\u0087 J\t\u0010\u001b\u001a\u00020\nH\u0087 J\t\u0010\u001c\u001a\u00020\nH\u0087 J\t\u0010\u001d\u001a\u00020\bH\u0087 J\t\u0010\u001e\u001a\u00020\nH\u0087 J\t\u0010\u001f\u001a\u00020\fH\u0087 J\t\u0010 \u001a\u00020\u000eH\u0086 J\u0018\u0010!\u001a\f\u0012\u0004\u0012\u00020\u00000\u0010j\u0002`\u0011H\u0086 ¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u0013j\u0002`\u0014H\u0086 J\t\u0010$\u001a\u00020\u0005H\u0082 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\nH\u0082 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\fH\u0082 J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000eH\u0082 J \u0010$\u001a\u00020\u00052\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00000\u0010j\u0002`\u0011H\u0082 ¢\u0006\u0002\u0010%J!\u0010$\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\u0013j\u0002`\u0014H\u0082 J\b\u0010&\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/margelo/nitro/core/AnyValue;", "", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "value", "", "(D)V", "", "(Z)V", "", "(J)V", "", "(Ljava/lang/String;)V", "", "Lcom/margelo/nitro/core/AnyArray;", "([Lcom/margelo/nitro/core/AnyValue;)V", "", "Lcom/margelo/nitro/core/AnyObject;", "(Ljava/util/Map;)V", "isNull", "isDouble", "isBoolean", "isInt64", "isString", "isAnyArray", "isAnyObject", "asDouble", "asBoolean", "asInt64", "asString", "asAnyArray", "()[Lcom/margelo/nitro/core/AnyValue;", "asAnyObject", "initHybrid", "([Lcom/margelo/nitro/core/AnyValue;)Lcom/facebook/jni/HybridData;", "toAny", "Companion", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnyValue {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HybridData mHybridData;

    private final native HybridData initHybrid();

    private final native HybridData initHybrid(double value);

    private final native HybridData initHybrid(long value);

    private final native HybridData initHybrid(String value);

    private final native HybridData initHybrid(Map<String, AnyValue> value);

    private final native HybridData initHybrid(boolean value);

    private final native HybridData initHybrid(AnyValue[] value);

    public final native AnyValue[] asAnyArray();

    public final native Map<String, AnyValue> asAnyObject();

    @FastNative
    public final native boolean asBoolean();

    @FastNative
    public final native double asDouble();

    @FastNative
    public final native long asInt64();

    public final native String asString();

    @FastNative
    public final native boolean isAnyArray();

    @FastNative
    public final native boolean isAnyObject();

    @FastNative
    public final native boolean isBoolean();

    @FastNative
    public final native boolean isDouble();

    @FastNative
    public final native boolean isInt64();

    @FastNative
    public final native boolean isNull();

    @FastNative
    public final native boolean isString();

    public AnyValue() {
        this.mHybridData = initHybrid();
    }

    private AnyValue(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public AnyValue(double d) {
        this.mHybridData = initHybrid(d);
    }

    public AnyValue(boolean z) {
        this.mHybridData = initHybrid(z);
    }

    public AnyValue(long j) {
        this.mHybridData = initHybrid(j);
    }

    public AnyValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mHybridData = initHybrid(value);
    }

    public AnyValue(AnyValue[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mHybridData = initHybrid(value);
    }

    public AnyValue(Map<String, AnyValue> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mHybridData = initHybrid(value);
    }

    public final Object toAny() {
        if (isNull()) {
            return null;
        }
        if (isDouble()) {
            return Double.valueOf(asDouble());
        }
        if (isInt64()) {
            return Long.valueOf(asInt64());
        }
        if (isBoolean()) {
            return Boolean.valueOf(asBoolean());
        }
        if (isString()) {
            return asString();
        }
        if (isAnyArray()) {
            AnyValue[] anyValueArrAsAnyArray = asAnyArray();
            ArrayList arrayList = new ArrayList(anyValueArrAsAnyArray.length);
            for (AnyValue anyValue : anyValueArrAsAnyArray) {
                arrayList.add(anyValue.toAny());
            }
            return arrayList.toArray(new Object[0]);
        }
        if (isAnyObject()) {
            Map<String, AnyValue> mapAsAnyObject = asAnyObject();
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapAsAnyObject.size()));
            Iterator<T> it = mapAsAnyObject.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                linkedHashMap.put(key, ((AnyValue) entry.getValue()).toAny());
            }
            return linkedHashMap;
        }
        throw new Error("AnyValue holds unknown type!");
    }

    /* JADX INFO: compiled from: AnyValue.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¨\u0006\u0007"}, d2 = {"Lcom/margelo/nitro/core/AnyValue$Companion;", "", "<init>", "()V", "fromAny", "Lcom/margelo/nitro/core/AnyValue;", "value", "react-native-nitro-modules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnyValue fromAny(Object value) {
            if (value == null) {
                return new AnyValue();
            }
            if (value instanceof Double) {
                return new AnyValue(((Number) value).doubleValue());
            }
            if (value instanceof Float) {
                return new AnyValue(((Number) value).floatValue());
            }
            if (value instanceof Integer) {
                return new AnyValue(((Number) value).intValue());
            }
            if (value instanceof Boolean) {
                return new AnyValue(((Boolean) value).booleanValue());
            }
            if (value instanceof Long) {
                return new AnyValue(((Number) value).longValue());
            }
            if (value instanceof String) {
                return new AnyValue((String) value);
            }
            if (value instanceof Object[]) {
                Object[] objArr = (Object[]) value;
                ArrayList arrayList = new ArrayList(objArr.length);
                for (Object obj : objArr) {
                    arrayList.add(AnyValue.INSTANCE.fromAny(obj));
                }
                return new AnyValue((AnyValue[]) arrayList.toArray(new AnyValue[0]));
            }
            if (value instanceof List) {
                Iterable iterable = (Iterable) value;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AnyValue.INSTANCE.fromAny(it.next()));
                }
                return new AnyValue((AnyValue[]) arrayList2.toArray(new AnyValue[0]));
            }
            if (value instanceof Map) {
                Map map = (Map) value;
                ArrayList arrayList3 = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList3.add(TuplesKt.to(String.valueOf(entry.getKey()), AnyValue.INSTANCE.fromAny(entry.getValue())));
                }
                return new AnyValue((Map<String, AnyValue>) MapsKt.toMap(arrayList3));
            }
            if ((value instanceof AnyValue) || (value instanceof AnyMap)) {
                throw new Error("Cannot box AnyValue (" + value + ") twice!");
            }
            throw new Error("Value \"" + value + "\" cannot be represented as AnyValue!");
        }
    }
}
