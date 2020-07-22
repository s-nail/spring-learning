package com.mine.jna;

import com.sun.jna.*;

import java.util.Arrays;
import java.util.List;

/**
 * Simple example of native library declaration and usage.
 */
public class HelloWorld {
    public static class TestStruct extends Structure {
        public static class ByReference extends TestStruct implements Structure.ByReference {
            public ByReference() {
            }
        }

        public static class ByValue extends TestStruct implements Structure.ByValue {
            public ByValue() {
            }
            //public ByValue(Pointer p) { super(p);}
        }

        public int nSize;                                // 许可证结构大小
        public byte lpChecksum[] = new byte[16];                   // 该字段后面所有数据的校验和，MD5
        public int nInternalNo;                // 内部统一编号
        public byte szLicenseNo[] = new byte[64];// 许可证编号, 格式: 最终用户编号[？]-厂商编号[？]-产品编号[？]-版本[4]
        public byte szEndUserName[] = new byte[128];                // 最终用户名
        public byte szDeveloperName[] = new byte[128];                // 厂商名
        public byte szRemark[] = new byte[256];                        // 备注
        public int nValidDate;                            // 有效日期，YYYYMMDD
        public int uiApplyProtocol;            // 适用协议，可组合。0x0001 T1，0x0002 T2
        public int nMaxClient;                            // 最多允许接入客户端个数
        public int nActiveClient;                        // 目前活动连接数（为了方便程序控制而添加）
        public int nMaxSendPackets;                    // 每连接最多每秒钟请求数
        public int nMaxSendBytes;                        // 每连接最多每秒钟发送字节数
        public int bRouteByName;                        // 是否允许有名注册，使可根据名字路由
        public int bBulkSend;                            // 是否允许大块数据传输

        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{
                    "nSize", "lpChecksum", "nInternalNo", "szLicenseNo", "szEndUserName", "szDeveloperName",
                    "szRemark", "nValidDate", "uiApplyProtocol", "nMaxClient", "nActiveClient", "nMaxSendPackets", "nMaxSendBytes"
                    , "bRouteByName", "bBulkSend"
            });
        }
    }


    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("license", CLibrary.class);

        void Save_Exter_License(String lpLicenseNo, String szFileName);

        int Init_Dll(String szFileName);

        String Save_Inter_License(TestStruct.ByReference lpLicence, String szFileName);

        int Get_Current_No();

        TestStruct.ByReference Open_Inter_License(String szFileName);

        void Save_Client_License(String lpLicenseNo, String szFileName);

    }

    public static void main(String[] args) {
      /*  int result = CLibrary.INSTANCE.Init_Dll("D:\\license.dat");
        System.out.println("result:" + result);
        //Pointer pointer = new Memory(16);
        TestStruct.ByReference license = new TestStruct.ByReference();
        //license.nSize = 1024;
        //license.lpChecksum = "MD5".getBytes();
        license.nInternalNo = 1111;
        license.szLicenseNo = "1234".getBytes();
        license.szEndUserName = "userTest".getBytes();
        license.szDeveloperName = "Company".getBytes();
        license.szRemark = "remark".getBytes();
        license.nValidDate = 20200324;
        license.uiApplyProtocol = 0x0002;
        license.nMaxClient = 16;
        //license.nActiveClient = 6;
        license.nMaxSendPackets = 5;
        license.nMaxSendBytes = 258;
        //license.bRouteByName = 0;
        //license.bBulkSend = 99;
        String licenseNo = CLibrary.INSTANCE.Save_Inter_License(license, null);
        CLibrary.INSTANCE.Save_Client_License(licenseNo,"D:\\logsssss123.dat");
        System.out.println(licenseNo);

        System.out.println(CLibrary.INSTANCE.Get_Current_No());*/


        /*TestStruct.ByReference license = CLibrary.INSTANCE.Open_Inter_License("D:\\logsssss.dat");
        System.out.println(license);*/
        /*CLibrary.INSTANCE.Save_Exter_License("213212","D:\\logs\\teett.txt");*/

        /*Pointer buffer = new Memory(2048);
        int ret = SZEntcryptLib.INSTANCE.getTzSoftEncryptBuffer(buffer, 2048);
        System.out.println(ret);*/


        /*String a = new String("aaa").intern();
        String b = new String("aaa");
        String c = "aaa";
        System.out.println(a==b);
        System.out.println(a==c);*/

        String x1 = new String("a") + new String("b");
        System.out.println(x1);
    }

}
