package org.spring.springboot.base.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by mongoding on 2016/4/18.
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    public UserServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String hi(User user) throws RemoteException {
        return "Hi, " + user.getName() + ", your age is " + user.getAge() + "?";
    }
}
