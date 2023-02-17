@file:Suppress("PropertyName")

package ai.wandering.retriever.common.storekit.entities

import kotlinx.serialization.Serializable

sealed class Channel {
    @Serializable
    data class Network(
        val _id: String,

        // Relationships
        val userId: String,
        val graphId: String,
        val tagId: String,

        // M-M
        val noteIds: List<String>,
        val pinnerIds: List<String>
    ) : Channel()

    @Serializable
    sealed class Output : Channel() {
        @Serializable
        data class Populated(
            val id: String,

            // Relationships
            val user: User.Output.Unpopulated,
            val graph: Graph.Output.Populated,
            val tag: Tag.Output.Populated,

            // M-M
            val notes: List<Note.Output.Unpopulated>,
            val pinners: List<User.Output.Unpopulated>
        ) : Output()

        @Serializable
        data class Unpopulated(
            val id: String,

            // Relationships
            val userId: String,
            val graphId: String,
            val tagId: String,

            // M-M
            val noteIds: List<String>,
            val pinnerIds: List<String>
        ) : Output()
    }
}