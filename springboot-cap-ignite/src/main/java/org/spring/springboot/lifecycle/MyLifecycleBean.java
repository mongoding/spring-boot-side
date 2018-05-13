package org.spring.springboot.lifecycle;

import org.apache.ignite.IgniteException;
import org.apache.ignite.lifecycle.LifecycleBean;
import org.apache.ignite.lifecycle.LifecycleEventType;

/**
 * BEFORE_NODE_START：Ignite节点的启动程序初始化之前调用
 * AFTER_NODE_START：Ignite节点启动之后调用
 * BEFORE_NODE_STOP：Ignite节点的停止程序初始化之前调用
 * AFTER_NODE_STOP：Ignite节点停止之后调用
 */
public class MyLifecycleBean implements LifecycleBean {
    @Override
    public void onLifecycleEvent(LifecycleEventType evt) throws IgniteException {
        if (evt == LifecycleEventType.BEFORE_NODE_START) {
            // Do something.

        }
    }
}
