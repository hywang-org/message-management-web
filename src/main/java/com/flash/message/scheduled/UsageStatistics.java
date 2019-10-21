package com.flash.message.scheduled;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.flash.message.entity.app.App;
import com.flash.message.entity.usage.Usage;
import com.flash.message.mapper.AppMapper;
import com.flash.message.mapper.DelivOrderMapper;
import com.flash.message.mapper.ProOrderMapper;
import com.flash.message.mapper.ResOrderMapper;
import com.flash.message.mapper.TabooOrderMapper;
import com.flash.message.mapper.UsageMapper;
import com.flash.message.utils.DateUtil;

@Component
public class UsageStatistics {

	@Resource
	private ProOrderMapper proOrderMapper;

	@Resource
	private ResOrderMapper resOrderMapper;

	@Resource
	private DelivOrderMapper delivOrderMapper;

	@Resource
	private TabooOrderMapper tabooOrderMapper;

	@Resource
	private AppMapper appMapper;

	@Resource
	private UsageMapper usageMapper;

	@Scheduled(cron = "${usage.statistics}")
	public void insertUsage() {
		Date shareDate = DateUtil.LocalDateToUdate();
		// 查询请求订单量
		List<Usage> usageSubmit = proOrderMapper.selectAllGBAppId(shareDate);
		// 查询已发送量
		List<Usage> usageSend = resOrderMapper.selectAllGBAppId(shareDate);
		// 查询发送成功量
		List<Usage> successSend = delivOrderMapper.selectAllGBAppId(shareDate);
		// 查询因为禁忌词发送失败量
		List<Usage> failSend = tabooOrderMapper.selectAllGBAppId(shareDate);

		if (usageSubmit != null && usageSubmit.size() > 0) {
			for (int i = 0; i < usageSubmit.size(); i++) {
				Usage usage = new Usage();
				String appId = usageSubmit.get(i).getAppId();
				App app = appMapper.queryAppByAppId(appId);
				usage.setAppId(appId);
				usage.setAppName(app.getAppName());
				usage.setChannel(app.getChannel());
				usage.setUserId(app.getUserId());
				usage.setDateTime(shareDate.toString());
				//已提交量
				usage.setSubmitCount(usageSubmit.get(i).getSubmitCount());
				//发送成功量
				if (successSend != null && successSend.size() > 0) {
					for (int j = 0; j < successSend.size(); j++) {
						if(usageSubmit.get(i).getAppId().equals(successSend.get(j).getAppId())) {
							usage.setSuccessCount(successSend.get(j).getSuccessCount());
						}else {
							usage.setSuccessCount(0);
						}
					}
				}
				//提交成功量
				if (usageSend != null && usageSend.size() > 0) {
					for (int k = 0; k < usageSend.size(); k++) {
						if(usageSubmit.get(i).getAppId().equals(usageSend.get(k).getAppId())) {
							usage.setOnSendCount(usageSend.get(k).getOnSendCount());
						}else {
							usage.setOnSendCount(0);
						}
					}
				}
				//发送失败量
				if (failSend != null && failSend.size() > 0) {
					for (int l = 0; l < successSend.size(); l++) {
						if(usageSubmit.get(i).getAppId().equals(successSend.get(l).getAppId())) {
							long fail = usageSubmit.get(i).getSubmitCount() - successSend.get(i).getSuccessCount();
							usage.setOnSendCount(fail + failSend.get(i).getFailCount());
						}else {
							usage.setSuccessCount(0);
						}
					}
				}
				//保存记录
				usageMapper.insert(usage);
			}
		}
	}

}
