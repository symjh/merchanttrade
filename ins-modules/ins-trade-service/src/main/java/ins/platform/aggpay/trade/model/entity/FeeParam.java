/*
 * Copyright (c) 2018-2020, Ripin Yan. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ins.platform.aggpay.trade.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 手续费信息表
 * </p>
 *
 * @author ripin
 * @since 2018-09-18
 */
@TableName("fee_param")
@Data
public class FeeParam extends Model<FeeParam> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 渠道类型 - 01：支付宝，02：微信支付
     */
    private String channeltype;
    /**
     * 费用类型 - 01：t0收单手续费，02：t1收单手续费
     */
    private String feetype;
    /**
     * 费率最多支持小数点后5位
     */
    private String feevalue;
    /**
     * 是否有效 - 1：有效，0：无效
     */
    @TableField("valid_ind")
    private String validInd;
    /**
     * 创建人代码
     */
    @TableField("creator_code")
    private String creatorCode;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新人代码
     */
    @TableField("updater_code")
    private String updaterCode;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FeeParam{" +
        ", id=" + id +
        ", channeltype=" + channeltype +
        ", feetype=" + feetype +
        ", feevalue=" + feevalue +
        ", validInd=" + validInd +
        ", creatorCode=" + creatorCode +
        ", createTime=" + createTime +
        ", updaterCode=" + updaterCode +
        ", updateTime=" + updateTime +
        "}";
    }
}
