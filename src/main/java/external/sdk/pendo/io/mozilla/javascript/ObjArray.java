package external.sdk.pendo.io.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ObjArray implements Serializable {
    private static final int FIELDS_STORE_SIZE = 5;
    private static final long serialVersionUID = 4174889037736658296L;
    private transient Object[] data;
    private transient Object f0;
    private transient Object f1;
    private transient Object f2;
    private transient Object f3;
    private transient Object f4;
    private boolean sealed;
    private int size;

    private void ensureCapacity(int i) {
        int i2 = i - 5;
        if (i2 <= 0) {
            throw new IllegalArgumentException();
        }
        Object[] objArr = this.data;
        if (objArr == null) {
            if (10 >= i2) {
                i2 = 10;
            }
            this.data = new Object[i2];
            return;
        }
        int length = objArr.length;
        if (length < i2) {
            int i3 = length > 5 ? length * 2 : 10;
            if (i3 >= i2) {
                i2 = i3;
            }
            Object[] objArr2 = new Object[i2];
            int i4 = this.size;
            if (i4 > 5) {
                System.arraycopy(objArr, 0, objArr2, 0, i4 - 5);
            }
            this.data = objArr2;
        }
    }

    private Object getImpl(int i) {
        if (i == 0) {
            return this.f0;
        }
        if (i == 1) {
            return this.f1;
        }
        if (i == 2) {
            return this.f2;
        }
        if (i != 3) {
            return i != 4 ? this.data[i - 5] : this.f4;
        }
        return this.f3;
    }

    private static RuntimeException onEmptyStackTopRead() {
        throw new RuntimeException("Empty stack");
    }

    private static RuntimeException onInvalidIndex(int i, int i2) {
        throw new IndexOutOfBoundsException(i + " ∉ [0, " + i2 + ')');
    }

    private static RuntimeException onSeledMutation() {
        throw new IllegalStateException("Attempt to modify sealed array");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = this.size;
        if (i > 5) {
            this.data = new Object[i - 5];
        }
        for (int i2 = 0; i2 != i; i2++) {
            setImpl(i2, objectInputStream.readObject());
        }
    }

    private void setImpl(int i, Object obj) {
        if (i == 0) {
            this.f0 = obj;
            return;
        }
        if (i == 1) {
            this.f1 = obj;
            return;
        }
        if (i == 2) {
            this.f2 = obj;
            return;
        }
        if (i == 3) {
            this.f3 = obj;
        } else if (i != 4) {
            this.data[i - 5] = obj;
        } else {
            this.f4 = obj;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            objectOutputStream.writeObject(getImpl(i2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0030  */
    /* JADX WARN: Code duplicated, block: B:22:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x003a  */
    /* JADX WARN: Code duplicated, block: B:25:0x003d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0044  */
    /* JADX WARN: Code duplicated, block: B:28:0x0047  */
    /* JADX WARN: Code duplicated, block: B:31:0x0054  */
    public final void add(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw onInvalidIndex(i, i2 + 1);
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        if (i == 0) {
            if (i2 == 0) {
                this.f0 = obj;
            } else {
                Object obj2 = this.f0;
                this.f0 = obj;
                obj = obj2;
            }
            this.size = i2 + 1;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        ensureCapacity(i2 + 1);
                        if (i != i2) {
                            Object[] objArr = this.data;
                            System.arraycopy(objArr, i - 5, objArr, i - 4, i2 - i);
                        }
                        this.data[i - 5] = obj;
                    }
                    this.size = i2 + 1;
                }
                if (i2 == 4) {
                    this.f4 = obj;
                } else {
                    Object obj3 = this.f4;
                    this.f4 = obj;
                    obj = obj3;
                    i = 5;
                    ensureCapacity(i2 + 1);
                    if (i != i2) {
                        Object[] objArr2 = this.data;
                        System.arraycopy(objArr2, i - 5, objArr2, i - 4, i2 - i);
                    }
                    this.data[i - 5] = obj;
                }
                this.size = i2 + 1;
            }
            if (i2 == 3) {
                this.f3 = obj;
            } else {
                Object obj4 = this.f3;
                this.f3 = obj;
                obj = obj4;
                if (i2 == 4) {
                    this.f4 = obj;
                } else {
                    Object obj5 = this.f4;
                    this.f4 = obj;
                    obj = obj5;
                    i = 5;
                    ensureCapacity(i2 + 1);
                    if (i != i2) {
                        Object[] objArr3 = this.data;
                        System.arraycopy(objArr3, i - 5, objArr3, i - 4, i2 - i);
                    }
                    this.data[i - 5] = obj;
                }
            }
            this.size = i2 + 1;
        }
        if (i2 == 2) {
            this.f2 = obj;
        } else {
            Object obj6 = this.f2;
            this.f2 = obj;
            obj = obj6;
            if (i2 == 3) {
                this.f3 = obj;
            } else {
                Object obj7 = this.f3;
                this.f3 = obj;
                obj = obj7;
                if (i2 == 4) {
                    this.f4 = obj;
                } else {
                    Object obj8 = this.f4;
                    this.f4 = obj;
                    obj = obj8;
                    i = 5;
                    ensureCapacity(i2 + 1);
                    if (i != i2) {
                        Object[] objArr4 = this.data;
                        System.arraycopy(objArr4, i - 5, objArr4, i - 4, i2 - i);
                    }
                    this.data[i - 5] = obj;
                }
            }
        }
        this.size = i2 + 1;
        if (i2 == 1) {
            this.f1 = obj;
        } else {
            Object obj9 = this.f1;
            this.f1 = obj;
            obj = obj9;
            if (i2 == 2) {
                this.f2 = obj;
            } else {
                Object obj10 = this.f2;
                this.f2 = obj;
                obj = obj10;
                if (i2 == 3) {
                    this.f3 = obj;
                } else {
                    Object obj11 = this.f3;
                    this.f3 = obj;
                    obj = obj11;
                    if (i2 == 4) {
                        this.f4 = obj;
                    } else {
                        Object obj12 = this.f4;
                        this.f4 = obj;
                        obj = obj12;
                        i = 5;
                        ensureCapacity(i2 + 1);
                        if (i != i2) {
                            Object[] objArr5 = this.data;
                            System.arraycopy(objArr5, i - 5, objArr5, i - 4, i2 - i);
                        }
                        this.data[i - 5] = obj;
                    }
                }
            }
        }
        this.size = i2 + 1;
    }

    public final void clear() {
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            setImpl(i2, null);
        }
        this.size = 0;
    }

    public final Object get(int i) {
        if (i < 0 || i >= this.size) {
            throw onInvalidIndex(i, this.size);
        }
        return getImpl(i);
    }

    public int indexOf(Object obj) {
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            Object impl = getImpl(i2);
            if (impl == obj || (impl != null && impl.equals(obj))) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public int lastIndexOf(Object obj) {
        int i = this.size;
        while (i != 0) {
            i--;
            Object impl = getImpl(i);
            if (impl == obj || (impl != null && impl.equals(obj))) {
                return i;
            }
        }
        return -1;
    }

    public final Object peek() {
        int i = this.size;
        if (i != 0) {
            return getImpl(i - 1);
        }
        throw onEmptyStackTopRead();
    }

    public final Object pop() {
        Object obj;
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i = this.size;
        int i2 = i - 1;
        if (i2 == -1) {
            throw onEmptyStackTopRead();
        }
        if (i2 == 0) {
            obj = this.f0;
            this.f0 = null;
        } else if (i2 == 1) {
            obj = this.f1;
            this.f1 = null;
        } else if (i2 == 2) {
            obj = this.f2;
            this.f2 = null;
        } else if (i2 == 3) {
            obj = this.f3;
            this.f3 = null;
        } else if (i2 != 4) {
            Object[] objArr = this.data;
            int i3 = i - 6;
            obj = objArr[i3];
            objArr[i3] = null;
        } else {
            obj = this.f4;
            this.f4 = null;
        }
        this.size = i2;
        return obj;
    }

    public final void push(Object obj) {
        add(obj);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0030  */
    /* JADX WARN: Code duplicated, block: B:22:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x0039  */
    /* JADX WARN: Code duplicated, block: B:25:0x003c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0042  */
    /* JADX WARN: Code duplicated, block: B:28:0x0045  */
    /* JADX WARN: Code duplicated, block: B:30:0x004f  */
    public final void remove(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw onInvalidIndex(i, i2);
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i3 = i2 - 1;
        if (i == 0) {
            if (i3 == 0) {
                this.f0 = null;
            } else {
                this.f0 = this.f1;
            }
            this.size = i3;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != i3) {
                            Object[] objArr = this.data;
                            System.arraycopy(objArr, i - 4, objArr, i - 5, i3 - i);
                        }
                        this.data[i2 - 6] = null;
                    }
                    this.size = i3;
                }
                if (i3 == 4) {
                    this.f4 = null;
                } else {
                    this.f4 = this.data[0];
                    i = 5;
                    if (i != i3) {
                        Object[] objArr2 = this.data;
                        System.arraycopy(objArr2, i - 4, objArr2, i - 5, i3 - i);
                    }
                    this.data[i2 - 6] = null;
                }
                this.size = i3;
            }
            if (i3 == 3) {
                this.f3 = null;
            } else {
                this.f3 = this.f4;
                if (i3 == 4) {
                    this.f4 = null;
                } else {
                    this.f4 = this.data[0];
                    i = 5;
                    if (i != i3) {
                        Object[] objArr3 = this.data;
                        System.arraycopy(objArr3, i - 4, objArr3, i - 5, i3 - i);
                    }
                    this.data[i2 - 6] = null;
                }
            }
            this.size = i3;
        }
        if (i3 == 2) {
            this.f2 = null;
        } else {
            this.f2 = this.f3;
            if (i3 == 3) {
                this.f3 = null;
            } else {
                this.f3 = this.f4;
                if (i3 == 4) {
                    this.f4 = null;
                } else {
                    this.f4 = this.data[0];
                    i = 5;
                    if (i != i3) {
                        Object[] objArr4 = this.data;
                        System.arraycopy(objArr4, i - 4, objArr4, i - 5, i3 - i);
                    }
                    this.data[i2 - 6] = null;
                }
            }
        }
        this.size = i3;
        if (i3 == 1) {
            this.f1 = null;
        } else {
            this.f1 = this.f2;
            if (i3 == 2) {
                this.f2 = null;
            } else {
                this.f2 = this.f3;
                if (i3 == 3) {
                    this.f3 = null;
                } else {
                    this.f3 = this.f4;
                    if (i3 == 4) {
                        this.f4 = null;
                    } else {
                        this.f4 = this.data[0];
                        i = 5;
                        if (i != i3) {
                            Object[] objArr5 = this.data;
                            System.arraycopy(objArr5, i - 4, objArr5, i - 5, i3 - i);
                        }
                        this.data[i2 - 6] = null;
                    }
                }
            }
        }
        this.size = i3;
    }

    public final void seal() {
        this.sealed = true;
    }

    public final void set(int i, Object obj) {
        if (i < 0 || i >= this.size) {
            throw onInvalidIndex(i, this.size);
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        setImpl(i, obj);
    }

    public final void setSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i2 = this.size;
        if (i < i2) {
            for (int i3 = i; i3 != i2; i3++) {
                setImpl(i3, null);
            }
        } else if (i > i2 && i > 5) {
            ensureCapacity(i);
        }
        this.size = i;
    }

    public final int size() {
        return this.size;
    }

    public final void toArray(Object[] objArr) {
        toArray(objArr, 0);
    }

    public final void add(Object obj) {
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i = this.size;
        if (i >= 5) {
            ensureCapacity(i + 1);
        }
        this.size = i + 1;
        setImpl(i, obj);
    }

    public final void toArray(Object[] objArr, int i) {
        int i2 = this.size;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                System.arraycopy(this.data, 0, objArr, i + 5, i2 - 5);
                            }
                            objArr[i + 4] = this.f4;
                        }
                        objArr[i + 3] = this.f3;
                    }
                    objArr[i + 2] = this.f2;
                }
                objArr[i + 1] = this.f1;
            }
            objArr[i] = this.f0;
        }
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[this.size];
        toArray(objArr, 0);
        return objArr;
    }
}
