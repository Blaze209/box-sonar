package com.box.android.boxai;

import com.box.android.domain.analytics.AiCenterSessionInfoProvider;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import com.margelo.nitro.boxcontext.providers.StyleVariant;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: AiCenterSessionInfoProviderImpl.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/box/android/boxai/AiCenterSessionInfoProviderImpl;", "Lcom/box/android/domain/analytics/AiCenterSessionInfoProvider;", "<init>", "()V", "lastActiveHostSurface", "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "getLastActiveHostSurface", "()Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "setLastActiveHostSurface", "(Lcom/box/brownfieldApi/featuresNavigator/HostSurface;)V", "lastActiveSessionId", "", "getLastActiveSessionId", "()Ljava/lang/String;", "setLastActiveSessionId", "(Ljava/lang/String;)V", "lastActiveStyleVariant", "Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "getLastActiveStyleVariant", "()Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "setLastActiveStyleVariant", "(Lcom/margelo/nitro/boxcontext/providers/StyleVariant;)V", "getHostAppName", "getSessionId", "getStyleName", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AiCenterSessionInfoProviderImpl implements AiCenterSessionInfoProvider {
    public static final int $stable = 8;
    private HostSurface lastActiveHostSurface;
    private String lastActiveSessionId;
    private StyleVariant lastActiveStyleVariant;

    @Inject
    public AiCenterSessionInfoProviderImpl() {
    }

    public final HostSurface getLastActiveHostSurface() {
        return this.lastActiveHostSurface;
    }

    public final void setLastActiveHostSurface(HostSurface hostSurface) {
        this.lastActiveHostSurface = hostSurface;
    }

    public final String getLastActiveSessionId() {
        return this.lastActiveSessionId;
    }

    public final void setLastActiveSessionId(String str) {
        this.lastActiveSessionId = str;
    }

    public final StyleVariant getLastActiveStyleVariant() {
        return this.lastActiveStyleVariant;
    }

    public final void setLastActiveStyleVariant(StyleVariant styleVariant) {
        this.lastActiveStyleVariant = styleVariant;
    }

    @Override // com.box.android.domain.analytics.AiCenterSessionInfoProvider
    public String getHostAppName() {
        HostSurface hostSurface = this.lastActiveHostSurface;
        if (hostSurface != null) {
            return hostSurface.getValue();
        }
        return null;
    }

    @Override // com.box.android.domain.analytics.AiCenterSessionInfoProvider
    public String getSessionId() {
        return this.lastActiveSessionId;
    }

    @Override // com.box.android.domain.analytics.AiCenterSessionInfoProvider
    public String getStyleName() {
        StyleVariant styleVariant = this.lastActiveStyleVariant;
        if (styleVariant != null) {
            return styleVariant.getValue();
        }
        return null;
    }
}
