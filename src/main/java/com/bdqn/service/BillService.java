package com.bdqn.service;

import com.bdqn.entity.Bill;
import com.bdqn.vo.BillVo;

import java.util.List;

public interface BillService {
    /**
     * 查询账单列表
     * @param billVo
     * @return
     */
    List<Bill> findBillList(BillVo billVo);

    /**
     * 添加账单
     * @param bill
     * @return
     */
    int addBill(Bill bill);

    /**
     * 修改账单
     * @param bill
     * @return
     */
    int updateBill(Bill bill);

    /**
     * 删除账单
     * @param id
     * @return
     */
    int deleteById(Integer id);
}
