package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxClassification.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/box/androidsdk/content/models/BoxClassification;", "Lcom/box/androidsdk/content/models/BoxJsonObject;", "jsonObject", "Lcom/eclipsesource/json/JsonObject;", "<init>", "(Lcom/eclipsesource/json/JsonObject;)V", "getName", "", "getColor", "getDefinition", "toString", "Companion", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxClassification extends BoxJsonObject {
    public static final String FIELD_COLOR = "color";
    public static final String FIELD_DEFINITION = "definition";
    public static final String FIELD_NAME = "name";

    /* JADX WARN: Multi-variable type inference failed */
    public BoxClassification() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BoxClassification(JsonObject jsonObject) {
        super(jsonObject);
    }

    public /* synthetic */ BoxClassification(JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new JsonObject() : jsonObject);
    }

    public final String getName() {
        return getPropertyAsString("name");
    }

    public final String getColor() {
        return getPropertyAsString("color");
    }

    public final String getDefinition() {
        return getPropertyAsString(FIELD_DEFINITION);
    }

    public String toString() {
        return "Classification: " + getName() + " " + getColor() + " " + getDefinition();
    }
}
