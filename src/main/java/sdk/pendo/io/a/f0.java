package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public class f0 {
    static void a(int i, d dVar) {
        int i2 = i >>> 24;
        if (i2 != 0 && i2 != 1) {
            switch (i2) {
                case 16:
                case 17:
                case 18:
                case 23:
                    break;
                case 19:
                case 20:
                case 21:
                    dVar.b(i2);
                    return;
                case 22:
                    break;
                default:
                    switch (i2) {
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            dVar.c(i);
                            return;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
            dVar.b(i2, (i & 16776960) >> 8);
            return;
        }
        dVar.d(i >>> 16);
    }
}
