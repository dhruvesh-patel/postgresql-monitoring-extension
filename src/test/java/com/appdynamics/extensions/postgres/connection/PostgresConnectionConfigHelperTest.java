/*
 * Copyright (c) 2019 AppDynamics,Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appdynamics.extensions.postgres.connection;

import com.appdynamics.extensions.yml.YmlReader;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static com.appdynamics.extensions.postgres.util.Constants.SERVERS;

/**
 * @author pradeep.nair
 */
public class PostgresConnectionConfigHelperTest {

    @Test(expected = RuntimeException.class)
    public void whenServerHostIsMissingThenExceptionIsThrown() {
        Map<String, ?> conf = YmlReader.readFromFileAsMap(new File("src/test/resources/conf/config_no_host.yml"));
        List<Map<String, ?>> servers = (List<Map<String, ?>>) conf.get(SERVERS);
        PostgresConnectionConfigHelper.getConnectionConfig("database", "server", "password", servers.get(0));
    }
}
