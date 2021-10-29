package com.myboot.cmms.common.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
    /**
     * 对明文密码进行加密
     *
     * @param pwd 明文密码
     * @return md5加密后的密码
     */
    public static String encodeMd5(String pwd) {
        return DigestUtils.md5DigestAsHex(pwd.getBytes());
    }

    /**
     * 密码验证
     *
     * @param pwd    明文密码
     * @param Md5Str md5加密的密文密码字符串
     * @return 验证是否一致
     */
    public static boolean verifyMd5(String pwd, String Md5Str) {
        if (Md5Str.equals(DigestUtils.md5DigestAsHex(pwd.getBytes()))) {
            return true;
        }
        return false;
    }

    // 测试
    public static void main(String[] args) throws Exception {
        String pwd = "123456";
        System.out.println("加密的字符串：" + pwd + "\t长度：" + pwd.length());
        System.out.println("MD5Util.encodeMd5(pwd):" + MD5Util.encodeMd5(pwd));
        System.out.println("verifyMd5(pwd,MD5Util.encodeMd5(pwd)):" + verifyMd5(pwd, MD5Util.encodeMd5(pwd)));
    }

}
