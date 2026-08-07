package com.box.android.boxai;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.base.presentation.utilities.IPermissionsHandler;
import com.box.android.boxai.voice.VoiceInputEnvironment;
import com.box.android.coreservices.models.BoxAccountSettings;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.metrics.boxai.BoxAiObservability;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001BY\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/box/android/boxai/BoxAiEnvironment;", "", "boxAiService", "Lcom/box/android/domain/services/IBoxAiService;", "clipboardService", "Lcom/box/android/base/cpl/IClipboardService;", "boxAiAnalytics", "Lcom/box/android/boxai/BoxAiAnalytics;", "boxAiObservability", "Lcom/box/android/domain/metrics/boxai/BoxAiObservability;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "boxAccountSettings", "Lcom/box/android/coreservices/models/BoxAccountSettings;", "voiceInputEnvironment", "Lcom/box/android/boxai/voice/VoiceInputEnvironment;", "permissionsHandler", "Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "getBoxAiAvailabilityUseCase", "Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;", "<init>", "(Lcom/box/android/domain/services/IBoxAiService;Lcom/box/android/base/cpl/IClipboardService;Lcom/box/android/boxai/BoxAiAnalytics;Lcom/box/android/domain/metrics/boxai/BoxAiObservability;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/coreservices/models/BoxAccountSettings;Lcom/box/android/boxai/voice/VoiceInputEnvironment;Lcom/box/android/base/presentation/utilities/IPermissionsHandler;Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;)V", "getBoxAiService", "()Lcom/box/android/domain/services/IBoxAiService;", "getClipboardService", "()Lcom/box/android/base/cpl/IClipboardService;", "getBoxAiAnalytics", "()Lcom/box/android/boxai/BoxAiAnalytics;", "getBoxAiObservability", "()Lcom/box/android/domain/metrics/boxai/BoxAiObservability;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "getBoxAccountSettings", "()Lcom/box/android/coreservices/models/BoxAccountSettings;", "getVoiceInputEnvironment", "()Lcom/box/android/boxai/voice/VoiceInputEnvironment;", "getPermissionsHandler", "()Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "getFileActionsManager", "()Lcom/box/android/coreservices/utilities/FileActionsManager;", "getGetBoxAiAvailabilityUseCase", "()Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiEnvironment {
    public static final int $stable = 8;
    private final BoxAccountSettings boxAccountSettings;
    private final BoxAiAnalytics boxAiAnalytics;
    private final BoxAiObservability boxAiObservability;
    private final IBoxAiService boxAiService;
    private final IClipboardService clipboardService;
    private final FeatureFlips featureFlips;
    private final FileActionsManager fileActionsManager;
    private final GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase;
    private final IPermissionsHandler permissionsHandler;
    private final VoiceInputEnvironment voiceInputEnvironment;

    @Inject
    public BoxAiEnvironment(IBoxAiService boxAiService, IClipboardService clipboardService, BoxAiAnalytics boxAiAnalytics, BoxAiObservability boxAiObservability, FeatureFlips featureFlips, BoxAccountSettings boxAccountSettings, VoiceInputEnvironment voiceInputEnvironment, IPermissionsHandler permissionsHandler, FileActionsManager fileActionsManager, GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase) {
        Intrinsics.checkNotNullParameter(boxAiService, "boxAiService");
        Intrinsics.checkNotNullParameter(clipboardService, "clipboardService");
        Intrinsics.checkNotNullParameter(boxAiAnalytics, "boxAiAnalytics");
        Intrinsics.checkNotNullParameter(boxAiObservability, "boxAiObservability");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(voiceInputEnvironment, "voiceInputEnvironment");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(getBoxAiAvailabilityUseCase, "getBoxAiAvailabilityUseCase");
        this.boxAiService = boxAiService;
        this.clipboardService = clipboardService;
        this.boxAiAnalytics = boxAiAnalytics;
        this.boxAiObservability = boxAiObservability;
        this.featureFlips = featureFlips;
        this.boxAccountSettings = boxAccountSettings;
        this.voiceInputEnvironment = voiceInputEnvironment;
        this.permissionsHandler = permissionsHandler;
        this.fileActionsManager = fileActionsManager;
        this.getBoxAiAvailabilityUseCase = getBoxAiAvailabilityUseCase;
    }

    public final IBoxAiService getBoxAiService() {
        return this.boxAiService;
    }

    public final IClipboardService getClipboardService() {
        return this.clipboardService;
    }

    public final BoxAiAnalytics getBoxAiAnalytics() {
        return this.boxAiAnalytics;
    }

    public final BoxAiObservability getBoxAiObservability() {
        return this.boxAiObservability;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final BoxAccountSettings getBoxAccountSettings() {
        return this.boxAccountSettings;
    }

    public final VoiceInputEnvironment getVoiceInputEnvironment() {
        return this.voiceInputEnvironment;
    }

    public final IPermissionsHandler getPermissionsHandler() {
        return this.permissionsHandler;
    }

    public final FileActionsManager getFileActionsManager() {
        return this.fileActionsManager;
    }

    public final GetBoxAiAvailabilityUseCase getGetBoxAiAvailabilityUseCase() {
        return this.getBoxAiAvailabilityUseCase;
    }
}
