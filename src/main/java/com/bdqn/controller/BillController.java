package com.bdqn.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Bill;
import com.bdqn.service.BillService;
import com.bdqn.utils.DataGridViewResult;
import com.bdqn.vo.BillVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Resource
    private BillService billService;

    @RequestMapping("/list")
    public DataGridViewResult list(BillVo billVo){
        //设置分页信息(当前页码,每页显示数量)
        PageHelper.startPage(billVo.getPage(),billVo.getLimit());
        //调用分页查询账单列表的方法
        List<Bill> billList = billService.findBillList(billVo);
        //创建分页对象
        PageInfo<Bill> pageInfo = new PageInfo<Bill>(billList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加账单
     * @param bill
     * @return
     */
    @RequestMapping("/addBill")
    public String addBill(Bill bill){
        Map<String,Object> map = new HashMap<String,Object>();
        if(billService.addBill(bill)>0){
            map.put("success",true);
            map.put("message","添加成功");
        }else{
            map.put("success",false);
            map.put("message","添加失败");
        }
        return JSON.toJSONString(map);
    }


    /**
     * 修改账单
     * @param bill
     * @return
     */
    @RequestMapping("/updateBill")
    public String updateBill(Bill bill){
        Map<String,Object> map = new HashMap<String,Object>();
        if(billService.updateBill(bill)>0){
            map.put("success",true);
            map.put("message","修改成功");
        }else{
            map.put("success",false);
            map.put("message","修改失败");
        }
        return JSON.toJSONString(map);
    }


    /**
     * 删除账单
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        if(billService.deleteById(id)>0){
            map.put("success",true);
            map.put("message","删除成功");
        }else{
            map.put("success",false);
            map.put("message","删除失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 批量删除账单
     * @param ids
     * @return
     */
    @RequestMapping("/batchDelete")
    public String batchDelete(String ids){
        Map<String,Object> map = new HashMap<String,Object>();
        int count = 0;
        //将字符串拆分成数组
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            count = billService.deleteById(Integer.valueOf(idsStr[i]));
            if(count>0){
                map.put("success",true);
                map.put("message","删除成功");
            }
        }
        //判断受影响行数是否为0
        if(count<=0){
            map.put("success",false);
            map.put("message","删除失败");
        }
        return JSON.toJSONString(map);
    }

}
