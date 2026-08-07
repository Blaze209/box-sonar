package com.microsoft.identity.common.java.flighting;

import com.microsoft.identity.common.java.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonFlightsManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001J\u0006\u0010\u0010\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/java/flighting/CommonFlightsManager;", "Lcom/microsoft/identity/common/java/flighting/IFlightsManager;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mFlightsManager", "getFlightsProvider", "Lcom/microsoft/identity/common/java/flighting/IFlightsProvider;", "waitForConfigsWithTimeoutInMs", "", "getFlightsProviderForTenant", "tenantId", "initializeCommonFlightsManager", "", "flightsManager", "resetFlightsManager", "DefaultValueFlightsManager", "DefaultValueFlightsProvider", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonFlightsManager implements IFlightsManager {
    public static final CommonFlightsManager INSTANCE = new CommonFlightsManager();
    private static final String TAG = "CommonFlightsManager";
    private static IFlightsManager mFlightsManager = DefaultValueFlightsManager.INSTANCE;

    private CommonFlightsManager() {
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
    public IFlightsProvider getFlightsProvider() {
        return IFlightsManager.DefaultImpls.getFlightsProvider(this);
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
    public IFlightsProvider getFlightsProviderForTenant(String str) {
        return IFlightsManager.DefaultImpls.getFlightsProviderForTenant(this, str);
    }

    public final void initializeCommonFlightsManager(IFlightsManager flightsManager) {
        Intrinsics.checkNotNullParameter(flightsManager, "flightsManager");
        Logger.info(TAG + ":initializeCommonFlightsManager", "initializing common flights manager with " + flightsManager.getClass().getSimpleName());
        mFlightsManager = flightsManager;
    }

    public final void resetFlightsManager() {
        Logger.info(TAG + ":resetFlightsManager", "Resetting flights manager to default value.");
        mFlightsManager = DefaultValueFlightsManager.INSTANCE;
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
    public IFlightsProvider getFlightsProvider(long waitForConfigsWithTimeoutInMs) {
        return mFlightsManager.getFlightsProvider(waitForConfigsWithTimeoutInMs);
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
    public IFlightsProvider getFlightsProviderForTenant(String tenantId, long waitForConfigsWithTimeoutInMs) {
        Intrinsics.checkNotNullParameter(tenantId, "tenantId");
        return mFlightsManager.getFlightsProviderForTenant(tenantId, waitForConfigsWithTimeoutInMs);
    }

    /* JADX INFO: compiled from: CommonFlightsManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/microsoft/identity/common/java/flighting/CommonFlightsManager$DefaultValueFlightsProvider;", "Lcom/microsoft/identity/common/java/flighting/IFlightsProvider;", "()V", "getBooleanValue", "", "flightConfig", "Lcom/microsoft/identity/common/java/flighting/IFlightConfig;", "getDoubleValue", "", "getIntValue", "", "getJsonValue", "Lorg/json/JSONObject;", "getStringValue", "", "isFlightEnabled", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DefaultValueFlightsProvider implements IFlightsProvider {
        public static final DefaultValueFlightsProvider INSTANCE = new DefaultValueFlightsProvider();

        private DefaultValueFlightsProvider() {
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsProvider
        public boolean isFlightEnabled(IFlightConfig flightConfig) {
            Intrinsics.checkNotNullParameter(flightConfig, "flightConfig");
            return getBooleanValue(flightConfig);
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsProvider
        public boolean getBooleanValue(IFlightConfig flightConfig) {
            Intrinsics.checkNotNullParameter(flightConfig, "flightConfig");
            Object defaultValue = flightConfig.getDefaultValue();
            Intrinsics.checkNotNull(defaultValue, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) defaultValue).booleanValue();
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsProvider
        public int getIntValue(IFlightConfig flightConfig) {
            Intrinsics.checkNotNullParameter(flightConfig, "flightConfig");
            Object defaultValue = flightConfig.getDefaultValue();
            Intrinsics.checkNotNull(defaultValue, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) defaultValue).intValue();
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsProvider
        public double getDoubleValue(IFlightConfig flightConfig) {
            Intrinsics.checkNotNullParameter(flightConfig, "flightConfig");
            Object defaultValue = flightConfig.getDefaultValue();
            Intrinsics.checkNotNull(defaultValue, "null cannot be cast to non-null type kotlin.Double");
            return ((Double) defaultValue).doubleValue();
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsProvider
        public String getStringValue(IFlightConfig flightConfig) {
            Intrinsics.checkNotNullParameter(flightConfig, "flightConfig");
            Object defaultValue = flightConfig.getDefaultValue();
            Intrinsics.checkNotNull(defaultValue, "null cannot be cast to non-null type kotlin.String");
            return (String) defaultValue;
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsProvider
        public JSONObject getJsonValue(IFlightConfig flightConfig) {
            Intrinsics.checkNotNullParameter(flightConfig, "flightConfig");
            Object defaultValue = flightConfig.getDefaultValue();
            Intrinsics.checkNotNull(defaultValue, "null cannot be cast to non-null type org.json.JSONObject");
            return (JSONObject) defaultValue;
        }
    }

    /* JADX INFO: compiled from: CommonFlightsManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/java/flighting/CommonFlightsManager$DefaultValueFlightsManager;", "Lcom/microsoft/identity/common/java/flighting/IFlightsManager;", "()V", "getFlightsProvider", "Lcom/microsoft/identity/common/java/flighting/IFlightsProvider;", "waitForConfigsWithTimeoutInMs", "", "getFlightsProviderForTenant", "tenantId", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DefaultValueFlightsManager implements IFlightsManager {
        public static final DefaultValueFlightsManager INSTANCE = new DefaultValueFlightsManager();

        private DefaultValueFlightsManager() {
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
        public IFlightsProvider getFlightsProvider() {
            return IFlightsManager.DefaultImpls.getFlightsProvider(this);
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
        public IFlightsProvider getFlightsProviderForTenant(String str) {
            return IFlightsManager.DefaultImpls.getFlightsProviderForTenant(this, str);
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
        public IFlightsProvider getFlightsProvider(long waitForConfigsWithTimeoutInMs) {
            return DefaultValueFlightsProvider.INSTANCE;
        }

        @Override // com.microsoft.identity.common.java.flighting.IFlightsManager
        public IFlightsProvider getFlightsProviderForTenant(String tenantId, long waitForConfigsWithTimeoutInMs) {
            Intrinsics.checkNotNullParameter(tenantId, "tenantId");
            return DefaultValueFlightsProvider.INSTANCE;
        }
    }
}
