package io.geekidea.boot.system.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单查询结果
 *
 * @author geekidea
 * @since 2026-04-03
 */
@Data
@Schema(description = "订单查询结果")
public class SysOrderVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "订单编号")
    private String orderNo;

    @Schema(description = "客户名称")
    private String customerName;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "订单金额")
    private BigDecimal totalAmount;

    @Schema(description = "订单状态 1：待支付，2：已支付，3：已发货，4：已完成，5：已取消")
    private Integer orderStatus;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建人ID")
    private Long createId;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "修改人ID")
    private Long updateId;

    @Schema(description = "修改时间")
    private Date updateTime;

}
