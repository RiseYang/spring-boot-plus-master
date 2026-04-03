package io.geekidea.boot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.geekidea.boot.system.entity.SysOrder;
import io.geekidea.boot.system.query.SysOrderQuery;
import io.geekidea.boot.system.vo.SysOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单 Mapper 接口
 *
 * @author geekidea
 * @since 2026-04-03
 */
@Mapper
public interface SysOrderMapper extends BaseMapper<SysOrder> {

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
     * @return 列表
     */
    List<SysOrderVo> getSysOrderPage(SysOrderQuery query);

}
