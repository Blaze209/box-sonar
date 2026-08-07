package com.box.android.data.mappers;

import com.box.android.data.fragment.ItemConnectionEdgesOnlyFragment;
import com.box.android.data.fragment.ItemConnectionFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemConnectionEdgesToItemConnectionEdgesOnlyMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¨\u0006\t"}, d2 = {"Lcom/box/android/data/mappers/ItemConnectionEdgesToItemConnectionEdgesOnlyMapper;", "", "<init>", "()V", "convert", "", "Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment$Edge;", "originalEdges", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemConnectionEdgesToItemConnectionEdgesOnlyMapper {
    public static final ItemConnectionEdgesToItemConnectionEdgesOnlyMapper INSTANCE = new ItemConnectionEdgesToItemConnectionEdgesOnlyMapper();

    private ItemConnectionEdgesToItemConnectionEdgesOnlyMapper() {
    }

    public final List<ItemConnectionEdgesOnlyFragment.Edge> convert(List<ItemConnectionFragment.Edge> originalEdges) {
        Intrinsics.checkNotNullParameter(originalEdges, "originalEdges");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = originalEdges.iterator();
        while (it.hasNext()) {
            arrayList.add(new ItemConnectionEdgesOnlyFragment.Edge(((ItemConnectionFragment.Edge) it.next()).getId()));
        }
        return arrayList;
    }
}
