package external.sdk.pendo.io.okhttp3.internal.publicsuffix;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import sdk.pendo.io.f2.b;
import sdk.pendo.io.n2.h;
import sdk.pendo.io.s2.f;
import sdk.pendo.io.s2.l;
import sdk.pendo.io.s2.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0005\u001a\u00020\bH\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0018"}, d2 = {"Lexternal/sdk/pendo/io/okhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "", "domain", "", "b", "domainLabels", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "", "[B", "publicSuffixListBytes", "d", "publicSuffixExceptionListBytes", "<init>", "()V", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] f = {CtapException.ERR_NO_OPERATION_PENDING};
    private static final List<String> g = CollectionsKt.listOf("*");
    private static final PublicSuffixDatabase h = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final AtomicBoolean listRead = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private byte[] publicSuffixListBytes;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private byte[] publicSuffixExceptionListBytes;

    /* JADX INFO: renamed from: external.sdk.pendo.io.okhttp3.internal.publicsuffix.PublicSuffixDatabase$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\b\u001a\u00020\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lexternal/sdk/pendo/io/okhttp3/internal/publicsuffix/PublicSuffixDatabase$a;", "", "", "", "labels", "", "labelIndex", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "([B[[BI)Ljava/lang/String;", "Lexternal/sdk/pendo/io/okhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "EXCEPTION_MARKER", "C", "", "PREVAILING_RULE", "Ljava/util/List;", "PUBLIC_SUFFIX_RESOURCE", "Ljava/lang/String;", "WILDCARD_LABEL", "[B", "instance", "Lexternal/sdk/pendo/io/okhttp3/internal/publicsuffix/PublicSuffixDatabase;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String a(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int iA;
            boolean z;
            int iA2;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != 10) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        iA = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        iA = b.a(bArr2[i8][i9], 255);
                        z = z3;
                    }
                    iA2 = iA - b.a(bArr[i5 + i10], 255);
                    if (iA2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length != i9) {
                        z2 = z;
                    } else {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    }
                }
                if (iA2 >= 0) {
                    if (iA2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                return new String(bArr, i5, i7, UTF_8);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i4;
            }
            return null;
        }

        public final PublicSuffixDatabase a() {
            return PublicSuffixDatabase.h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, byte[]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, byte[]] */
    private final void b() {
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(okhttp3.internal.publicsuffix.PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
            if (resourceAsStream != null) {
                f fVarA = o.a(new l(o.a(resourceAsStream)));
                try {
                    objectRef.element = fVarA.readByteArray(fVarA.readInt());
                    objectRef2.element = fVarA.readByteArray(fVarA.readInt());
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fVarA, null);
                    synchronized (this) {
                        T t = objectRef.element;
                        Intrinsics.checkNotNull(t);
                        this.publicSuffixListBytes = (byte[]) t;
                        T t2 = objectRef2.element;
                        Intrinsics.checkNotNull(t2);
                        this.publicSuffixExceptionListBytes = (byte[]) t2;
                        Unit unit2 = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fVarA, th);
                        throw th2;
                    }
                }
            }
            this.readCompleteLatch.countDown();
        } catch (Throwable th3) {
            this.readCompleteLatch.countDown();
            throw th3;
        }
    }

    private final void c() {
        boolean z = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    h.INSTANCE.d().a("Failed to read public suffix list", 5, e);
                    if (!z) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    private final List<String> a(List<String> domainLabels) {
        String str;
        String strA;
        String str2;
        List<String> listEmptyList;
        List<String> listEmptyList2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            c();
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = domainLabels.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            String str3 = domainLabels.get(i);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str3.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                strA = null;
                break;
            }
            Companion companion = INSTANCE;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                bArr2 = null;
            }
            strA = companion.a(bArr2, bArr, i2);
            if (strA != null) {
                break;
            }
            i2++;
        }
        if (size <= 1) {
            str2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                str2 = null;
                break;
            }
            bArr3[i3] = f;
            Companion companion2 = INSTANCE;
            byte[] bArr4 = this.publicSuffixListBytes;
            if (bArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                bArr4 = null;
            }
            String strA2 = companion2.a(bArr4, bArr3, i3);
            if (strA2 != null) {
                str2 = strA2;
                break;
            }
            i3++;
        }
        if (str2 != null) {
            int i4 = size - 1;
            for (int i5 = 0; i5 < i4; i5++) {
                Companion companion3 = INSTANCE;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                String strA3 = companion3.a(bArr5, bArr, i5);
                if (strA3 != null) {
                    str = strA3;
                    break;
                }
            }
        }
        if (str != null) {
            return StringsKt.split$default((CharSequence) ("!" + str), new char[]{'.'}, false, 0, 6, (Object) null);
        }
        if (strA == null && str2 == null) {
            return g;
        }
        if (strA == null || (listEmptyList = StringsKt.split$default((CharSequence) strA, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (str2 == null || (listEmptyList2 = StringsKt.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return listEmptyList.size() > listEmptyList2.size() ? listEmptyList : listEmptyList2;
    }

    private final List<String> b(String domain) {
        List<String> listSplit$default = StringsKt.split$default((CharSequence) domain, new char[]{'.'}, false, 0, 6, (Object) null);
        return Intrinsics.areEqual(CollectionsKt.last((List) listSplit$default), "") ? CollectionsKt.dropLast(listSplit$default, 1) : listSplit$default;
    }

    public final String a(String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List<String> listB = b(unicodeDomain);
        List<String> listA = a(listB);
        if (listB.size() == listA.size() && listA.get(0).charAt(0) != '!') {
            return null;
        }
        char cCharAt = listA.get(0).charAt(0);
        int size = listB.size();
        int size2 = listA.size();
        if (cCharAt != '!') {
            size2++;
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(b(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }
}
