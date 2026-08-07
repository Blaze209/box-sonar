package io.nutrient.domain.ai;

import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.y;
import io.nutrient.data.models.AiAssistantConfiguration;
import io.nutrient.data.models.CompletionResponse;
import io.nutrient.data.models.DocumentIdentifiers;
import io.nutrient.data.models.IngestionResponse;
import io.nutrient.data.models.None;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\b\u0010\tJ&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H¦@¢\u0006\u0004\b\r\u0010\u000eJ.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0006H¦@¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u0018\u001a\u00020\u0017H¦@¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0017H¦@¢\u0006\u0004\b\u001d\u0010\u001bJ\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010#\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0013H¦@¢\u0006\u0004\b#\u0010$J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010&\u001a\u00020%H¦@¢\u0006\u0004\b#\u0010'J\u0017\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0004H&¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H&¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0019H&¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0017H&¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0017H&¢\u0006\u0004\b3\u00104R\u0016\u0010&\u001a\u0004\u0018\u00010%8&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020!0\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140:8&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>À\u0006\u0003"}, d2 = {"Lio/nutrient/domain/ai/AiAssistant;", "", "Lcom/pspdfkit/document/providers/DataProvider;", "dataProvider", "", "jwt", "Lcom/pspdfkit/internal/y$a;", "Lio/nutrient/data/models/IngestionResponse;", "ingestDocument", "(Lcom/pspdfkit/document/providers/DataProvider;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentId", "fileHash", "Lio/nutrient/data/models/None;", "checkIfDocumentIsAlreadyIngested", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "layerName", "sourcePdfSha256", "instantIngestion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/nutrient/data/models/CompletionResponse;", "getSessionHistory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "includeSessionHistory", "", "initializeSocketConnection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withSessionHistory", "initialize", "documentSelectedText", "emitSelectedText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/nutrient/data/models/DocumentIdentifiers;", "listOfDocumentIdentifiers", "update", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/nutrient/data/models/AiAssistantConfiguration;", "configuration", "(Lio/nutrient/data/models/AiAssistantConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "message", "emitMessage", "(Ljava/lang/String;)V", "contextText", "emitContextSpecificMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "terminate", "()V", "enabled", "enableTextSelection", "(Z)V", "isTextSelectionEnabled", "()Z", "getConfiguration", "()Lio/nutrient/data/models/AiAssistantConfiguration;", "getIdentifiers", "()Ljava/util/List;", "identifiers", "Lkotlinx/coroutines/flow/Flow;", "getResponseState", "()Lkotlinx/coroutines/flow/Flow;", "responseState", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AiAssistant {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object initialize$default(AiAssistant aiAssistant, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return aiAssistant.initialize(z, continuation);
    }

    static /* synthetic */ Object initializeSocketConnection$default(AiAssistant aiAssistant, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initializeSocketConnection");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return aiAssistant.initializeSocketConnection(z, continuation);
    }

    Object checkIfDocumentIsAlreadyIngested(String str, String str2, Continuation<? super y.a<? extends None>> continuation);

    void emitContextSpecificMessage(String message, String contextText);

    void emitMessage(String message);

    Object emitSelectedText(String str, Continuation<? super Unit> continuation);

    void enableTextSelection(boolean enabled);

    AiAssistantConfiguration getConfiguration();

    List<DocumentIdentifiers> getIdentifiers();

    Flow<CompletionResponse> getResponseState();

    Object getSessionHistory(Continuation<? super y.a<? extends List<CompletionResponse>>> continuation);

    Object ingestDocument(DataProvider dataProvider, String str, Continuation<? super y.a<IngestionResponse>> continuation);

    Object initialize(boolean z, Continuation<? super Unit> continuation);

    Object initializeSocketConnection(boolean z, Continuation<? super Unit> continuation);

    Object instantIngestion(String str, String str2, String str3, Continuation<? super y.a<? extends None>> continuation);

    boolean isTextSelectionEnabled();

    void terminate();

    Object update(AiAssistantConfiguration aiAssistantConfiguration, Continuation<? super Unit> continuation);

    Object update(List<DocumentIdentifiers> list, Continuation<? super Unit> continuation);
}
