/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
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
package com.alibaba.nacos.api.config;

import java.lang.reflect.Constructor;
import java.util.Properties;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.exception.NacosException;
import org.apache.commons.lang3.StringUtils;

/**
 * Config Factory
 * 
 * @author Nacos
 *
 */
public class ConfigFactory {

	/**
	 * Create Config
	 * 
	 * @param properties
	 *            init param
	 * @return Config
	 * @throws NacosException
	 *             Exception
	 */
	public static ConfigService createConfigService(Properties properties) throws NacosException {
		try {
			Class<?> driverImplClass = Class.forName("com.alibaba.nacos.client.config.NacosConfigService");
			Constructor constructor = driverImplClass.getConstructor(Properties.class);
			ConfigService vendorImpl = (ConfigService) constructor.newInstance(properties);
			return vendorImpl;
		} catch (Throwable e) {
			throw new NacosException(-400, e.getMessage());
		}
	}

	/**
	 * Create Config
	 *
	 * @return Config
	 * @throws NacosException
	 *             Exception
	 */
	public static ConfigService createConfigService() throws NacosException {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ENDPOINT, System.getProperty("nacos.endpoint", "midenv.mychebao.com"));
		properties.put(PropertyKeyConst.ENDPINT_PORT, System.getProperty("nacos.endpoint.port", "80"));
		String encode = System.getProperty("nacos.encode");
		if (StringUtils.isNotEmpty(encode)) {
			properties.put(PropertyKeyConst.ENCODE, System.getProperty("nacos.encode"));
		}
		String namespace = System.getProperty("nacos.namespace");
		if (StringUtils.isNotEmpty(namespace)) {
			properties.put(PropertyKeyConst.NAMESPACE, namespace);
		}
		try {
			Class<?> driverImplClass = Class.forName("com.alibaba.nacos.client.config.NacosConfigService");
			Constructor constructor = driverImplClass.getConstructor(Properties.class);
			ConfigService vendorImpl = (ConfigService) constructor.newInstance(properties);
			return vendorImpl;
		} catch (Throwable e) {
			throw new NacosException(-400, e.getMessage());
		}
	}

	/**
	 * Create Config
	 * 
	 * @param ServerAddr
	 *            serverlist
	 * @return Config
	 * @throws NacosException
	 *             Exception
	 */
	public static ConfigService createConfigService(String serverAddr) throws NacosException {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
		try {
			Class<?> driverImplClass = Class.forName("com.alibaba.nacos.client.config.NacosConfigService");
			Constructor constructor = driverImplClass.getConstructor(Properties.class);
			ConfigService vendorImpl = (ConfigService) constructor.newInstance(properties);
			return vendorImpl;
		} catch (Throwable e) {
			throw new NacosException(-400, e.getMessage());
		}
	}

}