package com.box.android.data.api.models.upload;

import android.util.Base64;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: UploadFileStates.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/api/models/upload/ChunkUploadHeadersHelper;", "", "<init>", "()V", "createDigestHeader", "", "sha1", "createContentRangeHeader", "startByte", "", "endByte", "fileSize", "fileChunk", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChunkUploadHeadersHelper {
    public static final ChunkUploadHeadersHelper INSTANCE = new ChunkUploadHeadersHelper();

    private ChunkUploadHeadersHelper() {
    }

    public final String createDigestHeader(String sha1) {
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        String strChomp = StringUtils.chomp("sha=" + Base64.encodeToString(ByteString.INSTANCE.decodeHex(sha1).toByteArray(), 0));
        Intrinsics.checkNotNullExpressionValue(strChomp, "chomp(...)");
        return strChomp;
    }

    public final String createContentRangeHeader(long startByte, long endByte, long fileSize) {
        return "bytes " + startByte + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + (endByte - 1) + "/" + fileSize;
    }

    public final String createDigestHeader(byte[] fileChunk) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fileChunk, "fileChunk");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
        messageDigest.update(fileChunk);
        String strChomp = StringUtils.chomp("sha=" + Base64.encodeToString(messageDigest.digest(), 0));
        Intrinsics.checkNotNullExpressionValue(strChomp, "chomp(...)");
        return strChomp;
    }
}
