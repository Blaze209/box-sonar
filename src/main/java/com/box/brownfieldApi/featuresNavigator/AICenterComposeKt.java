package com.box.brownfieldApi.featuresNavigator;

import com.box.android.base.presentation.multiselect.SelectionIdKt;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.facebook.react.modules.dialog.AlertFragment;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.margelo.nitro.boxcontext.ItemType;
import com.margelo.nitro.boxcontext.PendingItemError;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\fH\u0002¨\u0006\r"}, d2 = {"encodeItemsAsJson", "", AlertFragment.ARG_ITEMS, "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "itemToJson", "Lorg/json/JSONObject;", "item", "errorToJson", "error", "Lcom/margelo/nitro/boxcontext/PendingItemError;", "toBridgeString", "Lcom/margelo/nitro/boxcontext/ItemType;", "brownfieldApi_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AICenterComposeKt {

    /* JADX INFO: compiled from: AICenterCompose.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.HUB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodeItemsAsJson(List<ItemInfo> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(itemToJson((ItemInfo) it.next()));
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final JSONObject itemToJson(ItemInfo itemInfo) throws JSONException {
        Object objErrorToJson;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", itemInfo.getId().getId());
        jSONObject2.put("type", toBridgeString(itemInfo.getId().getType()));
        Unit unit = Unit.INSTANCE;
        jSONObject.put("id", jSONObject2);
        jSONObject.put("name", itemInfo.getName());
        Object boxId = itemInfo.getBoxId();
        if (boxId == null) {
            boxId = JSONObject.NULL;
        }
        jSONObject.put("boxId", boxId);
        Object sharedLink = itemInfo.getSharedLink();
        if (sharedLink == null) {
            sharedLink = JSONObject.NULL;
        }
        jSONObject.put(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, sharedLink);
        Object itemSource = itemInfo.getItemSource();
        if (itemSource == null) {
            itemSource = JSONObject.NULL;
        }
        jSONObject.put("itemSource", itemSource);
        PendingItemError error = itemInfo.getError();
        if (error == null || (objErrorToJson = errorToJson(error)) == null) {
            objErrorToJson = JSONObject.NULL;
        }
        jSONObject.put("error", objErrorToJson);
        return jSONObject;
    }

    private static final JSONObject errorToJson(PendingItemError pendingItemError) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Object code = pendingItemError.getCode();
        if (code == null) {
            code = JSONObject.NULL;
        }
        jSONObject.put("code", code);
        jSONObject.put("message", pendingItemError.getMessage());
        jSONObject.put("isApiError", pendingItemError.isApiError());
        jSONObject.put("isRetryPossible", pendingItemError.isRetryPossible());
        return jSONObject;
    }

    private static final String toBridgeString(ItemType itemType) {
        int i = WhenMappings.$EnumSwitchMapping$0[itemType.ordinal()];
        if (i == 1) {
            return "file";
        }
        if (i == 2) {
            return "folder";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return SelectionIdKt.HUB_TYPE;
    }
}
