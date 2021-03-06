/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.foundation.metrics.output.servo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.servicecomb.foundation.metrics.output.MetricsFileOutput;

@Component
public class RollingMetricsFileOutput extends MetricsFileOutput {

  private final Map<String, Logger> allLoggers = new ConcurrentHashMap<>();

  public RollingMetricsFileOutput() {
  }

  @Override
  public void output(Map<String, String> metrics) {
    for (String metricName : metrics.keySet()) {
      Logger logger = allLoggers.computeIfAbsent(metricName, l -> LoggerFactory.getLogger(metricName));
      logger.trace(metrics.get(metricName));
    }
  }
}
