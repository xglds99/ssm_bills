package com.bdqn.service.impl;

import com.bdqn.dao.BillMapper;
import com.bdqn.entity.Bill;
import com.bdqn.service.BillService;
import com.bdqn.vo.BillVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper billMapper;

    /**
     * 查询账单列表
     *
     * @param billVo
     * @return
     */
    public List<Bill> findBillList(BillVo billVo) {
        return billMapper.findBillList(billVo);
    }

    public int addBill(Bill bill) {
        return billMapper.addBill(bill);
    }

    public int updateBill(Bill bill) {
        return billMapper.updateBill(bill);
    }

    public int deleteById(Integer id) {
        return billMapper.deleteById(id);
    }
}
