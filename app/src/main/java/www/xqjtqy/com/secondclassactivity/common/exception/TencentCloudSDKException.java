/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package www.xqjtqy.com.secondclassactivity.common.exception;

/**
 * 腾讯云api sdk异常类
 */
public class TencentCloudSDKException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请求Id,发起请求前的异常这个字段为空
	 */
	private String requestId;
    
	/**
	 * @param message 异常信息
	 */
    public TencentCloudSDKException(String message) {
    	this(message, "");
    }
    
    /**
     * @param message 异常信息
     * @param requestId 请求id
     */
    public TencentCloudSDKException(String message, String requestId) {
    	super(message);
    	this.requestId = requestId;
    }
    
    /**
     * 获取请求id
     * @return requestId
     */
    public String getRequestId() {
    	return requestId;
    }
    
    /**
     * 格式化输出异常信息
     * @return 异常信息
     */
    public String toString() {
    	return "[TencentCloudSDKException]" + "message:" + this.getMessage() + "  requestId:" + this.getRequestId();
    }
    
    
}
