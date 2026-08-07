package external.sdk.pendo.io.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UintMap implements Serializable {
    private static final int A = -1640531527;
    private static final int DELETED = -2;
    private static final int EMPTY = -1;
    private static final boolean check = false;
    private static final long serialVersionUID = 4242698212885848444L;
    private transient int ivaluesShift;
    private int keyCount;
    private transient int[] keys;
    private transient int occupiedCount;
    private int power;
    private transient Object[] values;

    public UintMap() {
        this(4);
    }

    private int ensureIndex(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int[] iArr = this.keys;
        int i5 = -1;
        if (iArr != null) {
            int i6 = A * i;
            int i7 = this.power;
            int i8 = i6 >>> (32 - i7);
            int i9 = iArr[i8];
            if (i9 == i) {
                return i8;
            }
            if (i9 != -1) {
                i3 = i9 == -2 ? i8 : -1;
                int i10 = (1 << i7) - 1;
                int iTableLookupStep = tableLookupStep(i6, i10, i7);
                do {
                    i8 = (i8 + iTableLookupStep) & i10;
                    i4 = iArr[i8];
                    if (i4 == i) {
                        return i8;
                    }
                    if (i4 == -2 && i3 < 0) {
                        i3 = i8;
                    }
                } while (i4 != -1);
            } else {
                i3 = -1;
            }
            i2 = i8;
            i5 = i3;
        } else {
            i2 = -1;
        }
        if (i5 < 0) {
            if (iArr != null) {
                int i11 = this.occupiedCount;
                if (i11 * 4 < (1 << this.power) * 3) {
                    this.occupiedCount = i11 + 1;
                    i5 = i2;
                }
            }
            rehashTable(z);
            return insertNewKey(i);
        }
        iArr[i5] = i;
        this.keyCount++;
        return i5;
    }

    private int findIndex(int i) {
        int i2;
        int[] iArr = this.keys;
        if (iArr != null) {
            int i3 = A * i;
            int i4 = this.power;
            int i5 = i3 >>> (32 - i4);
            int i6 = iArr[i5];
            if (i6 == i) {
                return i5;
            }
            if (i6 != -1) {
                int i7 = (1 << i4) - 1;
                int iTableLookupStep = tableLookupStep(i3, i7, i4);
                do {
                    i5 = (i5 + iTableLookupStep) & i7;
                    i2 = iArr[i5];
                    if (i2 == i) {
                        return i5;
                    }
                } while (i2 != -1);
            }
        }
        return -1;
    }

    private int insertNewKey(int i) {
        int[] iArr = this.keys;
        int i2 = A * i;
        int i3 = this.power;
        int i4 = i2 >>> (32 - i3);
        if (iArr[i4] != -1) {
            int i5 = (1 << i3) - 1;
            int iTableLookupStep = tableLookupStep(i2, i5, i3);
            do {
                i4 = (i4 + iTableLookupStep) & i5;
            } while (iArr[i4] != -1);
        }
        iArr[i4] = i;
        this.occupiedCount++;
        this.keyCount++;
        return i4;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.keyCount;
        if (i != 0) {
            this.keyCount = 0;
            boolean z = objectInputStream.readBoolean();
            boolean z2 = objectInputStream.readBoolean();
            int i2 = 1 << this.power;
            if (z) {
                this.keys = new int[i2 * 2];
                this.ivaluesShift = i2;
            } else {
                this.keys = new int[i2];
            }
            for (int i3 = 0; i3 != i2; i3++) {
                this.keys[i3] = -1;
            }
            if (z2) {
                this.values = new Object[i2];
            }
            for (int i4 = 0; i4 != i; i4++) {
                int iInsertNewKey = insertNewKey(objectInputStream.readInt());
                if (z) {
                    this.keys[this.ivaluesShift + iInsertNewKey] = objectInputStream.readInt();
                }
                if (z2) {
                    this.values[iInsertNewKey] = objectInputStream.readObject();
                }
            }
        }
    }

    private void rehashTable(boolean z) {
        int[] iArr = this.keys;
        if (iArr != null && this.keyCount * 2 >= this.occupiedCount) {
            this.power++;
        }
        int i = 1 << this.power;
        int i2 = this.ivaluesShift;
        if (i2 != 0 || z) {
            this.ivaluesShift = i;
            this.keys = new int[i * 2];
        } else {
            this.keys = new int[i];
        }
        int i3 = 0;
        for (int i4 = 0; i4 != i; i4++) {
            this.keys[i4] = -1;
        }
        Object[] objArr = this.values;
        if (objArr != null) {
            this.values = new Object[i];
        }
        int i5 = this.keyCount;
        this.occupiedCount = 0;
        if (i5 != 0) {
            this.keyCount = 0;
            while (i5 != 0) {
                int i6 = iArr[i3];
                if (i6 != -1 && i6 != -2) {
                    int iInsertNewKey = insertNewKey(i6);
                    if (objArr != null) {
                        this.values[iInsertNewKey] = objArr[i3];
                    }
                    if (i2 != 0) {
                        this.keys[this.ivaluesShift + iInsertNewKey] = iArr[i2 + i3];
                    }
                    i5--;
                }
                i3++;
            }
        }
    }

    private static int tableLookupStep(int i, int i2, int i3) {
        int i4 = 32 - (i3 * 2);
        if (i4 >= 0) {
            i >>>= i4;
        } else {
            i2 >>>= -i4;
        }
        return (i & i2) | 1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.keyCount;
        if (i != 0) {
            int i2 = 0;
            boolean z = this.ivaluesShift != 0;
            boolean z2 = this.values != null;
            objectOutputStream.writeBoolean(z);
            objectOutputStream.writeBoolean(z2);
            while (i != 0) {
                int i3 = this.keys[i2];
                if (i3 != -1 && i3 != -2) {
                    i--;
                    objectOutputStream.writeInt(i3);
                    if (z) {
                        objectOutputStream.writeInt(this.keys[this.ivaluesShift + i2]);
                    }
                    if (z2) {
                        objectOutputStream.writeObject(this.values[i2]);
                    }
                }
                i2++;
            }
        }
    }

    public void clear() {
        int i = 1 << this.power;
        if (this.keys != null) {
            for (int i2 = 0; i2 != i; i2++) {
                this.keys[i2] = -1;
            }
            if (this.values != null) {
                for (int i3 = 0; i3 != i; i3++) {
                    this.values[i3] = null;
                }
            }
        }
        this.ivaluesShift = 0;
        this.keyCount = 0;
        this.occupiedCount = 0;
    }

    public int getExistingInt(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        int iFindIndex = findIndex(i);
        if (iFindIndex < 0) {
            Kit.codeBug();
            return 0;
        }
        int i2 = this.ivaluesShift;
        if (i2 != 0) {
            return this.keys[i2 + iFindIndex];
        }
        return 0;
    }

    public int getInt(int i, int i2) {
        if (i < 0) {
            Kit.codeBug();
        }
        int iFindIndex = findIndex(i);
        if (iFindIndex < 0) {
            return i2;
        }
        int i3 = this.ivaluesShift;
        if (i3 != 0) {
            return this.keys[i3 + iFindIndex];
        }
        return 0;
    }

    public int[] getKeys() {
        int[] iArr = this.keys;
        int i = this.keyCount;
        int[] iArr2 = new int[i];
        int i2 = 0;
        while (i != 0) {
            int i3 = iArr[i2];
            if (i3 != -1 && i3 != -2) {
                i--;
                iArr2[i] = i3;
            }
            i2++;
        }
        return iArr2;
    }

    public Object getObject(int i) {
        int iFindIndex;
        if (i < 0) {
            Kit.codeBug();
        }
        if (this.values == null || (iFindIndex = findIndex(i)) < 0) {
            return null;
        }
        return this.values[iFindIndex];
    }

    public boolean has(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        return findIndex(i) >= 0;
    }

    public boolean isEmpty() {
        return this.keyCount == 0;
    }

    public void put(int i, int i2) {
        if (i < 0) {
            Kit.codeBug();
        }
        int iEnsureIndex = ensureIndex(i, true);
        if (this.ivaluesShift == 0) {
            int i3 = 1 << this.power;
            int[] iArr = this.keys;
            int i4 = i3 * 2;
            if (iArr.length != i4) {
                int[] iArr2 = new int[i4];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.keys = iArr2;
            }
            this.ivaluesShift = i3;
        }
        this.keys[this.ivaluesShift + iEnsureIndex] = i2;
    }

    public void remove(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        int iFindIndex = findIndex(i);
        if (iFindIndex >= 0) {
            int[] iArr = this.keys;
            iArr[iFindIndex] = -2;
            this.keyCount--;
            Object[] objArr = this.values;
            if (objArr != null) {
                objArr[iFindIndex] = null;
            }
            int i2 = this.ivaluesShift;
            if (i2 != 0) {
                iArr[i2 + iFindIndex] = 0;
            }
        }
    }

    public int size() {
        return this.keyCount;
    }

    public UintMap(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        int i2 = 2;
        while ((1 << i2) < (i * 4) / 3) {
            i2++;
        }
        this.power = i2;
    }

    public void put(int i, Object obj) {
        if (i < 0) {
            Kit.codeBug();
        }
        int iEnsureIndex = ensureIndex(i, false);
        if (this.values == null) {
            this.values = new Object[1 << this.power];
        }
        this.values[iEnsureIndex] = obj;
    }
}
