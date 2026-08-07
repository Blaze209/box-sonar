package com.box.android.data.api.models.boxai;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.observability.DiagnosisParams;
import com.facebook.react.modules.dialog.AlertFragment;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiGetAnswerStreamingRequestDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003J[\u0010\"\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0003\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiGetAnswerStreamingRequestDTO;", "", DiagnosisParams.DIAGNOSIS_MODE, "", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", AuthenticationConstants.AAD.QUERY_PROMPT, "itemSession", "contextSession", "aiIntelligenceConfig", "Lcom/box/android/data/api/models/boxai/AiIntelligenceConfigDTO;", "aiAgentConfig", "Lcom/box/android/data/api/models/boxai/AiAgentConfigDTO;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/boxai/AiIntelligenceConfigDTO;Lcom/box/android/data/api/models/boxai/AiAgentConfigDTO;)V", "getMode", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getPrompt", "getItemSession", "getContextSession", "getAiIntelligenceConfig", "()Lcom/box/android/data/api/models/boxai/AiIntelligenceConfigDTO;", "getAiAgentConfig", "()Lcom/box/android/data/api/models/boxai/AiAgentConfigDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiGetAnswerStreamingRequestDTO {
    private final AiAgentConfigDTO aiAgentConfig;
    private final AiIntelligenceConfigDTO aiIntelligenceConfig;
    private final String contextSession;
    private final String itemSession;
    private final List<ItemIdDTO> items;
    private final String mode;
    private final String prompt;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AiGetAnswerStreamingRequestDTO copy$default(AiGetAnswerStreamingRequestDTO aiGetAnswerStreamingRequestDTO, String str, List list, String str2, String str3, String str4, AiIntelligenceConfigDTO aiIntelligenceConfigDTO, AiAgentConfigDTO aiAgentConfigDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiGetAnswerStreamingRequestDTO.mode;
        }
        if ((i & 2) != 0) {
            list = aiGetAnswerStreamingRequestDTO.items;
        }
        if ((i & 4) != 0) {
            str2 = aiGetAnswerStreamingRequestDTO.prompt;
        }
        if ((i & 8) != 0) {
            str3 = aiGetAnswerStreamingRequestDTO.itemSession;
        }
        if ((i & 16) != 0) {
            str4 = aiGetAnswerStreamingRequestDTO.contextSession;
        }
        if ((i & 32) != 0) {
            aiIntelligenceConfigDTO = aiGetAnswerStreamingRequestDTO.aiIntelligenceConfig;
        }
        if ((i & 64) != 0) {
            aiAgentConfigDTO = aiGetAnswerStreamingRequestDTO.aiAgentConfig;
        }
        AiIntelligenceConfigDTO aiIntelligenceConfigDTO2 = aiIntelligenceConfigDTO;
        AiAgentConfigDTO aiAgentConfigDTO2 = aiAgentConfigDTO;
        String str5 = str4;
        String str6 = str2;
        return aiGetAnswerStreamingRequestDTO.copy(str, list, str6, str3, str5, aiIntelligenceConfigDTO2, aiAgentConfigDTO2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final List<ItemIdDTO> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getItemSession() {
        return this.itemSession;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContextSession() {
        return this.contextSession;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final AiIntelligenceConfigDTO getAiIntelligenceConfig() {
        return this.aiIntelligenceConfig;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final AiAgentConfigDTO getAiAgentConfig() {
        return this.aiAgentConfig;
    }

    public final AiGetAnswerStreamingRequestDTO copy(@Json(name = DiagnosisParams.DIAGNOSIS_MODE) String mode, @Json(name = AlertFragment.ARG_ITEMS) List<ItemIdDTO> items, @Json(name = AuthenticationConstants.AAD.QUERY_PROMPT) String prompt, @Json(name = "item_session") String itemSession, @Json(name = "context_session") String contextSession, @Json(name = "config") AiIntelligenceConfigDTO aiIntelligenceConfig, @Json(name = "aiAgent") AiAgentConfigDTO aiAgentConfig) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(aiAgentConfig, "aiAgentConfig");
        return new AiGetAnswerStreamingRequestDTO(mode, items, prompt, itemSession, contextSession, aiIntelligenceConfig, aiAgentConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiGetAnswerStreamingRequestDTO)) {
            return false;
        }
        AiGetAnswerStreamingRequestDTO aiGetAnswerStreamingRequestDTO = (AiGetAnswerStreamingRequestDTO) other;
        return Intrinsics.areEqual(this.mode, aiGetAnswerStreamingRequestDTO.mode) && Intrinsics.areEqual(this.items, aiGetAnswerStreamingRequestDTO.items) && Intrinsics.areEqual(this.prompt, aiGetAnswerStreamingRequestDTO.prompt) && Intrinsics.areEqual(this.itemSession, aiGetAnswerStreamingRequestDTO.itemSession) && Intrinsics.areEqual(this.contextSession, aiGetAnswerStreamingRequestDTO.contextSession) && Intrinsics.areEqual(this.aiIntelligenceConfig, aiGetAnswerStreamingRequestDTO.aiIntelligenceConfig) && Intrinsics.areEqual(this.aiAgentConfig, aiGetAnswerStreamingRequestDTO.aiAgentConfig);
    }

    public int hashCode() {
        int iHashCode = ((((this.mode.hashCode() * 31) + this.items.hashCode()) * 31) + this.prompt.hashCode()) * 31;
        String str = this.itemSession;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.contextSession;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        AiIntelligenceConfigDTO aiIntelligenceConfigDTO = this.aiIntelligenceConfig;
        return ((iHashCode3 + (aiIntelligenceConfigDTO != null ? aiIntelligenceConfigDTO.hashCode() : 0)) * 31) + this.aiAgentConfig.hashCode();
    }

    public String toString() {
        return "AiGetAnswerStreamingRequestDTO(mode=" + this.mode + ", items=" + this.items + ", prompt=" + this.prompt + ", itemSession=" + this.itemSession + ", contextSession=" + this.contextSession + ", aiIntelligenceConfig=" + this.aiIntelligenceConfig + ", aiAgentConfig=" + this.aiAgentConfig + ")";
    }

    public AiGetAnswerStreamingRequestDTO(@Json(name = DiagnosisParams.DIAGNOSIS_MODE) String mode, @Json(name = AlertFragment.ARG_ITEMS) List<ItemIdDTO> items, @Json(name = AuthenticationConstants.AAD.QUERY_PROMPT) String prompt, @Json(name = "item_session") String str, @Json(name = "context_session") String str2, @Json(name = "config") AiIntelligenceConfigDTO aiIntelligenceConfigDTO, @Json(name = "aiAgent") AiAgentConfigDTO aiAgentConfig) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(aiAgentConfig, "aiAgentConfig");
        this.mode = mode;
        this.items = items;
        this.prompt = prompt;
        this.itemSession = str;
        this.contextSession = str2;
        this.aiIntelligenceConfig = aiIntelligenceConfigDTO;
        this.aiAgentConfig = aiAgentConfig;
    }

    public /* synthetic */ AiGetAnswerStreamingRequestDTO(String str, List list, String str2, String str3, String str4, AiIntelligenceConfigDTO aiIntelligenceConfigDTO, AiAgentConfigDTO aiAgentConfigDTO, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : aiIntelligenceConfigDTO, aiAgentConfigDTO);
    }

    public final String getMode() {
        return this.mode;
    }

    public final List<ItemIdDTO> getItems() {
        return this.items;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getItemSession() {
        return this.itemSession;
    }

    public final String getContextSession() {
        return this.contextSession;
    }

    public final AiIntelligenceConfigDTO getAiIntelligenceConfig() {
        return this.aiIntelligenceConfig;
    }

    public final AiAgentConfigDTO getAiAgentConfig() {
        return this.aiAgentConfig;
    }
}
