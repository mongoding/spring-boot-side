package org.spring.springboot.base.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by mongoding on 2016/4/18.
 */
public interface UserService extends Remote {

    public String hi(org.spring.springboot.base.rmi.User user) throws RemoteException;
}
