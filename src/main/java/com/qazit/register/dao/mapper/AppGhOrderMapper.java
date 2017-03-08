package com.qazit.register.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppGhOrderVO;

public interface AppGhOrderMapper {
	//点击预约
	public void createGhOrder(AppGhOrderVO gd);
	//查询预约记录
	public List<AppGhOrderVO> queryAllOrderByUserId(@Param("userId")Integer userId);
	//通过ID查询记录
	public AppGhOrderVO queryById(Integer orderId);
	//通过身份证和商品ID查询是否已有预约
	public AppGhOrderVO queryByCardAndPId(@Param("productId")Integer productId,@Param("card")String card);
	
}
