package expo.modules.kotlin.jni.worklets;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.jni.HybridData;
import expo.modules.kotlin.jni.Destructible;
import external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBuffer;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Serializable.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0019\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0004J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/jni/worklets/Serializable;", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "type", "", "<init>", "(Lcom/facebook/jni/HybridData;I)V", "Lexpo/modules/kotlin/jni/worklets/Serializable$ValueType;", "getType", "()Lexpo/modules/kotlin/jni/worklets/Serializable$ValueType;", "finalize", "", "getHybridDataForJNIDeallocator", "ValueType", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Serializable implements Destructible {
    public static final int $stable = 8;
    private final HybridData mHybridData;
    private final ValueType type;

    private Serializable(HybridData hybridData, int i) {
        this.mHybridData = hybridData;
        for (ValueType valueType : ValueType.getEntries()) {
            if (valueType.getValue() == i) {
                this.type = valueType;
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX INFO: compiled from: Serializable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/jni/worklets/Serializable$ValueType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Undefined", "Null", "Boolean", "Number", "BigInt", "String", "Object", "Array", "Map", "Set", "Worklet", "RemoteFunction", "Handle", "HostObject", "HostFunction", NativeArrayBuffer.CLASS_NAME, "TurboModuleLike", "Import", "Synchronizable", TypedValues.Custom.NAME, "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ValueType {
        Undefined(1),
        Null(2),
        Boolean(3),
        Number(4),
        BigInt(5),
        String(6),
        Object(7),
        Array(8),
        Map(9),
        Set(10),
        Worklet(11),
        RemoteFunction(12),
        Handle(13),
        HostObject(14),
        HostFunction(15),
        ArrayBuffer(16),
        TurboModuleLike(17),
        Import(18),
        Synchronizable(19),
        Custom(20);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final int value;

        public static EnumEntries<ValueType> getEntries() {
            return $ENTRIES;
        }

        ValueType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public final ValueType getType() {
        return this.type;
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }
}
