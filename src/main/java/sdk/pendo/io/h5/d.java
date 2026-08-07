package sdk.pendo.io.h5;

import com.google.api.client.http.HttpMethods;

/* JADX INFO: loaded from: classes4.dex */
public interface d {
    public static final String[] a = {HttpMethods.CONNECT, "DISCONNECT", "EVENT", "ACK", "ERROR", "BINARY_EVENT", "BINARY_ACK"};

    public interface a {

        /* JADX INFO: renamed from: sdk.pendo.io.h5.d$a$a, reason: collision with other inner class name */
        public interface InterfaceC0396a {
            void a(c cVar);
        }

        void a(String str);

        void a(InterfaceC0396a interfaceC0396a);

        void a(byte[] bArr);

        void destroy();
    }

    public interface b {

        public interface a {
            void call(Object[] objArr);
        }

        void a(c cVar, a aVar);
    }
}
