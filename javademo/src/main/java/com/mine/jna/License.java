package com.mine.jna;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jiayq24996 on 2020-03-23
 */
@Getter
@Setter
public class License {
    int nSize;                                // 许可证结构大小
    String lpChecksum;                    // 该字段后面所有数据的校验和，MD5
    int nInternalNo;                // 内部统一编号
    String szLicenseNo;// 许可证编号, 格式: 最终用户编号[？]-厂商编号[？]-产品编号[？]-版本[4]
    String szEndUserName;                // 最终用户名
    String szDeveloperName;                // 厂商名
    String szRemark;                        // 备注
    int nValidDate;                            // 有效日期，YYYYMMDD
    int uiApplyProtocol;            // 适用协议，可组合。0x0001 T1，0x0002 T2
    int nMaxClient;                            // 最多允许接入客户端个数
    int nActiveClient;                        // 目前活动连接数（为了方便程序控制而添加）
    int nMaxSendPackets;                    // 每连接最多每秒钟请求数
    int nMaxSendBytes;                        // 每连接最多每秒钟发送字节数
    int bRouteByName;                        // 是否允许有名注册，使可根据名字路由
    int bBulkSend;                            // 是否允许大块数据传输
}
