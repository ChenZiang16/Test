package Utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpUtils {

    public static Result getConnect(String address,String message){

        if(address ==null || address ==""){
            return  new Result(404,"地址不能为空！",null);
        }

        try{

            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setConnectTimeout(10000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.setUseCaches(false);
          //  connection.connect(); 可以省去

            OutputStream out = connection.getOutputStream();
            out.write(message.getBytes(StandardCharsets.UTF_8));
            out.flush();
            out.close();

            InputStream input = connection.getInputStream();//此时http请求正问才真正发出
            byte[] bytes = new byte[input.available()];
            input.read(bytes);


            input.close();
            return new Result(200,"success" ,bytes);


        }catch (Exception e){
            e.printStackTrace();
        }

        return new Result(500,"请求出错！",null);
    }

}
