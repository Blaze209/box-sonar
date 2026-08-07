package io.split.android.client.storage.splits;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitListTransformer<I, O> {
    List<O> transform(List<I> inputList);

    List<O> transform(Map<String, I> allNamesAndBodies);
}
