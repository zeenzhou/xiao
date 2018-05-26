package com.zeen.proxy;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * //JDK6 Complier API, CGLib, ASM
 *
 * 实现任意对象的,任意接口方法,任意代理实现(权限,时间,事物,日志....)
 *
 */
public class Proxy {
    public static Object newProxyInstance(Class interfaceClazz, InvocationHandler handler) throws Exception {
        String methodStr = "";
        String rt = "\r\n";

        Method[] methods = interfaceClazz.getMethods();
        for (Method m : methods) {
            methodStr += "@Override" + rt +
                    "public void " + m.getName() + "() {" + rt +
                    "    try {" + rt +
                    "    Method md = " + interfaceClazz.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                    "    h.invoke(this, md);" + rt +
                    "    }catch(Exception e) {e.printStackTrace();}" + rt +

                    "}";

        }

        String src =
                "package com.zeen.proxy;" + rt +
                        "import java.lang.reflect.Method;" + rt +
                        "public class $Proxy1 implements " + interfaceClazz.getName() + "{" + rt +
                        "    public $Proxy1(InvocationHandler h) {" + rt +
                        "        this.h = h;" + rt +
                        "    }" + rt +


                        "    com.zeen.proxy.InvocationHandler h;" + rt +

                        methodStr +
                        "}";
        String fileName =
                "d:/src/com/zeen/proxy/$Proxy1.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        //load into memory and create an instance
        URL[] urls = new URL[]{new URL("file:/" + "d:/src/")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.zeen.proxy.$Proxy1");
        System.out.println(c);

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(handler);


        return m;
    }


}
