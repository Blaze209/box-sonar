package com.microsoft.identity.common.crypto;

import android.content.Context;
import android.os.Build;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.flighting.IFlightsProvider;
import com.microsoft.identity.common.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: CryptoParameterSpecFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0002J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001fJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001fR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\f¨\u0006%"}, d2 = {"Lcom/microsoft/identity/common/crypto/CryptoParameterSpecFactory;", "", "context", "Landroid/content/Context;", "keyAlias", "", "flightsProvider", "Lcom/microsoft/identity/common/java/flighting/IFlightsProvider;", "(Landroid/content/Context;Ljava/lang/String;Lcom/microsoft/identity/common/java/flighting/IFlightsProvider;)V", "enableKeyGenEncryptionPaddingRsaOaep", "", "getEnableKeyGenEncryptionPaddingRsaOaep", "()Z", "getFlightsProvider", "()Lcom/microsoft/identity/common/java/flighting/IFlightsProvider;", "keyGenParamSpecLegacy", "Lcom/microsoft/identity/common/crypto/LegacyKeyGenSpec;", "keyGenParamSpecWithPurposeWrapKey", "Lcom/microsoft/identity/common/crypto/KeyGenSpec;", "getKeyGenParamSpecWithPurposeWrapKey", "()Lcom/microsoft/identity/common/crypto/KeyGenSpec;", "keyGenParamSpecWithPurposeWrapKey$delegate", "Lkotlin/Lazy;", "keyGenParamSpecWithoutPurposeWrapKey", "getKeyGenParamSpecWithoutPurposeWrapKey", "keyGenParamSpecWithoutPurposeWrapKey$delegate", "keySpecWithWrapPurposeKey", "getKeySpecWithWrapPurposeKey", "keySpecWithoutWrapPurposeKey", "getKeySpecWithoutWrapPurposeKey", "getEncryptionPaddingsForKeyGen", "", "getPrioritizedCipherParameterSpecs", "Lcom/microsoft/identity/common/crypto/CipherSpec;", "getPrioritizedKeyGenParameterSpecs", "Lcom/microsoft/identity/common/crypto/IKeyGenSpec;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CryptoParameterSpecFactory {

    @Deprecated
    private static final int KEY_SIZE = 2048;

    @Deprecated
    private static final String LEGACY_SPEC = "legacy_key_gen_spec";

    @Deprecated
    private static final String MODERN_SPEC_WITHOUT_PURPOSE_WRAP_KEY = "modern_spec_without_wrap_key";

    @Deprecated
    private static final String MODERN_SPEC_WITH_PURPOSE_WRAP_KEY = "modern_spec_with_wrap_key";

    @Deprecated
    private static final String RSA_ALGORITHM = "RSA";
    private final IFlightsProvider flightsProvider;
    private final LegacyKeyGenSpec keyGenParamSpecLegacy;

    /* JADX INFO: renamed from: keyGenParamSpecWithPurposeWrapKey$delegate, reason: from kotlin metadata */
    private final Lazy keyGenParamSpecWithPurposeWrapKey;

    /* JADX INFO: renamed from: keyGenParamSpecWithoutPurposeWrapKey$delegate, reason: from kotlin metadata */
    private final Lazy keyGenParamSpecWithoutPurposeWrapKey;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final String TAG = "CryptoParameterSpecFactory";

    public CryptoParameterSpecFactory(Context context, final String keyAlias, IFlightsProvider flightsProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(flightsProvider, "flightsProvider");
        this.flightsProvider = flightsProvider;
        Logger.verbose(TAG + ":init", "Initialized CryptoParameterSpecFactory - API: " + Build.VERSION.SDK_INT + ", flags: [keySpecWithWrapPurposeKey=" + getKeySpecWithWrapPurposeKey() + ", keySpecWithoutWrapPurposeKey=" + getKeySpecWithoutWrapPurposeKey() + ", oaepSupported=" + getEnableKeyGenEncryptionPaddingRsaOaep() + AbstractJsonLexerKt.END_LIST);
        this.keyGenParamSpecWithPurposeWrapKey = LazyKt.lazy(new Function0<KeyGenSpec>() { // from class: com.microsoft.identity.common.crypto.CryptoParameterSpecFactory$keyGenParamSpecWithPurposeWrapKey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final KeyGenSpec invoke() {
                return new KeyGenSpec(35, CollectionsKt.listOf((Object[]) new String[]{"SHA-256", MessageDigestAlgorithms.SHA_512}), keyAlias, 2048, "modern_spec_with_wrap_key", "RSA", this.this$0.getEncryptionPaddingsForKeyGen());
            }
        });
        this.keyGenParamSpecWithoutPurposeWrapKey = LazyKt.lazy(new Function0<KeyGenSpec>() { // from class: com.microsoft.identity.common.crypto.CryptoParameterSpecFactory$keyGenParamSpecWithoutPurposeWrapKey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final KeyGenSpec invoke() {
                return new KeyGenSpec(3, CollectionsKt.listOf((Object[]) new String[]{"SHA-256", MessageDigestAlgorithms.SHA_512}), keyAlias, 2048, "modern_spec_without_wrap_key", "RSA", this.this$0.getEncryptionPaddingsForKeyGen());
            }
        });
        this.keyGenParamSpecLegacy = new LegacyKeyGenSpec(context, keyAlias, 2048, LEGACY_SPEC, "RSA", CollectionsKt.listOf("PKCS1Padding"));
    }

    public /* synthetic */ CryptoParameterSpecFactory(Context context, String str, IFlightsProvider iFlightsProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? CommonFlightsManager.INSTANCE.getFlightsProvider() : iFlightsProvider);
    }

    public final IFlightsProvider getFlightsProvider() {
        return this.flightsProvider;
    }

    /* JADX INFO: compiled from: CryptoParameterSpecFactory.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/crypto/CryptoParameterSpecFactory$Companion;", "", "()V", "KEY_SIZE", "", "LEGACY_SPEC", "", "MODERN_SPEC_WITHOUT_PURPOSE_WRAP_KEY", "MODERN_SPEC_WITH_PURPOSE_WRAP_KEY", "RSA_ALGORITHM", "TAG", "kotlin.jvm.PlatformType", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean getKeySpecWithWrapPurposeKey() {
        return this.flightsProvider.isFlightEnabled(CommonFlight.ENABLE_NEW_KEY_GEN_SPEC_FOR_WRAP_WITH_PURPOSE_WRAP_KEY);
    }

    private final boolean getKeySpecWithoutWrapPurposeKey() {
        return this.flightsProvider.isFlightEnabled(CommonFlight.ENABLE_NEW_KEY_GEN_SPEC_FOR_WRAP_WITHOUT_PURPOSE_WRAP_KEY);
    }

    private final boolean getEnableKeyGenEncryptionPaddingRsaOaep() {
        return this.flightsProvider.isFlightEnabled(CommonFlight.ENABLE_OAEP_WITH_SHA_AND_MGF1_PADDING);
    }

    private final KeyGenSpec getKeyGenParamSpecWithPurposeWrapKey() {
        return (KeyGenSpec) this.keyGenParamSpecWithPurposeWrapKey.getValue();
    }

    private final KeyGenSpec getKeyGenParamSpecWithoutPurposeWrapKey() {
        return (KeyGenSpec) this.keyGenParamSpecWithoutPurposeWrapKey.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getEncryptionPaddingsForKeyGen() {
        List<String> listMutableListOf = CollectionsKt.mutableListOf("PKCS1Padding");
        if (getEnableKeyGenEncryptionPaddingRsaOaep()) {
            listMutableListOf.add("OAEPPadding");
        }
        return listMutableListOf;
    }

    public final List<CipherSpec> getPrioritizedCipherParameterSpecs() {
        String str = TAG + ":getPrioritizedCipherParameterSpecs";
        List<CipherSpec> listListOf = CollectionsKt.listOf((Object[]) new CipherSpec[]{CipherSpec.INSTANCE.getOaepCipherSpec(), CipherSpec.INSTANCE.getPkcs1CipherSpec()});
        Logger.info(str, "Ciphers: " + listListOf);
        return listListOf;
    }

    public final List<IKeyGenSpec> getPrioritizedKeyGenParameterSpecs() {
        String str = TAG + ":getPrioritizedKeyGenParameterSpecs";
        ArrayList arrayList = new ArrayList();
        if (getKeySpecWithWrapPurposeKey()) {
            arrayList.add(getKeyGenParamSpecWithPurposeWrapKey());
        }
        if (getKeySpecWithoutWrapPurposeKey()) {
            arrayList.add(getKeyGenParamSpecWithoutPurposeWrapKey());
        }
        arrayList.add(this.keyGenParamSpecLegacy);
        Logger.info(str, "Key generation specs: " + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<IKeyGenSpec, CharSequence>() { // from class: com.microsoft.identity.common.crypto.CryptoParameterSpecFactory.getPrioritizedKeyGenParameterSpecs.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(IKeyGenSpec it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getDescription();
            }
        }, 31, null));
        return arrayList;
    }
}
