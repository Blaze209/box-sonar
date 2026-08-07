package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class OAuth2StrategyParameters {
    private final transient AbstractAuthenticationScheme mAuthenticationScheme;
    public final List<String> mCapabilities;
    public final List<String> mChallengeTypes;
    private final transient IPlatformComponents mPlatformComponents;
    private transient boolean mUsingOpenIdConfiguration;

    public static class OAuth2StrategyParametersBuilder {
        private AbstractAuthenticationScheme authenticationScheme;
        private List<String> capabilities;
        private List<String> challengeTypes;
        private IPlatformComponents platformComponents;
        private boolean usingOpenIdConfiguration;

        OAuth2StrategyParametersBuilder() {
        }

        public OAuth2StrategyParametersBuilder authenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
            this.authenticationScheme = abstractAuthenticationScheme;
            return this;
        }

        public OAuth2StrategyParameters build() {
            return new OAuth2StrategyParameters(this.platformComponents, this.authenticationScheme, this.challengeTypes, this.capabilities, this.usingOpenIdConfiguration);
        }

        public OAuth2StrategyParametersBuilder capabilities(List<String> list) {
            this.capabilities = list;
            return this;
        }

        public OAuth2StrategyParametersBuilder challengeTypes(List<String> list) {
            this.challengeTypes = list;
            return this;
        }

        public OAuth2StrategyParametersBuilder platformComponents(IPlatformComponents iPlatformComponents) {
            this.platformComponents = iPlatformComponents;
            return this;
        }

        public String toString() {
            return "OAuth2StrategyParameters.OAuth2StrategyParametersBuilder(platformComponents=" + this.platformComponents + ", authenticationScheme=" + this.authenticationScheme + ", challengeTypes=" + this.challengeTypes + ", capabilities=" + this.capabilities + ", usingOpenIdConfiguration=" + this.usingOpenIdConfiguration + ")";
        }

        public OAuth2StrategyParametersBuilder usingOpenIdConfiguration(boolean z) {
            this.usingOpenIdConfiguration = z;
            return this;
        }
    }

    OAuth2StrategyParameters(IPlatformComponents iPlatformComponents, AbstractAuthenticationScheme abstractAuthenticationScheme, List<String> list, List<String> list2, boolean z) {
        this.mPlatformComponents = iPlatformComponents;
        this.mAuthenticationScheme = abstractAuthenticationScheme;
        this.mChallengeTypes = list;
        this.mCapabilities = list2;
        this.mUsingOpenIdConfiguration = z;
    }

    public static OAuth2StrategyParametersBuilder builder() {
        return new OAuth2StrategyParametersBuilder();
    }

    public IPlatformComponents getPlatformComponents() {
        return this.mPlatformComponents;
    }

    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.mAuthenticationScheme;
    }

    public List<String> getChallengeTypes() {
        return this.mChallengeTypes;
    }

    public List<String> getCapabilities() {
        return this.mCapabilities;
    }

    public boolean isUsingOpenIdConfiguration() {
        return this.mUsingOpenIdConfiguration;
    }

    public void setUsingOpenIdConfiguration(boolean z) {
        this.mUsingOpenIdConfiguration = z;
    }
}
