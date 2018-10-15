package org.spring.springboot.base.lambda.collection;

/**
 * Created by mongoding on 2018/1/11.
 */
public interface MyCollection {

    int size();

    default String notRequired() {
        return "Default implementation";
    }
}
