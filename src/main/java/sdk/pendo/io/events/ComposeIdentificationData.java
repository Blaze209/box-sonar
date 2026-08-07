package sdk.pendo.io.events;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\u001e\u0010\u0016\u001a\u00020\u00142\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aJ\u0014\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0004J\u0010\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010\u0004J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0004J\u0012\u0010*\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J(\u0010-\u001a\u00020\u0014*\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u00100\u001a\u000201H\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lsdk/pendo/io/events/ComposeIdentificationData;", "Lsdk/pendo/io/events/IdentificationData;", "()V", "composeRole", "", ComposeIdentificationData.FIELD_DEPTH, ComposeIdentificationData.HIERARCHY, "isEditableText", "", "isSelectable", "isToggleable", ComposeIdentificationData.PENDO_TAG_BASE64, "pendoTagHashed", ComposeIdentificationData.FIELD_TEST_TAG_BASE64, "testTagHashed", "createRetroElementTexts", "Lorg/json/JSONObject;", "createTagIdentifiers", "Lorg/json/JSONArray;", "setAccessibility", "", "label", "setDepth", "depthArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setHierarchy", "hierarchyList", "", "setIsEditableText", "isEditable", "setIsSelectable", "setIsToggleable", "setPendoTagBase64", IdentificationData.FIELD_TEXT_BASE64, "setPendoTagHashed", "hash", "setRole", "role", "setTestTagBase64", "setTestTagHashed", "setText", "text", "toJSON", "addIdentifierIfValid", "base64", "hashed", "source", "Lsdk/pendo/io/events/TagsIdentifier$Source;", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ComposeIdentificationData extends IdentificationData {
    public static final String FIELD_COMPOSE_ROLE = "role";
    public static final String FIELD_DEPTH = "depth";
    public static final String FIELD_IS_EDITABLE_TEXT = "editable";
    public static final String FIELD_IS_SELECTABLE = "selectable";
    public static final String FIELD_IS_TOGGLEABLE = "toggleable";
    public static final String FIELD_TEST_TAG_BASE64 = "testTagBase64";
    public static final String FIELD_TEST_TAG_HASHED = "testTag";
    public static final String HIERARCHY = "hierarchy";
    public static final String PENDO_TAG_BASE64 = "pendoTagBase64";
    public static final String PENDO_TAG_HASHED = "pendoTag";

    @c("pendoComposeRole")
    private String composeRole;

    @c(FIELD_DEPTH)
    private String depth;

    @c(HIERARCHY)
    private String hierarchy;

    @c("isEditable")
    private boolean isEditableText;

    @c("isSelectable")
    private boolean isSelectable;

    @c("isToggleable")
    private boolean isToggleable;

    @c(PENDO_TAG_BASE64)
    private String pendoTagBase64;

    @c("pendoTagHash")
    private String pendoTagHashed;

    @c(FIELD_TEST_TAG_BASE64)
    private String testTagBase64;

    @c("testTagHash")
    private String testTagHashed;

    private final void addIdentifierIfValid(JSONArray jSONArray, String str, String str2, TagsIdentifier.Source source) {
        if (str == null || str2 == null) {
            return;
        }
        jSONArray.put(new TagsIdentifier(str2, str, source).toJSON());
    }

    @Override // sdk.pendo.io.events.IdentificationData
    public JSONObject createRetroElementTexts() {
        JSONObject jSONObjectCreateRetroElementTexts = super.createRetroElementTexts();
        if ((this.pendoTagBase64 != null || this.testTagBase64 != null) && jSONObjectCreateRetroElementTexts == null) {
            jSONObjectCreateRetroElementTexts = new JSONObject();
        }
        if (jSONObjectCreateRetroElementTexts == null) {
            return null;
        }
        String str = this.pendoTagBase64;
        if (str != null) {
            jSONObjectCreateRetroElementTexts.put(PENDO_TAG_BASE64, str);
        }
        String str2 = this.testTagBase64;
        if (str2 != null) {
            jSONObjectCreateRetroElementTexts.put(FIELD_TEST_TAG_BASE64, str2);
        }
        return jSONObjectCreateRetroElementTexts;
    }

    @Override // sdk.pendo.io.events.IdentificationData
    public JSONArray createTagIdentifiers() {
        JSONArray jSONArrayCreateTagIdentifiers = super.createTagIdentifiers();
        Intrinsics.checkNotNullExpressionValue(jSONArrayCreateTagIdentifiers, "createTagIdentifiers(...)");
        addIdentifierIfValid(jSONArrayCreateTagIdentifiers, this.pendoTagBase64, this.pendoTagHashed, TagsIdentifier.Source.PENDO_TAG);
        addIdentifierIfValid(jSONArrayCreateTagIdentifiers, this.testTagBase64, this.testTagHashed, TagsIdentifier.Source.TEST_TAG);
        return jSONArrayCreateTagIdentifiers;
    }

    @Override // sdk.pendo.io.events.IdentificationData
    public void setAccessibility(String label) {
    }

    public final void setDepth(ArrayList<Integer> depthArray) {
        Intrinsics.checkNotNullParameter(depthArray, "depthArray");
        this.depth = depthArray.toString();
    }

    public final void setHierarchy(List<String> hierarchyList) {
        Intrinsics.checkNotNullParameter(hierarchyList, "hierarchyList");
        this.hierarchy = hierarchyList.toString();
    }

    public final void setIsEditableText(boolean isEditable) {
        this.isEditableText = isEditable;
    }

    public final void setIsSelectable(boolean isSelectable) {
        this.isSelectable = isSelectable;
    }

    public final void setIsToggleable(boolean isToggleable) {
        this.isToggleable = isToggleable;
    }

    public final void setPendoTagBase64(String textBase64) {
        Intrinsics.checkNotNullParameter(textBase64, "textBase64");
        this.pendoTagBase64 = textBase64;
    }

    public final void setPendoTagHashed(String hash) {
        this.pendoTagHashed = hash;
    }

    public final void setRole(String role) {
        this.composeRole = role;
    }

    public final void setTestTagBase64(String textBase64) {
        Intrinsics.checkNotNullParameter(textBase64, "textBase64");
        this.testTagBase64 = textBase64;
    }

    public final void setTestTagHashed(String hash) {
        this.testTagHashed = hash;
    }

    @Override // sdk.pendo.io.events.IdentificationData
    public void setText(String text) {
    }

    @Override // sdk.pendo.io.events.IdentificationData
    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String rAPredicate = getRAPredicate();
        if (rAPredicate != null) {
            jSONObject.put(IdentificationData.RA_PREDICATE, rAPredicate);
        }
        String accessibilityHashed = getAccessibilityHashed();
        if (accessibilityHashed != null && accessibilityHashed.length() != 0) {
            jSONObject.put("accessibility", new JSONObject().put("label", getAccessibilityHashed()));
        }
        String textHashed = getTextHashed();
        if (textHashed != null && textHashed.length() != 0) {
            jSONObject.put("text", getTextHashed());
        }
        String str = this.pendoTagHashed;
        if (str != null) {
            jSONObject.put(PENDO_TAG_HASHED, str);
        }
        String str2 = this.testTagHashed;
        if (str2 != null) {
            jSONObject.put(FIELD_TEST_TAG_HASHED, str2);
        }
        Integer indexInParent = getIndexInParent();
        Intrinsics.checkNotNullExpressionValue(indexInParent, "getIndexInParent(...)");
        jSONObject.put(IdentificationData.FIELD_INDEX_IN_PARENT, indexInParent.intValue());
        String str3 = this.composeRole;
        if (str3 != null) {
            jSONObject.put("role", str3);
        }
        if (this.isSelectable) {
            jSONObject.put(FIELD_IS_SELECTABLE, true);
        }
        if (this.isToggleable) {
            jSONObject.put(FIELD_IS_TOGGLEABLE, true);
        }
        if (this.isEditableText) {
            jSONObject.put(FIELD_IS_EDITABLE_TEXT, true);
        }
        String str4 = this.depth;
        if (str4 != null && !StringsKt.isBlank(str4)) {
            jSONObject.put(FIELD_DEPTH, this.depth);
        }
        String str5 = this.hierarchy;
        if (str5 != null && !StringsKt.isBlank(str5)) {
            jSONObject.put(HIERARCHY, this.hierarchy);
        }
        return jSONObject;
    }
}
