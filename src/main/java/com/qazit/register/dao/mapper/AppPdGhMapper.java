package com.qazit.register.dao.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppPdGhVO;

public interface AppPdGhMapper {
	public List<AppPdGhVO> queryAllByDate(@Param("hospitalId")Integer hospitalId,@Param("departId")Integer departId,@Param("consDate")Date consDate);
	public AppPdGhVO selectById(@Param("productId")Integer productId);

	public List<AppPdGhVO> queryWebPDByDate(@Param("hospitalId")Integer hospitalId,@Param("departId")Integer departId,@Param("consDate")Date consDate,@Param("timeSolt")String timeSolt);
	public List<AppPdGhVO> queryPDList(@Param("hospitalId")Integer hospitalId, @Param("departId")Integer departId,
			@Param("consDate")Date consDate,@Param("timeSolt")String timeSolt);

	//修改预约订单表剩余票数量
		public void updateCount(AppPdGhVO aps);

}
