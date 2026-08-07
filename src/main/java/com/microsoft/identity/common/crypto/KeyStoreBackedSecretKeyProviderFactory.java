package com.microsoft.identity.common.crypto;

import android.content.Context;
import com.box.android.common.utilities.BoxCommonConstants;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyStoreBackedSecretKeyProviderFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/crypto/KeyStoreBackedSecretKeyProviderFactory;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/microsoft/identity/common/java/crypto/key/ISecretKeyProvider;", "keyIdentifier", "", BoxCommonConstants.EXTRA_FILE_NAME, "context", "Landroid/content/Context;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyStoreBackedSecretKeyProviderFactory {
    public static final KeyStoreBackedSecretKeyProviderFactory INSTANCE = new KeyStoreBackedSecretKeyProviderFactory();

    private KeyStoreBackedSecretKeyProviderFactory() {
    }

    public final ISecretKeyProvider create(String keyIdentifier, String fileName, Context context) {
        Intrinsics.checkNotNullParameter(keyIdentifier, "keyIdentifier");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(context, "context");
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_KEYSTORE_BACKED_SECRET_KEY_PROVIDER)) {
            return new KeyStoreBackedSecretKeyProvider(context, keyIdentifier, fileName);
        }
        return new AndroidWrappedKeyProvider(keyIdentifier, fileName, context);
    }
}
