package com.box.brownfieldApi.featuresNavigator;

import android.os.Bundle;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.margelo.nitro.boxcontext.ItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B;\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/AiCenterInitialContext;", "", AiCenterInitialContext.INITIAL_ITEMS_KEY, "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", AiCenterInitialContext.INITIAL_PROMPT_KEY, "", AiCenterInitialContext.INITIAL_SOURCE_KEY, AiCenterInitialContext.INITIAL_SOURCE_CONTEXT_ID_KEY, "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInitialItems", "()Ljava/util/List;", "getInitialPrompt", "()Ljava/lang/String;", "getInitialSource", "getInitialSourceContextId", "toLaunchOptions", "Landroid/os/Bundle;", "writeTo", "", "bundle", "writeTo$brownfieldApi_release", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AiCenterInitialContext {
    public static final String INITIAL_ITEMS_KEY = "initialItems";
    public static final String INITIAL_PROMPT_KEY = "initialPrompt";
    public static final String INITIAL_SOURCE_CONTEXT_ID_KEY = "initialSourceContextId";
    public static final String INITIAL_SOURCE_KEY = "initialSource";
    private final List<ItemInfo> initialItems;
    private final String initialPrompt;
    private final String initialSource;
    private final String initialSourceContextId;
    public static final int $stable = 8;

    public AiCenterInitialContext() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AiCenterInitialContext copy$default(AiCenterInitialContext aiCenterInitialContext, List list, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = aiCenterInitialContext.initialItems;
        }
        if ((i & 2) != 0) {
            str = aiCenterInitialContext.initialPrompt;
        }
        if ((i & 4) != 0) {
            str2 = aiCenterInitialContext.initialSource;
        }
        if ((i & 8) != 0) {
            str3 = aiCenterInitialContext.initialSourceContextId;
        }
        return aiCenterInitialContext.copy(list, str, str2, str3);
    }

    public final List<ItemInfo> component1() {
        return this.initialItems;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInitialPrompt() {
        return this.initialPrompt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInitialSource() {
        return this.initialSource;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInitialSourceContextId() {
        return this.initialSourceContextId;
    }

    public final AiCenterInitialContext copy(List<ItemInfo> initialItems, String initialPrompt, String initialSource, String initialSourceContextId) {
        Intrinsics.checkNotNullParameter(initialItems, "initialItems");
        return new AiCenterInitialContext(initialItems, initialPrompt, initialSource, initialSourceContextId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiCenterInitialContext)) {
            return false;
        }
        AiCenterInitialContext aiCenterInitialContext = (AiCenterInitialContext) other;
        return Intrinsics.areEqual(this.initialItems, aiCenterInitialContext.initialItems) && Intrinsics.areEqual(this.initialPrompt, aiCenterInitialContext.initialPrompt) && Intrinsics.areEqual(this.initialSource, aiCenterInitialContext.initialSource) && Intrinsics.areEqual(this.initialSourceContextId, aiCenterInitialContext.initialSourceContextId);
    }

    public int hashCode() {
        int iHashCode = this.initialItems.hashCode() * 31;
        String str = this.initialPrompt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.initialSource;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.initialSourceContextId;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AiCenterInitialContext(initialItems=" + this.initialItems + ", initialPrompt=" + this.initialPrompt + ", initialSource=" + this.initialSource + ", initialSourceContextId=" + this.initialSourceContextId + ")";
    }

    public AiCenterInitialContext(List<ItemInfo> initialItems, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(initialItems, "initialItems");
        this.initialItems = initialItems;
        this.initialPrompt = str;
        this.initialSource = str2;
        this.initialSourceContextId = str3;
    }

    public /* synthetic */ AiCenterInitialContext(List list, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final List<ItemInfo> getInitialItems() {
        return this.initialItems;
    }

    public final String getInitialPrompt() {
        return this.initialPrompt;
    }

    public final String getInitialSource() {
        return this.initialSource;
    }

    public final String getInitialSourceContextId() {
        return this.initialSourceContextId;
    }

    public final Bundle toLaunchOptions() {
        Bundle bundle = new Bundle();
        writeTo$brownfieldApi_release(bundle);
        return bundle;
    }

    public final void writeTo$brownfieldApi_release(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.initialItems.isEmpty()) {
            bundle.putString(INITIAL_ITEMS_KEY, AICenterComposeKt.encodeItemsAsJson(this.initialItems));
        }
        String str = this.initialPrompt;
        if (str != null) {
            bundle.putString(INITIAL_PROMPT_KEY, str);
        }
        String str2 = this.initialSource;
        if (str2 != null) {
            bundle.putString(INITIAL_SOURCE_KEY, str2);
        }
        String str3 = this.initialSourceContextId;
        if (str3 != null) {
            bundle.putString(INITIAL_SOURCE_CONTEXT_ID_KEY, str3);
        }
    }
}
