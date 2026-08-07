package io.split.android.client.common;

import io.split.android.client.utils.CompressionUtil;
import io.split.android.client.utils.Gzip;
import io.split.android.client.utils.Zlib;
import io.split.android.client.utils.logger.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class CompressionUtilProvider {
    Map<CompressionType, CompressionUtil> mCompressionUtils = new ConcurrentHashMap();

    public CompressionUtil get(CompressionType type) {
        CompressionUtil compressionUtil = this.mCompressionUtils.get(type);
        return compressionUtil != null ? compressionUtil : create(type);
    }

    /* JADX INFO: renamed from: io.split.android.client.common.CompressionUtilProvider$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$common$CompressionType;

        static {
            int[] iArr = new int[CompressionType.values().length];
            $SwitchMap$io$split$android$client$common$CompressionType = iArr;
            try {
                iArr[CompressionType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$common$CompressionType[CompressionType.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$split$android$client$common$CompressionType[CompressionType.ZLIB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private CompressionUtil create(CompressionType type) {
        int i = AnonymousClass2.$SwitchMap$io$split$android$client$common$CompressionType[type.ordinal()];
        if (i == 1) {
            return new CompressionUtil() { // from class: io.split.android.client.common.CompressionUtilProvider.1
                @Override // io.split.android.client.utils.CompressionUtil
                public byte[] decompress(byte[] compressed) {
                    return compressed;
                }
            };
        }
        if (i == 2) {
            return new Gzip();
        }
        if (i == 3) {
            return new Zlib();
        }
        Logger.d("Unavailable compression algorithm: " + type);
        return null;
    }
}
