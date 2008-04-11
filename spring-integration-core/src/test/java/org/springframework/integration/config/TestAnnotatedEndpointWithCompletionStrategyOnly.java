/*
 * Copyright 2002-2007 the original author or authors.
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

package org.springframework.integration.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CompletionStrategy;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.message.Message;
import org.springframework.integration.message.StringMessage;
import org.springframework.integration.router.MessageSequenceComparator;
import org.springframework.stereotype.Component;

/**
 * @author Marius Bogoevici
 */
@MessageEndpoint(input="inputChannel")
@Component("endpointWithoutAggregatorAndWithCompletionStrategy")
public class TestAnnotatedEndpointWithCompletionStrategyOnly {

	@CompletionStrategy
	public boolean checkCompleteness(List<Message<?>> messages) {
		throw new UnsupportedOperationException("Not intended to being called");
	}

}
