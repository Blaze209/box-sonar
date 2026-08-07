package com.microsoft.identity.common.java.authscheme;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class AuthenticationSchemeFactory {
    private static final String TAG = "AuthenticationSchemeFactory";

    public static AbstractAuthenticationScheme createScheme(IPlatformComponents iPlatformComponents, INameable iNameable) throws ClientException {
        if (iPlatformComponents == null) {
            throw new NullPointerException("commonComponents is marked non-null but is null");
        }
        String str = TAG + ":createScheme";
        if (iNameable == null) {
            return new BearerAuthenticationSchemeInternal();
        }
        String name = iNameable.getName();
        name.hashCode();
        switch (name) {
            case "PoP_With_Client_Key":
                if (iNameable instanceof IPoPAuthenticationSchemeParams) {
                    Logger.verbose(str, "Constructing PoP Authentication Scheme With Client Key.");
                    return (PopAuthenticationSchemeWithClientKeyInternal) iNameable;
                }
                throw new IllegalStateException("Unrecognized parameter type.");
            case "PoP":
                if (iNameable instanceof IPoPAuthenticationSchemeParams) {
                    Logger.verbose(str, "Constructing PoP Authentication Scheme.");
                    IPoPAuthenticationSchemeParams iPoPAuthenticationSchemeParams = (IPoPAuthenticationSchemeParams) iNameable;
                    return new PopAuthenticationSchemeInternal(iPlatformComponents.getClockSkewManager(), iPlatformComponents.getDefaultDevicePopManager(), iPoPAuthenticationSchemeParams.getHttpMethod(), iPoPAuthenticationSchemeParams.getUrl(), iPoPAuthenticationSchemeParams.getNonce(), iPoPAuthenticationSchemeParams.getClientClaims());
                }
                throw new IllegalStateException("Unrecognized parameter type.");
            case "Bearer":
                Logger.verbose(str, "Constructing Bearer Authentication Scheme.");
                return new BearerAuthenticationSchemeInternal();
            default:
                throw new UnsupportedOperationException("Unknown or unsupported scheme: " + iNameable.getName());
        }
    }

    public static boolean isPopAuthenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authenticationScheme is marked non-null but is null");
        }
        return abstractAuthenticationScheme instanceof IPoPAuthenticationSchemeParams;
    }
}
