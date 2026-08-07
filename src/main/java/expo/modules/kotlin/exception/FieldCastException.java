package expo.modules.kotlin.exception;

import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: CodedException.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\rB)\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/exception/FieldCastException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "message", "", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/exception/CodedException;)V", "fieldName", "fieldType", "Lkotlin/reflect/KType;", "providedType", "Lcom/facebook/react/bridge/ReadableType;", "(Ljava/lang/String;Lkotlin/reflect/KType;Lcom/facebook/react/bridge/ReadableType;Lexpo/modules/kotlin/exception/CodedException;)V", "recordType", "(Ljava/lang/String;Lkotlin/reflect/KType;Lkotlin/reflect/KType;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldCastException extends DecoratedException {
    public static final int $stable = 8;

    private FieldCastException(String str, CodedException codedException) {
        super(str, codedException);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FieldCastException(String fieldName, KType fieldType, ReadableType providedType, CodedException cause) {
        this("Cannot cast '" + providedType.name() + "' for field '" + fieldName + "' ('" + fieldType + "').", cause);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(providedType, "providedType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FieldCastException(String fieldName, KType fieldType, KType recordType, CodedException cause) {
        this("Cannot cast value for field '" + fieldName + "' ('" + fieldType + "') in record '" + recordType + "'.", cause);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
