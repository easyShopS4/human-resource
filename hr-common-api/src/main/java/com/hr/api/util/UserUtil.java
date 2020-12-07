package com.hr.api.util;

/**
 * @author echo lovely
 * @date 2020/12/7 10:25
 */

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.UUID;

/**
 * 生成盐&对用户密码进行加密
 * @author echo lovely
 * @date 2020/11/2 16:38
 */
@Component
public class UserUtil {

    /**
     * 验证密码
     * @param password 用户过来的密码
     * @param salt salt
     * @return md5加密，再加盐，再加密，后的密码
     */
    public String generatePassword(String password, String salt) {

        // 第一次加密
        String pwdByMd5 = Md5Util.getStrMD5(password);

        // 第二次加密
        String pwdByMd5AndSalt = Md5Util.getStrMD5(pwdByMd5 + salt);

        return pwdByMd5AndSalt;
    }

    /**
     * 生成盐，插入数据库
     * @return salt 5个字符
     */
    public String generateSalt() {
        UUID uuid = UUID.randomUUID();
        //  System.out.println(uuid);

        return uuid.toString().substring(0, 5);
    }


    /**
     * md5 test 不可逆加密
     * @author echo lovely
     * @date 2020/8/17 21:47
     */
    public static class Md5Util {

        /**
         * 获取字符串的md5值
         * @param pw pwd
         * @return md5
         */
        public static String getStrMD5(String pw) {
            try {

                // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
                MessageDigest messageDigest =MessageDigest.getInstance("MD5");
                // 输入的字符串转换成字节数组
                byte[] inputByteArray = pw.getBytes();
                // inputByteArray是输入字符串转换得到的字节数组
                messageDigest.update(inputByteArray);
                // 转换并返回结果，也是字节数组，包含16个元素
                byte[] resultByteArray = messageDigest.digest();
                // 字符数组转换成字符串返回
                return byteArrayToHex(resultByteArray);
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        }

        /**
         * 将字节转化为十六进制输出
         * @param byteArray byteArrayToHex
         * @return res
         */
        public static String byteArrayToHex(byte[] byteArray) {

            // 首先初始化一个字符数组，用来存放每个16进制字符
            char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
            // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
            char[] resultCharArray =new char[byteArray.length * 2];
            // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
            int index = 0;
            for (byte b : byteArray) {
                resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
                resultCharArray[index++] = hexDigits[b & 0xf];
            }
            // 字符数组组合成字符串返回
            return new String(resultCharArray);
        }

    }


}

