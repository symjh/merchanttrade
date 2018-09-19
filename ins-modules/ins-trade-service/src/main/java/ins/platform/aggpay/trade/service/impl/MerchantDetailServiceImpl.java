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

package ins.platform.aggpay.trade.service.impl;

import ins.platform.aggpay.trade.mapper.MerchantDetailMapper;
import ins.platform.aggpay.trade.model.entity.MerchantDetail;
import ins.platform.aggpay.trade.service.MerchantDetailService;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 商户详情表 服务实现类
 * </p>
 *
 * @author ripin
 * @since 2018-09-18
 */
@Service
public class MerchantDetailServiceImpl extends ServiceImpl<MerchantDetailMapper, MerchantDetail> implements MerchantDetailService {

}
