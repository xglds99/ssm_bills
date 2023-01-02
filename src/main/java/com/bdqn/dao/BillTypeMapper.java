package com.bdqn.dao;

import com.bdqn.entity.BillType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillTypeMapper {

    /**
     * 查询所有账单类型
     * @return
     */
    @Select("select * from billtype")
    List<BillType> findBillTypeList();

}
