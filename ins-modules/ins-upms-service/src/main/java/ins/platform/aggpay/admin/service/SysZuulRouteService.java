package ins.platform.aggpay.admin.service;

import com.baomidou.mybatisplus.service.IService;
import ins.platform.aggpay.common.entity.SysZuulRoute;

/**
 * <p>
 * 动态路由配置表 服务类
 * </p>
 *
 * @author lengleng
 * @since 2018-05-15
 */
public interface SysZuulRouteService extends IService<SysZuulRoute> {

    /**
     * 立即生效配置
     * @return
     */
    Boolean applyZuulRoute();
}
