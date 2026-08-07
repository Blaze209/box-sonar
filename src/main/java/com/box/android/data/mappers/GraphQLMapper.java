package com.box.android.data.mappers;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: GraphQLMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J#\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/mappers/GraphQLMapper;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "", "toGraphQL", "source", "options", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GraphQLMapper<A, B> {
    A fromGraphQL(B source, Object options);

    B toGraphQL(A source, Object options);

    /* JADX INFO: compiled from: GraphQLMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object toGraphQL$default(GraphQLMapper graphQLMapper, Object obj, Object obj2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toGraphQL");
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        return graphQLMapper.toGraphQL(obj, obj2);
    }

    static /* synthetic */ Object fromGraphQL$default(GraphQLMapper graphQLMapper, Object obj, Object obj2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromGraphQL");
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        return graphQLMapper.fromGraphQL(obj, obj2);
    }
}
