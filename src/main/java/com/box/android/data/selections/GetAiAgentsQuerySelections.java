package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.box.android.data.type.AiAgent;
import com.box.android.data.type.AiAgentAskCapability;
import com.box.android.data.type.AiAgentCapabilities;
import com.box.android.data.type.AiAgentConnectionEdge;
import com.box.android.data.type.AiAgentsConnection;
import com.box.android.data.type.GraphQLBoolean;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import com.box.android.observability.DiagnosisParams;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GetAiAgentsQuerySelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/selections/GetAiAgentsQuerySelections;", "", "<init>", "()V", "__ask", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__capabilities", "__node", "__edges", "__filteredForUserAiAgents", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAiAgentsQuerySelections {
    public static final GetAiAgentsQuerySelections INSTANCE = new GetAiAgentsQuerySelections();
    private static final List<CompiledSelection> __ask;
    private static final List<CompiledSelection> __capabilities;
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __filteredForUserAiAgents;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __root;

    private GetAiAgentsQuerySelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf(new CompiledField.Builder("description", GraphQLString.INSTANCE.getType()).build());
        __ask = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf(new CompiledField.Builder("ask", AiAgentAskCapability.INSTANCE.getType()).selections(listListOf).build());
        __capabilities = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("isEnterpriseDefault", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("iconReference", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder(NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, AiAgentCapabilities.INSTANCE.getType()).selections(listListOf2).build()});
        __node = listListOf3;
        List<CompiledSelection> listListOf4 = CollectionsKt.listOf(new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(AiAgent.INSTANCE.getType())).selections(listListOf3).build());
        __edges = listListOf4;
        List<CompiledSelection> listListOf5 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(AiAgentConnectionEdge.INSTANCE.getType())))).selections(listListOf4).build());
        __filteredForUserAiAgents = listListOf5;
        __root = CollectionsKt.listOf(new CompiledField.Builder("filteredForUserAiAgents", CompiledGraphQL.m11195notNull(AiAgentsConnection.INSTANCE.getType())).arguments(CollectionsKt.listOf(new CompiledArgument.Builder(DiagnosisParams.DIAGNOSIS_MODE, "ASK").build())).selections(listListOf5).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
