package sdk.pendo.io.actions;

import java.util.List;
import sdk.pendo.io.k3.j;

/* JADX INFO: loaded from: classes4.dex */
public interface GuidePreparationManagerInterface {
    void fetchImages(String str, List<String> list);

    boolean getHasImages(String str);

    j<Boolean> getImagesLoadedAsObservable(String str);

    void prepareGuideImages(int i, String str);
}
