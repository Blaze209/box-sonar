package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.boxai.AiAgentModel;
import com.box.android.domain.models.boxai.AiAnswerStreamingModel;
import com.box.android.domain.models.boxai.AiPermissionModel;
import com.box.android.domain.models.boxai.AiRecentSession;
import com.box.android.domain.models.boxai.AiSessionModel;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IBoxAiService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH¦@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000e\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000e\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0015\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017JT\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00050\u00030\u00192\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH&¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IBoxAiService;", "", "getPermission", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/boxai/AiPermissionModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "isMultidoc", "", "(Lcom/box/android/domain/models/ItemId;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "Lcom/box/android/domain/models/boxai/AiSessionModel;", "itemIds", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAgents", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentAiSessions", "Lcom/box/android/domain/models/boxai/AiRecentSession;", BoxIterator.FIELD_LIMIT, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerQAStreaming", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", AuthenticationConstants.AAD.QUERY_PROMPT, "", "itemSession", "contextSession", "agentId", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBoxAiService {
    Object createSession(List<? extends ItemId> list, Continuation<? super Result<AiSessionModel, ? extends DomainError>> continuation);

    Object getAgents(Continuation<? super Result<? extends List<AiAgentModel>, ? extends DomainError>> continuation);

    Flow<Result<AiAnswerStreamingModel, DomainError>> getAnswerQAStreaming(List<? extends ItemId> itemIds, boolean isMultidoc, String prompt, String itemSession, String contextSession, String agentId);

    Object getPermission(ItemId itemId, boolean z, Continuation<? super Result<AiPermissionModel, ? extends DomainError>> continuation);

    Object getRecentAiSessions(int i, Continuation<? super Result<? extends List<AiRecentSession>, ? extends DomainError>> continuation);
}
