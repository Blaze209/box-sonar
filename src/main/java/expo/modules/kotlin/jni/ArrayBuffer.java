package expo.modules.kotlin.jni;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* JADX INFO: compiled from: ArrayBuffer.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/jni/ArrayBuffer;", "", "size", "", "readByte", "", ViewProps.POSITION, "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "toDirectBuffer", "Ljava/nio/ByteBuffer;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "Lexpo/modules/kotlin/jni/NativeArrayBuffer;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ArrayBuffer {
    NativeArrayBuffer copy();

    short read2Byte(int position);

    int read4Byte(int position);

    long read8Byte(int position);

    byte readByte(int position);

    double readDouble(int position);

    float readFloat(int position);

    int size();

    ByteBuffer toDirectBuffer();

    /* JADX INFO: compiled from: ArrayBuffer.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static NativeArrayBuffer copy(ArrayBuffer arrayBuffer) {
            return NativeArrayBuffer.INSTANCE.copyOf(arrayBuffer);
        }
    }
}
