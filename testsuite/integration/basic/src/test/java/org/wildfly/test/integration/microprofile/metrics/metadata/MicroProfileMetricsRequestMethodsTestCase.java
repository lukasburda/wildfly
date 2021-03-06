/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2018, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.wildfly.test.integration.microprofile.metrics.metadata;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.as.arquillian.api.ContainerResource;
import org.jboss.as.arquillian.container.ManagementClient;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@RunAsClient
public class MicroProfileMetricsRequestMethodsTestCase {
    @ContainerResource
    ManagementClient managementClient;

    @Test
    public void checkOptions() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpOptions httpOptions = new HttpOptions(endpointURL);
            httpOptions.setHeader("Accept", "application/json");
            CloseableHttpResponse resp = client.execute(httpOptions);
            assertEquals(200, resp.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void checkGet() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse resp = client.execute(new HttpGet(endpointURL));
            assertEquals(200, resp.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void checkHead() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse resp = client.execute(new HttpHead(endpointURL));
            assertEquals(406, resp.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void checkPost() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse resp = client.execute(new HttpPost(endpointURL));
            assertEquals(406, resp.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void checkPut() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse resp = client.execute(new HttpPut(endpointURL));
            assertEquals(406, resp.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void checkDelete() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse resp = client.execute(new HttpDelete(endpointURL));
            assertEquals(406, resp.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void checkTrace() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse resp = client.execute(new HttpTrace(endpointURL));
            assertEquals(406, resp.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void checkPatch() throws Exception {
        final String endpointURL = "http://" + managementClient.getMgmtAddress() + ":" + managementClient.getMgmtPort() + "/metrics";

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse resp = client.execute(new HttpPatch(endpointURL));
            assertEquals(406, resp.getStatusLine().getStatusCode());
        }
    }

}
