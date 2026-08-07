package sdk.pendo.io.x6;

import android.content.SharedPreferences;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.n0;
import sdk.pendo.io.views.custom.PendoBackCapture;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 ;2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002JN\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R$\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020 0\u001f0\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0015\u0010#R$\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b\u000f\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001aR\u0016\u0010)\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001aR$\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b'\u0010\u001cR\"\u0010\u0007\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b+\u0010,R$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b-\u0010\u001a\u001a\u0004\b(\u0010\u001cR$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001cR$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010\u001cR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b/\u0010\u001a\u001a\u0004\b!\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b1\u0010\u001aR$\u00102\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b-\u0010\u001cR$\u00103\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b*\u0010\u001cR*\u00106\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00048\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001a\u001a\u0004\b0\u0010\u001c\"\u0004\b\u0015\u0010,R*\u00108\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00048\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001a\u001a\u0004\b.\u0010\u001c\"\u0004\b\u000f\u0010,¨\u0006<"}, d2 = {"Lsdk/pendo/io/x6/k;", "", "", "p", "", "includePageViewTexts", "includeFeatureClickTexts", "includeFeatureClickNestedTexts", "includeRetroElementCompatibilityHashes", "isOldScreenIdFormat", "ignoreDynamicFragmentsInScrollView", "isRespondToScrollChangeEventsForScreenId", "", "globalLayoutChangeDebouncer", "shouldDetectClicksForAccessibility", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "o", "Lsdk/pendo/io/Pendo$PendoOptions;", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "<set-?>", "b", "J", "c", "()J", "globalLayoutChangeEventsDebouncer", "Z", CmcdData.STREAMING_FORMAT_HLS, "()Z", "shouldExcludeGhostElementsForCapture", "", "Lkotlin/reflect/KClass;", "Landroid/view/View;", "d", "Ljava/util/Set;", "()Ljava/util/Set;", "excludedViewTypes", "e", "disableBackCapture", "f", "g", "includeNestedText", "i", "setIncludeFeatureClickNestedTexts$pendoIO_release", "(Z)V", "j", "k", CmcdData.OBJECT_TYPE_MANIFEST, CmcdData.STREAM_TYPE_LIVE, "n", "shouldIgnoreDynamicElementsDuringScan", "shouldForceHandleGlobalLayoutChange", "value", "q", "useOnlyXamarinBridgeProvidedScreenId", "r", Pendo.PendoOptions.USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT, "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;)V", "s", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class k {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Pendo.PendoOptions pendoOptions;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private long globalLayoutChangeEventsDebouncer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final boolean shouldExcludeGhostElementsForCapture;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Set<KClass<? extends View>> excludedViewTypes;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private boolean disableBackCapture;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean includePageViewTexts;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean includeNestedText;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private boolean includeFeatureClickTexts;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean includeFeatureClickNestedTexts;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private boolean includeRetroElementCompatibilityHashes;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private boolean isOldScreenIdFormat;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private boolean isRespondToScrollChangeEventsForScreenId;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private boolean ignoreDynamicFragmentsInScrollView;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean shouldDetectClicksForAccessibility;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private boolean shouldIgnoreDynamicElementsDuringScan;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private boolean shouldForceHandleGlobalLayoutChange;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private boolean useOnlyXamarinBridgeProvidedScreenId;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private boolean useModifiedScreenDataForNativeTransientUIComponent;

    public k(Pendo.PendoOptions pendoOptions) {
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        this.pendoOptions = pendoOptions;
        this.globalLayoutChangeEventsDebouncer = 100L;
        this.shouldExcludeGhostElementsForCapture = pendoOptions.getExcludeHiddenElementsWhileScanning();
        this.excludedViewTypes = SetsKt.setOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(sdk.pendo.io.s5.b.class), Reflection.getOrCreateKotlinClass(PendoBackCapture.class), Reflection.getOrCreateKotlinClass(FloatingListenerButton.class)});
        this.includePageViewTexts = true;
        this.includeFeatureClickTexts = true;
        this.includeRetroElementCompatibilityHashes = true;
        this.isOldScreenIdFormat = true;
        this.ignoreDynamicFragmentsInScrollView = true;
        this.useOnlyXamarinBridgeProvidedScreenId = pendoOptions.getUseOnlyXamarinBridgeProvidedScreenId();
        this.useModifiedScreenDataForNativeTransientUIComponent = pendoOptions.getUseModifiedScreenDataForNativeTransientUIComponent();
    }

    private final void p() {
        SharedPreferences sharedPreferencesA = n0.a("pendo_screen_manager");
        if (sharedPreferencesA != null) {
            SharedPreferences.Editor editor = sharedPreferencesA.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            editor.putBoolean("includePageViewTexts", this.includePageViewTexts);
            editor.putBoolean("includeFeatureClickTexts", this.includeFeatureClickTexts);
            editor.putBoolean("includeFeatureClickNestedTexts", this.includeFeatureClickNestedTexts);
            editor.putBoolean("includeRetroElementCompatibilityHashes", this.includeRetroElementCompatibilityHashes);
            editor.putBoolean("isOldScreenIdFormat", this.isOldScreenIdFormat);
            editor.putBoolean("ignoreDynamicFragmentsInScrollView", this.ignoreDynamicFragmentsInScrollView);
            editor.putBoolean("isRespondToScrollChangeEventsForScreenId", this.isRespondToScrollChangeEventsForScreenId);
            editor.putLong("globalLayoutChangeDebouncer", this.globalLayoutChangeEventsDebouncer);
            editor.commit();
        }
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getDisableBackCapture() {
        return this.disableBackCapture;
    }

    public final Set<KClass<? extends View>> b() {
        return this.excludedViewTypes;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getGlobalLayoutChangeEventsDebouncer() {
        return this.globalLayoutChangeEventsDebouncer;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getIgnoreDynamicFragmentsInScrollView() {
        return this.ignoreDynamicFragmentsInScrollView;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final boolean getIncludeFeatureClickNestedTexts() {
        return this.includeFeatureClickNestedTexts;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getIncludeFeatureClickTexts() {
        return this.includeFeatureClickTexts;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getIncludeRetroElementCompatibilityHashes() {
        return this.includeRetroElementCompatibilityHashes;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getShouldExcludeGhostElementsForCapture() {
        return this.shouldExcludeGhostElementsForCapture;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getShouldForceHandleGlobalLayoutChange() {
        return this.shouldForceHandleGlobalLayoutChange;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getShouldIgnoreDynamicElementsDuringScan() {
        return this.shouldIgnoreDynamicElementsDuringScan;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getUseModifiedScreenDataForNativeTransientUIComponent() {
        return this.useModifiedScreenDataForNativeTransientUIComponent;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final boolean getUseOnlyXamarinBridgeProvidedScreenId() {
        return this.useOnlyXamarinBridgeProvidedScreenId;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final boolean getIsOldScreenIdFormat() {
        return this.isOldScreenIdFormat;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final boolean getIsRespondToScrollChangeEventsForScreenId() {
        return this.isRespondToScrollChangeEventsForScreenId;
    }

    public final void o() {
        SharedPreferences sharedPreferencesA = n0.a("pendo_screen_manager");
        if (sharedPreferencesA != null) {
            this.includePageViewTexts = sharedPreferencesA.getBoolean("includePageViewTexts", this.includePageViewTexts);
            this.includeFeatureClickTexts = sharedPreferencesA.getBoolean("includeFeatureClickTexts", this.includeFeatureClickTexts);
            this.includeFeatureClickNestedTexts = sharedPreferencesA.getBoolean("includeFeatureClickNestedTexts", this.includeFeatureClickNestedTexts);
            this.includeRetroElementCompatibilityHashes = sharedPreferencesA.getBoolean("includeRetroElementCompatibilityHashes", this.includeRetroElementCompatibilityHashes);
            this.isOldScreenIdFormat = sharedPreferencesA.getBoolean("isOldScreenIdFormat", true);
        }
        Object objValueOf = Boolean.valueOf(sharedPreferencesA != null ? sharedPreferencesA.getBoolean("ignoreDynamicFragmentsInScrollView", true) : true);
        Map<String, Object> additionalOptions = this.pendoOptions.getAdditionalOptions();
        Object obj = additionalOptions != null ? additionalOptions.get("ignoreDynamicFragmentsInScrollView") : null;
        if (obj != null && (obj instanceof Boolean)) {
            objValueOf = obj;
        }
        this.ignoreDynamicFragmentsInScrollView = ((Boolean) objValueOf).booleanValue();
        Object objValueOf2 = Boolean.valueOf(sharedPreferencesA != null ? sharedPreferencesA.getBoolean("isRespondToScrollChangeEventsForScreenId", false) : false);
        Map<String, Object> additionalOptions2 = this.pendoOptions.getAdditionalOptions();
        Object obj2 = additionalOptions2 != null ? additionalOptions2.get("isRespondToScrollChangeEventsForScreenId") : null;
        if (obj2 != null && (obj2 instanceof Boolean)) {
            objValueOf2 = obj2;
        }
        this.isRespondToScrollChangeEventsForScreenId = ((Boolean) objValueOf2).booleanValue();
        Object objValueOf3 = Long.valueOf(sharedPreferencesA != null ? sharedPreferencesA.getLong("globalLayoutChangeDebouncer", 100L) : 100L);
        Map<String, Object> additionalOptions3 = this.pendoOptions.getAdditionalOptions();
        Object obj3 = additionalOptions3 != null ? additionalOptions3.get("globalLayoutChangeDebouncer") : null;
        if (obj3 != null && (obj3 instanceof Long)) {
            objValueOf3 = obj3;
        }
        this.globalLayoutChangeEventsDebouncer = ((Number) objValueOf3).longValue();
        Object obj4 = Boolean.FALSE;
        Map<String, Object> additionalOptions4 = this.pendoOptions.getAdditionalOptions();
        Object obj5 = additionalOptions4 != null ? additionalOptions4.get("disableBackCapture") : null;
        if (obj5 == null || !(obj5 instanceof Boolean)) {
            obj5 = obj4;
        }
        this.disableBackCapture = ((Boolean) obj5).booleanValue();
        Map<String, Object> additionalOptions5 = this.pendoOptions.getAdditionalOptions();
        Object obj6 = additionalOptions5 != null ? additionalOptions5.get("shouldIgnoreDynamicElementsDuringScan") : null;
        if (obj6 == null || !(obj6 instanceof Boolean)) {
            obj6 = obj4;
        }
        this.shouldIgnoreDynamicElementsDuringScan = ((Boolean) obj6).booleanValue();
        Map<String, Object> additionalOptions6 = this.pendoOptions.getAdditionalOptions();
        Object obj7 = additionalOptions6 != null ? additionalOptions6.get("forceHandleGlobalLayoutChange") : null;
        if (obj7 != null && (obj7 instanceof Boolean)) {
            obj4 = obj7;
        }
        boolean zBooleanValue = ((Boolean) obj4).booleanValue();
        this.shouldForceHandleGlobalLayoutChange = zBooleanValue;
        PendoLogger.d("ScreenManagerPolicy", "loadPolicy additionalOptions flags - ignoreDynamicFragmentsInScrollView " + this.ignoreDynamicFragmentsInScrollView + ", isRespondToScrollChangeEventsForScreenId " + this.isRespondToScrollChangeEventsForScreenId + ", globalLayoutChangeDebouncer " + this.globalLayoutChangeEventsDebouncer + ", shouldIgnoreDynamicElementsDuringScan " + this.shouldIgnoreDynamicElementsDuringScan + ", shouldForceHandleGlobalLayoutChange " + zBooleanValue);
    }

    public final void a(boolean includePageViewTexts, boolean includeFeatureClickTexts, boolean includeFeatureClickNestedTexts, boolean includeRetroElementCompatibilityHashes, boolean isOldScreenIdFormat, boolean ignoreDynamicFragmentsInScrollView, boolean isRespondToScrollChangeEventsForScreenId, long globalLayoutChangeDebouncer, boolean shouldDetectClicksForAccessibility) {
        this.includePageViewTexts = includePageViewTexts;
        this.includeFeatureClickTexts = includeFeatureClickTexts;
        this.includeFeatureClickNestedTexts = includeFeatureClickTexts && includeFeatureClickNestedTexts;
        this.includeRetroElementCompatibilityHashes = includeRetroElementCompatibilityHashes;
        this.isOldScreenIdFormat = isOldScreenIdFormat;
        Object objValueOf = Boolean.valueOf(ignoreDynamicFragmentsInScrollView);
        Map<String, Object> additionalOptions = this.pendoOptions.getAdditionalOptions();
        Object obj = additionalOptions != null ? additionalOptions.get("ignoreDynamicFragmentsInScrollView") : null;
        if (obj != null && (obj instanceof Boolean)) {
            objValueOf = obj;
        }
        this.ignoreDynamicFragmentsInScrollView = ((Boolean) objValueOf).booleanValue();
        Object objValueOf2 = Boolean.valueOf(isRespondToScrollChangeEventsForScreenId);
        Map<String, Object> additionalOptions2 = this.pendoOptions.getAdditionalOptions();
        Object obj2 = additionalOptions2 != null ? additionalOptions2.get("isRespondToScrollChangeEventsForScreenId") : null;
        if (obj2 != null && (obj2 instanceof Boolean)) {
            objValueOf2 = obj2;
        }
        this.isRespondToScrollChangeEventsForScreenId = ((Boolean) objValueOf2).booleanValue();
        Object objValueOf3 = Long.valueOf(globalLayoutChangeDebouncer);
        Map<String, Object> additionalOptions3 = this.pendoOptions.getAdditionalOptions();
        Object obj3 = additionalOptions3 != null ? additionalOptions3.get("globalLayoutChangeDebouncer") : null;
        if (obj3 != null && (obj3 instanceof Long)) {
            objValueOf3 = obj3;
        }
        this.globalLayoutChangeEventsDebouncer = ((Number) objValueOf3).longValue();
        this.shouldDetectClicksForAccessibility = shouldDetectClicksForAccessibility;
        p();
    }

    public final void b(boolean z) {
        Object objValueOf = Boolean.valueOf(z);
        Map<String, Object> additionalOptions = this.pendoOptions.getAdditionalOptions();
        Object obj = additionalOptions != null ? additionalOptions.get(Pendo.PendoOptions.USE_ONLY_XAMARIN_BRIDGE_PROVIDED_SCREEN_ID) : null;
        if (obj != null && (obj instanceof Boolean)) {
            objValueOf = obj;
        }
        this.useOnlyXamarinBridgeProvidedScreenId = ((Boolean) objValueOf).booleanValue();
    }

    public final void a(boolean z) {
        Object objValueOf = Boolean.valueOf(z);
        Map<String, Object> additionalOptions = this.pendoOptions.getAdditionalOptions();
        Object obj = additionalOptions != null ? additionalOptions.get(Pendo.PendoOptions.USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT) : null;
        if (obj != null && (obj instanceof Boolean)) {
            objValueOf = obj;
        }
        this.useModifiedScreenDataForNativeTransientUIComponent = ((Boolean) objValueOf).booleanValue();
    }
}
