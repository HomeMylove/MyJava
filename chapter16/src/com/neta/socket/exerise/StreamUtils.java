package com.neta.socket.exerise;

import java.io.*;

public class StreamUtils {
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = is.read(b)) != -1)
            bos.write(b,0,len);
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line + "\r\n");
        br.close();
        return sb.toString();



    }
}
