package zipkin2.reporter.okhttp3;

import java.io.IOException;
import java.io.UncheckedIOException;

/* JADX INFO: loaded from: classes6.dex */
abstract class Platform {
    private static final Platform PLATFORM = findPlatform();

    Platform() {
    }

    RuntimeException uncheckedIOException(IOException iOException) {
        return new RuntimeException(iOException);
    }

    static Platform get() {
        return PLATFORM;
    }

    static Platform findPlatform() {
        try {
            Class.forName("java.io.UncheckedIOException");
            return new Jre8();
        } catch (ClassNotFoundException unused) {
            return Jre6.build();
        }
    }

    static final class Jre8 extends Platform {
        Jre8() {
        }

        @Override // zipkin2.reporter.okhttp3.Platform
        public RuntimeException uncheckedIOException(IOException iOException) {
            return new UncheckedIOException(iOException);
        }
    }

    static final class Jre6 extends Platform {
        Jre6() {
        }

        static Jre6 build() {
            return new Jre6();
        }
    }
}
