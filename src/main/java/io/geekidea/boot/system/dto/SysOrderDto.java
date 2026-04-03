package io.geekidea.boot.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单参数
 *
 * @author geekidea
 * @since 2026-04-03
 */
@Data
@Schema(description = "订单参数")
public class SysOrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    private Long id;

    @Schema(description = "订单编号")
    @NotBlank(message = "订单编号不能为空")
    @Length(max = 64, message = "订单编号长度超过限制")
    private String orderNo;

    @Schema(description = "客户名称")
    @NotBlank(message = "客户名称不能为空")
    @Length(max = 100, message = "客户名称长度超过限制")
    private String customerName;

    @Schema(description = "联系电话")
    @NotBlank(message = "联系电话不能为空")
    @Length(max = 20, message = "联系电话长度超过限制")
    private String phone;

    @Schema(description = "订单金额")
    @NotNull(message = "订单金额不能为空")
    @DecimalMin(value = "0.01", message = "订单金额必须大于0")
    private BigDecimal totalAmount;

    @Schema(description = "订单状态 1：待支付，2：已支付，3：已发货，4：已完成，5：已取消")
    private Integer orderStatus;

    @Schema(description = "备注")
    @Length(max = 500, message = "备注长度超过限制")
    private String remark;

}
