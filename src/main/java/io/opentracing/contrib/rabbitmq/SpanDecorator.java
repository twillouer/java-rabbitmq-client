/*
 * Copyright 2017-2019 The OpenTracing Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.opentracing.contrib.rabbitmq;


import io.opentracing.Span;
import io.opentracing.tag.Tags;

class SpanDecorator {

  static final String COMPONENT_NAME = "java-rabbitmq";

  static void onRequest(String exchange, Span span) {
    Tags.COMPONENT.set(span, COMPONENT_NAME);
    Tags.MESSAGE_BUS_DESTINATION.set(span, exchange);
  }

  static void onResponse(Span span) {
    Tags.COMPONENT.set(span, COMPONENT_NAME);
  }
}
