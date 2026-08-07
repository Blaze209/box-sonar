package io.opentelemetry.exporter.zipkin;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class LocalInetAddressSupplier implements Supplier<InetAddress> {

    @Nullable
    private final InetAddress inetAddress;
    private static final Logger logger = Logger.getLogger(LocalInetAddressSupplier.class.getName());
    private static final LocalInetAddressSupplier INSTANCE = new LocalInetAddressSupplier(findLocalIp());

    private LocalInetAddressSupplier(@Nullable InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    @Override // java.util.function.Supplier
    @Nullable
    public InetAddress get() {
        return this.inetAddress;
    }

    @Nullable
    private static InetAddress findLocalIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (inetAddressNextElement.isSiteLocalAddress()) {
                        return inetAddressNextElement;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            logger.log(Level.FINE, "error reading nics", (Throwable) e);
            return null;
        }
    }

    static LocalInetAddressSupplier getInstance() {
        return INSTANCE;
    }
}
