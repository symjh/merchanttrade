package ins.platform.aggpay.gateway.feign.fallback;

import ins.platform.aggpay.common.vo.MenuVO;
import ins.platform.aggpay.gateway.feign.MenuService;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.xiaoleilu.hutool.collection.CollUtil;

/**
 * @author lengleng
 * @date 2017/10/31
 * why add @Service when i up version ?
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/762
 */
@Slf4j
@Service
public class MenuServiceFallbackImpl implements MenuService {
    @Override
    public Set<MenuVO> findMenuByRole(String role) {
        log.error("调用{}异常{}","findMenuByRole",role);
        return CollUtil.newHashSet();
    }
}
