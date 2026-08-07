package expo.modules.kotlin.records;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProviderImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordTypeConverter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\bH\u0001¢\u0006\u0002\u0010\t\u001a0\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086\b¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"recordFromMap", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "map", "", "", "", "converter", "Lexpo/modules/kotlin/records/RecordTypeConverter;", "(Ljava/util/Map;Lexpo/modules/kotlin/records/RecordTypeConverter;)Lexpo/modules/kotlin/records/Record;", "(Ljava/util/Map;)Lexpo/modules/kotlin/records/Record;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RecordTypeConverterKt {
    public static final <T extends Record> T recordFromMap(Map<String, ? extends Object> map, RecordTypeConverter<T> converter) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(converter, "converter");
        return (T) RecordTypeConverter.convertFromMap$expo_modules_core_release$default(converter, map, null, false, 6, null);
    }

    public static final /* synthetic */ <T extends Record> T recordFromMap(Map<String, ? extends Object> map) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(map, "map");
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        TypeConverter<?> typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(null);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
        return (T) recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
    }
}
