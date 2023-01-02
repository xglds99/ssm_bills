package com.bdqn.vo;

import com.bdqn.entity.Bill;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 自定义查询条件类
 */
@Data
public class BillVo extends Bill {

    //注意：page和limit属性要与LayUI的数据表格参数一致
    private Integer page;//当前页码
    private Integer limit;//每页显示数量

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;//开始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;//结束日期

}
