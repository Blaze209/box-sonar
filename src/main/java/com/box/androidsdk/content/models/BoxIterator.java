package com.box.androidsdk.content.models;

import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxIterator<E extends BoxJsonObject> extends BoxJsonObject implements Iterable<E> {
    public static final String FIELD_ENTRIES = "entries";
    public static final String FIELD_LIMIT = "limit";
    public static final String FIELD_NEXT_MARKER = "next_marker";
    public static final String FIELD_OFFSET = "offset";
    public static final String FIELD_ORDER = "order";
    public static final String FIELD_SORT = "sort";
    public static final String FIELD_TOTAL_COUNT = "total_count";
    private static final long serialVersionUID = 8036181424029520417L;

    protected abstract BoxJsonObject.BoxJsonObjectCreator<E> getObjectCreator();

    protected BoxIterator() {
    }

    protected BoxIterator(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxJsonObject
    public void createFromJson(JsonObject jsonObject) {
        super.createFromJson(jsonObject);
    }

    public Long offset() {
        return getPropertyAsLong("offset");
    }

    public Long limit() {
        return getPropertyAsLong(FIELD_LIMIT);
    }

    public Long fullSize() {
        return getPropertyAsLong(FIELD_TOTAL_COUNT);
    }

    public int size() {
        if (getEntries() == null) {
            return 0;
        }
        return getEntries().size();
    }

    public ArrayList<E> getEntries() {
        return (ArrayList<E>) getPropertyAsJsonObjectArray(getObjectCreator(), "entries");
    }

    public E get(int i) {
        return (E) getAs(getObjectCreator(), i);
    }

    public E getAs(BoxJsonObject.BoxJsonObjectCreator<E> boxJsonObjectCreator, int i) {
        return getEntries().get(i);
    }

    public ArrayList<BoxOrder> getSortOrders() {
        return getPropertyAsJsonObjectArray(BoxJsonObject.getBoxJsonObjectCreator(BoxOrder.class), FIELD_ORDER);
    }

    public Iterator<E> iterator() {
        return getEntries() == null ? Collections.emptyList().iterator() : getEntries().iterator();
    }

    public String getNextMarker() {
        return getPropertyAsString(FIELD_NEXT_MARKER);
    }
}
