package zipkin2.codec;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface BytesEncoder<T> {
    byte[] encode(T t);

    byte[] encodeList(List<T> list);

    Encoding encoding();

    int sizeInBytes(T t);
}
