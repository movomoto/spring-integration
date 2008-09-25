/*
 * Copyright 2002-2008 the original author or authors.
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

package org.springframework.integration.gateway.config;

import org.w3c.dom.Element;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.integration.config.IntegrationNamespaceUtils;
import org.springframework.integration.gateway.GatewayProxyFactoryBean;
import org.springframework.util.ObjectUtils;

/**
 * Parser for the &lt;gateway/&gt; element.
 * 
 * @author Mark Fisher
 */
public class GatewayParser extends AbstractSimpleBeanDefinitionParser {

	private static String[] referenceAttributes = new String[] {
		"request-channel", "reply-channel", "message-mapper"
	};


	@Override
	protected Class<?> getBeanClass(Element element) {
		return GatewayProxyFactoryBean.class;
	}

	@Override
	protected boolean isEligibleAttribute(String attributeName) {
		return !ObjectUtils.containsElement(referenceAttributes, attributeName)
				&& super.isEligibleAttribute(attributeName);
	}

	@Override
	protected void postProcess(BeanDefinitionBuilder builder, Element element) {
		for (String attributeName : referenceAttributes) {
			IntegrationNamespaceUtils.setReferenceIfAttributeDefined(builder, element, attributeName);
		}
	}

}
