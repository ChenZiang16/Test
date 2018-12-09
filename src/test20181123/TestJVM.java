package test20181123;

public class TestJVM {

    public static void main(String[] args) {

        int M = 1024*1024;

        byte[] bytes = new byte[7*M];

        long maxMemory = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("Max_Memory :" + maxMemory + "k");
        System.out.println("Start_Memory :" + total +"k");

        System.out.println("over !");



    }

}
