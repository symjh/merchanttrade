package ins.platform.aggpay.auth.service;

import ins.platform.aggpay.auth.feign.UserService;
import ins.platform.aggpay.auth.util.UserDetailsImpl;
import ins.platform.aggpay.common.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author lengleng
 * @date 2017/10/26
 * <p>
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO userVo = userService.findUserByUsername(username);
        return new UserDetailsImpl(userVo);
    }
}
