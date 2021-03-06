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

package io.servicecomb.demo.pojo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.servicecomb.demo.CodeFirstPojoIntf;
import io.servicecomb.demo.helloworld.greeter.Hello;
import io.servicecomb.demo.server.Test;
import io.servicecomb.demo.smartcare.SmartCare;
import io.servicecomb.provider.pojo.RpcReference;

@Component
public class SomePojoConfig {

  @RpcReference(microserviceName = "pojo", schemaId = "helloworld.Greeter")
  private Hello hello;

  @RpcReference(microserviceName = "pojo", schemaId = "smartcare")
  private SmartCare smartCare;

  @RpcReference(microserviceName = "pojo", schemaId = "server")
  private Test test;

  @RpcReference(microserviceName = "pojo", schemaId = "codeFirst")
  private CodeFirstPojoIntf codeFirst;

  @Bean
  Hello hello() {
    return hello;
  }

  @Bean
  SmartCare smartCare() {
    return smartCare;
  }

  @Bean
  Test test() {
    return test;
  }

  @Bean
  CodeFirstPojoIntf codeFirst() {
    return codeFirst;
  }
}
