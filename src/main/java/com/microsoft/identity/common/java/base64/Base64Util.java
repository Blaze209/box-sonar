package com.microsoft.identity.common.java.base64;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: Base64Util.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/common/java/base64/Base64Util;", "", "()V", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Base64Util {
    private static final String ANDROID_BASE64_CLASS_PATH = "com.microsoft.identity.common.base64.AndroidBase64";
    private static final String BROKER4J_UNIT_TEST_BASE64_CLASS_PATH = "com.microsoft.identity.broker4j.MseberaBase64ForBroker4jTests";
    private static final String COMMON4J_UNIT_TEST_BASE64_CLASS_PATH = "com.microsoft.identity.common.java.MseberaBase64ForCommon4jTests";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String LINUX_BASE64_CLASS_PATH = "com.microsoft.identity.broker.base64.MseberaBase64ForLinux";
    private static final String TAG;
    private static final String TESTUTILS_BASE64_CLASS_PATH = "com.microsoft.identity.internal.testutils.MseberaBase64ForTestUtils";
    private static IBase64 base64;

    @JvmStatic
    public static final byte[] decode(String str, String str2, Base64Flags... base64FlagsArr) {
        return INSTANCE.decode(str, str2, base64FlagsArr);
    }

    @JvmStatic
    public static final byte[] decode(String str, Base64Flags... base64FlagsArr) {
        return INSTANCE.decode(str, base64FlagsArr);
    }

    @JvmStatic
    public static final byte[] decode(byte[] bArr, Base64Flags... base64FlagsArr) {
        return INSTANCE.decode(bArr, base64FlagsArr);
    }

    @JvmStatic
    public static final byte[] decodeNoWrap(String str) {
        return INSTANCE.decodeNoWrap(str);
    }

    @JvmStatic
    public static final byte[] encode(byte[] bArr, Base64Flags... base64FlagsArr) {
        return INSTANCE.encode(bArr, base64FlagsArr);
    }

    @JvmStatic
    public static final String encodeToString(byte[] bArr, Base64Flags... base64FlagsArr) {
        return INSTANCE.encodeToString(bArr, base64FlagsArr);
    }

    @JvmStatic
    public static final String encodeToStringNoWrap(byte[] bArr) {
        return INSTANCE.encodeToStringNoWrap(bArr);
    }

    @JvmStatic
    public static final String encodeUrlSafeString(String str) {
        return INSTANCE.encodeUrlSafeString(str);
    }

    @JvmStatic
    public static final String encodeUrlSafeString(byte[] bArr) {
        return INSTANCE.encodeUrlSafeString(bArr);
    }

    /* JADX INFO: compiled from: Base64Util.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J)\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0014J1\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J)\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J)\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0006\u0010\u001d\u001a\u00020\fJ\n\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\fH\u0002J\n\u0010!\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/microsoft/identity/common/java/base64/Base64Util$Companion;", "", "()V", "ANDROID_BASE64_CLASS_PATH", "", "BROKER4J_UNIT_TEST_BASE64_CLASS_PATH", "COMMON4J_UNIT_TEST_BASE64_CLASS_PATH", "LINUX_BASE64_CLASS_PATH", "TAG", "kotlin.jvm.PlatformType", "TESTUTILS_BASE64_CLASS_PATH", "base64", "Lcom/microsoft/identity/common/java/base64/IBase64;", "decode", "", "input", "flags", "", "Lcom/microsoft/identity/common/java/base64/Base64Flags;", "([B[Lcom/microsoft/identity/common/java/base64/Base64Flags;)[B", "(Ljava/lang/String;[Lcom/microsoft/identity/common/java/base64/Base64Flags;)[B", "failureMessage", "(Ljava/lang/String;Ljava/lang/String;[Lcom/microsoft/identity/common/java/base64/Base64Flags;)[B", "decodeNoWrap", "encode", "encodeToString", "([B[Lcom/microsoft/identity/common/java/base64/Base64Flags;)Ljava/lang/String;", "encodeToStringNoWrap", "encodeUrlSafeString", "initialize", "tryLoadAndroidBase64", "tryLoadMseberaBase64InBroker4jUnitTest", "tryLoadMseberaBase64InCommon4jUnitTest", "tryLoadMseberaBase64InLinux", "tryLoadMseberaBase64InTestUtils", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IBase64 initialize() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            IBase64 iBase64TryLoadAndroidBase64 = tryLoadAndroidBase64();
            if (iBase64TryLoadAndroidBase64 != null) {
                return iBase64TryLoadAndroidBase64;
            }
            IBase64 iBase64TryLoadMseberaBase64InLinux = tryLoadMseberaBase64InLinux();
            if (iBase64TryLoadMseberaBase64InLinux != null) {
                return iBase64TryLoadMseberaBase64InLinux;
            }
            IBase64 iBase64TryLoadMseberaBase64InCommon4jUnitTest = tryLoadMseberaBase64InCommon4jUnitTest();
            if (iBase64TryLoadMseberaBase64InCommon4jUnitTest != null) {
                return iBase64TryLoadMseberaBase64InCommon4jUnitTest;
            }
            IBase64 iBase64TryLoadMseberaBase64InBroker4jUnitTest = tryLoadMseberaBase64InBroker4jUnitTest();
            if (iBase64TryLoadMseberaBase64InBroker4jUnitTest != null) {
                return iBase64TryLoadMseberaBase64InBroker4jUnitTest;
            }
            IBase64 iBase64TryLoadMseberaBase64InTestUtils = tryLoadMseberaBase64InTestUtils();
            if (iBase64TryLoadMseberaBase64InTestUtils != null) {
                return iBase64TryLoadMseberaBase64InTestUtils;
            }
            throw new IllegalStateException("Cannot find a Base64 implementation to initialize.");
        }

        private final IBase64 tryLoadAndroidBase64() {
            try {
                Object objNewInstance = Class.forName(Base64Util.ANDROID_BASE64_CLASS_PATH).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.microsoft.identity.common.java.base64.IBase64");
                IBase64 iBase64 = (IBase64) objNewInstance;
                iBase64.encode(new byte[0], Base64Flags.DEFAULT);
                return iBase64;
            } catch (ClassNotFoundException | RuntimeException unused) {
                return null;
            }
        }

        private final IBase64 tryLoadMseberaBase64InLinux() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            try {
                Object objNewInstance = Class.forName(Base64Util.LINUX_BASE64_CLASS_PATH).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.microsoft.identity.common.java.base64.IBase64");
                return (IBase64) objNewInstance;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        private final IBase64 tryLoadMseberaBase64InCommon4jUnitTest() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            try {
                Object objNewInstance = Class.forName(Base64Util.COMMON4J_UNIT_TEST_BASE64_CLASS_PATH).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.microsoft.identity.common.java.base64.IBase64");
                return (IBase64) objNewInstance;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        private final IBase64 tryLoadMseberaBase64InBroker4jUnitTest() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            try {
                Object objNewInstance = Class.forName(Base64Util.BROKER4J_UNIT_TEST_BASE64_CLASS_PATH).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.microsoft.identity.common.java.base64.IBase64");
                return (IBase64) objNewInstance;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        private final IBase64 tryLoadMseberaBase64InTestUtils() throws IllegalAccessException, InstantiationException, InvocationTargetException {
            try {
                Object objNewInstance = Class.forName(Base64Util.TESTUTILS_BASE64_CLASS_PATH).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.microsoft.identity.common.java.base64.IBase64");
                return (IBase64) objNewInstance;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        @JvmStatic
        public final byte[] encode(byte[] input, Base64Flags... flags) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(flags, "flags");
            return Base64Util.base64.encode(input, (Base64Flags[]) Arrays.copyOf(flags, flags.length));
        }

        @JvmStatic
        public final String encodeToString(byte[] input, Base64Flags... flags) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(flags, "flags");
            byte[] bArrEncode = encode(input, (Base64Flags[]) Arrays.copyOf(flags, flags.length));
            Charset US_ASCII = StandardCharsets.US_ASCII;
            Intrinsics.checkNotNullExpressionValue(US_ASCII, "US_ASCII");
            return new String(bArrEncode, US_ASCII);
        }

        @JvmStatic
        public final String encodeToStringNoWrap(byte[] input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return encodeToString(input, Base64Flags.NO_WRAP);
        }

        @JvmStatic
        public final String encodeUrlSafeString(byte[] input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return encodeToString(input, Base64Flags.NO_WRAP, Base64Flags.NO_PADDING, Base64Flags.URL_SAFE);
        }

        @JvmStatic
        public final String encodeUrlSafeString(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            byte[] byteArray = StringUtil.toByteArray(input);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(input)");
            return encodeUrlSafeString(byteArray);
        }

        @JvmStatic
        public final byte[] decode(byte[] input, Base64Flags... flags) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(flags, "flags");
            return Base64Util.base64.decode(input, (Base64Flags[]) Arrays.copyOf(flags, flags.length));
        }

        @JvmStatic
        public final byte[] decode(String input, Base64Flags... flags) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(flags, "flags");
            IBase64 iBase64 = Base64Util.base64;
            byte[] bytes = input.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return iBase64.decode(bytes, (Base64Flags[]) Arrays.copyOf(flags, flags.length));
        }

        @JvmStatic
        public final byte[] decodeNoWrap(String input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return decode(input, Base64Flags.NO_WRAP);
        }

        @JvmStatic
        public final byte[] decode(String failureMessage, String input, Base64Flags... flags) {
            Intrinsics.checkNotNullParameter(failureMessage, "failureMessage");
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(flags, "flags");
            String str = Base64Util.TAG + ":decode";
            try {
                return decode(input, (Base64Flags[]) Arrays.copyOf(flags, flags.length));
            } catch (IllegalArgumentException e) {
                Logger.error(str, failureMessage + ' ' + e.getMessage(), null);
                throw e;
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TAG = "Base64Util";
        base64 = companion.initialize();
    }
}
