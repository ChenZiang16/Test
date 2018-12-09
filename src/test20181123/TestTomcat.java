package test20181123;


import Utils.HttpUtils;
import Utils.Result;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试Tomcat并发 BIO NIO AIO
 */

public class TestTomcat {

    public static void main(String[] args){

        ExecutorService service = new ThreadPoolExecutor(300,1000,0l, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());


        User[] users = new User[20];



        for (int i = 0; i < 20; i++) {

            users[i] = new User("User" + i ,service);

        }

        for (int i = 0; i < 20; i++) {
            users[i].start();
        }

    }




}

class Connecter extends  Thread{

    String message;
    public Connecter(String message){
        this.message = message;
    }

    @Override
    public void run() {

        Result result = HttpUtils.getConnect("http://192.168.2.102:8080/TomcatTest/tomcatTest.do",message);
        if(result.getCode() ==200){
            System.out.println("success , return message: " + new String((byte[])result.getData()));
        }else {
            System.out.println("connect fail ...");
        }

    }
}

class User extends Thread{

    String name;

    ExecutorService pool;

    public User(String name, ExecutorService pool){
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run(){
        while(true){

            for (int i = 0; i < 30; i++) {

                pool.submit(new Connecter(name + " 第 " + i +"个请求！" ));

            }

           try{
               Thread.sleep(1000);
           }catch (Exception e){
               e.printStackTrace();
           }

        }
    }

}
