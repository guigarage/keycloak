/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
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
package org.keycloak.component;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.provider.ConfiguredProvider;
import org.keycloak.provider.Provider;
import org.keycloak.provider.ProviderFactory;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public interface ComponentFactory<CreatedType, ProviderType extends Provider> extends ProviderFactory<ProviderType>, ConfiguredProvider {
    CreatedType create(KeycloakSession session, ComponentModel model);

    @Override
    default ProviderType create(KeycloakSession session) {
        return null;
    }

    void validateConfiguration(KeycloakSession session, ComponentModel model) throws ComponentValidationException;

    default
    void onCreate(KeycloakSession session, RealmModel realm, ComponentModel model) {

    }

}