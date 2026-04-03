package io.geekidea.boot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.geekidea.boot.framework.exception.BusinessException;
import io.geekidea.boot.framework.page.OrderByItem;
import io.geekidea.boot.framework.page.OrderMapping;
import io.geekidea.boot.framework.page.Paging;
import io.geekidea.boot.system.dto.SysOrderDto;
import io.geekidea.boot.system.entity.SysOrder;
import io.geekidea.boot.system.mapper.SysOrderMapper;
import io.geekidea.boot.system.query.SysOrderQuery;
import io.geekidea.boot.system.service.SysOrderService;
import io.geekidea.boot.system.vo.SysOrderVo;
import io.geekidea.boot.util.PagingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单 服务实现类
 *
 * @author geekidea
 * @since 2026-04-03
 */
@Slf4j
@Service
public class SysOrderServiceImpl extends ServiceImpl<SysOrderMapper, SysOrder> implements SysOrderService {

    @Autowired
    private SysOrderMapper sysOrderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addSysOrder(SysOrderDto dto) {
        checkOrderNoExists(dto.getOrderNo(), null);
        SysOrder sysOrder = new SysOrder();
        BeanUtils.copyProperties(dto, sysOrder);
        if (sysOrder.getOrderStatus() == null) {
            sysOrder.setOrderStatus(1);
        }
        return save(sysOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateSysOrder(SysOrderDto dto) {
        Long id = dto.getId();
        if (id == null) {
            throw new BusinessException("订单ID不能为空");
        }
        SysOrder exist = getById(id);
        if (exist == null) {
            throw new BusinessException("订单不存在");
        }
        checkOrderNoExists(dto.getOrderNo(), id);
        SysOrder sysOrder = new SysOrder();
        BeanUtils.copyProperties(dto, sysOrder);
        return updateById(sysOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSysOrder(Long id) {
        return removeById(id);
    }

    @Override
    public SysOrderVo getSysOrderById(Long id) {
        return sysOrderMapper.getSysOrderById(id);
    }

    @Override
    public Paging<SysOrderVo> getSysOrderPage(SysOrderQuery query) {
        OrderMapping orderMapping = new OrderMapping();
        orderMapping.put("createTime", "create_time");
        orderMapping.put("totalAmount", "total_amount");
        PagingUtil.handlePage(query, orderMapping, OrderByItem.desc("id"));
        List<SysOrderVo> list = sysOrderMapper.getSysOrderPage(query);
        return new Paging<>(list);
    }

    private void checkOrderNoExists(String orderNo, Long excludeId) {
        LambdaQueryWrapper<SysOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysOrder::getOrderNo, orderNo);
        if (excludeId != null) {
            wrapper.ne(SysOrder::getId, excludeId);
        }
        long count = count(wrapper);
        if (count > 0) {
            throw new BusinessException("订单编号已存在：" + orderNo);
        }
    }

}
