package com.apollographql.apollo3.api;

import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: fakeResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\f\u0010\u0019\u001a\u00020\u0013*\u00020\u000bH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\r\u0012\t\u0012\u00070\b¢\u0006\u0002\b\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/apollographql/apollo3/api/DefaultFakeResolver;", "Lcom/apollographql/apollo3/api/FakeResolver;", "types", "", "Lcom/apollographql/apollo3/api/CompiledNamedType;", "(Ljava/util/List;)V", "allTypes", "enumTypes", "Lcom/apollographql/apollo3/api/EnumType;", "Lkotlin/internal/NoInfer;", "resolveLeaf", "", "context", "Lcom/apollographql/apollo3/api/FakeResolverContext;", "resolveListSize", "", "resolveMaybeNull", "", "resolveTypename", "", "stableIdForObject", "obj", "", "mergedField", "Lcom/apollographql/apollo3/api/CompiledField;", "toPathComponent", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class DefaultFakeResolver implements FakeResolver {
    private final List<CompiledNamedType> allTypes;
    private final List<EnumType> enumTypes;

    @Override // com.apollographql.apollo3.api.FakeResolver
    public int resolveListSize(FakeResolverContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return 3;
    }

    @Override // com.apollographql.apollo3.api.FakeResolver
    public boolean resolveMaybeNull(FakeResolverContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultFakeResolver(List<? extends CompiledNamedType> types) {
        Intrinsics.checkNotNullParameter(types, "types");
        ArrayList arrayList = new ArrayList();
        for (Object obj : types) {
            if (obj instanceof EnumType) {
                arrayList.add(obj);
            }
        }
        this.enumTypes = arrayList;
        this.allTypes = types;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0107  */
    /* JADX WARN: Code duplicated, block: B:51:0x012a  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v9 java.lang.Object, still in use, count: 2, list:
          (r1v9 java.lang.Object) from 0x0103: PHI (r1 I:??) = (r1v2 java.lang.Object), (r1v9 java.lang.Object) binds: [B:46:0x0102, B:57:0x0103] A[DONT_GENERATE, DONT_INLINE]
          (r1v9 java.lang.Object) from 0x00f5: CHECK_CAST (com.apollographql.apollo3.api.EnumType) (r1v9 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // com.apollographql.apollo3.api.FakeResolver
    public java.lang.Object resolveLeaf(com.apollographql.apollo3.api.FakeResolverContext r10) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.api.DefaultFakeResolver.resolveLeaf(com.apollographql.apollo3.api.FakeResolverContext):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toPathComponent(Object obj) {
        return obj instanceof Integer ? "[" + obj + AbstractJsonLexerKt.END_LIST : obj.toString();
    }

    @Override // com.apollographql.apollo3.api.FakeResolver
    public String resolveTypename(FakeResolverContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<ObjectType> listPossibleTypes = PossibleTypes.possibleTypes(this.allTypes, context.getMergedField().getType().rawType());
        int iHashCode = context.getId().hashCode();
        int size = listPossibleTypes.size();
        int i = iHashCode % size;
        return listPossibleTypes.get(i + (size & (((i ^ size) & ((-i) | i)) >> 31))).getName();
    }

    @Override // com.apollographql.apollo3.api.FakeResolver
    public String stableIdForObject(Map<String, ? extends Object> obj, CompiledField mergedField) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(mergedField, "mergedField");
        List<String> listKeyFields = CompiledGraphQL.keyFields(mergedField.getType().rawType());
        if (obj.containsKey("__stableId")) {
            return String.valueOf(obj.get("__stableId"));
        }
        if (listKeyFields.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(obj.get(GQLCacheConstants.TYPENAME_KEY)));
        Iterator<T> it = listKeyFields.iterator();
        while (it.hasNext()) {
            sb.append(String.valueOf(obj.get((String) it.next())));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
