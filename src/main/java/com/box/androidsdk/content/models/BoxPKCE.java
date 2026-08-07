package com.box.androidsdk.content.models;

import android.util.Base64;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BoxPKCE.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/androidsdk/content/models/BoxPKCE;", "", "codeVerifier", "", BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCodeVerifier", "()Ljava/lang/String;", "getCodeChallenge", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BoxPKCE {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String codeChallenge;
    private final String codeVerifier;

    public static /* synthetic */ BoxPKCE copy$default(BoxPKCE boxPKCE, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = boxPKCE.codeVerifier;
        }
        if ((i & 2) != 0) {
            str2 = boxPKCE.codeChallenge;
        }
        return boxPKCE.copy(str, str2);
    }

    @JvmStatic
    public static final BoxPKCE generate() {
        return INSTANCE.generate();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    public final BoxPKCE copy(String codeVerifier, String codeChallenge) {
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
        return new BoxPKCE(codeVerifier, codeChallenge);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxPKCE)) {
            return false;
        }
        BoxPKCE boxPKCE = (BoxPKCE) other;
        return Intrinsics.areEqual(this.codeVerifier, boxPKCE.codeVerifier) && Intrinsics.areEqual(this.codeChallenge, boxPKCE.codeChallenge);
    }

    public int hashCode() {
        return (this.codeVerifier.hashCode() * 31) + this.codeChallenge.hashCode();
    }

    public String toString() {
        return "BoxPKCE(codeVerifier=" + this.codeVerifier + ", codeChallenge=" + this.codeChallenge + ")";
    }

    /* JADX INFO: compiled from: BoxPKCE.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/box/androidsdk/content/models/BoxPKCE$Companion;", "", "<init>", "()V", "generate", "Lcom/box/androidsdk/content/models/BoxPKCE;", "generateCodeVerifier", "", "generateCodeChallenge", "verifier", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BoxPKCE generate() {
            String strGenerateCodeVerifier = generateCodeVerifier();
            return new BoxPKCE(strGenerateCodeVerifier, generateCodeChallenge(strGenerateCodeVerifier));
        }

        private final String generateCodeVerifier() {
            byte[] bArr = new byte[32];
            new SecureRandom().nextBytes(bArr);
            String strEncodeToString = Base64.encodeToString(bArr, 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }

        private final String generateCodeChallenge(String verifier) throws NoSuchAlgorithmException {
            byte[] bytes = verifier.getBytes(Charsets.US_ASCII);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
            String strEncodeToString = Base64.encodeToString(bArrDigest, 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }
    }

    public BoxPKCE(String codeVerifier, String codeChallenge) {
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
        this.codeVerifier = codeVerifier;
        this.codeChallenge = codeChallenge;
    }

    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }
}
