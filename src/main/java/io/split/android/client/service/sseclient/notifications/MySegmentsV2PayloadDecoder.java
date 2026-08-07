package io.split.android.client.service.sseclient.notifications;

import io.split.android.client.exceptions.MySegmentsParsingException;
import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.CompressionUtil;
import io.split.android.client.utils.MurmurHash3;
import io.split.android.client.utils.StringHelper;
import java.math.BigInteger;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsV2PayloadDecoder {
    public final int FIELD_SIZE = 8;

    public String decodeAsString(String payload, CompressionUtil compressionUtil) throws MySegmentsParsingException {
        return StringHelper.stringFromBytes(decodeAsBytes(payload, compressionUtil));
    }

    public byte[] decodeAsBytes(String payload, CompressionUtil compressionUtil) throws MySegmentsParsingException {
        byte[] bArrBytesDecode = Base64Util.bytesDecode(payload);
        if (bArrBytesDecode == null) {
            throw new MySegmentsParsingException("Could not decode payload");
        }
        byte[] bArrDecompress = compressionUtil.decompress(bArrBytesDecode);
        if (bArrDecompress != null) {
            return bArrDecompress;
        }
        throw new MySegmentsParsingException("Could not decompress payload");
    }

    public boolean isKeyInBitmap(byte[] keyMap, int index) {
        int i = index / 8;
        return i <= keyMap.length - 1 && (keyMap[i] & (1 << ((byte) (index % 8)))) != 0;
    }

    public BigInteger hashKey(String key) {
        return MurmurHash3.unsignedHash128x64(key.getBytes(StringHelper.defaultCharset()))[0];
    }

    public int computeKeyIndex(BigInteger hashedKey, int keyMapLength) {
        return hashedKey.remainder(BigInteger.valueOf(keyMapLength * 8)).intValue();
    }

    public KeyList.Action getKeyListAction(KeyList keyList, BigInteger hashedKey) {
        if (new HashSet(keyList.getAdded()).contains(hashedKey)) {
            return KeyList.Action.ADD;
        }
        if (new HashSet(keyList.getRemoved()).contains(hashedKey)) {
            return KeyList.Action.REMOVE;
        }
        return KeyList.Action.NONE;
    }
}
