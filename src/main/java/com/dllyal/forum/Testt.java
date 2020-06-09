package com.dllyal.forum;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

public class Testt {
    // 机器标识位数
    private final static long WORKERIDBITS = 5L;
    // 数据中心标识位数
    private final static long DATACENTERIDBITS = 5L;
    //服务器ID
    private static long workerMask = -1L ^ (-1L << WORKERIDBITS);
    //进程编码
    private static long processMask = -1L ^ (-1L << DATACENTERIDBITS);

    public static void main(String[] args) {

        String filePath = "D:\\签名授权.png";
        String str = file2String(filePath);
        System.out.println("文件转字符串结果：start");
        System.out.println(str);
        System.out.println("文件转字符串结果：end");

        /*for (int i = 0;i<=10000;i++){
            String sss = SeqGenerateUtil.seqGenerate().toString();
            System.out.println(sss);
        }*/
        for (int i = 0;i<=100;i++){
            //唯一标识，增大随机
            UUID uid = UUID.randomUUID();
            String uidStr =uid.toString().replace("-", "");
            long uuid = uidStr.hashCode();
            UUID uid2 = UUID.randomUUID();
            String uidStr2 =uid2.toString().replace("-", "");
            long uuid2 = uidStr2.hashCode();
            //获取机器编码
            long workerId = getMachineNum ();
            workerId = workerId + uuid;
            //获取进程编码
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean ();
            long processId = Long.valueOf (runtimeMXBean.getName ().split ("@")[0]).longValue ();
            processId = processId + uuid2;
            //避免编码超出最大值
            workerId = workerId & workerMask;
            processId = processId & processMask;
            System.out.println("workerId---"+workerId);
            //System.out.println("processId--"+processId);
        }
    }

    private static long timeGen() {
        return System.currentTimeMillis ();
    }

    /**
     * 获取机器编码
     *
     * @return
     */
    private static long getMachineNum() {
        long machinePiece;
        StringBuilder sb = new StringBuilder ();
        Enumeration<NetworkInterface> e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces ();
        } catch (SocketException e1) {
            e1.printStackTrace ();
        }
        while (e.hasMoreElements ()) {
            NetworkInterface ni = e.nextElement ();
            sb.append (ni.toString ());
        }
        machinePiece = sb.toString ().hashCode ();
        return machinePiece;
    }

    public static String file2String(String path) {
        // TODO Auto-generated method stub
        File file = new File(path);
        FileInputStream fis = null;
        StringBuffer content = new StringBuffer();
        try {
            fis = new FileInputStream(file);
            int length = 2 * 1024 * 1024;
            byte[] byteAttr = new byte[length];
            int byteLength = -1;

            while ((byteLength = fis.read(byteAttr, 0, byteAttr.length)) != -1) {

                String encode = "";
                if (byteLength != byteAttr.length) {
                    byte[] temp = new byte[byteLength];
                    System.arraycopy(byteAttr, 0, temp, 0, byteLength);
                    //使用BASE64转译
                    Base64 base64 = new Base64();
                    encode = base64.encodeToString(temp);
                    //encode = new BASE64Encoder().encode(temp);
                    content.append(encode);
                } else {
                    Base64 base64 = new Base64();
                    encode = base64.encodeToString(byteAttr);
                    //encode = new BASE64Encoder().encode(byteAttr);
                    content.append(encode);
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return content.toString();
    }


}
