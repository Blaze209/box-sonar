package com.microsoft.identity.common.java.platform;

import com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import java.net.URL;

/* JADX INFO: loaded from: classes14.dex */
public class DevicePoPUtils {
    private DevicePoPUtils() {
    }

    public static synchronized GenerateShrResult generateSignedHttpRequest(IPlatformComponents iPlatformComponents, IPoPAuthenticationSchemeParams iPoPAuthenticationSchemeParams) throws ClientException {
        GenerateShrResult generateShrResult;
        try {
            if (iPlatformComponents == null) {
                throw new NullPointerException("platformComponents is marked non-null but is null");
            }
            if (iPoPAuthenticationSchemeParams == null) {
                throw new NullPointerException("popSchemeParams is marked non-null but is null");
            }
            long time = iPlatformComponents.getClockSkewManager().getAdjustedReferenceTime().getTime();
            String httpMethod = iPoPAuthenticationSchemeParams.getHttpMethod();
            URL url = iPoPAuthenticationSchemeParams.getUrl();
            String nonce = iPoPAuthenticationSchemeParams.getNonce();
            String clientClaims = iPoPAuthenticationSchemeParams.getClientClaims();
            IDevicePopManager defaultDevicePopManager = iPlatformComponents.getDefaultDevicePopManager();
            if (!defaultDevicePopManager.asymmetricKeyExists()) {
                defaultDevicePopManager.generateAsymmetricKey();
            }
            String strMintSignedHttpRequest = defaultDevicePopManager.mintSignedHttpRequest(httpMethod, time / 1000, url, nonce, clientClaims);
            generateShrResult = new GenerateShrResult();
            generateShrResult.setShr(strMintSignedHttpRequest);
        } catch (Throwable th) {
            throw th;
        }
        return generateShrResult;
    }
}
