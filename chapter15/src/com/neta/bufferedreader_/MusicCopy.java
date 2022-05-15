package com.neta.bufferedreader_;

import java.io.*;

public class MusicCopy {
    public static void main(String[] args) {
        String srcPath = "E:\\music.mp3";
        String tgtPath = "E:\\music-copy.mp3";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte[] data = new byte[1024];
        int len;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(tgtPath));
            while ((len = bis.read(data)) != -1) {
                bos.write(data, 0, len);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
