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

package org.springframework.integration.gateway;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.integration.channel.MessageChannel;
import org.springframework.integration.channel.interceptor.ChannelInterceptorAdapter;
import org.springframework.integration.message.Message;

/**
 * @author Mark Fisher
 */
public class TestChannelInterceptor extends ChannelInterceptorAdapter {

	private final AtomicInteger sentCount = new AtomicInteger();

	private final AtomicInteger receivedCount = new AtomicInteger();


	public int getSentCount() {
		return this.sentCount.get();
	}

	public int getReceivedCount() {
		return this.receivedCount.get();
	}

	@Override
	public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
		if (sent) {
			this.sentCount.incrementAndGet();
		}
	}

	@Override
	public void postReceive(Message<?> message, MessageChannel channel) {
		if (message != null) {
			this.receivedCount.incrementAndGet();
		}
	}

}
