package org.tinylog.configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;
import org.tinylog.runtime.RuntimeProvider;

/* JADX INFO: loaded from: classes5.dex */
public final class ServiceLoader<T> {
    private static final String SERVICE_PREFIX = "META-INF/services/";
    private static final Pattern SPLIT_PATTERN = Pattern.compile(" ");
    private final Class<?>[] argumentTypes;
    private final ClassLoader classLoader;
    private final Collection<String> classes;
    private final Class<? extends T> service;

    public ServiceLoader(Class<? extends T> cls, Class<?>... clsArr) {
        this.service = cls;
        this.argumentTypes = clsArr;
        String str = SERVICE_PREFIX + cls.getName();
        for (ClassLoader classLoader : RuntimeProvider.getClassLoaders()) {
            if (fetchServiceFiles(classLoader, str).hasMoreElements()) {
                this.classLoader = classLoader;
                this.classes = loadClasses(classLoader, cls);
                return;
            }
        }
        this.classLoader = null;
        this.classes = Collections.emptyList();
    }

    public T create(String str, Object... objArr) {
        if (str.indexOf(46) == -1) {
            String simpleClassName = toSimpleClassName(str);
            for (String str2 : this.classes) {
                int iLastIndexOf = str2.lastIndexOf(46);
                if (simpleClassName.equals(iLastIndexOf == -1 ? str2 : str2.substring(iLastIndexOf + 1))) {
                    return createInstance(str2, objArr);
                }
            }
            InternalLogger.log(Level.ERROR, "Service implementation '" + str + "' not found");
            return null;
        }
        return createInstance(str, objArr);
    }

    public List<T> createList(String str) {
        T tCreate;
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(",")) {
            String strTrim = str2.trim();
            if (!strTrim.isEmpty()) {
                int iIndexOf = strTrim.indexOf(58);
                if (iIndexOf == -1) {
                    tCreate = create(strTrim, null);
                } else {
                    tCreate = create(strTrim.substring(0, iIndexOf).trim(), strTrim.substring(iIndexOf + 1).trim());
                }
                if (tCreate != null) {
                    arrayList.add(tCreate);
                }
            }
        }
        return arrayList;
    }

    public Collection<T> createAll(Object... objArr) {
        ArrayList arrayList = new ArrayList(this.classes.size());
        Iterator<String> it = this.classes.iterator();
        while (it.hasNext()) {
            T tCreateInstance = createInstance(it.next(), objArr);
            if (tCreateInstance != null) {
                arrayList.add(tCreateInstance);
            }
        }
        return arrayList;
    }

    private static Enumeration<URL> fetchServiceFiles(ClassLoader classLoader, String str) {
        try {
            return classLoader.getResources(str);
        } catch (IOException unused) {
            InternalLogger.log(Level.ERROR, "Failed loading services from '" + str + "'");
            return Collections.enumeration(Collections.emptyList());
        }
    }

    private static <T> Collection<String> loadClasses(ClassLoader classLoader, Class<? extends T> cls) throws Throwable {
        String str = SERVICE_PREFIX + cls.getName();
        try {
            Enumeration<URL> resources = classLoader.getResources(str);
            ArrayList arrayList = new ArrayList();
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(urlNextElement.openStream(), "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line != null) {
                                    String strTrim = line.trim();
                                    if (strTrim.length() > 0 && strTrim.charAt(0) != '#' && !arrayList.contains(strTrim)) {
                                        arrayList.add(strTrim);
                                    }
                                } else {
                                    try {
                                        break;
                                    } catch (IOException unused) {
                                    }
                                }
                            } catch (IOException unused2) {
                                bufferedReader = bufferedReader2;
                                InternalLogger.log(Level.ERROR, "Failed reading service resource '" + urlNextElement + "'");
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                throw th;
                            }
                        }
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return arrayList;
        } catch (IOException unused5) {
            InternalLogger.log(Level.ERROR, "Failed loading services from '" + str + "'");
            return Collections.emptyList();
        }
    }

    public String toSimpleClassName(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (String str2 : SPLIT_PATTERN.split(str)) {
            if (!str2.isEmpty()) {
                sb.append(Character.toUpperCase(str2.charAt(0)));
                sb.append(str2.substring(1).toLowerCase(Locale.ROOT));
            }
        }
        sb.append(this.service.getSimpleName());
        return sb.toString();
    }

    private T createInstance(String str, Object... objArr) {
        try {
            Class<?> cls = Class.forName(str, false, this.classLoader);
            if (this.service.isAssignableFrom(cls)) {
                return (T) cls.getDeclaredConstructor(this.argumentTypes).newInstance(objArr);
            }
            InternalLogger.log(Level.ERROR, "Class '" + str + "' does not implement service interface '" + this.service + "'");
            return null;
        } catch (ClassNotFoundException unused) {
            InternalLogger.log(Level.ERROR, "Service implementation '" + str + "' not found");
            return null;
        } catch (IllegalAccessException unused2) {
            InternalLogger.log(Level.ERROR, "Constructor of service implementation '" + str + "' is not accessible");
            return null;
        } catch (IllegalArgumentException unused3) {
            InternalLogger.log(Level.ERROR, "Illegal arguments for constructor of service implementation '" + str + "'");
            return null;
        } catch (InstantiationException unused4) {
            InternalLogger.log(Level.ERROR, "Service implementation '" + str + "' is not instantiable");
            return null;
        } catch (NoSuchMethodException unused5) {
            InternalLogger.log(Level.ERROR, "Service implementation '" + str + "' has no matching constructor");
            return null;
        } catch (InvocationTargetException e) {
            InternalLogger.log(Level.ERROR, e.getTargetException(), "Failed creating service implementation '" + str + "'");
            return null;
        }
    }
}
