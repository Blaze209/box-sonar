package com.microsoft.identity.common.java.commands.parameters;

import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class CommandParameters {
    public static final String APPLICATION_IDENTIFIER_FORMAT = "%s/%s";

    @Expose
    private String applicationName;

    @Expose
    private String applicationVersion;

    @Expose
    private String callerPackageName;

    @Expose
    private String callerSignature;

    @Expose
    private String childClientId;

    @Expose
    private String childRedirectUri;

    @Expose
    private String clientId;

    @Expose
    private String correlationId;
    private transient Map<String, String> flightInformation;
    private transient boolean isSharedDevice;
    private transient OAuth2TokenCache oAuth2TokenCache;
    private transient IPlatformComponents platformComponents;

    @Expose
    private boolean powerOptCheckEnabled;

    @Expose
    private String redirectUri;

    @Expose
    private String requiredBrokerProtocolVersion;

    @Expose
    private SdkType sdkType;

    @Expose
    private String sdkVersion;

    @Expose
    private SerializableSpanContext spanContext;

    public static abstract class CommandParametersBuilder<C extends CommandParameters, B extends CommandParametersBuilder<C, B>> {
        private String applicationName;
        private String applicationVersion;
        private String callerPackageName;
        private String callerSignature;
        private String childClientId;
        private String childRedirectUri;
        private String clientId;
        private String correlationId;
        private boolean flightInformation$set;
        private Map<String, String> flightInformation$value;
        private boolean isSharedDevice;
        private OAuth2TokenCache oAuth2TokenCache;
        private IPlatformComponents platformComponents;
        private boolean powerOptCheckEnabled;
        private String redirectUri;
        private String requiredBrokerProtocolVersion;
        private SdkType sdkType;
        private String sdkVersion;
        private SerializableSpanContext spanContext;

        public abstract C build();

        protected abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(CommandParameters commandParameters, CommandParametersBuilder<?, ?> commandParametersBuilder) {
            commandParametersBuilder.platformComponents(commandParameters.platformComponents);
            commandParametersBuilder.oAuth2TokenCache(commandParameters.oAuth2TokenCache);
            commandParametersBuilder.isSharedDevice(commandParameters.isSharedDevice);
            commandParametersBuilder.applicationName(commandParameters.applicationName);
            commandParametersBuilder.applicationVersion(commandParameters.applicationVersion);
            commandParametersBuilder.requiredBrokerProtocolVersion(commandParameters.requiredBrokerProtocolVersion);
            commandParametersBuilder.sdkType(commandParameters.sdkType);
            commandParametersBuilder.sdkVersion(commandParameters.sdkVersion);
            commandParametersBuilder.clientId(commandParameters.clientId);
            commandParametersBuilder.redirectUri(commandParameters.redirectUri);
            commandParametersBuilder.childClientId(commandParameters.childClientId);
            commandParametersBuilder.childRedirectUri(commandParameters.childRedirectUri);
            commandParametersBuilder.powerOptCheckEnabled(commandParameters.powerOptCheckEnabled);
            commandParametersBuilder.callerPackageName(commandParameters.callerPackageName);
            commandParametersBuilder.callerSignature(commandParameters.callerSignature);
            commandParametersBuilder.flightInformation(commandParameters.flightInformation);
            commandParametersBuilder.correlationId(commandParameters.correlationId);
            commandParametersBuilder.spanContext(commandParameters.spanContext);
        }

        protected B $fillValuesFrom(C c) {
            $fillValuesFromInstanceIntoBuilder(c, this);
            return (B) self();
        }

        public B applicationName(String str) {
            this.applicationName = str;
            return (B) self();
        }

        public B applicationVersion(String str) {
            this.applicationVersion = str;
            return (B) self();
        }

        public B callerPackageName(String str) {
            this.callerPackageName = str;
            return (B) self();
        }

        public B callerSignature(String str) {
            this.callerSignature = str;
            return (B) self();
        }

        public B childClientId(String str) {
            this.childClientId = str;
            return (B) self();
        }

        public B childRedirectUri(String str) {
            this.childRedirectUri = str;
            return (B) self();
        }

        public B clientId(String str) {
            this.clientId = str;
            return (B) self();
        }

        public B correlationId(String str) {
            this.correlationId = str;
            return (B) self();
        }

        public B flightInformation(Map<String, String> map) {
            this.flightInformation$value = map;
            this.flightInformation$set = true;
            return (B) self();
        }

        public B isSharedDevice(boolean z) {
            this.isSharedDevice = z;
            return (B) self();
        }

        public B oAuth2TokenCache(OAuth2TokenCache oAuth2TokenCache) {
            this.oAuth2TokenCache = oAuth2TokenCache;
            return (B) self();
        }

        public B platformComponents(IPlatformComponents iPlatformComponents) {
            if (iPlatformComponents == null) {
                throw new NullPointerException("platformComponents is marked non-null but is null");
            }
            this.platformComponents = iPlatformComponents;
            return (B) self();
        }

        public B powerOptCheckEnabled(boolean z) {
            this.powerOptCheckEnabled = z;
            return (B) self();
        }

        public B redirectUri(String str) {
            this.redirectUri = str;
            return (B) self();
        }

        public B requiredBrokerProtocolVersion(String str) {
            this.requiredBrokerProtocolVersion = str;
            return (B) self();
        }

        public B sdkType(SdkType sdkType) {
            this.sdkType = sdkType;
            return (B) self();
        }

        public B sdkVersion(String str) {
            this.sdkVersion = str;
            return (B) self();
        }

        public B spanContext(SerializableSpanContext serializableSpanContext) {
            this.spanContext = serializableSpanContext;
            return (B) self();
        }

        public String toString() {
            return "CommandParameters.CommandParametersBuilder(platformComponents=" + this.platformComponents + ", oAuth2TokenCache=" + this.oAuth2TokenCache + ", isSharedDevice=" + this.isSharedDevice + ", applicationName=" + this.applicationName + ", applicationVersion=" + this.applicationVersion + ", requiredBrokerProtocolVersion=" + this.requiredBrokerProtocolVersion + ", sdkType=" + this.sdkType + ", sdkVersion=" + this.sdkVersion + ", clientId=" + this.clientId + ", redirectUri=" + this.redirectUri + ", childClientId=" + this.childClientId + ", childRedirectUri=" + this.childRedirectUri + ", powerOptCheckEnabled=" + this.powerOptCheckEnabled + ", callerPackageName=" + this.callerPackageName + ", callerSignature=" + this.callerSignature + ", flightInformation$value=" + this.flightInformation$value + ", correlationId=" + this.correlationId + ", spanContext=" + this.spanContext + ")";
        }
    }

    private static final class CommandParametersBuilderImpl extends CommandParametersBuilder<CommandParameters, CommandParametersBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public CommandParametersBuilderImpl self() {
            return this;
        }

        private CommandParametersBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.commands.parameters.CommandParameters.CommandParametersBuilder
        public CommandParameters build() {
            return new CommandParameters(this);
        }
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof CommandParameters;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommandParameters)) {
            return false;
        }
        CommandParameters commandParameters = (CommandParameters) obj;
        if (!commandParameters.canEqual(this) || isPowerOptCheckEnabled() != commandParameters.isPowerOptCheckEnabled()) {
            return false;
        }
        String applicationName = getApplicationName();
        String applicationName2 = commandParameters.getApplicationName();
        if (applicationName != null ? !applicationName.equals(applicationName2) : applicationName2 != null) {
            return false;
        }
        String applicationVersion = getApplicationVersion();
        String applicationVersion2 = commandParameters.getApplicationVersion();
        if (applicationVersion != null ? !applicationVersion.equals(applicationVersion2) : applicationVersion2 != null) {
            return false;
        }
        String requiredBrokerProtocolVersion = getRequiredBrokerProtocolVersion();
        String requiredBrokerProtocolVersion2 = commandParameters.getRequiredBrokerProtocolVersion();
        if (requiredBrokerProtocolVersion != null ? !requiredBrokerProtocolVersion.equals(requiredBrokerProtocolVersion2) : requiredBrokerProtocolVersion2 != null) {
            return false;
        }
        SdkType sdkType = getSdkType();
        SdkType sdkType2 = commandParameters.getSdkType();
        if (sdkType != null ? !sdkType.equals(sdkType2) : sdkType2 != null) {
            return false;
        }
        String sdkVersion = getSdkVersion();
        String sdkVersion2 = commandParameters.getSdkVersion();
        if (sdkVersion != null ? !sdkVersion.equals(sdkVersion2) : sdkVersion2 != null) {
            return false;
        }
        String clientId = getClientId();
        String clientId2 = commandParameters.getClientId();
        if (clientId != null ? !clientId.equals(clientId2) : clientId2 != null) {
            return false;
        }
        String redirectUri = getRedirectUri();
        String redirectUri2 = commandParameters.getRedirectUri();
        if (redirectUri != null ? !redirectUri.equals(redirectUri2) : redirectUri2 != null) {
            return false;
        }
        String childClientId = getChildClientId();
        String childClientId2 = commandParameters.getChildClientId();
        if (childClientId != null ? !childClientId.equals(childClientId2) : childClientId2 != null) {
            return false;
        }
        String childRedirectUri = getChildRedirectUri();
        String childRedirectUri2 = commandParameters.getChildRedirectUri();
        if (childRedirectUri != null ? !childRedirectUri.equals(childRedirectUri2) : childRedirectUri2 != null) {
            return false;
        }
        String callerPackageName = getCallerPackageName();
        String callerPackageName2 = commandParameters.getCallerPackageName();
        if (callerPackageName != null ? !callerPackageName.equals(callerPackageName2) : callerPackageName2 != null) {
            return false;
        }
        String callerSignature = getCallerSignature();
        String callerSignature2 = commandParameters.getCallerSignature();
        if (callerSignature != null ? !callerSignature.equals(callerSignature2) : callerSignature2 != null) {
            return false;
        }
        SerializableSpanContext spanContext = getSpanContext();
        SerializableSpanContext spanContext2 = commandParameters.getSpanContext();
        return spanContext != null ? spanContext.equals(spanContext2) : spanContext2 == null;
    }

    public int hashCode() {
        int i = isPowerOptCheckEnabled() ? 79 : 97;
        String applicationName = getApplicationName();
        int iHashCode = ((i + 59) * 59) + (applicationName == null ? 43 : applicationName.hashCode());
        String applicationVersion = getApplicationVersion();
        int iHashCode2 = (iHashCode * 59) + (applicationVersion == null ? 43 : applicationVersion.hashCode());
        String requiredBrokerProtocolVersion = getRequiredBrokerProtocolVersion();
        int iHashCode3 = (iHashCode2 * 59) + (requiredBrokerProtocolVersion == null ? 43 : requiredBrokerProtocolVersion.hashCode());
        SdkType sdkType = getSdkType();
        int iHashCode4 = (iHashCode3 * 59) + (sdkType == null ? 43 : sdkType.hashCode());
        String sdkVersion = getSdkVersion();
        int iHashCode5 = (iHashCode4 * 59) + (sdkVersion == null ? 43 : sdkVersion.hashCode());
        String clientId = getClientId();
        int iHashCode6 = (iHashCode5 * 59) + (clientId == null ? 43 : clientId.hashCode());
        String redirectUri = getRedirectUri();
        int iHashCode7 = (iHashCode6 * 59) + (redirectUri == null ? 43 : redirectUri.hashCode());
        String childClientId = getChildClientId();
        int iHashCode8 = (iHashCode7 * 59) + (childClientId == null ? 43 : childClientId.hashCode());
        String childRedirectUri = getChildRedirectUri();
        int iHashCode9 = (iHashCode8 * 59) + (childRedirectUri == null ? 43 : childRedirectUri.hashCode());
        String callerPackageName = getCallerPackageName();
        int iHashCode10 = (iHashCode9 * 59) + (callerPackageName == null ? 43 : callerPackageName.hashCode());
        String callerSignature = getCallerSignature();
        int i2 = iHashCode10 * 59;
        int iHashCode11 = callerSignature == null ? 43 : callerSignature.hashCode();
        SerializableSpanContext spanContext = getSpanContext();
        return ((i2 + iHashCode11) * 59) + (spanContext != null ? spanContext.hashCode() : 43);
    }

    protected CommandParameters(CommandParametersBuilder<?, ?> commandParametersBuilder) {
        Map<String, String> mapEmptyMap;
        IPlatformComponents iPlatformComponents = ((CommandParametersBuilder) commandParametersBuilder).platformComponents;
        this.platformComponents = iPlatformComponents;
        if (iPlatformComponents == null) {
            throw new NullPointerException("platformComponents is marked non-null but is null");
        }
        this.oAuth2TokenCache = ((CommandParametersBuilder) commandParametersBuilder).oAuth2TokenCache;
        this.isSharedDevice = ((CommandParametersBuilder) commandParametersBuilder).isSharedDevice;
        this.applicationName = ((CommandParametersBuilder) commandParametersBuilder).applicationName;
        this.applicationVersion = ((CommandParametersBuilder) commandParametersBuilder).applicationVersion;
        this.requiredBrokerProtocolVersion = ((CommandParametersBuilder) commandParametersBuilder).requiredBrokerProtocolVersion;
        this.sdkType = ((CommandParametersBuilder) commandParametersBuilder).sdkType;
        this.sdkVersion = ((CommandParametersBuilder) commandParametersBuilder).sdkVersion;
        this.clientId = ((CommandParametersBuilder) commandParametersBuilder).clientId;
        this.redirectUri = ((CommandParametersBuilder) commandParametersBuilder).redirectUri;
        this.childClientId = ((CommandParametersBuilder) commandParametersBuilder).childClientId;
        this.childRedirectUri = ((CommandParametersBuilder) commandParametersBuilder).childRedirectUri;
        this.powerOptCheckEnabled = ((CommandParametersBuilder) commandParametersBuilder).powerOptCheckEnabled;
        this.callerPackageName = ((CommandParametersBuilder) commandParametersBuilder).callerPackageName;
        this.callerSignature = ((CommandParametersBuilder) commandParametersBuilder).callerSignature;
        if (((CommandParametersBuilder) commandParametersBuilder).flightInformation$set) {
            mapEmptyMap = ((CommandParametersBuilder) commandParametersBuilder).flightInformation$value;
        } else {
            mapEmptyMap = Collections.emptyMap();
        }
        this.flightInformation = mapEmptyMap;
        this.correlationId = ((CommandParametersBuilder) commandParametersBuilder).correlationId;
        this.spanContext = ((CommandParametersBuilder) commandParametersBuilder).spanContext;
    }

    public static CommandParametersBuilder<?, ?> builder() {
        return new CommandParametersBuilderImpl();
    }

    public CommandParametersBuilder<?, ?> toBuilder() {
        return new CommandParametersBuilderImpl().$fillValuesFrom(this);
    }

    public IPlatformComponents getPlatformComponents() {
        return this.platformComponents;
    }

    public OAuth2TokenCache getOAuth2TokenCache() {
        return this.oAuth2TokenCache;
    }

    public boolean isSharedDevice() {
        return this.isSharedDevice;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public String getApplicationVersion() {
        return this.applicationVersion;
    }

    public String getRequiredBrokerProtocolVersion() {
        return this.requiredBrokerProtocolVersion;
    }

    public SdkType getSdkType() {
        return this.sdkType;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getRedirectUri() {
        return this.redirectUri;
    }

    public String getChildClientId() {
        return this.childClientId;
    }

    public String getChildRedirectUri() {
        return this.childRedirectUri;
    }

    public boolean isPowerOptCheckEnabled() {
        return this.powerOptCheckEnabled;
    }

    public String getCallerPackageName() {
        return this.callerPackageName;
    }

    public String getCallerSignature() {
        return this.callerSignature;
    }

    public Map<String, String> getFlightInformation() {
        return this.flightInformation;
    }

    public void setCorrelationId(String str) {
        this.correlationId = str;
    }

    public SerializableSpanContext getSpanContext() {
        return this.spanContext;
    }

    public String getApplicationIdentifier() {
        return String.format(APPLICATION_IDENTIFIER_FORMAT, this.callerPackageName, this.callerSignature);
    }

    public boolean hasNestedAppParameters() {
        return (StringUtil.isNullOrEmpty(this.childRedirectUri) && StringUtil.isNullOrEmpty(this.childClientId)) ? false : true;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    public void logParameters(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (Logger.isAllowPii()) {
            Logger.infoPII(str, ObjectMapper.serializeObjectToJsonString(this));
        } else {
            Logger.info(str, ObjectMapper.serializeExposedFieldsOfObjectToJsonString(this));
        }
    }
}
