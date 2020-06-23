package indi.wwq.mickey.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <p>对java对象的一些操作</p>
 * @author wg
 */
public class JavaBeanManager {
    /**
     * <p>将两个JavaBean里相同的字段自动填充</p>
     * @param dto 参数对象
     * @param obj 待填充的对象
     */
    public static void autoFillEqFields(Object dto, Object obj) {
        try {
            Field[] pfields = dto.getClass().getDeclaredFields();

            Field[] ofields = obj.getClass().getDeclaredFields();
            System.out.println(Arrays.toString(pfields));
            for (Field of : ofields) {
                if ("serialVersionUID".equals(of.getName())) {
                    continue;
                }
                for (Field pf : pfields) {
                    if (of.getName().equals(pf.getName())) {
                        PropertyDescriptor rpd = new PropertyDescriptor(pf.getName(), dto.getClass());
                        Method getMethod = rpd.getReadMethod();

                        PropertyDescriptor wpd = new PropertyDescriptor(pf.getName(), obj.getClass());
                        Method setMethod = wpd.getWriteMethod();
                        setMethod.invoke(obj, getMethod.invoke(dto));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
