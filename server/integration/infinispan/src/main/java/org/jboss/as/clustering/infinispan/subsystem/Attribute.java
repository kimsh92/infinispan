/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.clustering.infinispan.subsystem;

import javax.xml.XMLConstants;

import java.util.HashMap;
import java.util.Map;

import org.jboss.as.controller.AttributeDefinition;

/**
 * Enumerates the attributes used in the Infinispan subsystem schema.
 * @author Paul Ferraro
 * @author Richard Achmatowicz (c) 2011 RedHat Inc.
 * @author Tristan Tarrant
 */
public enum Attribute {
    // must be first
    UNKNOWN((String) null),
    ACQUIRE_TIMEOUT(ModelKeys.ACQUIRE_TIMEOUT),
    ALIASES(ModelKeys.ALIASES),
    APPEND_CACHE_NAME_TO_PATH(ModelKeys.APPEND_CACHE_NAME_TO_PATH),
    ASYNC_MARSHALLING(ModelKeys.ASYNC_MARSHALLING),
    AUDIT_LOGGER(ModelKeys.AUDIT_LOGGER),
    AWAIT_INITIAL_TRANSFER(ModelKeys.AWAIT_INITIAL_TRANSFER),
    BACKUP_FAILURE_POLICY(ModelKeys.BACKUP_FAILURE_POLICY),
    BATCH_SIZE(ModelKeys.BATCH_SIZE),
    BATCHING(ModelKeys.BATCHING),
    BLOCK_SIZE(ModelKeys.BLOCK_SIZE),
    BUFFER_SIZE(ModelKeys.BUFFER_SIZE),
    CACHE(ModelKeys.CACHE),
    CACHE_SIZE(ModelKeys.CACHE_SIZE),
    CAPACITY_FACTOR(ModelKeys.CAPACITY_FACTOR),
    CHUNK_SIZE(ModelKeys.CHUNK_SIZE),
    CLASS(ModelKeys.CLASS),
    CLEAR_THRESHOLD(ModelKeys.CLEAR_THRESHOLD),
    CLUSTER(ModelKeys.CLUSTER),
    CONCURRENCY_LEVEL(ModelKeys.CONCURRENCY_LEVEL),
    CONNECTION_TIMEOUT(ModelKeys.CONNECTION_TIMEOUT),
    DATASOURCE(ModelKeys.DATASOURCE),
    DEFAULT_CACHE(ModelKeys.DEFAULT_CACHE),
    @Deprecated DEFAULT_CACHE_CONTAINER("default-cache-container"),
    DIALECT(ModelKeys.DIALECT),
    @Deprecated EAGER_LOCKING("eager-locking"),
    ENABLED(ModelKeys.ENABLED),
    EVICTION_EXECUTOR(ModelKeys.EVICTION_EXECUTOR),
    EXECUTOR(ModelKeys.EXECUTOR),
    FETCH_SIZE(ModelKeys.FETCH_SIZE),
    FETCH_STATE(ModelKeys.FETCH_STATE),
    FLUSH_LOCK_TIMEOUT(ModelKeys.FLUSH_LOCK_TIMEOUT),
    @Deprecated FLUSH_TIMEOUT("flush-timeout"),
    HOTROD_WRAPPING(ModelKeys.HOTROD_WRAPPING),
    INDEXING(ModelKeys.INDEXING),
    INDEX(ModelKeys.INDEX),
    INTERVAL(ModelKeys.INTERVAL),
    ISOLATION(ModelKeys.ISOLATION),
    JNDI_NAME(ModelKeys.JNDI_NAME),
    L1_LIFESPAN(ModelKeys.L1_LIFESPAN),
    LIFESPAN(ModelKeys.LIFESPAN),
    LISTENER_EXECUTOR(ModelKeys.LISTENER_EXECUTOR),
    LOCK_TIMEOUT(ModelKeys.LOCK_TIMEOUT),
    LOCKING(ModelKeys.LOCKING),
    MACHINE(ModelKeys.MACHINE),
    MAPPER(ModelKeys.MAPPER),
    MARSHALLER(ModelKeys.MARSHALLER),
    MAX_CONNECTIONS_PER_HOST(ModelKeys.MAX_CONNECTIONS_PER_HOST),
    MAX_ENTRIES(ModelKeys.MAX_ENTRIES),
    MAX_IDLE(ModelKeys.MAX_IDLE),
    MAX_TOTAL_CONNECTIONS(ModelKeys.MAX_TOTAL_CONNECTIONS),
    MODE(ModelKeys.MODE),
    MODIFICATION_QUEUE_SIZE(ModelKeys.MODIFICATION_QUEUE_SIZE),
    MODULE(ModelKeys.MODULE),
    NAME(ModelKeys.NAME),
    NAMESPACE(XMLConstants.XMLNS_ATTRIBUTE),
    OUTBOUND_SOCKET_BINDING(ModelKeys.OUTBOUND_SOCKET_BINDING),
    OWNERS(ModelKeys.OWNERS),
    PASSIVATION(ModelKeys.PASSIVATION),
    PATH(ModelKeys.PATH),
    PERMISSIONS(ModelKeys.PERMISSIONS),
    PREFIX(ModelKeys.PREFIX),
    PRELOAD(ModelKeys.PRELOAD),
    PURGE(ModelKeys.PURGE),
    QUEUE_FLUSH_INTERVAL(ModelKeys.QUEUE_FLUSH_INTERVAL),
    QUEUE_SIZE(ModelKeys.QUEUE_SIZE),
    RACK(ModelKeys.RACK),
    RAW_VALUES(ModelKeys.RAW_VALUES),
    READ_ONLY(ModelKeys.READ_ONLY),
    RELATIVE_TO(ModelKeys.RELATIVE_TO),
    REMOTE_TIMEOUT(ModelKeys.REMOTE_TIMEOUT),
    REPLICATION_QUEUE_EXECUTOR(ModelKeys.REPLICATION_QUEUE_EXECUTOR),
    ROLES(ModelKeys.ROLES),
    SEGMENTS(ModelKeys.SEGMENTS),
    SHARED(ModelKeys.SHARED),
    SHUTDOWN_TIMEOUT(ModelKeys.SHUTDOWN_TIMEOUT),
    SINGLETON(ModelKeys.SINGLETON),
    SITE(ModelKeys.SITE),
    SOCKET_TIMEOUT(ModelKeys.SOCKET_TIMEOUT),
    STACK(ModelKeys.STACK),
    START(ModelKeys.START),
    STATISTICS(ModelKeys.STATISTICS),
    STRICT_PEER_TO_PEER(ModelKeys.STRICT_PEER_TO_PEER),
    STOP_TIMEOUT(ModelKeys.STOP_TIMEOUT),
    STRATEGY(ModelKeys.STRATEGY),
    STRIPING(ModelKeys.STRIPING),
    TAKE_BACKUP_OFFLINE_AFTER_FAILURES(ModelKeys.TAKE_BACKUP_OFFLINE_AFTER_FAILURES),
    TAKE_BACKUP_OFFLINE_MIN_WAIT(ModelKeys.TAKE_BACKUP_OFFLINE_MIN_WAIT),
    TCP_NO_DELAY(ModelKeys.TCP_NO_DELAY),
    THREAD_POOL_SIZE(ModelKeys.THREAD_POOL_SIZE),
    TIMEOUT(ModelKeys.TIMEOUT),
    TYPE(ModelKeys.TYPE),
    @Deprecated VIRTUAL_NODES("virtual-nodes")
    ;

    private final String name;
    private final AttributeDefinition definition;

    private Attribute(final String name) {
        this.name = name;
        this.definition = null;
    }

    private Attribute(final AttributeDefinition definition) {
        this.name = definition.getXmlName();
        this.definition = definition;
    }

    /**
     * Get the local name of this element.
     *
     * @return the local name
     */
    public String getLocalName() {
        return name;
    }

    public AttributeDefinition getDefinition() {
        return definition;
    }

    private static final Map<String, Attribute> attributes;

    static {
        final Map<String, Attribute> map = new HashMap<String, Attribute>();
        for (Attribute attribute : values()) {
            final String name = attribute.getLocalName();
            if (name != null) map.put(name, attribute);
        }
        attributes = map;
    }

    public static Attribute forName(String localName) {
        final Attribute attribute = attributes.get(localName);
        return attribute == null ? UNKNOWN : attribute;
    }
}
