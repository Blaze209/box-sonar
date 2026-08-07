package com.box.android.base.presentation.utilities;

import android.content.Intent;
import android.os.AsyncTask;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.base.presentation.fragments.BaseFTUX;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class FTUXController {
    private static HashMap<FTUXTrigger, ArrayList<BaseFTUX.FTUXType>> triggerToFTUXMap;
    private final BaseFTUX.FTUXFactory ftuxFactory;

    public enum FTUXTrigger {
        PREVIEW_CLOSED,
        OFFLINING_ITEM,
        SHARED_OR_COLLABORATED_ITEM
    }

    static {
        HashMap<FTUXTrigger, ArrayList<BaseFTUX.FTUXType>> map = new HashMap<>();
        triggerToFTUXMap = map;
        map.put(FTUXTrigger.PREVIEW_CLOSED, new ArrayList<>(Arrays.asList(BaseFTUX.FTUXType.RATE)));
        triggerToFTUXMap.put(FTUXTrigger.OFFLINING_ITEM, new ArrayList<>(Collections.singletonList(BaseFTUX.FTUXType.RATE)));
        triggerToFTUXMap.put(FTUXTrigger.SHARED_OR_COLLABORATED_ITEM, new ArrayList<>(Collections.singletonList(BaseFTUX.FTUXType.RATE)));
    }

    @Inject
    public FTUXController(BaseFTUX.FTUXFactory fTUXFactory) {
        this.ftuxFactory = fTUXFactory;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.box.android.base.presentation.utilities.FTUXController$1] */
    public void evaluateTrigger(FTUXTrigger fTUXTrigger) {
        final ArrayList<BaseFTUX.FTUXType> arrayList = triggerToFTUXMap.get(fTUXTrigger);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        new AsyncTask<Void, Void, BaseFTUX.FTUXType>() { // from class: com.box.android.base.presentation.utilities.FTUXController.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public BaseFTUX.FTUXType doInBackground(Void... voidArr) {
                for (BaseFTUX.FTUXType fTUXType : arrayList) {
                    BaseFTUX baseFTUXCreateFTUX = FTUXController.this.ftuxFactory.createFTUX(fTUXType);
                    if (baseFTUXCreateFTUX != null && baseFTUXCreateFTUX.shouldShow()) {
                        return baseFTUXCreateFTUX.getType();
                    }
                    if (baseFTUXCreateFTUX == null) {
                        BoxLogUtils.logException("unhandled ftux", fTUXType.toString(), new RuntimeException("unhandled ftux"));
                    }
                }
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(BaseFTUX.FTUXType fTUXType) {
                if (fTUXType != null) {
                    Intent intent = new Intent();
                    intent.setAction(BaseFTUX.EXTRA_ACTION_SHOW_FTUX);
                    intent.putExtra(BaseFTUX.EXTRA_FTUX_TYPE_NAME, fTUXType.name());
                    LocalBroadcastManager.getInstance(ApplicationProvider.getApplication()).sendBroadcast(intent);
                }
            }
        }.execute(new Void[0]);
    }
}
