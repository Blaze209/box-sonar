package com.box.android.coreservices.modelcontroller;

import android.database.AbstractCursor;
import com.box.android.coreservices.models.BoxLocalMetadata;
import com.j256.ormlite.field.FieldType;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/* JADX INFO: loaded from: classes9.dex */
public abstract class MoCoCursor<T> extends AbstractCursor implements Iterable<T> {
    private List<String> mTypedIds;

    public abstract T getItemAt(int i);

    public abstract String getItemIdAt(int i);

    public abstract BoxLocalMetadata getItemLocalMetadataAt(int i);

    public abstract String getItemTypeAt(int i);

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        return ShortCompanionObject.MIN_VALUE;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        return null;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return true;
    }

    protected MoCoCursor(List<String> list) {
        this.mTypedIds = list;
    }

    public T getItem() {
        return getItemAt(getPosition());
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        List<String> list = this.mTypedIds;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<String> getTypedIds() {
        return this.mTypedIds;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: com.box.android.coreservices.modelcontroller.MoCoCursor.1
            private int position = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.position < MoCoCursor.this.getCount();
            }

            @Override // java.util.Iterator
            public T next() {
                MoCoCursor moCoCursor = MoCoCursor.this;
                int i = this.position;
                this.position = i + 1;
                return (T) moCoCursor.getItemAt(i);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("BoxCursor does not implement Iterator.remove()");
            }
        };
    }

    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.mTypedIds.toArray());
        return hashCodeBuilder.toHashCode();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof MoCoCursor)) {
            return new EqualsBuilder().append(this.mTypedIds.toArray(), ((MoCoCursor) obj).mTypedIds.toArray()).isEquals();
        }
        return false;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX};
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        return getPosition();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        return getPosition();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        return getPosition();
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        return getPosition();
    }

    public void setTypedIds(List<String> list) {
        this.mTypedIds = list;
    }
}
