package expo.modules.kotlin.jni;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'STRING' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: ReturnType.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/jni/ReturnType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DOUBLE", "INT", "LONG", "STRING", "BOOLEAN", "FLOAT", "WRITEABLE_ARRAY", "WRITEABLE_MAP", "JS_MODULE", "SHARED_OBJECT", "JS_TYPED_ARRAY", "JS_ARRAY_BUFFER", "NATIVE_ARRAY_BUFFER", "MAP", "COLLECTION", "DOUBLE_ARRAY", "INT_ARRAY", "LONG_ARRAY", "FLOAT_ARRAY", "BOOLEAN_ARRAY", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReturnType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReturnType[] $VALUES;
    public static final ReturnType JS_TYPED_ARRAY;
    public static final ReturnType LONG_ARRAY;
    public static final ReturnType STRING;
    private final int value;
    public static final ReturnType UNKNOWN = new ReturnType("UNKNOWN", 0, 0);
    public static final ReturnType DOUBLE = new ReturnType("DOUBLE", 1, 0, 1, null);
    public static final ReturnType INT = new ReturnType("INT", 2, 0, 1, null);
    public static final ReturnType LONG = new ReturnType("LONG", 3, 0, 1, null);
    public static final ReturnType BOOLEAN = new ReturnType("BOOLEAN", 5, 0, 1, null);
    public static final ReturnType FLOAT = new ReturnType("FLOAT", 6, 0, 1, null);
    public static final ReturnType WRITEABLE_ARRAY = new ReturnType("WRITEABLE_ARRAY", 7, 0, 1, null);
    public static final ReturnType WRITEABLE_MAP = new ReturnType("WRITEABLE_MAP", 8, 0, 1, null);
    public static final ReturnType JS_MODULE = new ReturnType("JS_MODULE", 9, 0, 1, null);
    public static final ReturnType SHARED_OBJECT = new ReturnType("SHARED_OBJECT", 10, 0, 1, null);
    public static final ReturnType JS_ARRAY_BUFFER = new ReturnType("JS_ARRAY_BUFFER", 12, 0, 1, null);
    public static final ReturnType NATIVE_ARRAY_BUFFER = new ReturnType("NATIVE_ARRAY_BUFFER", 13, 0, 1, null);
    public static final ReturnType MAP = new ReturnType("MAP", 14, 0, 1, null);
    public static final ReturnType COLLECTION = new ReturnType("COLLECTION", 15, 0, 1, null);
    public static final ReturnType DOUBLE_ARRAY = new ReturnType("DOUBLE_ARRAY", 16, 0, 1, null);
    public static final ReturnType INT_ARRAY = new ReturnType("INT_ARRAY", 17, 0, 1, null);
    public static final ReturnType FLOAT_ARRAY = new ReturnType("FLOAT_ARRAY", 19, 0, 1, null);
    public static final ReturnType BOOLEAN_ARRAY = new ReturnType("BOOLEAN_ARRAY", 20, 0, 1, null);

    private static final /* synthetic */ ReturnType[] $values() {
        return new ReturnType[]{UNKNOWN, DOUBLE, INT, LONG, STRING, BOOLEAN, FLOAT, WRITEABLE_ARRAY, WRITEABLE_MAP, JS_MODULE, SHARED_OBJECT, JS_TYPED_ARRAY, JS_ARRAY_BUFFER, NATIVE_ARRAY_BUFFER, MAP, COLLECTION, DOUBLE_ARRAY, INT_ARRAY, LONG_ARRAY, FLOAT_ARRAY, BOOLEAN_ARRAY};
    }

    public static EnumEntries<ReturnType> getEntries() {
        return $ENTRIES;
    }

    private ReturnType(String str, int i, int i2) {
        super(str, i);
        this.value = i2;
    }

    /* synthetic */ ReturnType(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i3 & 1) != 0 ? ReturnTypeKt.nextValue() : i2);
    }

    public final int getValue() {
        return this.value;
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        STRING = new ReturnType("STRING", 4, 0, 1, defaultConstructorMarker);
        JS_TYPED_ARRAY = new ReturnType("JS_TYPED_ARRAY", 11, 0, 1, defaultConstructorMarker);
        LONG_ARRAY = new ReturnType("LONG_ARRAY", 18, 0, 1, defaultConstructorMarker);
        ReturnType[] returnTypeArr$values = $values();
        $VALUES = returnTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(returnTypeArr$values);
    }

    public static ReturnType valueOf(String str) {
        return (ReturnType) Enum.valueOf(ReturnType.class, str);
    }

    public static ReturnType[] values() {
        return (ReturnType[]) $VALUES.clone();
    }
}
