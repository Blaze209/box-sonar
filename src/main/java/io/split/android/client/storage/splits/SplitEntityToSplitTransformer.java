package io.split.android.client.storage.splits;

import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.Split;
import io.split.android.client.storage.cipher.SplitCipher;
import io.split.android.client.storage.db.SplitEntity;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SplitEntityToSplitTransformer implements SplitListTransformer<SplitEntity, Split> {
    private final SplitCipher mSplitCipher;

    public SplitEntityToSplitTransformer(SplitCipher splitCipher) {
        this.mSplitCipher = (SplitCipher) Utils.checkNotNull(splitCipher);
    }

    @Override // io.split.android.client.storage.splits.SplitListTransformer
    @Deprecated
    public List<Split> transform(List<SplitEntity> entities) {
        return new ArrayList();
    }

    @Override // io.split.android.client.storage.splits.SplitListTransformer
    public List<Split> transform(Map<String, SplitEntity> allNamesAndBodies) {
        String strDecrypt;
        if (allNamesAndBodies == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(allNamesAndBodies.size());
        for (Map.Entry<String, SplitEntity> entry : allNamesAndBodies.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                try {
                    String strDecrypt2 = this.mSplitCipher.decrypt(entry.getKey());
                    if (strDecrypt2 != null && (strDecrypt = this.mSplitCipher.decrypt(entry.getValue().getBody())) != null) {
                        arrayList.add(new Split(strDecrypt2, strDecrypt));
                    }
                } catch (JsonSyntaxException unused) {
                    Logger.e("Could not parse entity to split: " + entry.getKey());
                }
            }
        }
        return arrayList;
    }
}
