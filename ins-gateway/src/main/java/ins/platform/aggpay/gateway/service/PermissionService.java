package ins.platform.aggpay.gateway.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

/**
 * @author lengleng
 * @date 2017/10/28
 */
public interface PermissionService {
    /**
     * 判断请求是否有权限
     *
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
