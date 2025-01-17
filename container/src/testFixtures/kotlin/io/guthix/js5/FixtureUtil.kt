/*
 * Copyright 2018-2021 Guthix
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.guthix.js5

import io.guthix.js5.container.disk.Js5DiskStore
import io.netty.buffer.ByteBuf
import java.nio.file.Files
import java.nio.file.Path

/**
 * Fills a [ByteBuf] with increasing numbers starting from 0.
 */
fun ByteBuf.iterationFill(): ByteBuf {
    var i = 0
    while (isWritable) {
        writeByte(i++)
    }
    return this
}

fun createEmptyCacheFolder(): Path = Files.createTempDirectory("js5").apply {
    resolve(Js5DiskStore.FILE_NAME + ".dat2").toFile().createNewFile()
    resolve(Js5DiskStore.FILE_NAME + ".idx255").toFile().createNewFile()
}