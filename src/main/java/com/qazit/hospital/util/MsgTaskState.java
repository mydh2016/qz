package com.qazit.hospital.util;


/**
 * 短信相关状态静态变量
 * @author Administrator
 *
 */
public class MsgTaskState {
	//**********短信发送记录表
	public static final int  RECORD_STATE_ADD_OK=1;//任务记录表，向任务队列添加成功
	public static final int  RECORD_STATE_ADD_FAIL=2;//任务记录表，向任务队列添加失败
	public static final int  RECORD_STATE_ADD_CL=3;//任务记录表，任务关闭
	public static final int  RECORD_TYPE_ONLY_ONE=1;//1：仅发送一次
	public static final int  RECORD_TYPE_EVERY_DAY=2;//2:每天发送
	public static final int  RECORD_TYPE_EVERY_WEEK=3;//3:每周发送
	public static final int  RECORD_TYPE_EVERY_MONTH=4;//每月发送 
	public static final int  RECORD_TYPE_SELF=5;//自定义发送
	
	//*********短信发送表状态
	public static final int SEND_STATUS_NO_CHECK=1;// 1：短信已发送，短信结果未查询
	public static final int STATUS_SEND_FAIL=401;// 3，发送失败，短信网关异常
	public static final int TASK_STATUS_NO_SEND=1;// 定时任务表1.未发送2.发送失败3任务异常
	public static final int IS_MO=1;//短信需要上行
	public static final int IS_NOT_MO=2;//短信不需要上行
	
	//********模板ID和短信发送号码对照表
	public static final int  NUMBER_STATUS_OK=1;//模板正常使用
	public static final int  NUMBER_STATUS_FAIL=2;//模板已废弃
	//********任务队列表状态
	public static final int  TASK_STATUS_WAIT_SEND=0;//等待发送
	
	//********任务发送短信记录表状态
	public static final int  WAIT_SEND_ADD_TASK_OK=1;//添加到任务队列成功
	public static final int  WAIT_SEND_ADD_TASK_FAIL=2;//添加到任务队列失败
	public static final int  SEND_TYPE_HAND=1;//手动发送
	public static final int  SEND_TYPE_TIMED=2;//定时发送
	
	
}
