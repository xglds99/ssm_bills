package com.bdqn.service;

import com.bdqn.entity.BillType;

import java.util.List;

public interface BillTypeService {
    /**
     * 查询所有账单类型
     * @return
     */
    List<BillType> findBillTypeList();
}
