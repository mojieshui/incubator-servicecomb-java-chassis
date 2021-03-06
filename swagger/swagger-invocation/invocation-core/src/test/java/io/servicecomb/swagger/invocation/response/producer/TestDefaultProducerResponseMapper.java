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
package io.servicecomb.swagger.invocation.response.producer;

import javax.ws.rs.core.Response.Status;

import org.junit.Assert;
import org.junit.Test;

import io.servicecomb.swagger.invocation.Response;
import io.servicecomb.swagger.invocation.converter.Converter;
import io.servicecomb.swagger.invocation.converter.ConverterMgr;

public class TestDefaultProducerResponseMapper {
  ConverterMgr mgr = new ConverterMgr();

  Converter converter = mgr.findConverter(Integer.class, String.class);

  DefaultProducerResponseMapper mapper = new DefaultProducerResponseMapper(converter);

  @Test
  public void mapResponse() {
    Response result = mapper.mapResponse(Status.OK, 1);
    Assert.assertSame(Status.OK, result.getStatus());
    Assert.assertEquals("1", result.getResult());
  }
}
