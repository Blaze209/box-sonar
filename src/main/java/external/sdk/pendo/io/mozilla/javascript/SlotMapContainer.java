package external.sdk.pendo.io.mozilla.javascript;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
class SlotMapContainer implements SlotMap {
    private static final int LARGE_HASH_SIZE = 2000;
    protected SlotMap map;

    SlotMapContainer(int i) {
        this.map = i > 2000 ? new HashSlotMap() : new EmbeddedSlotMap();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        checkMapSize();
        this.map.addSlot(slot);
    }

    protected void checkMapSize() {
        SlotMap slotMap = this.map;
        if (!(slotMap instanceof EmbeddedSlotMap) || slotMap.size() < 2000) {
            return;
        }
        HashSlotMap hashSlotMap = new HashSlotMap();
        Iterator<ScriptableObject.Slot> it = this.map.iterator();
        while (it.hasNext()) {
            hashSlotMap.addSlot(it.next());
        }
        this.map = hashSlotMap;
    }

    public int dirtySize() {
        return this.map.size();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public ScriptableObject.Slot get(Object obj, int i, ScriptableObject.SlotAccess slotAccess) {
        if (slotAccess != ScriptableObject.SlotAccess.QUERY) {
            checkMapSize();
        }
        return this.map.get(obj, i, slotAccess);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return this.map.iterator();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i) {
        return this.map.query(obj, i);
    }

    public long readLock() {
        return 0L;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public void remove(Object obj, int i) {
        this.map.remove(obj, i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public int size() {
        return this.map.size();
    }

    public void unlockRead(long j) {
    }
}
