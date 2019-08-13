/*
 * Copyright(C),2019-2020,dream wind
 * FileName:ResultDto.java
 * Author:xiayu
 * History:
 *    <author>  <time>  <version>  <desc>
 *      作者      修改时间      版本           描述
 */

package com.dream.xy.bootx.mybatisplusgenerate.utils;

/**
 * <b>类描述:</b><br>
 * 返回值
 * 
 * @author xiayu
 * @version 1.0
 * @create 2019-08-12
 * @since 1.0.0
 */
public class ResultDto {
	private String resultCode;
	private String resultMsg;

	/**
	 * 
	 * 构造器
	 */
	public ResultDto() {

	}
    /**
     * 
     * 构造器
     * @param resultCode
     * @param resultMsg
     */
	public ResultDto(String resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	/**
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode 要设置的resultCode
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the resultMsg
	 */
	public String getResultMsg() {
		return resultMsg;
	}

	/**
	 * @param resultMsg 要设置的resultMsg
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}
