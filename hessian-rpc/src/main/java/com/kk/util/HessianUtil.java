package com.kk.util;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * <dependency>
 * <groupId>com.caucho</groupId>
 * <artifactId>hessian</artifactId>
 * <version>3.1.5</version>
 * </dependency>
 * <p/>
 * 序列化对象 要实现   Serializable接口，以及定义serialVersionUID。
 * <p/>
 * hessian2  采用缓冲区的方式，故 write后需要执行flush方法。
 */
public class HessianUtil {

    @Deprecated
    public static byte[] serialize(Object obj) throws IOException {
        if (obj == null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(obj);
        return os.toByteArray();
    }

    @Deprecated
    public static Object deserialize(byte[] by) throws IOException {
        if (by == null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        HessianInput hi = new HessianInput(is);
        return hi.readObject();
    }

    public static byte[] serialize2(Object obj) throws IOException {
        if (obj == null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(os);

        ho.writeObject(obj);

        ho.flush();
        return os.toByteArray();
    }

    public static Object deserialize2(byte[] by) throws IOException {
        if (by == null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        Hessian2Input hi = new Hessian2Input(is);
        return hi.readObject();
    }
}
