package expo.modules.kotlin.types.worklets;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.worklets.Serializable;
import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.kotlin.types.NonNullableTypeConverter;
import expo.modules.kotlin.types.TypeConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkletTypeConverter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/types/worklets/WorkletTypeConverter;", "Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "Lexpo/modules/kotlin/jni/worklets/Worklet;", "serializableTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "Lexpo/modules/kotlin/jni/worklets/Serializable;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverter;)V", "convertNonNullable", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkletTypeConverter extends NonNullableTypeConverter<Worklet> {
    public static final int $stable = 8;
    private final TypeConverter<Serializable> serializableTypeConverter;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public WorkletTypeConverter(TypeConverter<Serializable> serializableTypeConverter) {
        Intrinsics.checkNotNullParameter(serializableTypeConverter, "serializableTypeConverter");
        this.serializableTypeConverter = serializableTypeConverter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public Worklet convertNonNullable(Object value, AppContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        Serializable serializableConvert = this.serializableTypeConverter.convert(value, context, forceConversion);
        if (serializableConvert == null) {
            throw new IllegalArgumentException("Cannot convert '" + value + "' to Serializable.");
        }
        if (serializableConvert.getType() != Serializable.ValueType.Worklet) {
            throw new IllegalArgumentException("Expected Serializable of type Worklet but got " + serializableConvert.getType() + ".");
        }
        return new Worklet(serializableConvert);
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return this.serializableTypeConverter.getCppRequiredTypes();
    }
}
