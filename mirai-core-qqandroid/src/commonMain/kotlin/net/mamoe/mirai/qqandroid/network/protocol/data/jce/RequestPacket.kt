/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.qqandroid.network.protocol.data.jce

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoId
import net.mamoe.mirai.qqandroid.io.JceStruct
import net.mamoe.mirai.qqandroid.network.protocol.packet.EMPTY_BYTE_ARRAY

private val EMPTY_MAP = mapOf<String, String>()

@Serializable
internal class RequestPacket(
    @ProtoId(1) val iVersion: Short? = 3,
    @ProtoId(2) val cPacketType: Byte = 0,
    @ProtoId(3) val iMessageType: Int = 0,
    @ProtoId(4) val iRequestId: Int,
    @ProtoId(5) val sServantName: String = "",
    @ProtoId(6) val sFuncName: String = "",
    @ProtoId(7) val sBuffer: ByteArray = EMPTY_BYTE_ARRAY,
    @ProtoId(8) val iTimeout: Int? = 0,
    @ProtoId(9) val context: Map<String, String>? = EMPTY_MAP,
    @ProtoId(10) val status: Map<String, String>? = EMPTY_MAP
) : JceStruct

@Serializable
internal class RequestDataVersion3(
    @ProtoId(0) val map: Map<String, ByteArray> // 注意: ByteArray 不能直接放序列化的 JceStruct!! 要放类似 RequestDataStructSvcReqRegister 的
) : JceStruct

@Serializable
internal class RequestDataVersion2(
    @ProtoId(0) val map: Map<String, Map<String, ByteArray>>
) : JceStruct

@Serializable
internal class RequestDataStructSvcReqRegister(
    @ProtoId(0) val struct: SvcReqRegister
) : JceStruct