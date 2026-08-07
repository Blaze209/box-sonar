package com.geniusscansdk.structureddata;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ReadableCode.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/geniusscansdk/structureddata/ReadableCode;", "Ljava/io/Serializable;", "value", "", "type", "Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "<init>", "(Ljava/lang/String;Lcom/geniusscansdk/structureddata/ReadableCode$Type;)V", "getValue", "()Ljava/lang/String;", "getType", "()Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Type", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ReadableCode implements Serializable {
    private final Type type;
    private final String value;

    public static /* synthetic */ ReadableCode copy$default(ReadableCode readableCode, String str, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            str = readableCode.value;
        }
        if ((i & 2) != 0) {
            type = readableCode.type;
        }
        return readableCode.copy(str, type);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final ReadableCode copy(String value, Type type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ReadableCode(value, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReadableCode)) {
            return false;
        }
        ReadableCode readableCode = (ReadableCode) other;
        return Intrinsics.areEqual(this.value, readableCode.value) && this.type == readableCode.type;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ReadableCode(value=" + this.value + ", type=" + this.type + ")";
    }

    public ReadableCode(String value, Type type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.value = value;
        this.type = type;
    }

    public final String getValue() {
        return this.value;
    }

    public final Type getType() {
        return this.type;
    }

    /* JADX INFO: compiled from: ReadableCode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "", "code", "", "mlkitFormat", "", "displayName", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getCode$gssdk_release", "()Ljava/lang/String;", "getMlkitFormat", "()I", "getDisplayName", "Aztec", "Code39", "Code93", "Code128", "DataMatrix", "EAN8", "EAN13", "ITF", "PDF417", "QR", "UPC_A", "UPC_E", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Type {
        Aztec("aztec", 4096, "Aztec"),
        Code39("code39", 2, "Code 39"),
        Code93("code93", 4, "Code 93"),
        Code128("code128", 1, "Code 128"),
        DataMatrix("dataMatrix", 16, "Data Matrix"),
        EAN8("ean8", 64, "EAN-8"),
        EAN13("ean13", 32, "EAN-13"),
        ITF("itf", 128, "ITF"),
        PDF417("pdf417", 2048, "PDF417"),
        QR("qr", 256, "QR Code"),
        UPC_A("upca", 512, "UPC-A"),
        UPC_E("upce", 1024, "UPC-E");

        private static final Map<String, Type> CODE_TO_TYPE_MAP;
        private final String code;
        private final String displayName;
        private final int mlkitFormat;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @JvmStatic
        public static final EnumSet<Type> fromCodes(List<String> list) {
            return INSTANCE.fromCodes(list);
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        Type(String str, int i, String str2) {
            this.code = str;
            this.mlkitFormat = i;
            this.displayName = str2;
        }

        /* JADX INFO: renamed from: getCode$gssdk_release, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final int getMlkitFormat() {
            return this.mlkitFormat;
        }

        static {
            EnumEntries<Type> entries = getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
            for (Type type : entries) {
                linkedHashMap.put(type.code, type);
            }
            CODE_TO_TYPE_MAP = linkedHashMap;
        }

        /* JADX INFO: compiled from: ReadableCode.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/structureddata/ReadableCode$Type$Companion;", "", "<init>", "()V", "CODE_TO_TYPE_MAP", "", "", "Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "fromCodes", "Ljava/util/EnumSet;", "codes", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final EnumSet<Type> fromCodes(List<String> codes) {
                Intrinsics.checkNotNullParameter(codes, "codes");
                EnumSet<Type> enumSetNoneOf = EnumSet.noneOf(Type.class);
                for (String str : codes) {
                    Type type = (Type) Type.CODE_TO_TYPE_MAP.get(str);
                    if (type == null) {
                        throw new IllegalArgumentException("Invalid code: " + str);
                    }
                    enumSetNoneOf.add(type);
                }
                Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "also(...)");
                return enumSetNoneOf;
            }
        }
    }
}
