package sdk.pendo.io.a;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
final class j {
    static void a(Object obj) {
        Class<?> cls = obj.getClass();
        String strReplace = cls.getName().replace('.', '/');
        if (a(strReplace)) {
            return;
        }
        a(cls.getClassLoader().getResourceAsStream(strReplace + ".class"));
    }

    static void a(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalStateException("Bytecode not available, can't check class version");
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            try {
                dataInputStream.readInt();
                int unsignedShort = dataInputStream.readUnsignedShort();
                dataInputStream.close();
                if (unsignedShort != 65535) {
                    throw new IllegalStateException("ASM9_EXPERIMENTAL can only be used by classes compiled with --enable-preview");
                }
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e) {
            throw new IllegalStateException("I/O error, can't check class version", e);
        }
    }

    static boolean a(String str) {
        if (str.startsWith("external/sdk/pendo/io/asm/")) {
            return str.contains("Test$") || Pattern.matches("external/sdk/pendo/io/asm/util/Trace(Annotation|Class|Field|Method|Module|RecordComponent|Signature)Visitor(\\$.*)?", str) || Pattern.matches("external/sdk/pendo/io/asm/util/Check(Annotation|Class|Field|Method|Module|RecordComponent|Signature)Adapter(\\$.*)?", str);
        }
        return false;
    }
}
