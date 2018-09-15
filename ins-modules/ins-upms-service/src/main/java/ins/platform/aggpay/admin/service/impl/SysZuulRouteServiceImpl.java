package ins.platform.aggpay.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import ins.platform.aggpay.admin.mapper.SysZuulRouteMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ins.platform.aggpay.common.constant.CommonConstant;
import ins.platform.aggpay.common.constant.MqQueueConstant;
import ins.platform.aggpay.common.entity.SysZuulRoute;
import ins.platform.aggpay.admin.service.SysZuulRouteService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 动态路由配置表 服务实现类
 * </p>
 *
 * @author lengleng
 * @since 2018-05-15
 */
@Service
public class SysZuulRouteServiceImpl extends ServiceImpl<SysZuulRouteMapper, SysZuulRoute> implements SysZuulRouteService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 立即生效配置
     *
     * @return
     */
    @Override
    public Boolean applyZuulRoute() {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        List<SysZuulRoute> routeList = selectList(wrapper);
        redisTemplate.opsForValue().set(CommonConstant.ROUTE_KEY, routeList);
        rabbitTemplate.convertAndSend(MqQueueConstant.ROUTE_CONFIG_CHANGE, 1);
        return Boolean.TRUE;
    }
}
