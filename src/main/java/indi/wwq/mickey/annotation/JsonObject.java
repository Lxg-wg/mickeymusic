package indi.wwq.mickey.annotation;

import java.lang.annotation.*;

/**
 * @author wg
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface JsonObject {
}
