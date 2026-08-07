package zipkin2.codec;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public enum Encoding {
    JSON { // from class: zipkin2.codec.Encoding.1
        @Override // zipkin2.codec.Encoding
        public int listSizeInBytes(int i) {
            return i + 2;
        }

        @Override // zipkin2.codec.Encoding
        public int listSizeInBytes(List<byte[]> list) {
            int size = list.size();
            int length = 2;
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                length += list.get(i).length;
                if (i2 < size) {
                    length++;
                }
                i = i2;
            }
            return length;
        }
    },
    THRIFT { // from class: zipkin2.codec.Encoding.2
        @Override // zipkin2.codec.Encoding
        public int listSizeInBytes(int i) {
            return i + 5;
        }

        @Override // zipkin2.codec.Encoding
        public int listSizeInBytes(List<byte[]> list) {
            int size = list.size();
            int length = 5;
            for (int i = 0; i < size; i++) {
                length += list.get(i).length;
            }
            return length;
        }
    },
    PROTO3 { // from class: zipkin2.codec.Encoding.3
        @Override // zipkin2.codec.Encoding
        public int listSizeInBytes(int i) {
            return i;
        }

        @Override // zipkin2.codec.Encoding
        public int listSizeInBytes(List<byte[]> list) {
            int size = list.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += list.get(i).length;
            }
            return length;
        }
    };

    public abstract int listSizeInBytes(int i);

    public abstract int listSizeInBytes(List<byte[]> list);
}
