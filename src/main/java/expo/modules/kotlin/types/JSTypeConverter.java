package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.formatters.FormattedRecord;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import expo.modules.kotlin.types.folly.FollyDynamicExtensionConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: JSTypeConverter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0016\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eJ\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "convertToJS", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "PassThroughConverter", "BundleConverter", "ArrayConverter", "IntArrayConverter", "FloatArrayConverter", "DoubleArrayConverter", "BooleanArrayConverter", "ByteArrayConverter", "MapConverter", "EnumConverter", "RecordConverter", "URIConverter", "URLConverter", "AndroidUriConverter", "FileConverter", "PairConverter", "LongConverter", "DurationConverter", "RawTypedArrayHolderConverter", "CollectionConverter", "AnyConverter", "FormattedRecordConverter", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface JSTypeConverter<T> {
    Object convertToJS(Object value);

    expo.modules.kotlin.jni.ReturnType getReturnType();

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$PassThroughConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PassThroughConverter implements JSTypeConverter<Object> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            return value;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.UNKNOWN;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$BundleConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Landroid/os/Bundle;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BundleConverter implements JSTypeConverter<Bundle> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Bundle bundle = (Bundle) value;
            if (bundle != null) {
                return JSTypeConverterHelperKt.toJSValue(bundle, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.WRITEABLE_MAP;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$ArrayConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ArrayConverter implements JSTypeConverter<Object[]> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Object[] objArr = (Object[]) value;
            if (objArr != null) {
                return JSTypeConverterHelperKt.toJSValue(objArr, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.WRITEABLE_ARRAY;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$IntArrayConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IntArrayConverter implements JSTypeConverter<int[]> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            int[] iArr = (int[]) value;
            if (iArr != null) {
                return JSTypeConverterHelperKt.toJSValue(iArr, (JSTypeConverterProvider.ContainerProvider) JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.INT_ARRAY;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$FloatArrayConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FloatArrayConverter implements JSTypeConverter<float[]> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            float[] fArr = (float[]) value;
            if (fArr != null) {
                return JSTypeConverterHelperKt.toJSValue(fArr, (JSTypeConverterProvider.ContainerProvider) JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.FLOAT_ARRAY;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$DoubleArrayConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DoubleArrayConverter implements JSTypeConverter<double[]> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            double[] dArr = (double[]) value;
            if (dArr != null) {
                return JSTypeConverterHelperKt.toJSValue(dArr, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.DOUBLE_ARRAY;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$BooleanArrayConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BooleanArrayConverter implements JSTypeConverter<boolean[]> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            boolean[] zArr = (boolean[]) value;
            if (zArr != null) {
                return JSTypeConverterHelperKt.toJSValue(zArr, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.BOOLEAN_ARRAY;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$ByteArrayConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ByteArrayConverter implements JSTypeConverter<byte[]> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            byte[] bArr = (byte[]) value;
            if (bArr != null) {
                return FollyDynamicExtensionConverter.INSTANCE.put(bArr);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$MapConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MapConverter implements JSTypeConverter<Map<?, ?>> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Map map = (Map) value;
            if (map != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(map);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.MAP;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$EnumConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EnumConverter implements JSTypeConverter<Enum<?>> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Enum r1 = (Enum) value;
            if (r1 != null) {
                return JSTypeConverterHelperKt.toJSValue((Enum<?>) r1);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.UNKNOWN;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$RecordConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecordConverter implements JSTypeConverter<Record> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Record record = (Record) value;
            if (record != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(record);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.MAP;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$URIConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Ljava/net/URI;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class URIConverter implements JSTypeConverter<URI> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            URI uri = (URI) value;
            if (uri != null) {
                return JSTypeConverterHelperKt.toJSValue(uri);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$URLConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Ljava/net/URL;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class URLConverter implements JSTypeConverter<URL> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            URL url = (URL) value;
            if (url != null) {
                return JSTypeConverterHelperKt.toJSValue(url);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$AndroidUriConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Landroid/net/Uri;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AndroidUriConverter implements JSTypeConverter<Uri> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Uri uri = (Uri) value;
            if (uri != null) {
                return JSTypeConverterHelperKt.toJSValue(uri);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$FileConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Ljava/io/File;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileConverter implements JSTypeConverter<File> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            File file = (File) value;
            if (file != null) {
                return JSTypeConverterHelperKt.toJSValue(file);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.STRING;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$PairConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Lkotlin/Pair;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PairConverter implements JSTypeConverter<Pair<?, ?>> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Pair pair = (Pair) value;
            if (pair != null) {
                return JSTypeConverterHelperKt.toJSValue((Pair<?, ?>) pair, JSTypeConverterProvider.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.WRITEABLE_ARRAY;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$LongConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LongConverter implements JSTypeConverter<Long> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Long l = (Long) value;
            if (l != null) {
                return Double.valueOf(l.longValue());
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.LONG;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$DurationConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Lkotlin/time/Duration;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DurationConverter implements JSTypeConverter<Duration> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Duration duration = (Duration) value;
            if (duration != null) {
                return Double.valueOf(Duration.m16192toDoubleimpl(duration.getRawValue(), DurationUnit.SECONDS));
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.DOUBLE;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$RawTypedArrayHolderConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Lexpo/modules/kotlin/typedarray/RawTypedArrayHolder;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RawTypedArrayHolderConverter implements JSTypeConverter<RawTypedArrayHolder> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            RawTypedArrayHolder rawTypedArrayHolder = (RawTypedArrayHolder) value;
            if (rawTypedArrayHolder != null) {
                return rawTypedArrayHolder.getRawArray();
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.JS_TYPED_ARRAY;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$CollectionConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CollectionConverter implements JSTypeConverter<Collection<?>> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            Collection collection = (Collection) value;
            if (collection != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(collection);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.COLLECTION;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$AnyConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "convertToJS", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnyConverter implements JSTypeConverter<Object> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            return JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, value, null, true, 2, null);
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.UNKNOWN;
        }
    }

    /* JADX INFO: compiled from: JSTypeConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$FormattedRecordConverter;", "Lexpo/modules/kotlin/types/JSTypeConverter;", "Lexpo/modules/kotlin/records/formatters/FormattedRecord;", "<init>", "()V", "convertToJS", "", "value", "returnType", "Lexpo/modules/kotlin/jni/ReturnType;", "getReturnType", "()Lexpo/modules/kotlin/jni/ReturnType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FormattedRecordConverter implements JSTypeConverter<FormattedRecord<?>> {
        public static final int $stable = 0;

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public Object convertToJS(Object value) {
            FormattedRecord formattedRecord = (FormattedRecord) value;
            if (formattedRecord != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental((FormattedRecord<?>) formattedRecord);
            }
            return null;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter
        public expo.modules.kotlin.jni.ReturnType getReturnType() {
            return expo.modules.kotlin.jni.ReturnType.MAP;
        }
    }
}
