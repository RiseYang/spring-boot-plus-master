package io.geekidea.boot.system.query;

import io.geekidea.boot.framework.page.BasePageQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 订单查询参数
 *
 * @author geekidea
 * @since 2026-04-03
 */
@Data
@Schema(description = "订单查询参数")
public class SysOrderQuery extends BasePageQuery {
    private static final long serialVersionUID = 1L;

    @Schema(description = "订单状态 1：待支付，2：已支付，3：已发货，4：已完成，5：已取消")
    private Integer orderStatus;

}
