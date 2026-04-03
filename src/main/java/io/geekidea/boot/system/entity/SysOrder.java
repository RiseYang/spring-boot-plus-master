package io.geekidea.boot.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author geekidea
 * @since 2026-04-03
 */
@Data
@TableName("sys_order")
@Schema(description = "订单")
public class SysOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "客户名称")
    private String customerName;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "订单金额")
    private BigDecimal totalAmount;

    /**
     * 1：待支付，2：已支付，3：已发货，4：已完成，5：已取消
     */
    @Schema(description = "订单状态 1：待支付，2：已支付，3：已发货，4：已完成，5：已取消")
    private Integer orderStatus;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建人ID")
    @TableField(fill = FieldFill.INSERT)
    private Long createId;

    @Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @Schema(description = "修改人ID")
    @TableField(fill = FieldFill.UPDATE)
    private Long updateId;

    @Schema(description = "修改时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
