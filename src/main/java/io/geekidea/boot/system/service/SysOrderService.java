package io.geekidea.boot.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.geekidea.boot.framework.page.Paging;
import io.geekidea.boot.system.dto.SysOrderDto;
import io.geekidea.boot.system.entity.SysOrder;
import io.geekidea.boot.system.query.SysOrderQuery;
import io.geekidea.boot.system.vo.SysOrderVo;

/**
 * 订单 服务接口
 *
 * @author geekidea
 * @since 2026-04-03
 */
public interface SysOrderService extends IService<SysOrder> {

    /**
     * 添加订单
     *
     * @param dto 参数
     * @return 是否成功
     */
    boolean addSysOrder(SysOrderDto dto);

    /**
     * 修改订单
     *
     * @param dto 参数
     * @return 是否成功
     */
    boolean updateSysOrder(SysOrderDto dto);

    /**
     * 删除订单
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteSysOrder(Long id);

    /**
     * 订单详情
     *
     * @param id 主键
     * @return 详情
     */
    SysOrderVo getSysOrderById(Long id);

    /**
     * 订单分页列表
     *
     * @param query 查询条件
     * @return 分页结果
     */
    Paging<SysOrderVo> getSysOrderPage(SysOrderQuery query);

}
