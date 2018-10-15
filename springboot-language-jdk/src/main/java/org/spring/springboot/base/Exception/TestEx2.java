package org.spring.springboot.base.Exception;

public class TestEx2 {

    public static void main(String[] args) {
        System.out.println("返回值："+testBasic());
        System.out.println("dd"+test1());
    }

    static Object test1() {
        for (int i = 0; i < 2; i++) {
            try {
                Object value = getValue();
                return value;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("exception");
            }
        }

        return "123";
    }
    static Object getValue() throws Exception{
        throw new Exception();
    }
    static  int testBasic(){
        int i = 1;
        try{
            i++;
            System.out.println("try block, i = "+i);
            return i;
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
            return i;
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
        }
    }
}
