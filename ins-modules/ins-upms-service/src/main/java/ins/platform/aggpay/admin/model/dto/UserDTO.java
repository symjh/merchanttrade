package ins.platform.aggpay.admin.model.dto;

import ins.platform.aggpay.admin.model.entity.SysUser;
import lombok.Data;

import java.util.List;

/**
 * @author lengleng
 * @date 2017/11/5
 */
@Data
public class UserDTO extends SysUser {
    /**
     * 角色ID
     */
    private List<Integer> role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword1;
}
