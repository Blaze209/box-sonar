package com.box.android.domain.configuration;

import android.content.SharedPreferences;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureFlips.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0016\u0010[\u001a\u00020\\2\u0006\u0010\n\u001a\u00020\u00142\u0006\u0010]\u001a\u00020^J\u0010\u0010_\u001a\u0004\u0018\u00010\u000b2\u0006\u0010`\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u001f\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010!\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u001b\u0010#\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b$\u0010\u0016R\u0011\u0010'\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u0011\u0010)\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0011\u0010+\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0016R\u0011\u0010-\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0016R\u0011\u0010/\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0016R\u0011\u00101\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0016R\u0011\u00103\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0016R\u0011\u00105\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0016R\u0011\u00107\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0016R\u0011\u00109\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0016R\u0011\u0010;\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0016R\u0011\u0010=\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0016R\u0011\u0010?\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0016R\u0011\u0010A\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0016R\u0011\u0010C\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0016R\u0011\u0010E\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0016R\u0011\u0010G\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0016R\u0011\u0010I\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0016R\u0011\u0010K\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0016R\u0011\u0010M\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0016R\u0011\u0010O\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0016R\u0011\u0010Q\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0016R\u0011\u0010S\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0016R\u0011\u0010U\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0016R\u0011\u0010W\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0016R\u0011\u0010Y\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u0016¨\u0006a"}, d2 = {"Lcom/box/android/domain/configuration/FeatureFlips;", "", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "debugSharedPreferences", "Landroid/content/SharedPreferences;", "evaluator", "Lcom/box/android/domain/configuration/FeatureFlipEvaluator;", "<init>", "(Lcom/box/android/domain/configuration/IBoxAccountSettings;Landroid/content/SharedPreferences;Lcom/box/android/domain/configuration/FeatureFlipEvaluator;)V", "featureFlip", "Lcom/box/android/domain/configuration/FeatureFlip;", "owner", "", "name", "rule", "Lcom/box/android/domain/configuration/FeatureFlipRule;", "flippablePreRelease", "Lcom/box/android/domain/configuration/FlippablePreRelease;", "mainScreenRedesign", "Lcom/box/android/domain/configuration/IFeatureFlip;", "getMainScreenRedesign", "()Lcom/box/android/domain/configuration/IFeatureFlip;", "boxAiCenterForPreviewAndMultidoc", "getBoxAiCenterForPreviewAndMultidoc", "boxAiInNewMainScreen", "getBoxAiInNewMainScreen", "unifiedSearch", "getUnifiedSearch", "axForSearch", "getAxForSearch", "viewAnnotations", "getViewAnnotations", "createAnnotations", "getCreateAnnotations", "fileDownloadJobMigration", "getFileDownloadJobMigration", "fileDownloadJobMigration$delegate", "Lkotlin/Lazy;", "useGraphQLEndpoints", "getUseGraphQLEndpoints", "fileActivitiesModernization", "getFileActivitiesModernization", "splunkRUM", "getSplunkRUM", "boxAiApiChangesSafeguard", "getBoxAiApiChangesSafeguard", "hubsFeatureFlip", "getHubsFeatureFlip", "downloadFolderJobMigration", "getDownloadFolderJobMigration", "videoWatermarkingModernization", "getVideoWatermarkingModernization", "resetJobRunningInfo", "getResetJobRunningInfo", "moveCopyV2", "getMoveCopyV2", "inAppUpdates", "getInAppUpdates", "videoAnnotations", "getVideoAnnotations", "offlineMigration", "getOfflineMigration", "migrateOfflineInfoToDb", "getMigrateOfflineInfoToDb", "boxAiMultidoc", "getBoxAiMultidoc", "boxAiStudioSettingsUpdates", "getBoxAiStudioSettingsUpdates", "boxAiQuickAction", "getBoxAiQuickAction", "canEditWatermark", "getCanEditWatermark", "addTask", "getAddTask", "promptLibrary", "getPromptLibrary", "useCoAuthoring", "getUseCoAuthoring", "intuneOidBasedEnrollment", "getIntuneOidBasedEnrollment", "contentPicker", "getContentPicker", "boxNotesScreen", "getBoxNotesScreen", "newNoteCreationFlow", "getNewNoteCreationFlow", "uploadFileMetadataExtraction", "getUploadFileMetadataExtraction", "webAuthnInLoginWebView", "getWebAuthnInLoginWebView", "toggleFeatureFlip", "", "isEnabled", "", "findByDeepLinkKey", "key", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeatureFlips {
    private final IFeatureFlip addTask;
    private final IFeatureFlip axForSearch;
    private final IBoxAccountSettings boxAccountSettings;
    private final IFeatureFlip boxAiApiChangesSafeguard;
    private final IFeatureFlip boxAiCenterForPreviewAndMultidoc;
    private final IFeatureFlip boxAiInNewMainScreen;
    private final IFeatureFlip boxAiMultidoc;
    private final IFeatureFlip boxAiQuickAction;
    private final IFeatureFlip boxAiStudioSettingsUpdates;
    private final IFeatureFlip boxNotesScreen;
    private final IFeatureFlip canEditWatermark;
    private final IFeatureFlip contentPicker;
    private final IFeatureFlip createAnnotations;
    private final SharedPreferences debugSharedPreferences;
    private final IFeatureFlip downloadFolderJobMigration;
    private final FeatureFlipEvaluator evaluator;
    private final IFeatureFlip fileActivitiesModernization;

    /* JADX INFO: renamed from: fileDownloadJobMigration$delegate, reason: from kotlin metadata */
    private final Lazy fileDownloadJobMigration;
    private final IFeatureFlip hubsFeatureFlip;
    private final IFeatureFlip inAppUpdates;
    private final IFeatureFlip intuneOidBasedEnrollment;
    private final IFeatureFlip mainScreenRedesign;
    private final IFeatureFlip migrateOfflineInfoToDb;
    private final IFeatureFlip moveCopyV2;
    private final IFeatureFlip newNoteCreationFlow;
    private final IFeatureFlip offlineMigration;
    private final IFeatureFlip promptLibrary;
    private final IFeatureFlip resetJobRunningInfo;
    private final IFeatureFlip splunkRUM;
    private final IFeatureFlip unifiedSearch;
    private final IFeatureFlip uploadFileMetadataExtraction;
    private final IFeatureFlip useCoAuthoring;
    private final IFeatureFlip useGraphQLEndpoints;
    private final IFeatureFlip videoAnnotations;
    private final IFeatureFlip videoWatermarkingModernization;
    private final IFeatureFlip viewAnnotations;
    private final IFeatureFlip webAuthnInLoginWebView;

    @Inject
    public FeatureFlips(IBoxAccountSettings boxAccountSettings, @Named("feature_flip_shared_preferences") SharedPreferences debugSharedPreferences, FeatureFlipEvaluator evaluator) {
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(debugSharedPreferences, "debugSharedPreferences");
        Intrinsics.checkNotNullParameter(evaluator, "evaluator");
        this.boxAccountSettings = boxAccountSettings;
        this.debugSharedPreferences = debugSharedPreferences;
        this.evaluator = evaluator;
        this.mainScreenRedesign = featureFlip("zmamadjonov", "Main Screen Redesign", IFeatureFlipKt.or(IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.BETA), IFeatureFlipKt.selectedTestRun("mainScreenRedesign")), IFeatureFlipKt.split(Split.MAIN_SCREEN_REDESIGN)), new FlippablePreRelease("main-screen-redesign"));
        this.boxAiCenterForPreviewAndMultidoc = featureFlip("mthiha", "AX for Preview and MultiDoc", IFeatureFlipKt.or(IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.enabledIn(FeatureFlipTarget.BETA)), IFeatureFlipKt.split(Split.AX_EXPERIENCE_FOR_PREVIEW_MULTIDOC)), new FlippablePreRelease("boxai-center"));
        this.boxAiInNewMainScreen = featureFlip("asvintsilava", "Box AI in New Main Screen", IFeatureFlipKt.or(IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.enabledIn(FeatureFlipTarget.BETA)), IFeatureFlipKt.split(Split.AX_EXPERIENCE)), new FlippablePreRelease("boxai-in-new-main-screen"));
        this.unifiedSearch = featureFlip("asvintsilava", "Unified Search", IFeatureFlipKt.or(IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.enabledIn(FeatureFlipTarget.BETA)), IFeatureFlipKt.split(Split.UNIFIED_SEARCH)), new FlippablePreRelease("unified_search"));
        this.axForSearch = featureFlip("amakarenko", "AX launch from Unified Search", IFeatureFlipKt.or(IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.enabledIn(FeatureFlipTarget.BETA)), IFeatureFlipKt.split(Split.AX_FOR_SEARCH)), new FlippablePreRelease("ax_for_search"));
        this.viewAnnotations = featureFlip$default(this, "sbhowmick", "View Annotations on all file types", new FeatureFlipRule.Eval(new FeatureFlips$viewAnnotations$1(this, null)), null, 8, null);
        this.createAnnotations = featureFlip$default(this, "sbhowmick", "Create Annotations on all file types", new FeatureFlipRule.Eval(new FeatureFlips$createAnnotations$1(this, null)), null, 8, null);
        this.fileDownloadJobMigration = LazyKt.lazy(new Function0() { // from class: com.box.android.domain.configuration.FeatureFlips$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FeatureFlips.fileDownloadJobMigration_delegate$lambda$0(this.f$0);
            }
        });
        this.useGraphQLEndpoints = featureFlip$default(this, "santsipau", "Use real GraphQL endpoint", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.USE_GRAPHQL_ENDPOINT)), null, 8, null);
        this.fileActivitiesModernization = featureFlip$default(this, "ashankar", "File Activities modernization", IFeatureFlipKt.split(Split.FILE_ACTIVITIES_MODERNIZATION), null, 8, null);
        this.splunkRUM = featureFlip$default(this, "mchrzanowska", "Send observability data to Splunk RUM", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.SPLUNK_RUM)), null, 8, null);
        this.boxAiApiChangesSafeguard = featureFlip$default(this, "mthiha", "BoxAI API Changes Safeguard", IFeatureFlipKt.split(Split.BOX_AI_API_CHANGES_SAFEGUARD), null, 8, null);
        this.hubsFeatureFlip = featureFlip("mthiha", "Hubs Feature Flip", IFeatureFlipKt.split(Split.HUBS), new FlippablePreRelease("hubs"));
        this.downloadFolderJobMigration = featureFlip$default(this, "ashankar", "Download Folder Job Migration", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.DOWNLOAD_FOLDER_JOB_MIGRATION)), null, 8, null);
        this.videoWatermarkingModernization = featureFlip$default(this, "ggoncharik", "Video Watermarking Modernization", IFeatureFlipKt.split(Split.VIDEO_WATERMARKING_MODERNIZATION), null, 8, null);
        this.resetJobRunningInfo = featureFlip$default(this, "rsanas", "Reset Job Running Info", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.RESET_JOB_INFO)), null, 8, null);
        this.moveCopyV2 = featureFlip$default(this, "rsanas", "Move/Copy using Job service", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.MOVE_COPY_V2)), null, 8, null);
        this.inAppUpdates = featureFlip$default(this, "kjurski", "Show in-app updates", IFeatureFlipKt.split(Split.IN_APP_UPDATES), null, 8, null);
        this.videoAnnotations = featureFlip$default(this, "mthiha", "Video Annotations", IFeatureFlipKt.split(Split.VIDEO_ANNOTATIONS), null, 8, null);
        this.offlineMigration = featureFlip$default(this, "rsanas", "Offline Files with JobService", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.OFFLINE_V2)), null, 8, null);
        this.migrateOfflineInfoToDb = featureFlip$default(this, "rsanas", "Offline Info to Room db", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.MIGRATE_OFFLINE_INFO_ROOM)), null, 8, null);
        this.boxAiMultidoc = featureFlip$default(this, "kjurski", "Box AI multi-doc in Browse", IFeatureFlipKt.split(Split.BOX_AI_MULTIDOC), null, 8, null);
        this.boxAiStudioSettingsUpdates = featureFlip$default(this, "hosewski", "Box AI Studio settings updates", IFeatureFlipKt.split(Split.BOX_AI_STUDIO_SETTINGS_UPDATE), null, 8, null);
        this.boxAiQuickAction = featureFlip$default(this, "kjurski", "Box AI quick action in Browse", IFeatureFlipKt.and(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV, FeatureFlipTarget.BETA, FeatureFlipTarget.BOXERS), IFeatureFlipKt.split(Split.BOX_AI_QUICK_ACTION)), null, 8, null);
        this.canEditWatermark = featureFlip$default(this, "jskwarczek", "Watermarking", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.WATERMARKING_SETTINGS)), null, 8, null);
        this.addTask = featureFlip$default(this, "rsanas", "Add task", FeatureFlipRule.Disabled.INSTANCE, null, 8, null);
        this.promptLibrary = featureFlip$default(this, "mchrzanowska", "Prompt library", IFeatureFlipKt.split(Split.PROMPT_LIBRARY), null, 8, null);
        this.useCoAuthoring = featureFlip$default(this, "rsanas", "Use Co-Auth serviceID during WOPI", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV), IFeatureFlipKt.split(Split.USE_CO_AUTHORING)), null, 8, null);
        this.intuneOidBasedEnrollment = featureFlip$default(this, "ggoncharik", "Intune OID-based enrollment", FeatureFlipRule.Enabled.INSTANCE, null, 8, null);
        this.contentPicker = featureFlip$default(this, "rsanas", "Content Picker", FeatureFlipRule.Disabled.INSTANCE, null, 8, null);
        this.boxNotesScreen = featureFlip$default(this, "hosewski", "Show Box Notes tab on Main Screen", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV, FeatureFlipTarget.BETA), IFeatureFlipKt.split(Split.NOTES_SCREEN)), null, 8, null);
        this.newNoteCreationFlow = featureFlip$default(this, "kjurski", "New Box Note creation flow", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV, FeatureFlipTarget.BETA), IFeatureFlipKt.split(Split.NEW_NOTE_CREATION_FLOW)), null, 8, null);
        this.uploadFileMetadataExtraction = featureFlip$default(this, "rsanas", "Exif Metadata Extraction", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV, FeatureFlipTarget.BETA), IFeatureFlipKt.split(Split.EXIF_METADATA_EXTRACTION)), null, 8, null);
        this.webAuthnInLoginWebView = featureFlip$default(this, "ggoncharik", "WebAuthn in Login WebView", IFeatureFlipKt.or(IFeatureFlipKt.enabledIn(FeatureFlipTarget.DEV, FeatureFlipTarget.BETA), IFeatureFlipKt.split(Split.WEBAUTHN_IN_LOGIN_WEBVIEW)), null, 8, null);
    }

    static /* synthetic */ FeatureFlip featureFlip$default(FeatureFlips featureFlips, String str, String str2, FeatureFlipRule featureFlipRule, FlippablePreRelease flippablePreRelease, int i, Object obj) {
        if ((i & 8) != 0) {
            flippablePreRelease = null;
        }
        return featureFlips.featureFlip(str, str2, featureFlipRule, flippablePreRelease);
    }

    private final FeatureFlip featureFlip(String owner, String name, FeatureFlipRule rule, FlippablePreRelease flippablePreRelease) {
        return new FeatureFlip(owner, name, rule, this.debugSharedPreferences, this.evaluator, flippablePreRelease);
    }

    public final IFeatureFlip getMainScreenRedesign() {
        return this.mainScreenRedesign;
    }

    public final IFeatureFlip getBoxAiCenterForPreviewAndMultidoc() {
        return this.boxAiCenterForPreviewAndMultidoc;
    }

    public final IFeatureFlip getBoxAiInNewMainScreen() {
        return this.boxAiInNewMainScreen;
    }

    public final IFeatureFlip getUnifiedSearch() {
        return this.unifiedSearch;
    }

    public final IFeatureFlip getAxForSearch() {
        return this.axForSearch;
    }

    public final IFeatureFlip getViewAnnotations() {
        return this.viewAnnotations;
    }

    public final IFeatureFlip getCreateAnnotations() {
        return this.createAnnotations;
    }

    public final IFeatureFlip getFileDownloadJobMigration() {
        return (IFeatureFlip) this.fileDownloadJobMigration.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeatureFlip fileDownloadJobMigration_delegate$lambda$0(FeatureFlips featureFlips) {
        return featureFlip$default(featureFlips, "ashankar", "Download files using Job System", IFeatureFlipKt.split(Split.JOB_CHUNK_DOWNLOAD), null, 8, null);
    }

    public final IFeatureFlip getUseGraphQLEndpoints() {
        return this.useGraphQLEndpoints;
    }

    public final IFeatureFlip getFileActivitiesModernization() {
        return this.fileActivitiesModernization;
    }

    public final IFeatureFlip getSplunkRUM() {
        return this.splunkRUM;
    }

    public final IFeatureFlip getBoxAiApiChangesSafeguard() {
        return this.boxAiApiChangesSafeguard;
    }

    public final IFeatureFlip getHubsFeatureFlip() {
        return this.hubsFeatureFlip;
    }

    public final IFeatureFlip getDownloadFolderJobMigration() {
        return this.downloadFolderJobMigration;
    }

    public final IFeatureFlip getVideoWatermarkingModernization() {
        return this.videoWatermarkingModernization;
    }

    public final IFeatureFlip getResetJobRunningInfo() {
        return this.resetJobRunningInfo;
    }

    public final IFeatureFlip getMoveCopyV2() {
        return this.moveCopyV2;
    }

    public final IFeatureFlip getInAppUpdates() {
        return this.inAppUpdates;
    }

    public final IFeatureFlip getVideoAnnotations() {
        return this.videoAnnotations;
    }

    public final IFeatureFlip getOfflineMigration() {
        return this.offlineMigration;
    }

    public final IFeatureFlip getMigrateOfflineInfoToDb() {
        return this.migrateOfflineInfoToDb;
    }

    public final IFeatureFlip getBoxAiMultidoc() {
        return this.boxAiMultidoc;
    }

    public final IFeatureFlip getBoxAiStudioSettingsUpdates() {
        return this.boxAiStudioSettingsUpdates;
    }

    public final IFeatureFlip getBoxAiQuickAction() {
        return this.boxAiQuickAction;
    }

    public final IFeatureFlip getCanEditWatermark() {
        return this.canEditWatermark;
    }

    public final IFeatureFlip getAddTask() {
        return this.addTask;
    }

    public final IFeatureFlip getPromptLibrary() {
        return this.promptLibrary;
    }

    public final IFeatureFlip getUseCoAuthoring() {
        return this.useCoAuthoring;
    }

    public final IFeatureFlip getIntuneOidBasedEnrollment() {
        return this.intuneOidBasedEnrollment;
    }

    public final IFeatureFlip getContentPicker() {
        return this.contentPicker;
    }

    public final IFeatureFlip getBoxNotesScreen() {
        return this.boxNotesScreen;
    }

    public final IFeatureFlip getNewNoteCreationFlow() {
        return this.newNoteCreationFlow;
    }

    public final IFeatureFlip getUploadFileMetadataExtraction() {
        return this.uploadFileMetadataExtraction;
    }

    public final IFeatureFlip getWebAuthnInLoginWebView() {
        return this.webAuthnInLoginWebView;
    }

    public final void toggleFeatureFlip(IFeatureFlip featureFlip, boolean isEnabled) {
        Intrinsics.checkNotNullParameter(featureFlip, "featureFlip");
        SharedPreferences.Editor editorEdit = this.debugSharedPreferences.edit();
        editorEdit.putBoolean(featureFlip.getName(), isEnabled);
        editorEdit.apply();
    }

    public final FeatureFlip findByDeepLinkKey(String key) throws IllegalAccessException {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Field[] declaredFields = getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (Intrinsics.areEqual(field.getType(), IFeatureFlip.class)) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Field field2 = (Field) it.next();
            field2.setAccessible(true);
            Object obj2 = field2.get(this);
            obj = obj2 instanceof FeatureFlip ? (FeatureFlip) obj2 : null;
            if (obj != null) {
                arrayList2.add(obj);
            }
        }
        for (Object obj3 : arrayList2) {
            FlippablePreRelease flippablePreRelease = ((FeatureFlip) obj3).getFlippablePreRelease();
            if (Intrinsics.areEqual(flippablePreRelease != null ? flippablePreRelease.getKey() : null, key)) {
                obj = obj3;
                break;
            }
        }
        return (FeatureFlip) obj;
    }
}
