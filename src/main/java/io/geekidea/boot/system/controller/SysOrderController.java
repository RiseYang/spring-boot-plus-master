package io.geekidea.boot.system.controller;

import io.geekidea.boot.auth.annotation.Permission;
import io.geekidea.boot.common.enums.SysLogType;
import io.geekidea.boot.framework.annotation.Log;
import io.geekidea.boot.framework.page.Paging;
import io.geekidea.boot.framework.response.ApiResult;
import io.geekidea.boot.system.dto.SysOrderDto;
import io.geekidea.boot.system.query.SysOrderQuery;
import io.geekidea.boot.system.service.SysOrderService;
import io.geekidea.boot.system.vo.SysOrderVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 订单 控制器
 *
 * @author geekidea
 * @since 2026-04-03
 */
@Slf4j
@RestController
@Tag(name = "订单管理")
@RequestMapping("/admin/sysOrder")
public class SysOrderController {

    @Autowired
    private SysOrderService sysOrderService;

    /**
     * 添加订单
     */
    @Log(value = "添加订单", type = SysLogType.ADD)
    @PostMapping("/addSysOrder")
    @Operation(summary = "添加订单")
    @Permission("sys:order:add")
    public ApiResult addSysOrder(@Valid @RequestBody SysOrderDto dto) {
        boolean flag = sysOrderService.addSysOrder(dto);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单
     */
    @Log(value = "修改订单", type = SysLogType.UPDATE)
    @PostMapping("/updateSysOrder")
    @Operation(summary = "修改订单")
    @Permission("sys:order:update")
    public ApiResult updateSysOrder(@Valid @RequestBody SysOrderDto dto) {
        boolean flag = sysOrderService.updateSysOrder(dto);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单
     */
    @Log(value = "删除订单", type = SysLogType.DELETE)
    @PostMapping("/deleteSysOrder/{id}")
    @Operation(summary = "删除订单")
    @Permission("sys:order:delete")
    public ApiResult deleteSysOrder(@PathVariable Long id) {
        boolean flag = sysOrderService.deleteSysOrder(id);
        return ApiResult.result(flag);
    }

    /**
     * 订单详情
     */
    @PostMapping("/getSysOrder/{id}")
    @Operation(summary = "订单详情")
    @Permission("sys:order:info")
    public ApiResult<SysOrderVo> getSysOrder(@PathVariable Long id) {
        SysOrderVo vo = sysOrderService.getSysOrderById(id);
        return ApiResult.success(vo);
    }

    /**
     * 订单分页列表
     */
    @PostMapping("/getSysOrderPage")
    @Operation(summary = "订单分页列表")
    @Permission("sys:order:page")
    public ApiResult<SysOrderVo> getSysOrderPage(@Valid @RequestBody SysOrderQuery query) {
        Paging<SysOrderVo> paging = sysOrderService.getSysOrderPage(query);
        return ApiResult.success(paging);
    }

}
