package ins.platform.aggpay.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import ins.platform.aggpay.admin.mapper.SysLogMapper;
import ins.platform.aggpay.admin.service.SysLogService;
import ins.platform.aggpay.common.constant.CommonConstant;
import ins.platform.aggpay.common.entity.SysLog;
import ins.platform.aggpay.common.util.Assert;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author lengleng
 * @since 2017-11-20
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public Boolean updateByLogId(Long id) {
        Assert.isNull(id, "日志ID为空");

        SysLog sysLog = new SysLog();
        sysLog.setId(id);
        sysLog.setDelFlag(CommonConstant.STATUS_DEL);
        sysLog.setUpdateTime(new Date());
        return updateById(sysLog);
    }
}
