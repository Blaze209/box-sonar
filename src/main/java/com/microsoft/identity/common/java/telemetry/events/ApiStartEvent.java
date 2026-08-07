package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.BrokerSilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class ApiStartEvent extends BaseEvent {
    private static final String TAG = "ApiStartEvent";

    public ApiStartEvent() {
        names(TelemetryEventStrings.Event.API_START_EVENT);
        types(TelemetryEventStrings.EventType.API_EVENT);
    }

    public ApiStartEvent(String str) {
        if (str == null) {
            throw new NullPointerException("apiId is marked non-null but is null");
        }
        names(TelemetryEventStrings.Event.API_START_EVENT);
        types(TelemetryEventStrings.EventType.API_EVENT);
        putApiId(str);
    }

    @Override // com.microsoft.identity.common.java.telemetry.events.BaseEvent, com.microsoft.identity.common.java.telemetry.Properties
    public ApiStartEvent put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("propertyName is marked non-null but is null");
        }
        super.put(str, str2);
        return this;
    }

    public ApiStartEvent putBrokerVersion(String str) {
        put(TelemetryEventStrings.Key.BROKER_VERSION, str);
        return this;
    }

    public ApiStartEvent putProperties(@Nullable CommandParameters commandParameters) {
        if (commandParameters != null) {
            if (commandParameters.getSdkType() != null) {
                put(TelemetryEventStrings.Key.SDK_NAME, commandParameters.getSdkType().name());
            }
            put(TelemetryEventStrings.Key.SDK_VERSION, commandParameters.getSdkVersion());
            put(TelemetryEventStrings.Key.REDIRECT_URI, commandParameters.getRedirectUri());
            put(TelemetryEventStrings.Key.CLIENT_ID, commandParameters.getClientId());
            put(TelemetryEventStrings.Key.BROKER_PROTOCOL_VERSION, String.valueOf(commandParameters.getRequiredBrokerProtocolVersion()));
            if (commandParameters instanceof TokenCommandParameters) {
                TokenCommandParameters tokenCommandParameters = (TokenCommandParameters) commandParameters;
                Authority authority = tokenCommandParameters.getAuthority();
                if (authority != null) {
                    if (authority.getAuthorityURL() != null) {
                        put(TelemetryEventStrings.Key.AUTHORITY, authority.getAuthorityURL().getAuthority());
                    }
                    put(TelemetryEventStrings.Key.AUTHORITY_TYPE, authority.getAuthorityTypeString());
                }
                put(TelemetryEventStrings.Key.CLAIM_REQUEST, StringUtil.isNullOrEmpty(tokenCommandParameters.getClaimsRequestJson()) ? "false" : TelemetryEventStrings.Value.TRUE);
                if (tokenCommandParameters.getScopes() != null) {
                    put(TelemetryEventStrings.Key.SCOPE_SIZE, String.valueOf(tokenCommandParameters.getScopes().size()));
                    put(TelemetryEventStrings.Key.SCOPE, tokenCommandParameters.getScopes().toString());
                }
                AbstractAuthenticationScheme authenticationScheme = tokenCommandParameters.getAuthenticationScheme();
                if (authenticationScheme != null) {
                    put(TelemetryEventStrings.Key.AUTHENTICATION_SCHEME, authenticationScheme.getName());
                }
            }
            if (commandParameters instanceof InteractiveTokenCommandParameters) {
                InteractiveTokenCommandParameters interactiveTokenCommandParameters = (InteractiveTokenCommandParameters) commandParameters;
                if (interactiveTokenCommandParameters.getAuthorizationAgent() != null) {
                    put(TelemetryEventStrings.Key.USER_AGENT, interactiveTokenCommandParameters.getAuthorizationAgent().name());
                }
                put(TelemetryEventStrings.Key.LOGIN_HINT, interactiveTokenCommandParameters.getLoginHint());
                if (interactiveTokenCommandParameters.getExtraQueryStringParameters() != null) {
                    put(TelemetryEventStrings.Key.REQUEST_QUERY_PARAMS, String.valueOf(interactiveTokenCommandParameters.getExtraQueryStringParameters().size()));
                }
                if (interactiveTokenCommandParameters.getPrompt() != null) {
                    put(TelemetryEventStrings.Key.PROMPT_BEHAVIOR, interactiveTokenCommandParameters.getPrompt().toString());
                }
            }
            if (commandParameters instanceof SilentTokenCommandParameters) {
                SilentTokenCommandParameters silentTokenCommandParameters = (SilentTokenCommandParameters) commandParameters;
                if (silentTokenCommandParameters.getAccount() != null) {
                    put(TelemetryEventStrings.Key.USER_ID, silentTokenCommandParameters.getAccount().getHomeAccountId());
                }
                put("Microsoft.MSAL.force_refresh", String.valueOf(silentTokenCommandParameters.isForceRefresh()));
            }
            if (commandParameters instanceof BrokerInteractiveTokenCommandParameters) {
                BrokerInteractiveTokenCommandParameters brokerInteractiveTokenCommandParameters = (BrokerInteractiveTokenCommandParameters) commandParameters;
                put(TelemetryEventStrings.Key.BROKER_PROTOCOL_VERSION, brokerInteractiveTokenCommandParameters.getNegotiatedBrokerProtocolVersion());
                put(TelemetryEventStrings.Key.CALLER_APP_VERSION, brokerInteractiveTokenCommandParameters.getCallerAppVersion());
                put(TelemetryEventStrings.Key.CALLER_APP_PACKAGE_NAME, brokerInteractiveTokenCommandParameters.getCallerPackageName());
                put(TelemetryEventStrings.Key.CALLER_APP_UUID, String.valueOf(brokerInteractiveTokenCommandParameters.getCallerUid()));
            }
            if (commandParameters instanceof BrokerSilentTokenCommandParameters) {
                BrokerSilentTokenCommandParameters brokerSilentTokenCommandParameters = (BrokerSilentTokenCommandParameters) commandParameters;
                put(TelemetryEventStrings.Key.BROKER_PROTOCOL_VERSION, brokerSilentTokenCommandParameters.getNegotiatedBrokerProtocolVersion());
                put(TelemetryEventStrings.Key.CALLER_APP_VERSION, brokerSilentTokenCommandParameters.getCallerAppVersion());
                put(TelemetryEventStrings.Key.CALLER_APP_PACKAGE_NAME, brokerSilentTokenCommandParameters.getCallerPackageName());
                put(TelemetryEventStrings.Key.CALLER_APP_UUID, String.valueOf(brokerSilentTokenCommandParameters.getCallerUid()));
            }
        }
        return this;
    }

    public ApiStartEvent authority(String str) {
        if (str == null) {
            throw new NullPointerException("authority is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.AUTHORITY, sanitizeUrlForTelemetry(str));
        return this;
    }

    public ApiStartEvent putAuthorityType(String str) {
        if (str == null) {
            throw new NullPointerException("authorityType is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.AUTHORITY_TYPE, str);
        return this;
    }

    public ApiStartEvent putApiId(String str) {
        if (str == null) {
            throw new NullPointerException("apiId is marked non-null but is null");
        }
        put("Microsoft.MSAL.api_id", str);
        return this;
    }

    public ApiStartEvent putValidationStatus(String str) {
        if (str == null) {
            throw new NullPointerException("validationStatus is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.AUTHORITY_VALIDATION_STATUS, str);
        return this;
    }

    public ApiStartEvent putWorkPlaceJoined(boolean z) {
        put(TelemetryEventStrings.Key.IS_WPJ_JOINED, String.valueOf(z));
        return this;
    }

    public ApiStartEvent putLoginHint(String str) {
        if (str == null) {
            throw new NullPointerException("loginHint is marked non-null but is null");
        }
        String str2 = TAG + ":putLoginHint";
        try {
            put(TelemetryEventStrings.Key.LOGIN_HINT, StringUtil.createHash(str));
            return this;
        } catch (NoSuchAlgorithmException e) {
            Logger.warn(str2, e.getMessage());
            return this;
        }
    }

    public ApiStartEvent putExtendedExpiresOnSetting(String str) {
        if (str == null) {
            throw new NullPointerException("extendedExpiresOnSetting is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.EXTENDED_EXPIRES_ON_SETTING, str);
        return this;
    }

    private static String sanitizeUrlForTelemetry(String str) {
        URL url;
        if (str == null) {
            throw new NullPointerException("url is marked non-null but is null");
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            Logger.errorPII(TAG, "Url is invalid", e);
            url = null;
        }
        if (url == null) {
            return null;
        }
        return sanitizeUrlForTelemetry(url);
    }

    private static String sanitizeUrlForTelemetry(URL url) {
        if (url == null) {
            throw new NullPointerException("url is marked non-null but is null");
        }
        String authority = url.getAuthority();
        String[] strArrSplit = url.getPath().split("/");
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol()).append("://").append(authority).append('/');
        for (int i = 2; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            sb.append('/');
        }
        return sb.toString();
    }
}
