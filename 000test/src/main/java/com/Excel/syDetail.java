package com.Excel;

import lombok.Data;

/**
 * @author tzh
 * @date 2023/1/9
 */
@Data
public class syDetail extends syItem{

    public int detailCount;
    //企业药品溯源编码
    public String QYYPSYBM;
    //供货企业编码
    public String GHQYBM;
    //错误信息
    public String errMassager;
    //批次号
    public String PCH;
    //医保代码
    public String YPYBDM;
    // 协会药品溯源码
    public String YPSYBM;
}


