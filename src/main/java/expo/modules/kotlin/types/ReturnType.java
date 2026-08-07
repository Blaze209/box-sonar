package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.formatters.FormattedRecord;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.Duration;

/* JADX INFO: compiled from: ReturnType.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u000e\u001a\u00020\u000f\"\u0006\b\u0000\u0010\u0010\u0018\u0001H\u0080\b¢\u0006\u0002\b\u0011R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/types/ReturnType;", "", "klass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "converter", "Lexpo/modules/kotlin/types/JSTypeConverter;", "convertToJS", "value", "cppType", "Lexpo/modules/kotlin/jni/ReturnType;", "getCppType", "()Lexpo/modules/kotlin/jni/ReturnType;", "inheritFrom", "", ExifInterface.GPS_DIRECTION_TRUE, "inheritFrom$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReturnType {
    public static final int $stable = 8;
    private final JSTypeConverter<?> converter;
    private final KClass<?> klass;

    public ReturnType(KClass<?> klass) {
        JSTypeConverter.AnyConverter anyConverter;
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
        KClass<?> kClass = this.klass;
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Unit.class))) {
            anyConverter = new JSTypeConverter.PassThroughConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Bundle.class))) {
            anyConverter = new JSTypeConverter.BundleConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(int[].class))) {
            anyConverter = new JSTypeConverter.IntArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(float[].class))) {
            anyConverter = new JSTypeConverter.FloatArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(double[].class))) {
            anyConverter = new JSTypeConverter.DoubleArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(boolean[].class))) {
            anyConverter = new JSTypeConverter.BooleanArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
            anyConverter = new JSTypeConverter.ByteArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(URI.class))) {
            anyConverter = new JSTypeConverter.URIConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(URL.class))) {
            anyConverter = new JSTypeConverter.URLConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Uri.class))) {
            anyConverter = new JSTypeConverter.AndroidUriConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(File.class))) {
            anyConverter = new JSTypeConverter.FileConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
            anyConverter = new JSTypeConverter.PairConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            anyConverter = new JSTypeConverter.LongConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Duration.class))) {
            anyConverter = new JSTypeConverter.DurationConverter();
        } else {
            anyConverter = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Object.class)) ? new JSTypeConverter.AnyConverter() : null;
        }
        if (anyConverter == null) {
            if (Map.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new JSTypeConverter.MapConverter();
            } else if (Enum.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new JSTypeConverter.EnumConverter();
            } else if (Record.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new JSTypeConverter.RecordConverter();
            } else if (FormattedRecord.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new JSTypeConverter.FormattedRecordConverter();
            } else if (RawTypedArrayHolder.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new JSTypeConverter.RawTypedArrayHolderConverter();
            } else if (Object[].class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new JSTypeConverter.ArrayConverter();
            } else if (Collection.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new JSTypeConverter.CollectionConverter();
            } else {
                anyConverter = new JSTypeConverter.PassThroughConverter();
            }
        }
        this.converter = anyConverter;
    }

    public final Object convertToJS(Object value) {
        return this.converter.convertToJS(value);
    }

    public final expo.modules.kotlin.jni.ReturnType getCppType() {
        return this.converter.getReturnType();
    }

    public final /* synthetic */ <T> boolean inheritFrom$expo_modules_core_release() {
        Class javaClass = JvmClassMappingKt.getJavaClass(this.klass);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(javaClass);
    }
}
