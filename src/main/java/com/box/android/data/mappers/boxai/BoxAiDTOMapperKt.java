package com.box.android.data.mappers.boxai;

import com.box.android.data.GetAiAgentsQuery;
import com.box.android.data.GetAiSessionsQuery;
import com.box.android.data.api.models.boxai.AiCreateSessionDTO;
import com.box.android.data.api.models.boxai.AiGetAnswerCitationDTO;
import com.box.android.data.api.models.boxai.AiGetAnswerDTO;
import com.box.android.data.api.models.boxai.AiPermissionDTO;
import com.box.android.domain.models.boxai.AiAgentModel;
import com.box.android.domain.models.boxai.AiAnswerStreamingModel;
import com.box.android.domain.models.boxai.AiCitationModel;
import com.box.android.domain.models.boxai.AiPermissionModel;
import com.box.android.domain.models.boxai.AiRecentSession;
import com.box.android.domain.models.boxai.AiSessionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BoxAiDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\u0010\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b\u001a\n\u0010\u0000\u001a\u00020\t*\u00020\n\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006*\u00020\f\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\r0\u0006*\u00020\u000e¨\u0006\u000f"}, d2 = {"toDomain", "Lcom/box/android/domain/models/boxai/AiSessionModel;", "Lcom/box/android/data/api/models/boxai/AiCreateSessionDTO;", "Lcom/box/android/domain/models/boxai/AiPermissionModel;", "Lcom/box/android/data/api/models/boxai/AiPermissionDTO;", "toDomainList", "", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", "Lcom/box/android/domain/models/boxai/AiCitationModel;", "Lcom/box/android/data/api/models/boxai/AiGetAnswerCitationDTO;", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "Lcom/box/android/data/GetAiAgentsQuery$FilteredForUserAiAgents;", "Lcom/box/android/domain/models/boxai/AiRecentSession;", "Lcom/box/android/data/GetAiSessionsQuery$ItemV2s;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiDTOMapperKt {
    public static final AiSessionModel toDomain(AiCreateSessionDTO aiCreateSessionDTO) {
        Intrinsics.checkNotNullParameter(aiCreateSessionDTO, "<this>");
        return new AiSessionModel(aiCreateSessionDTO.getMetadataDTO().isLargeFile(), aiCreateSessionDTO.getEncodedSession());
    }

    public static final AiPermissionModel toDomain(AiPermissionDTO aiPermissionDTO) {
        Intrinsics.checkNotNullParameter(aiPermissionDTO, "<this>");
        return new AiPermissionModel(aiPermissionDTO.isValidUser());
    }

    public static final List<AiAnswerStreamingModel> toDomainList(AiGetAnswerDTO aiGetAnswerDTO) {
        Intrinsics.checkNotNullParameter(aiGetAnswerDTO, "<this>");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (aiGetAnswerDTO.getAnswer() != null) {
            listCreateListBuilder.add(new AiAnswerStreamingModel.AnswerPart(aiGetAnswerDTO.getAnswer()));
        }
        if (!aiGetAnswerDTO.getCitations().isEmpty()) {
            List<AiGetAnswerCitationDTO> citations = aiGetAnswerDTO.getCitations();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(citations, 10));
            Iterator<T> it = citations.iterator();
            while (it.hasNext()) {
                arrayList.add(toDomain((AiGetAnswerCitationDTO) it.next()));
            }
            listCreateListBuilder.add(new AiAnswerStreamingModel.CitationsPart(arrayList));
        }
        if (aiGetAnswerDTO.getContextSession() != null) {
            listCreateListBuilder.add(new AiAnswerStreamingModel.ContextSession(aiGetAnswerDTO.getContextSession()));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static final AiCitationModel toDomain(AiGetAnswerCitationDTO aiGetAnswerCitationDTO) {
        Intrinsics.checkNotNullParameter(aiGetAnswerCitationDTO, "<this>");
        return new AiCitationModel(StringsKt.toIntOrNull(aiGetAnswerCitationDTO.getLocation()), StringsKt.trim((CharSequence) aiGetAnswerCitationDTO.getContent()).toString(), aiGetAnswerCitationDTO.getDocId(), aiGetAnswerCitationDTO.getDocName());
    }

    public static final List<AiAgentModel> toDomain(GetAiAgentsQuery.FilteredForUserAiAgents filteredForUserAiAgents) {
        GetAiAgentsQuery.Ask ask;
        Intrinsics.checkNotNullParameter(filteredForUserAiAgents, "<this>");
        List<GetAiAgentsQuery.Edge> edges = filteredForUserAiAgents.getEdges();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(edges, 10));
        for (GetAiAgentsQuery.Edge edge : edges) {
            String id = edge.getNode().getId();
            String name = edge.getNode().getName();
            boolean zAreEqual = Intrinsics.areEqual((Object) edge.getNode().isEnterpriseDefault(), (Object) true);
            String iconReference = edge.getNode().getIconReference();
            GetAiAgentsQuery.Capabilities capabilities = edge.getNode().getCapabilities();
            arrayList.add(new AiAgentModel(id, name, zAreEqual, iconReference, (capabilities == null || (ask = capabilities.getAsk()) == null) ? null : ask.getDescription()));
        }
        return arrayList;
    }

    public static final List<AiRecentSession> toDomain(GetAiSessionsQuery.ItemV2s itemV2s) {
        String name;
        AiRecentSession aiRecentSession;
        GetAiSessionsQuery.OnAiSessionData onAiSessionData;
        GetAiSessionsQuery.AiAgentSession aiAgentSession;
        Intrinsics.checkNotNullParameter(itemV2s, "<this>");
        List<GetAiSessionsQuery.Edge> edges = itemV2s.getEdges();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = edges.iterator();
        while (it.hasNext()) {
            GetAiSessionsQuery.Node node = ((GetAiSessionsQuery.Edge) it.next()).getNode();
            if (node == null) {
                aiRecentSession = null;
            } else {
                GetAiSessionsQuery.Data1 data = node.getData();
                if ((data == null || (onAiSessionData = data.getOnAiSessionData()) == null || (aiAgentSession = onAiSessionData.getAiAgentSession()) == null || (name = aiAgentSession.getName()) == null) && (name = node.getName()) == null) {
                    name = "";
                }
                aiRecentSession = new AiRecentSession(node.getId(), name);
            }
            if (aiRecentSession != null) {
                arrayList.add(aiRecentSession);
            }
        }
        return arrayList;
    }
}
