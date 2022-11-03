package com.andreirookie.entity

import com.andreirookie.dto.Attachment
import com.andreirookie.dto.Post
import com.andreirookie.enumeration.AttachmentType
import javax.persistence.*

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    var author: String,
    @Column(columnDefinition = "TEXT")
    var content: String,
    var published: Long,
    var likedByMe: Boolean,
    var likes: Int = 0,
    var authorAvatar: String,
    @Embedded
    var attachment: AttachmentEmbeddable?
) {

    fun toDto() = Post(id, author, content, published, likedByMe, likes, authorAvatar, attachment?.toDto())

    companion object {
        fun fromDto(dto: Post) = PostEntity(
            dto.id,
            dto.author,
            dto.content,
            dto.published,
            dto.likedByMe,
            dto.likes,
            dto.authorAvatar,
            AttachmentEmbeddable.fromDto(dto.attachment))
    }
}
@Embeddable
data class AttachmentEmbeddable(
    var url: String,
    @Column(columnDefinition = "TEXT")
    var description: String?,
    @Enumerated(EnumType.STRING)
    var type: AttachmentType
) {
    fun toDto() = Attachment(url, description, type)

    companion object {
        fun fromDto(dto: Attachment?) = dto?.let {
            AttachmentEmbeddable(it.url, it.description, it.type)
        }
    }
}