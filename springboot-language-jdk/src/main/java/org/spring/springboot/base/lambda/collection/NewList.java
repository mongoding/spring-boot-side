package org.spring.springboot.base.lambda.collection;

/**
 * Created by mongoding on 2018/1/11.
 */
public class NewList implements MyCollection {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
