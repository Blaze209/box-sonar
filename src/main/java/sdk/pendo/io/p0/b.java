package sdk.pendo.io.p0;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private LinkedList a;
    private d b = new d(null);
    private e c = null;
    private int d = 0;

    private List a(a aVar) {
        if (aVar == null) {
            return new sdk.pendo.io.o0.a();
        }
        List listB = aVar.b();
        return listB == null ? new sdk.pendo.io.o0.a() : listB;
    }

    private Map b(a aVar) {
        if (aVar == null) {
            return new sdk.pendo.io.o0.c();
        }
        Map mapA = aVar.a();
        return mapA == null ? new sdk.pendo.io.o0.c() : mapA;
    }

    public void c() {
        this.c = null;
        this.d = 0;
        this.a = null;
    }

    private void b() throws c, IOException {
        e eVarB = this.b.b();
        this.c = eVarB;
        if (eVarB == null) {
            this.c = new e(-1, null);
        }
    }

    public int a() {
        return this.b.a();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:46:0x0100  */
    /* JADX WARN: Code duplicated, block: B:60:0x013a  */
    public Object a(Reader reader, a aVar) throws c, IOException {
        Object objB;
        Object objB2;
        Integer num;
        a(reader);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        do {
            b();
            int i = this.d;
            if (i == -1) {
                throw new c(a(), 1, this.c);
            }
            if (i == 0) {
                int i2 = this.c.a;
                if (i2 == 0) {
                    this.d = 1;
                    linkedList.addFirst(new Integer(1));
                    objB = this.c.b;
                } else if (i2 == 1) {
                    this.d = 2;
                    linkedList.addFirst(new Integer(2));
                    objB = b(aVar);
                } else if (i2 != 3) {
                    this.d = -1;
                } else {
                    this.d = 3;
                    linkedList.addFirst(new Integer(3));
                    objB = a(aVar);
                }
                linkedList2.addFirst(objB);
            } else {
                if (i == 1) {
                    if (this.c.a == -1) {
                        return linkedList2.removeFirst();
                    }
                    throw new c(a(), 1, this.c);
                }
                if (i == 2) {
                    e eVar = this.c;
                    int i3 = eVar.a;
                    if (i3 == 0) {
                        Object obj = eVar.b;
                        if (obj instanceof String) {
                            linkedList2.addFirst((String) obj);
                            this.d = 4;
                            linkedList.addFirst(new Integer(4));
                        } else {
                            this.d = -1;
                        }
                    } else if (i3 != 2) {
                        if (i3 != 5) {
                            this.d = -1;
                        }
                    } else if (linkedList2.size() > 1) {
                        linkedList.removeFirst();
                        linkedList2.removeFirst();
                        this.d = a(linkedList);
                    } else {
                        this.d = 1;
                    }
                } else if (i == 3) {
                    int i4 = this.c.a;
                    if (i4 != 0) {
                        if (i4 == 1) {
                            List list = (List) linkedList2.getFirst();
                            objB2 = b(aVar);
                            list.add(objB2);
                            this.d = 2;
                            num = new Integer(2);
                        } else if (i4 == 3) {
                            List list2 = (List) linkedList2.getFirst();
                            objB2 = a(aVar);
                            list2.add(objB2);
                            this.d = 3;
                            num = new Integer(3);
                        } else if (i4 != 4) {
                            if (i4 != 5) {
                                this.d = -1;
                            }
                        } else if (linkedList2.size() > 1) {
                            linkedList.removeFirst();
                            linkedList2.removeFirst();
                            this.d = a(linkedList);
                        } else {
                            this.d = 1;
                        }
                        linkedList.addFirst(num);
                        linkedList2.addFirst(objB2);
                    } else {
                        ((List) linkedList2.getFirst()).add(this.c.b);
                    }
                } else if (i == 4) {
                    int i5 = this.c.a;
                    if (i5 != 0) {
                        if (i5 == 1) {
                            linkedList.removeFirst();
                            String str = (String) linkedList2.removeFirst();
                            Map map = (Map) linkedList2.getFirst();
                            objB2 = b(aVar);
                            map.put(str, objB2);
                            this.d = 2;
                            num = new Integer(2);
                        } else if (i5 == 3) {
                            linkedList.removeFirst();
                            String str2 = (String) linkedList2.removeFirst();
                            Map map2 = (Map) linkedList2.getFirst();
                            objB2 = a(aVar);
                            map2.put(str2, objB2);
                            this.d = 3;
                            num = new Integer(3);
                        } else if (i5 != 6) {
                            this.d = -1;
                        }
                        linkedList.addFirst(num);
                        linkedList2.addFirst(objB2);
                    } else {
                        linkedList.removeFirst();
                        ((Map) linkedList2.getFirst()).put((String) linkedList2.removeFirst(), this.c.b);
                        this.d = a(linkedList);
                    }
                }
            }
            if (this.d == -1) {
                throw new c(a(), 1, this.c);
            }
        } while (this.c.a != -1);
        throw new c(a(), 1, this.c);
    }

    public Object a(String str, a aVar) {
        try {
            return a(new StringReader(str), aVar);
        } catch (IOException e) {
            throw new c(-1, 2, e);
        }
    }

    private int a(LinkedList linkedList) {
        if (linkedList.size() == 0) {
            return -1;
        }
        return ((Integer) linkedList.getFirst()).intValue();
    }

    public void a(Reader reader) {
        this.b.a(reader);
        c();
    }
}
